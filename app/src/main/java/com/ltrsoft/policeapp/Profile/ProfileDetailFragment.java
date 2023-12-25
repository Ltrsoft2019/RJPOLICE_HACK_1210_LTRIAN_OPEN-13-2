package com.ltrsoft.policeapp.Profile;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.ltrsoft.policeapp.EditFragment;
import com.ltrsoft.policeapp.LoinRegistration.LoginFragment;
import com.ltrsoft.policeapp.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
public class ProfileDetailFragment extends Fragment {
    public ProfileDetailFragment() {    }
    private final static String POLICE_DETAIL_URL = "http://rj.ltr-soft.com/public/police_api/data/police_read.php";
    private TextView police_id,batch_number,station_id,police_fname,police_mname,police_lname
            ,police_email,police_gender,police_dob,police_mobile1,police_mobile2,police_address,
            position_name,city_name,district_name,state_name,police_adhar;
    private Button button;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.profile_detail_fragment, container, false);

        police_id = view.findViewById(R.id.poiceid);
        batch_number = view.findViewById(R.id.batchno);
        station_id = view.findViewById(R.id.stationid);
        police_fname = view.findViewById(R.id.fname);
        police_mname = view.findViewById(R.id.mname);
        police_lname = view.findViewById(R.id.lname);
        police_email = view.findViewById(R.id.pemail);
        police_mobile1 = view.findViewById(R.id.mno);
        police_gender = view.findViewById(R.id.pgender);
        police_dob = view.findViewById(R.id.pdob);
        police_mobile2 = view.findViewById(R.id.alno);
        police_address = view.findViewById(R.id.adress);
        position_name = view.findViewById(R.id.positionid);
        city_name = view.findViewById(R.id.cityid);
        district_name = view.findViewById(R.id.districtid);
        state_name = view.findViewById(R.id.stateid);
        police_adhar = view . findViewById(R.id.policeadhar);


        view.findViewById(R.id.p_update).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, new EditFragment())
                        .addToBackStack(null)
                        .commit();
            }
        });

        StringRequest request = new StringRequest(Request.Method.POST, POLICE_DETAIL_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
               // Toast.makeText(getContext(), "response = "+response.toString(), Toast.LENGTH_SHORT).show();
                try {
                    JSONArray jsonArray = new JSONArray(response);
                    for (int i = 0 ; i < jsonArray.length() ; i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        police_id.setText(jsonObject.getString("police_id"));
                        batch_number.setText(jsonObject.getString("batch_number"));
                        station_id.setText(jsonObject.getString("station_id"));
                        police_fname.setText(jsonObject.getString("police_fname"));
                        police_mname.setText(jsonObject.getString("police_mname"));
                        police_lname.setText(jsonObject.getString("police_lname"));
                        police_email.setText(jsonObject.getString("police_email"));
                        police_gender.setText(jsonObject.getString("police_gender"));
                        police_gender.setText(jsonObject.getString("police_gender"));
                        police_dob.setText(jsonObject.getString("police_dob"));
                        police_mobile1.setText(jsonObject.getString("police_mobile1"));
                        police_mobile2.setText(jsonObject.getString("police_mobile2"));
                        police_address.setText(jsonObject.getString("police_address"));
                        city_name.setText(jsonObject.getString("city_name"));
                        district_name.setText(jsonObject.getString("district_name"));
                        state_name.setText(jsonObject.getString("state_name"));
                        position_name.setText(jsonObject.getString("position_name"));
                        police_adhar.setText(jsonObject.getString("police_adhar"));

                    }
                } catch (JSONException e) {
                    Toast.makeText(getContext(), "error = "+e.toString(), Toast.LENGTH_SHORT).show();
                    throw new RuntimeException(e);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getContext(), "response erro"+error.toString(), Toast.LENGTH_SHORT).show();
            }
        }){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String,String>map=new HashMap<>();
                map.put("police_id","1");
                return map;
            }
        };


        RequestQueue queue = Volley.newRequestQueue(getContext());
        queue.add(request);
        request.setRetryPolicy(new DefaultRetryPolicy(
                5000,  // Timeout in milliseconds
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT
        ));

        return view;
    }
}