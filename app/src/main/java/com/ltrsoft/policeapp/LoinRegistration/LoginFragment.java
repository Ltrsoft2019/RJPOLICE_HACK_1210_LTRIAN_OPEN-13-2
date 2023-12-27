package com.ltrsoft.policeapp.LoinRegistration;

import static android.content.Context.MODE_PRIVATE;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
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
import com.ltrsoft.policeapp.Navigation.NavigationFragment;
import com.ltrsoft.policeapp.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class LoginFragment extends Fragment {
    private static final String BASE_URL = "https://rj.ltr-soft.com/public/police_api/login/police_login.php";

    private Button login;
    private TextView register;
    private EditText login_email,login_password;
    private ProgressBar bar;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.login_fragment, container, false);
        login=view.findViewById(R.id.login_btn);
        register=view.findViewById(R.id.reg);
        login_email=view.findViewById(R.id.email);
        login_password=view.findViewById(R.id.password);
        bar=view.findViewById(R.id.progressBar);
        bar.setVisibility(View.GONE);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String email =login_email.getText().toString();
                String password =login_password.getText().toString();
                if (!email.isEmpty() && !password.isEmpty()) {
                    login(email,password);
                    login.setVisibility(View.GONE);
                    bar.setVisibility(View.VISIBLE);

                } else {
                    login_email.setError("Please Enter Email");
                    login_password.setError("Please Enter Password");
                }
//
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction()
                        .addToBackStack(null) .replace(R.id.main_container,new RegistrationFragment())
                        .commit();
            }
        });
        return view;
    }

    private void login(String email, String password) {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, BASE_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject jsonObject = new JSONObject(response);
                    String msg = jsonObject.getString("Message");
                    if (msg.equals("100")) {
                        Toast.makeText(getContext(), "Login Successfully", Toast.LENGTH_SHORT).show();

                        getActivity().getSupportFragmentManager().beginTransaction()
                                .addToBackStack(null).replace(R.id.main_container, new NavigationFragment())
                                .commit();

                        bar.setVisibility(View.GONE);
                        login.setVisibility(View.VISIBLE);
                        SharedPreferences pref = getActivity().getSharedPreferences("login", MODE_PRIVATE);
                        SharedPreferences.Editor editor = pref.edit();
                        editor.putBoolean("flag", true)
                                .apply();



                    } else if (msg.equals("200")) {
                        Toast.makeText(getContext(), "Invalid Password", Toast.LENGTH_LONG).show();
                        bar.setVisibility(View.GONE);
                        login.setVisibility(View.VISIBLE);

                    } else {
                        Toast.makeText(getContext(), "Police Not Found Please Registration ", Toast.LENGTH_LONG).show();
                        bar.setVisibility(View.GONE);
                        login.setVisibility(View.VISIBLE);

                    }
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
        },

                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getContext(), "Error Response " + error.toString(), Toast.LENGTH_SHORT).show();

                    }
                }) {
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> map = new HashMap<>();
                map.put("email",email);
                map.put("password",password);
                return map;
            }
        };
        RequestQueue queue = Volley.newRequestQueue(getActivity());
        queue.add(stringRequest);

    }
}