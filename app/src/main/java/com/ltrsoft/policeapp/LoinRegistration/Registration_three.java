package com.ltrsoft.policeapp.LoinRegistration;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.ltrsoft.policeapp.R;

public class Registration_three extends Fragment {

    private Button submit_reg;
    private ImageView back3_btn;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_registration_three, container, false);
        back3_btn=v.findViewById(R.id.back3_btn);
        submit_reg=v.findViewById(R.id.submit_reg);

        back3_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction()
                        .addToBackStack(null) .replace(R.id.main_container,new Registration_two())
                        .commit();
            }
        });
        submit_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction()
                        .addToBackStack(null) .replace(R.id.main_container,new LoginFragment())
                        .commit();
            }
        });

        return v;
    }
}