package com.ltrsoft.policeapp.loinRegistration;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.ltrsoft.policeapp.R;

public class RegistrationFragment extends Fragment {
    public RegistrationFragment() {}
    private Button register;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.registration_fragment, container, false);
        Toast.makeText(getContext(), "this is register frgment", Toast.LENGTH_SHORT).show();
        register=view.findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "register Successful", Toast.LENGTH_SHORT).show();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.main_container, new LoginFragment())
                        .commit();
            }
        });

        return view;
    }
}