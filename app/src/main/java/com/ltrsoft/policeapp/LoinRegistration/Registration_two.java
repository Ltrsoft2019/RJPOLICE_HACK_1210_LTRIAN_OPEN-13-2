package com.ltrsoft.policeapp.LoinRegistration;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.ltrsoft.policeapp.R;

public class Registration_two extends Fragment {

    private static final int REQUEST_IMAGE_GET = 1;
    private Button reg2_btn;
    private ImageView back2_btn, user_photo;
    private TextView user_gallery;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_registration_two, container, false);
        reg2_btn = v.findViewById(R.id.reg2_btn);
        back2_btn = v.findViewById(R.id.back2_btn);
        user_gallery = v.findViewById(R.id.user_gallery);
        user_photo = v.findViewById(R.id.user_photo);

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
                getActivity().getSupportFragmentManager().beginTransaction()
                        .addToBackStack(null).replace(R.id.main_container, new Registration_three())
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
                    // Get the selected image URI
                    Uri imageUri = data.getData();

                    // Display the selected image in ImageView
                    user_photo.setImageURI(imageUri);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
