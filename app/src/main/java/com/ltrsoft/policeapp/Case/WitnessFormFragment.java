package com.ltrsoft.policeapp.Case;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.ltrsoft.policeapp.R;

import java.util.HashMap;
import java.util.Map;

public class WitnessFormFragment extends Fragment {

    public WitnessFormFragment() {    }
    public ImageView back;
    private EditText w_fname,w_mname,w_lname,w_address,w_dob,w_mobile,w_email,w_adhar,w_country,w_statename,w_city;
    private RadioButton male,female;
    private RadioGroup radioGroup;

    private String gender;

    private Button w_submit;
    private String fir="2023-12-14-1";
    private static final String BASE_URL = "https://rj.ltr-soft.com/public/police_api/investigation_witness/create__investigation_witness.php";
    private ProgressBar w_progressBar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.witness_fragment, container, false);
        w_fname=view.findViewById(R.id.w_fname);
        w_mname=view.findViewById(R.id.w_mname);
        w_lname=view.findViewById(R.id.w_lname);
        w_address=view.findViewById(R.id.w_address);
        w_dob=view.findViewById(R.id.w_dob);
        w_mobile=view.findViewById(R.id.w_mobile);
        w_email=view.findViewById(R.id.w_email);
        w_adhar=view.findViewById(R.id.w_adhar);
        w_country=view.findViewById(R.id.w_country);
        w_statename=view.findViewById(R.id.w_statename);
        w_city=view.findViewById(R.id.w_city);
        male=view.findViewById(R.id.w_male_btn);
        female=view.findViewById(R.id.w_female_btn);
        radioGroup=view.findViewById(R.id.radioGroup);
        w_submit=view.findViewById(R.id.w_submit);
        w_progressBar=view.findViewById(R.id.w_progressBar);

        w_progressBar.setVisibility(View.INVISIBLE);

        w_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                w_submit.setVisibility(View.INVISIBLE);
                w_progressBar.setVisibility(View.VISIBLE);
                    if(male.isChecked()){
                        gender=male.getText().toString();
                    } else if (female.isChecked()) {
                        gender=female.getText().toString();
                    }
                    else {
                        Toast.makeText(getContext(), "Please Select Gender", Toast.LENGTH_SHORT).show();
                    }

                    senddata();
            }
        });

        return view;
    }


    public void senddata(){
        RequestQueue requestQueue= Volley.newRequestQueue(getContext());
        StringRequest stringRequest =new StringRequest(Request.Method.POST,
                BASE_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(getContext(), "Record Saved", Toast.LENGTH_LONG).show();
                w_progressBar.setVisibility(View.INVISIBLE);
                w_submit.setVisibility(View.VISIBLE);
                w_fname.setText("");
                w_mname.setText("");
                w_lname.setText("");
                w_address.setText("");
                w_dob.setText("");
                w_mobile.setText("");
                w_email.setText("");
                w_adhar.setText("");
                radioGroup.clearCheck();
                w_country.setText("");
                w_statename.setText("");
                w_city.setText("");


            }
        }, new Response.ErrorListener() {
            @Override


            public void onErrorResponse(VolleyError error) {
                w_progressBar.setVisibility(View.INVISIBLE);
               w_submit.setVisibility(View.VISIBLE);
                Toast.makeText(getContext(), ""+error, Toast.LENGTH_SHORT).show();
            }
        }) {
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String,String> map=new HashMap<>();



                map.put("investigation_witness_fname",w_fname.getText().toString());
                map.put("investigation_witness_mname",w_mname.getText().toString());
                map.put("investigation_witness_lname",w_lname.getText().toString());
                map.put("investigation_witness_address",w_address.getText().toString());
                map.put("investigation_witness_dob",w_dob.getText().toString());
                map.put("investigation_witness_mobile",w_mobile.getText().toString());
                map.put("investigation_witness_email",w_email.getText().toString());
                map.put("investigation_witness_adhar",w_adhar.getText().toString());
                map.put("country_id",w_country.getText().toString());
                map.put("state_id",w_statename.getText().toString());
                map.put("city_id",w_city.getText().toString());
                map.put("investigation_witness_gender",gender.toString());
                map.put("fir_id",fir.toString());
                return map;
            }
        };
        requestQueue.add(stringRequest);
    }
}