package com.ltrsoft.policeapp.Investigation;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.ltrsoft.policeapp.LoinRegistration.LoginFragment;
import com.ltrsoft.policeapp.Navigation.NavigationFragment;
import com.ltrsoft.policeapp.R;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class VictimFormFragment extends Fragment {

    private EditText vv_firname,vv_fname,vv_mname,v_lname,vf_dob,v_mobile,v_address,v_email,v_contryname,v_statename,
            v_distname,v_cityname,v_addhar;
    private static final int REQUEST_IMAGE_GET = 1;


    private Button v_submit;

    private RadioButton v_male_btn,v_female_btn;
    private String gender,encodeImage;
    private ProgressBar v_progressbar;

    private String firid="2023-12-14-1";

    private RadioGroup v_radioGroup;
    private TextView user_gallery;

    private static final String BASE_URL = "https://rj.ltr-soft.com/public/police_api/investigation_witness/create__investigation_witness.php";

    private ImageView v_back,user_photo;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.victim_form_form, container, false);

        vv_fname=view.findViewById(R.id.vv_fname);
        vv_mname=view.findViewById(R.id.vv_mname);
        v_lname=view.findViewById(R.id.v_lname);
        vf_dob=view.findViewById(R.id.vf_dob);
        v_mobile=view.findViewById(R.id.v_mobile);
        v_address=view.findViewById(R.id.v_address);
        v_email=view.findViewById(R.id.v_email);
        v_contryname=view.findViewById(R.id.v_contryname);
        v_statename=view.findViewById(R.id.v_statename);
        v_distname=view.findViewById(R.id.v_distname);
        v_cityname=view.findViewById(R.id.v_cityname);
        v_addhar=view.findViewById(R.id.v_addhar);
        v_submit=view.findViewById(R.id.v_submit);
        v_male_btn=view.findViewById(R.id.v_male_btn);
        v_female_btn=view.findViewById(R.id.v_female_btn);
        v_progressbar=view.findViewById(R.id.v_progressbar);
        v_radioGroup= view.findViewById(R.id.v_radioGroup);
        v_back=view.findViewById(R.id.v_back);


        user_gallery = view.findViewById(R.id.user_gallery);
        user_photo = view.findViewById(R.id.user_photo);

        v_progressbar.setVisibility(View.INVISIBLE);

        v_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction()
                        .addToBackStack(null) .replace(R.id.main_container,new NavigationFragment())
                        .commit();
            }
        });
        v_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(v_male_btn.isChecked()){
                    gender=v_male_btn.getText().toString();
                } else if (v_female_btn.isChecked()) {
                    gender=v_female_btn.getText().toString();

                }
                else {
                    Toast.makeText(getContext(), "Please Select Gender", Toast.LENGTH_SHORT).show();
                }
                senddata();
            }
        });


        user_gallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGallery();
            }
        });

        user_photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGallery();
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
                Toast.makeText(getContext(), "Response="+response.toString(), Toast.LENGTH_LONG).show();

                v_progressbar.setVisibility(View.GONE);
                v_submit.setVisibility(View.VISIBLE);

                vv_firname.setText("");
                 vv_fname.setText("");
                vv_mname.setText("");
                v_lname.setText("");
                vf_dob.setText("");
                v_mobile.setText("");
                v_address.setText("");
                v_email.setText("");
                v_contryname.setText("");
                v_statename.setText("");
                v_distname.setText("");
                v_cityname.setText("");
                v_addhar.setText("");
                v_radioGroup.clearCheck();
                user_photo.setImageResource(R.drawable.person);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VictimFormFragment.this.onErrorResponse(error);
            }
        }) {
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String,String> map=new HashMap<>();

                map.put("fir_id",firid.toString());
                map.put("investigation_witness_fname",vv_fname.getText().toString());
                map.put("investigation_witness_mname",vv_mname.getText().toString());
                map.put("investigation_witness_lname",v_lname.getText().toString());
                map.put("investigation_witness_dob",vf_dob.getText().toString());
                map.put("investigation_witness_mobile",v_mobile.getText().toString());
                map.put("investigation_witness_address",v_address.getText().toString());
                map.put("investigation_witness_email",v_email.getText().toString());
                map.put("country_id","1");
                map.put("state_id","1");
                map.put("district_id","1");
                map.put("city_id","1");
                map.put("investigation_witness_gender",gender);
//                map.put("country_id",v_contryname.getText().toString());
//                map.put("state_id",v_statename.getText().toString());
//                map.put("district_id",v_distname.getText().toString());
//                map.put("city_id",v_cityname.getText().toString());
                map.put("investigation_witness_adhar",v_addhar.getText().toString());
                map.put("investigation_witness_photo",encodeImage.toString());
                return map;
            }
        };

        requestQueue.add(stringRequest);
    }

    private void openGallery() {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
        startActivityForResult(intent, REQUEST_IMAGE_GET);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_GET && resultCode == Activity.RESULT_OK) {
            if (data != null) {
                try {
                    // Get the selected image URI
                    Uri imageUri = data.getData();

                    InputStream inputStream =getContext().getContentResolver().openInputStream(imageUri);
                    Bitmap bitmap = BitmapFactory.decodeStream(inputStream);

                    // Display the selected image in ImageView
                    user_photo.setImageURI(imageUri);

                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    bitmap.compress(Bitmap.CompressFormat.JPEG,100,byteArrayOutputStream);
                    byte[] bytes = byteArrayOutputStream.toByteArray();
                    encodeImage = android.util.Base64.encodeToString(bytes, Base64.DEFAULT);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public void onErrorResponse(VolleyError error) {
        v_progressbar.setVisibility(View.INVISIBLE);
        v_submit.setVisibility(View.VISIBLE);
        if (error.networkResponse != null) {
            int statusCode = error.networkResponse.statusCode;
            Log.e("StatusCode", String.valueOf(statusCode));
        }
        Toast.makeText(getContext(), "Error: " + error.toString(), Toast.LENGTH_SHORT).show();
    }


}