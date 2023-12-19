package com.ltrsoft.policeapp.LoinRegistration;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.ltrsoft.policeapp.R;

public class Registration_two extends Fragment {
    private Button reg2_btn;
    private ImageView back2_btn;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_registration_two, container, false);
        reg2_btn=v.findViewById(R.id.reg2_btn);
        back2_btn=v.findViewById(R.id.back2_btn);

        back2_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction()
                        .addToBackStack(null) .replace(R.id.main_container,new RegistrationFragment())
                        .commit();
            }
        });
        reg2_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction()
                        .addToBackStack(null) .replace(R.id.main_container,new Registration_three())
                        .commit();
            }
        });

        return v;
    }
}