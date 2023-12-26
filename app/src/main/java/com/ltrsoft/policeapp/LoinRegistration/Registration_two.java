package com.ltrsoft.policeapp.LoinRegistration;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.ltrsoft.policeapp.R;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class Registration_two extends Fragment {

    private static final int REQUEST_IMAGE_GET = 1;
    private Button reg2_btn;
    private ImageView back2_btn, user_photo;
    private TextView user_gallery;
    private String gender;
    private RadioButton femail_btn,male_btn;
    private EditText dob,mobile,altmob;
    private RadioGroup radioGroup;
    private String tem_fname,tem_mname,tem_nname,tem_email,tem_password;
    private String encodeImage;
    private static final String BASE_URL = "https://rj.ltr-soft.com/public/police_api/data/police_insert.php";


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_registration_two, container, false);
        reg2_btn = v.findViewById(R.id.reg2_btn);
        back2_btn = v.findViewById(R.id.back2_btn);
        user_gallery = v.findViewById(R.id.user_gallery);
        user_photo = v.findViewById(R.id.user_photo);

        femail_btn=v.findViewById(R.id.femail_btn);
        male_btn=v.findViewById(R.id.male_btn);

        dob=v.findViewById(R.id.dob);
        mobile=v.findViewById(R.id.mobile);
        altmob=v.findViewById(R.id.altmob);
        radioGroup=v.findViewById(R.id.radioGroup);

        Bundle b = getArguments();
         tem_fname=b.getString("fname");
         tem_mname=b.getString("mname");
        tem_nname=b.getString("lname");
        tem_email=b.getString("email");
        tem_password=b.getString("password");





        back2_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction()
                        .addToBackStack(null).replace(R.id.main_container, new RegistrationFragment())
                        .commit();
            }
        });

        reg2_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (femail_btn.isChecked()) {

                     gender=femail_btn.getText().toString();

                }  else if (male_btn.isChecked()) {

                    gender=male_btn.getText().toString();
                }

               Registration_three registrationThree=new Registration_three();
                Bundle b = new Bundle();
                b.putString("dob", dob.getText().toString());
                b.putString("mobile", mobile.getText().toString());
                b.putString("altmob", altmob.getText().toString());
                b.putString("gender",gender.toString());
                b.putString("temfname",tem_fname.toString());
                b.putString("temmname",tem_mname.toString());
                b.putString("temnname",tem_nname.toString());
                b.putString("tememail",tem_email.toString());
                b.putString("tempassword",tem_password.toString());
                if (encodeImage!=null){
                    b.putString("userimg",encodeImage);
                }

                registrationThree.setArguments(b);
                getActivity().getSupportFragmentManager().beginTransaction()
                        .addToBackStack(null).replace(R.id.main_container, registrationThree)
                        .commit();


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

        return v;
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
                    Uri imageUri = data.getData();
                    user_photo.setImageURI(imageUri);
                    InputStream inputStream = getContext().getContentResolver().openInputStream(imageUri);
                    Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    bitmap.compress(Bitmap.CompressFormat.JPEG,100,byteArrayOutputStream);
                    byte[] bytes = byteArrayOutputStream.toByteArray();
                    encodeImage = android.util.Base64.encodeToString(bytes, Base64.DEFAULT);
                  //  Toast.makeText(getContext(), "encode image"+encodeImage, Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }



}
