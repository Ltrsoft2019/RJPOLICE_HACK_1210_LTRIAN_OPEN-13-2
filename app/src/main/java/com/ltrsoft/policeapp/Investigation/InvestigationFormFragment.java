package com.ltrsoft.policeapp.Investigation;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ltrsoft.policeapp.R;
public class InvestigationFormFragment extends Fragment {
    public InvestigationFormFragment() {}
    public TextView case_detail;
    public ImageView back;
    public String fir;
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
        back = view.findViewById(R.id.investigation_back);
        Bundle bundle = getArguments();
        fir=bundle.getString("fir_id");
        Toast.makeText(getContext(), "fir id = "+fir, Toast.LENGTH_SHORT).show();

        suspect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SuspectFormFragment suspectFormFragment  = new SuspectFormFragment();
                Bundle bundle = new Bundle();
                bundle.putString("firid",fir);
                suspectFormFragment.setArguments(bundle);
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
                Bundle bundle = new Bundle();
                bundle.putString("firid",fir);
                witnessFormFragment.setArguments(bundle);
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
                Bundle bundle = new Bundle();
                bundle.putString("firid",fir);
                victimFormFragment.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, victimFormFragment)
                        .addToBackStack(null)
                        .commit();
            }
        });
        incident_photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Investigationphoto investigationphoto =new Investigationphoto();
                Bundle bundle = new Bundle();
                bundle.putString("firid",fir);
                investigationphoto.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, investigationphoto)
                        .addToBackStack(null)
                        .commit();
            }
        });
        evidence.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EvidenceForm evidenceForm = new EvidenceForm();
                Bundle bundle = new Bundle();
                bundle.putString("firid",fir);
                evidenceForm.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, evidenceForm)
                        .addToBackStack(null)
                        .commit();
            }
        });
       back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.status_container, new InvestigationDetailFragment())
                        .addToBackStack(null)
                        .commit();
            }
        });
        return view;
    }
}