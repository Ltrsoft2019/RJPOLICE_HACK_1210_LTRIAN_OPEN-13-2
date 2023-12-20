package com.ltrsoft.policeapp.Case;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.ltrsoft.policeapp.R;
public class InvestigationFormFragment extends Fragment {
    public InvestigationFormFragment() {}
    public Button incident_photo,victim,witness,suspect,evidence;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.investigation_form_fragment, container, false);
        incident_photo  = view . findViewById(R.id.incident_photo);
        victim = view.findViewById(R.id.Victim);
        witness = view.findViewById(R.id.witness);
        suspect = view.findViewById(R.id.suspect);
        evidence = view.findViewById(R.id.evidence);

        suspect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SuspectFormFragment suspectFormFragment  = new SuspectFormFragment();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, suspectFormFragment)
                        .addToBackStack(null)
                        .commit();
            }
        });

        witness.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WitnessFormFragment witnessFormFragment  = new WitnessFormFragment();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, witnessFormFragment)
                        .addToBackStack(null)
                        .commit();
            }
        });

        victim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               VictimFormFragment victimFormFragment = new VictimFormFragment();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, victimFormFragment)
                        .addToBackStack(null)
                        .commit();
            }
        });

        evidence.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EvidenceForm evidenceForm = new EvidenceForm();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, evidenceForm)
                        .addToBackStack(null)
                        .commit();
            }
        });
        
        return view;
    }
}