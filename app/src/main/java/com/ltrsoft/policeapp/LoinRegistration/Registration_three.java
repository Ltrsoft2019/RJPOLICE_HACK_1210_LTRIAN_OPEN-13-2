package com.ltrsoft.policeapp.LoinRegistration;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.ltrsoft.policeapp.R;

import java.util.ArrayList;
import java.util.Arrays;

public class Registration_three extends Fragment {

    private Button submit_reg;
    private ImageView back3_btn;
    private Spinner spinner2,spinner3,spinner4,spinner5,spinner6;
    private TextView Login_txt;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_registration_three, container, false);
        back3_btn=v.findViewById(R.id.back3_btn);
        submit_reg=v.findViewById(R.id.submit_reg);
        spinner2=v.findViewById(R.id.spinner);
        spinner6=v.findViewById(R.id.spinner5);
        spinner3=v.findViewById(R.id.spinner2);
        spinner4=v.findViewById(R.id.spinner3);
        spinner5=v.findViewById(R.id.spinner4);
        Login_txt=v.findViewById(R.id.Login_txt);
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

        Login_txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction()
                        .addToBackStack(null) .replace(R.id.main_container,new LoginFragment())
                        .commit();

            }
        });


        String[] value2={"Select","1","2","3"};
        ArrayList<String> arrayList2=new ArrayList<>(Arrays.asList(value2));
        ArrayAdapter<String> arrayAdapter2=new ArrayAdapter<>(getActivity(),R.layout.stylespinner,arrayList2);
        spinner2.setAdapter(arrayAdapter2);





        String[] value3={"Select","1","2","3"};
        ArrayList<String> arrayList3=new ArrayList<>(Arrays.asList(value3));
        ArrayAdapter<String> arrayAdapter3=new ArrayAdapter<>(getActivity(),R.layout.stylespinner,arrayList3);
        spinner3.setAdapter(arrayAdapter3);




        String[] value4={"Select","1","2","3"};
        ArrayList<String> arrayList4=new ArrayList<>(Arrays.asList(value4));
        ArrayAdapter<String> arrayAdapter4=new ArrayAdapter<>(getActivity(),R.layout.stylespinner,arrayList4);
        spinner4.setAdapter(arrayAdapter4);




        String[] value5={"Select","1","2","3"};
        ArrayList<String> arrayList5=new ArrayList<>(Arrays.asList(value5));
        ArrayAdapter<String> arrayAdapter5=new ArrayAdapter<>(getActivity(),R.layout.stylespinner,arrayList5);
        spinner5.setAdapter(arrayAdapter5);




        String[] value6={"Select","1","2","3"};
        ArrayList<String> arrayList6=new ArrayList<>(Arrays.asList(value6));
        ArrayAdapter<String> arrayAdapter6=new ArrayAdapter<>(getActivity(),R.layout.stylespinner,arrayList6);
        spinner6.setAdapter(arrayAdapter6);




        return v;
    }
}