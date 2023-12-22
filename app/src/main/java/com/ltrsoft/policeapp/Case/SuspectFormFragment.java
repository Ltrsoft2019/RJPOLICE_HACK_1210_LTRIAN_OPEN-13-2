package com.ltrsoft.policeapp.Case;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.ltrsoft.policeapp.R;
public class SuspectFormFragment extends Fragment {
    public SuspectFormFragment() {}
    public TextView fname,mname,lanme,adress,mobile,dob,email,adhar,photo;
    public Button submit;
    public ImageView back;
    public RadioGroup gender;
  //  public RadioButton male,female;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.suspect_form_fragment, container, false);
        fname  = view.findViewById(R.id.sfname);
        mname  = view.findViewById(R.id.smname);
        lanme  = view.findViewById(R.id.slname);
        adress  = view.findViewById(R.id.sadress);
        mobile  = view.findViewById(R.id.smobno);
        dob  = view.findViewById(R.id.sdob);
        email  = view.findViewById(R.id.semail);
        adhar  = view.findViewById(R.id.sadhar);
        photo  = view.findViewById(R.id.sphoto);

        back=view.findViewById(R.id.suspect_back);

        submit = view.findViewById(R.id.suspect_submit);

        gender=view.findViewById(R.id.sgender);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, new InvestigationFormFragment())
                        .addToBackStack(null)
                        .commit();
            }
        });
        return view;
    }
}