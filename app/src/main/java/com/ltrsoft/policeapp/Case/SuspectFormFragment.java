package com.ltrsoft.policeapp.Case;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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
import com.ltrsoft.policeapp.Investigation.InvestigationFormFragment;
import com.ltrsoft.policeapp.R;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class SuspectFormFragment extends Fragment {
    public SuspectFormFragment() {}
    private static final int REQUEST_IMAGE_GET = 1;

    private TextView fname,mname,lanme,adress,mobile,dob,email,adhar,user_gallery;
    private Button submit;
     private ImageView back,user_photo;
    private RadioGroup radioGroup;
    private RadioButton male_btn,femail_btn;
    private String gender;
    private ProgressBar progressBar;
    private String encodeImage;

    private String id="2023-12-14-1";
    private static final String BASE_URL = "https://rj.ltr-soft.com/public/police_api/Investigation_suspect/create_investigation_suspect.php";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.suspect_form_fragment, container, false);
        fname  = view.findViewById(R.id.sfname);
        mname  = view.findViewById(R.id.smname);
        lanme  = view.findViewById(R.id.slname);
        adress  = view.findViewById(R.id.sadress);
        mobile  = view.findViewById(R.id.smobno);
        dob  = view.findViewById(R.id.sdob);
        email  = view.findViewById(R.id.semail);
        adhar  = view.findViewById(R.id.sadhar);
        user_gallery = view.findViewById(R.id.user_gallery);
        user_photo = view.findViewById(R.id.user_photo);


        back=view.findViewById(R.id.suspect_back);

        submit = view.findViewById(R.id.suspect_submit);

        radioGroup=view.findViewById(R.id.radioGroup);
        male_btn=view.findViewById(R.id.male_btn);
        femail_btn=view.findViewById(R.id.femail_btn);

        progressBar=view.findViewById(R.id.progressBar);

        progressBar.setVisibility(View.INVISIBLE);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, new InvestigationFormFragment())
                        .addToBackStack(null)
                        .commit();
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(male_btn.isChecked()){
                    gender=male_btn.getText().toString();
                } else if (femail_btn.isChecked()) {
                    gender=femail_btn.getText().toString();

                }
                else {
                    Toast.makeText(getContext(), "Please Select Gender", Toast.LENGTH_SHORT).show();
                }
                submit.setVisibility(View.INVISIBLE);
                progressBar.setVisibility(View.VISIBLE);
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
                Toast.makeText(getContext(), "Record Saved", Toast.LENGTH_LONG).show();
                progressBar.setVisibility(View.INVISIBLE);
                submit.setVisibility(View.VISIBLE);
                fname.setText("");
                mname.setText("");
                lanme.setText("");
                adress.setText("");
                mobile.setText("");
                dob.setText("");
                email.setText("");
                adhar.setText("");
                radioGroup.clearCheck();
                user_photo.setImageResource(R.drawable.person);


            }
        }, new Response.ErrorListener() {
            @Override


            public void onErrorResponse(VolleyError error) {
                progressBar.setVisibility(View.INVISIBLE);
                submit.setVisibility(View.VISIBLE);
                Toast.makeText(getContext(), ""+error, Toast.LENGTH_SHORT).show();
            }
        }) {
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String,String> map=new HashMap<>();
                map.put("suspect_fname",fname.getText().toString());
                map.put("suspect_mname",mname.getText().toString());
                map.put("suspect_lname",lanme.getText().toString());
                map.put("suspect_address",adress.getText().toString());
                map.put("suspect_dob",dob.getText().toString());
                map.put("suspect_gender",gender.toString());
                map.put("suspect_mobile_no",mobile.getText().toString());
                map.put("suspect_email",email.getText().toString());
                map.put("suspect_adhar",adhar.getText().toString());
                map.put("fir_id",id.toString());
                map.put("suspect_photo",encodeImage.toString());
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


}
