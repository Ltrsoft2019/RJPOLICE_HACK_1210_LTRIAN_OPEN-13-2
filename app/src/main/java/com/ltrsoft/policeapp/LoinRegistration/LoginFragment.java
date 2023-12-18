package com.ltrsoft.policeapp.LoinRegistration;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.ltrsoft.policeapp.Navigation.NavigationFragment;
import com.ltrsoft.policeapp.R;

public class LoginFragment extends Fragment {
    public LoginFragment() {}
    private Button login,register;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.login_fragment, container, false);
        Toast.makeText(getContext(), "this is login frgment", Toast.LENGTH_SHORT).show();
        login=view.findViewById(R.id.login_btn);
        register=view.findViewById(R.id.register_btn);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.main_container, new NavigationFragment())
                        .commit();
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.main_container,new RegistrationFragment())
                        .commit();*/
            }
        });
        return view;
    }
}