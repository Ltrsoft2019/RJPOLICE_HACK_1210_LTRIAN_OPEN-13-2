package com.ltrsoft.policeapp.LoinRegistration;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.ltrsoft.policeapp.R;

import java.util.HashMap;
import java.util.Map;

public class RegistrationFragment extends Fragment {
    public RegistrationFragment() {}
    private Button register;
    private ImageView back1;
    private EditText create_fname,create_mname,create_lname,create_email,create_password;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.registration_fragment, container, false);
        register = v.findViewById(R.id.reg1_btn);
        back1 = v.findViewById(R.id.back1_btn);

        create_fname = v.findViewById(R.id.create_fname);
        create_mname = v.findViewById(R.id.create_mname);
        create_lname = v.findViewById(R.id.create_lname);
        create_email = v.findViewById(R.id.create_email);
        create_password = v.findViewById(R.id.create_password);

        back1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction()
                        .addToBackStack(null).replace(R.id.main_container, new LoginFragment())
                        .commit();
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (create_fname.getText().toString().trim().isEmpty()) {
                    create_fname.setError("Enter First Name");
                } else {
                    create_fname.setError(null);


                    if (create_lname.getText().toString().trim().isEmpty()) {
                        create_lname.setError("Enter last Name");

                    } else {
                        create_lname.setError(null);
                        if (create_email.getText().toString().trim().isEmpty()) {
                            create_email.setError("Enter last Name");

                        } else {
                            create_email.setError(null);
                            if (create_password.getText().toString().trim().isEmpty()) {
                                create_password.setError("Enter last Name");

                            } else {
                                create_password.setError(null);
                                String pass = create_password.getText().toString();

                                if (pass.length() > 7) {

                                    Registration_two registrationTwo=new Registration_two();
                                    Bundle b = new Bundle();
                                    b.putString("fname", create_fname.getText().toString());
                                    b.putString("mname", create_mname.getText().toString());
                                    b.putString("lname", create_lname.getText().toString());
                                    b.putString("email",create_email.getText().toString());
                                    b.putString("password",create_password.getText().toString());

                                    registrationTwo.setArguments(b);
                                    getActivity().getSupportFragmentManager().beginTransaction()
                                            .addToBackStack(null).replace(R.id.main_container, registrationTwo)
                                            .commit();


                                } else {
                                    Toast.makeText(getContext(), "Please Enter Strong Password", Toast.LENGTH_SHORT).show();


                                }
                            }
                        }
                    }
                }
            }



        });

        return v;
    }




}