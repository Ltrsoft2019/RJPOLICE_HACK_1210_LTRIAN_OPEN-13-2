package com.ltrsoft.policeapp.Case;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
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
import com.ltrsoft.policeapp.LoinRegistration.LoginFragment;
import com.ltrsoft.policeapp.LoinRegistration.RegistrationFragment;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.ltrsoft.policeapp.R;

import java.util.HashMap;
import java.util.Map;

public class EvidenceForm extends Fragment {
    public EvidenceForm() {    }
    private TextView gallery,camera,ev_name,e_desc;
    private EditText ename,edesc;
    private ImageView back;
    private Button e_save;

    private static final String BASE_URL = "https://rj.ltr-soft.com/public/police_api/evidance/create_evidance.php";

    private String firid="2023-12-14-1";
    private ProgressBar progressBar2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.evidence_form_fragment, container, false);

        gallery = view.findViewById(R.id.gallery);
        camera = view.findViewById(R.id.camera);
        back = view.findViewById(R.id.back1_btn);
        ev_name=view.findViewById(R.id.ev_name);
        e_desc=view.findViewById(R.id.e_desc);
        e_save=view.findViewById(R.id.e_save);
        progressBar2=view.findViewById(R.id.progressBar2);
        progressBar2.setVisibility(View.INVISIBLE);

        e_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar2.setVisibility(View.VISIBLE);
                e_save.setVisibility(View.INVISIBLE);
                if (ev_name.getText().toString().isEmpty()) {
                    ev_name.setError("Enter Evidence Name");
                    progressBar2.setVisibility(View.INVISIBLE);
                    e_save.setVisibility(View.VISIBLE);
                } else {
                    ev_name.setError(null);
                    if(e_desc.getText().toString().isEmpty()){
                        e_desc.setError("Enter Description");
                        progressBar2.setVisibility(View.INVISIBLE);
                        e_save.setVisibility(View.VISIBLE);
                    }
                    else {
                        e_desc.setError(null);
                        senddata();
                    }
                }
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container,new InvestigationFormFragment())
                        .commit();
            }
        });


        return view;

        }

    public void senddata(){
        RequestQueue requestQueue= Volley.newRequestQueue(getContext());
        StringRequest stringRequest =new StringRequest(Request.Method.POST,
                BASE_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                showDoneDialog(getContext());

                progressBar2.setVisibility(View.GONE);
                e_save.setVisibility(View.VISIBLE);
                e_desc.setText("");
                ev_name.setText("");
            }
        }, new Response.ErrorListener() {
            @Override


            public void onErrorResponse(VolleyError error) {
                progressBar2.setVisibility(View.INVISIBLE);
                e_save.setVisibility(View.VISIBLE);
                Toast.makeText(getContext(), ""+error, Toast.LENGTH_SHORT).show();
            }
        }) {
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String,String> map=new HashMap<>();
                map.put("fir_id",firid.toString());
                map.put("evidance_name",ev_name.getText().toString());
                map.put("evidance_description",e_desc.getText().toString());

                return map;
            }
        };
        requestQueue.add(stringRequest);
    }

    private void showDoneDialog(Context context) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Evidence ")
                .setMessage("Evidence Saved Successfully")
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        dialog.dismiss();
                    }
                });

        // Create and display the AlertDialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }

}