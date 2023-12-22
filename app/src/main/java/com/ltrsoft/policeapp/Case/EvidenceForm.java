package com.ltrsoft.policeapp.Case;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.ltrsoft.policeapp.LoinRegistration.RegistrationFragment;
import com.ltrsoft.policeapp.R;
public class EvidenceForm extends Fragment {
    public EvidenceForm() {    }
    private TextView gallery,camera;
    private EditText ename,edesc;
    private ImageView back;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.evidence_form_fragment, container, false);

        gallery = view.findViewById(R.id.gallery);
        camera = view.findViewById(R.id.camera);
        back = view.findViewById(R.id.back1_btn);
        ename = view.findViewById(R.id.ename);
        edesc = view.findViewById(R.id.edesc);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container,new InvestigationFormFragment())
                        .commit();
            }
        });
        return view;
    }
}