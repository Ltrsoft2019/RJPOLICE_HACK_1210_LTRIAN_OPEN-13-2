package com.ltrsoft.policeapp.LoinRegistration;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.annotation.PluralsRes;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.ltrsoft.policeapp.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
public class Registration_three extends Fragment {
    private Button submit_reg;
    private ImageView back3_btn;
    private Spinner station_id,position_id,district_id,ciry_id,spinner6;
    private ArrayAdapter adapter;
    private TextView Login_txt;
    private String v1,v2,v3,v4,v5,v6,v7,v8,v9,v10;
    private EditText batch_id;
    private ProgressBar progressBar;
    private  RequestQueue requestQueue;
    ArrayList <String> list,listdistrict,listcity,liststation;
    private static final String BASE_URL = "https://rj.ltr-soft.com/public/police_api/data/police_insert.php";
    private static final String POSITON_URL = "https://rj.ltr-soft.com/police_api/data/position_read.php";
    private static final String DISTRICT_URL = "https://rj.ltr-soft.com/public/police_api/district/select_district.php";
    private static final String CITY_URL = "https://rj.ltr-soft.com/public/police_api/city/select_city.php";
    private static final String STATION_URL = "https://rj.ltr-soft.com/public/police_api/police_station/read_police_station.php";
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_registration_three, container, false);
        back3_btn=v.findViewById(R.id.back3_btn);
        submit_reg=v.findViewById(R.id.submit_reg);
        station_id=v.findViewById(R.id.station_id);
        batch_id=v.findViewById(R.id.batch_id);
        position_id=v.findViewById(R.id.position_id);
        district_id=v.findViewById(R.id.spinner2);
        ciry_id=v.findViewById(R.id.spinner4);

        Login_txt=v.findViewById(R.id.Login_txt);
        progressBar=v.findViewById(R.id.progressBar);
        progressBar.setVisibility(View.VISIBLE);
        loadSattion();
        loadCity();
        loadPosition();
        loadDistrict();
     //   if (list!=null && listcity!=null && liststation!=null && listdistrict!=null){
       //     progressBar.setVisibility(View.INVISIBLE);
       // }


        Bundle b = getArguments();
        v1=b.getString("dob");
        v2=b.getString("mobile");
        v3=b.getString("altmob");
        v4=b.getString("gender");
        v5=b.getString("temfname");
        v6=b.getString("temmname");
        v7=b.getString("temnname");
        v8=b.getString("tememail");
        v9=b.getString("tempassword");
        v10=b.getString("userimg");
        back3_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction()
                        .addToBackStack(null) .replace(R.id.main_container,new Registration_two())
                        .commit();
            }
        });
        submit_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
                submit_reg.setVisibility(View.INVISIBLE);
             senddata();
            }
        });
        Login_txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction()
                        .addToBackStack(null) .replace(R.id.main_container,new LoginFragment())
                        .commit();

            }
        });
        return v;
    }

    private void loadSattion() {
        StringRequest request = new StringRequest(Request.Method.POST, STATION_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(getContext(), "response = "+response.toString(), Toast.LENGTH_SHORT).show();
                liststation = new ArrayList<>();
                try {
                    JSONArray jsonArray = new JSONArray(response);
                    for (int i = 0 ; i < jsonArray.length() ; i++){
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        String sta = jsonObject.getString("police_station_name");
                        liststation.add(sta);
                    }
                } catch (JSONException e) {
                    Toast.makeText(getContext(), "error json "+e.toString(), Toast.LENGTH_SHORT).show();
                    throw new RuntimeException(e);
                }
                adapter = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1,liststation);
                adapter.setDropDownViewResource(android.R.layout.simple_list_item_1);
                station_id.setAdapter(adapter);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getContext(), "error"+error.toString(), Toast.LENGTH_SHORT).show();
            }
        }){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return super.getParams();
            }
        };
        requestQueue = Volley.newRequestQueue(getContext());
        requestQueue.add(request);
    }

    private void loadCity() {
        StringRequest cityrequest = new StringRequest(Request.Method.POST, CITY_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        listcity = new ArrayList<>();
                        Toast.makeText(getContext(), "response = "+response.toString(), Toast.LENGTH_SHORT).show();
                        try {
                            JSONArray jsonArray = new JSONArray(response);
                            for (int i = 0 ; i < jsonArray.length() ; i ++){
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                String cit = jsonObject.getString("city_name");
                                listcity.add(cit);
                            }
                        } catch (JSONException e) {
                            Toast.makeText(getContext(), "json erro"+e.toString(), Toast.LENGTH_SHORT).show();
                            throw new RuntimeException(e);
                        }
                        adapter = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1,listcity);
                        adapter.setDropDownViewResource(android.R.layout.simple_list_item_1);
                        ciry_id.setAdapter(adapter);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getContext(), "error "+error.toString(), Toast.LENGTH_SHORT).show();
                    }
                })
        {
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String,String> map = new HashMap<>();
                map.put("district_id","1");
                return map;
            }
        };
        requestQueue=Volley.newRequestQueue(getContext());
        requestQueue.add(cityrequest);
    }

    private void loadDistrict() {
        StringRequest request = new StringRequest(Request.Method.POST, DISTRICT_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                listdistrict= new ArrayList<>();
                Log.d("response",response.toString());
                try {
                    JSONArray jsonArray = new JSONArray(response);

                    for (int i = 0 ; i < jsonArray.length()  ; i++){

                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        String dis = jsonObject.getString("district_name");
                        listdistrict.add(dis);
                        Log.d("jsonarray",dis);
                    }

                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
                adapter = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1,listdistrict);
                adapter.setDropDownViewResource(android.R.layout.simple_list_item_1);
                district_id.setAdapter(adapter);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getContext(), "response = "+error.toString(), Toast.LENGTH_SHORT).show();
            }
        }){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String,String> map = new HashMap<>();
                map.put("state_id","1");
                return map;
            }
        };
        RequestQueue requestQueue= Volley.newRequestQueue(getContext());
        requestQueue.add(request);
        progressBar.setVisibility(View.INVISIBLE);
    }
    private void loadPosition() {
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.POST, POSITON_URL, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        list =new ArrayList<>();
                        for (int i = 0 ; i < response.length() ; i++){
                            try {
                                JSONObject jsonObject = response.getJSONObject(i);
                                list.add(jsonObject.getString("position_name"));
                            } catch (JSONException e) {
                                throw new RuntimeException(e);
                            }
                        }
                        ArrayAdapter adapter = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1,list);
                        adapter.setDropDownViewResource(android.R.layout.simple_list_item_1);
                        position_id.setAdapter(adapter);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getContext(), "error = "+error.toString(), Toast.LENGTH_SHORT).show();
            }
        });
        requestQueue=Volley.newRequestQueue(getContext());
        requestQueue.add(request);
    }
    public void senddata(){
       requestQueue= Volley.newRequestQueue(getContext());
        StringRequest stringRequest =new StringRequest(Request.Method.POST,
                BASE_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(getContext(), "Registration Successfully", Toast.LENGTH_LONG).show();
                progressBar.setVisibility(View.GONE);
                submit_reg.setVisibility(View.VISIBLE);
                getActivity().getSupportFragmentManager().beginTransaction()
                        .addToBackStack(null).replace(R.id.main_container, new LoginFragment())
                        .commit();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressBar.setVisibility(View.INVISIBLE);
                submit_reg.setVisibility(View.VISIBLE);
                Toast.makeText(getContext(), ""+error, Toast.LENGTH_SHORT).show();
            }
        }) {
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String,String> map=new HashMap<>();
                map.put("police_dob",v1.toString());
                map.put("police_mobile",v2.toString());
                map.put("police_adhar",v3.toString());
                map.put("police_gender",v4.toString());
                map.put("police_fname",v5.toString());
                map.put("police_mname",v6.toString());
                map.put("police_lname",v7.toString());
                map.put("police_email",v8.toString());
                map.put("police_password",v9.toString());
                map.put("police_photo_path",v9.toString());

               map.put("station_id",station_id.getSelectedItem().toString());
                map.put("batch_number",batch_id.getText().toString());
                map.put("position_id",position_id.getSelectedItem().toString());
                map.put("city_id",ciry_id.getSelectedItem().toString());
                map.put("district_id",district_id.getSelectedItem().toString());
                return map;
            }
        };
        requestQueue.add(stringRequest);
    }
}