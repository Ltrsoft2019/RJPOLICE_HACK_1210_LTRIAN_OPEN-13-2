package com.ltrsoft.policeapp.LoinRegistration;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.annotation.PluralsRes;
import androidx.fragment.app.Fragment;

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
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.ltrsoft.policeapp.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Registration_three extends Fragment {

    private Button submit_reg;
    private ImageView back3_btn;
    private Spinner spinner2,spinner3,spinner4,spinner5,spinner6;
    private TextView Login_txt;
    private String v1,v2,v3,v4,v5,v6,v7,v8,v9;
    private EditText station_id,batch_id,position_id;
    private ProgressBar progressBar;
    private static final String BASE_URL = "https://rj.ltr-soft.com/public/police_api/data/police_insert.php";

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_registration_three, container, false);
        back3_btn=v.findViewById(R.id.back3_btn);
        submit_reg=v.findViewById(R.id.submit_reg);
        station_id=v.findViewById(R.id.station_id);
        batch_id=v.findViewById(R.id.batch_id);
        position_id=v.findViewById(R.id.position_id);
//        spinner3=v.findViewById(R.id.spinner2);
//        spinner4=v.findViewById(R.id.spinner3);
//        spinner5=v.findViewById(R.id.spinner4);
        Login_txt=v.findViewById(R.id.Login_txt);
        progressBar=v.findViewById(R.id.progressBar);


        progressBar.setVisibility(View.INVISIBLE);

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

//
//        String[] value2={"Select","1","2","3"};
//        ArrayList<String> arrayList2=new ArrayList<>(Arrays.asList(value2));
//        ArrayAdapter<String> arrayAdapter2=new ArrayAdapter<>(getActivity(),R.layout.stylespinner,arrayList2);
//        spinner2.setAdapter(arrayAdapter2);
//
//
//
//
//
//        String[] value3={"Select","1","2","3"};
//        ArrayList<String> arrayList3=new ArrayList<>(Arrays.asList(value3));
//        ArrayAdapter<String> arrayAdapter3=new ArrayAdapter<>(getActivity(),R.layout.stylespinner,arrayList3);
//        spinner3.setAdapter(arrayAdapter3);
//
//
//
//
//        String[] value4={"Select","1","2","3"};
//        ArrayList<String> arrayList4=new ArrayList<>(Arrays.asList(value4));
//        ArrayAdapter<String> arrayAdapter4=new ArrayAdapter<>(getActivity(),R.layout.stylespinner,arrayList4);
//
//        spinner4.setAdapter(arrayAdapter4);








        return v;
    }


    public void senddata(){
        RequestQueue requestQueue= Volley.newRequestQueue(getContext());
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
                map.put("station_id",station_id.getText().toString());
                map.put("batch_number",batch_id.getText().toString());
                map.put("position_id",position_id.getText().toString());
                return map;
            }
        };
        requestQueue.add(stringRequest);
    }


}