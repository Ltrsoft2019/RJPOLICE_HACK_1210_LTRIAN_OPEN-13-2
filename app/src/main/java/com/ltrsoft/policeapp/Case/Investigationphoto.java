package com.ltrsoft.policeapp.Case;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;


import com.ltrsoft.policeapp.MainActivity;
import com.ltrsoft.policeapp.R;




public class Investigationphoto extends Fragment {

    private Button camera, gallery;
    private ImageView show_img;
    private static final int CAMERA_REQUEST = 101; // Updated request code for camera
    private static final int REQUEST_IMAGE_GET = 102; // Request code for gallery image selection

    // ... (other parts of your code)

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == CAMERA_REQUEST && data != null) {
                // Handle image captured from camera
                Bitmap bitmap = (Bitmap) data.getExtras().get("data");
                show_img.setImageBitmap(bitmap);
            } else if (requestCode == REQUEST_IMAGE_GET && data != null) {
                // Handle image selected from gallery
                try {
                    // Get the selected image URI
                    Uri imageUri = data.getData();

                    // Display the selected image in ImageView
                    show_img.setImageURI(imageUri);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_investigationphoto, container, false);
        camera = view.findViewById(R.id.camera);
        show_img = view.findViewById(R.id.show_img);
        gallery = view.findViewById(R.id.Gallery);

        if (ContextCompat.checkSelfPermission(getContext(), Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.CAMERA}, CAMERA_REQUEST);
        }

        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, CAMERA_REQUEST);
            }
        });

        gallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(intent, REQUEST_IMAGE_GET);
            }
        });

        return view;
    }

}
