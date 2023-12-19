package com.ltrsoft.policeapp.LoinRegistration;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.ltrsoft.policeapp.R;

public class RegistrationFragment extends Fragment {
    public RegistrationFragment() {}
    private Button register;
    private ImageView back1;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.registration_fragment, container, false);
        register=v.findViewById(R.id.reg1_btn);
        back1=v.findViewById(R.id.back1_btn);

        back1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction()
                        .addToBackStack(null) .replace(R.id.main_container,new LoginFragment())
                        .commit();
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction()
                        .addToBackStack(null) .replace(R.id.main_container,new Registration_two())
                        .commit();
            }
        });

        return v;
    }
}