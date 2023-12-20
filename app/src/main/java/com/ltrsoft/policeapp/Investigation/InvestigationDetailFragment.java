package com.ltrsoft.policeapp.Investigation;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ltrsoft.policeapp.R;
public class InvestigationDetailFragment extends Fragment {
    public InvestigationDetailFragment() {}
    private TextView idwitness,idvictim,idsuspect,idcrime_type,idcomplain_name;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.investigation_detail_fragment, container, false);
        idcomplain_name = view.findViewById(R.id.idcomplain_name);
        idwitness = view.findViewById(R.id.idwitness);
        idvictim=view.findViewById(R.id.idvictim);
        idsuspect = view.findViewById(R.id.idsuspect);
        idcrime_type = view.findViewById(R.id.idcrime_type);

        Bundle b = getArguments();
        idcomplain_name.setText(b.getString("complain_name"));
        idcrime_type.setText(b.getString("crime_type"));
        idsuspect.setText(b.getString("suspect"));
        idwitness.setText(b.getString("witness"));
        idvictim.setText(b.getString("victim"));


        return view;
    }
}