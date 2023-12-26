 package com.ltrsoft.policeapp.Investigation;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
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

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

import com.ltrsoft.policeapp.R;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class EvidenceForm extends Fragment {
    public EvidenceForm() {    }
    private static final int REQUEST_IMAGE_GET = 1;
    public String encodeImage;


    private TextView user_gallery,ev_name,e_desc,camera_txt;
    private EditText ename,edesc;
    private ImageView back,user_photo,show_img;
    private Button e_save;

    private static final String BASE_URL = "https://rj.ltr-soft.com/public/police_api/evidance/create_evidance.php";

    private String firid="2023-12-14-1";
    private ProgressBar progressBar2;
    private static final int CAMERA_REQUEST = 101; // Updated request code for camera
    private static final int REQUEST_IMAGE_GET1 = 102; // Request code for gallery image selection

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.evidence_form_fragment, container, false);


        back = view.findViewById(R.id.back1_btn);
        ev_name=view.findViewById(R.id.ev_name);
        e_desc=view.findViewById(R.id.e_desc);
        e_save=view.findViewById(R.id.e_save);
        progressBar2=view.findViewById(R.id.progressBar2);
        progressBar2.setVisibility(View.INVISIBLE);

        user_gallery = view.findViewById(R.id.user_gallery);
        user_photo = view.findViewById(R.id.user_photo);

        camera_txt=view.findViewById(R.id.camera_txt);
        show_img=view.findViewById(R.id.show_img);

        e_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar2.setVisibility(View.VISIBLE);
                e_save.setVisibility(View.INVISIBLE);
                if (ev_name.getText().toString().isEmpty()) {
                    ev_name.setError("Enter Evidence Name");
                    progressBar2.setVisibility(View.INVISIBLE);
                    e_save.setVisibility(View.VISIBLE);
                } else {
                    ev_name.setError(null);
                    if(e_desc.getText().toString().isEmpty()){
                        e_desc.setError("Enter Description");
                        progressBar2.setVisibility(View.INVISIBLE);
                        e_save.setVisibility(View.VISIBLE);
                    }
                    else {
                        e_desc.setError(null);
                        senddata();
                    }
                }
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

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container,new InvestigationFormFragment())
                        .commit();
            }
        });

show_img.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, CAMERA_REQUEST);
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
                showDoneDialog(getContext());

                progressBar2.setVisibility(View.GONE);
                e_save.setVisibility(View.VISIBLE);
                e_desc.setText("");
                ev_name.setText("");
            }
        }, new Response.ErrorListener() {
            @Override


            public void onErrorResponse(VolleyError error) {
                progressBar2.setVisibility(View.INVISIBLE);
                e_save.setVisibility(View.VISIBLE);
                Toast.makeText(getContext(), ""+error, Toast.LENGTH_SHORT).show();
            }
        }) {
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String,String> map=new HashMap<>();
                map.put("fir_id",firid.toString());
                map.put("evidance_name",ev_name.getText().toString());
                map.put("evidance_description",e_desc.getText().toString());

                return map;
            }
        };
        requestQueue.add(stringRequest);
    }

    private void showDoneDialog(Context context) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Evidence ")
                .setMessage("Evidence Saved Successfully")
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {


                        dialog.dismiss();
                    }
                });

        // Create and display the AlertDialog
        AlertDialog dialog = builder.create();
        dialog.show();





    }


    private void openGallery() {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
        startActivityForResult(intent, REQUEST_IMAGE_GET);
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == CAMERA_REQUEST && data != null) {
                Bitmap bitmap = (Bitmap) data.getExtras().get("data");
                show_img.setImageBitmap(bitmap);
                encodeImg(bitmap);
            } else if (requestCode == REQUEST_IMAGE_GET && data != null) {
                try {
                    Uri imageUri = data.getData();
                    InputStream inputStream = getContext().getContentResolver().openInputStream(imageUri);
                    Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                    encodeImg(bitmap);
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    user_photo.setImageURI(imageUri);
                    encodeImg(bitmap);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void encodeImg(Bitmap bitmap) {
    }


}


