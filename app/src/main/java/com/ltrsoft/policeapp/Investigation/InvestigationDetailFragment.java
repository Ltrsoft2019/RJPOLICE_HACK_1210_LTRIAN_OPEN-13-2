package com.ltrsoft.policeapp.Investigation;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.ltrsoft.policeapp.R;
public class InvestigationDetailFragment extends Fragment {
    public InvestigationDetailFragment() {}
    private TextView fir_id,complaint_subject,complaint_type_name,complaintORfir_name,status_name;
    private TextView suspect_name,suspect_address,suspect_gender,suspect_mobile_no,suspect_dob;
    private TextView investigation_witness_name, investigation_witness_address,investigation_witness_dob,investigation_witness_gender,
            investigation_witness_mobile;
    private TextView victim_name, victim_address,victim_gender,victim_mobile_no,victim_dob;
    private Button addinfobtn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.investigation_detail_fragment, container, false);
        Bundle b= getArguments();

        addinfobtn = view.findViewById(R.id.addinfobtn);

        fir_id = view.findViewById(R.id.ifirno);
        complaint_subject = view.findViewById(R.id.invstcompalin_name);
        complaint_type_name = view.findViewById(R.id.crime_type);
        complaintORfir_name = view.findViewById(R.id.complainorfir);
        status_name = view.findViewById(R.id.status);
        suspect_name = view.findViewById(R.id.s_name);
        suspect_address = view.findViewById(R.id.sadress);
        suspect_gender = view.findViewById(R.id.sgender);
        suspect_mobile_no = view.findViewById(R.id.suspect_no);
        suspect_dob = view.findViewById(R.id.sdob);
        investigation_witness_name = view.findViewById(R.id.wname);
        investigation_witness_address = view.findViewById(R.id.wadress);
        investigation_witness_dob = view.findViewById(R.id.wdob);
        investigation_witness_gender = view.findViewById(R.id.wgender);
        investigation_witness_mobile = view.findViewById(R.id.witness_mobno);
        victim_name = view.findViewById(R.id.vname);
        victim_address = view.findViewById(R.id.vadress);
        victim_gender = view.findViewById(R.id.vgender);
        victim_mobile_no = view.findViewById(R.id.victim_mobno);
        victim_dob = view.findViewById(R.id.vdob);

        if (b!=null) {
            fir_id.setText(b.getString("fir_id"));
            complaint_subject.setText(b.getString("complaint_subject"));
            complaint_type_name.setText(b.getString("complaint_type_name"));
            complaintORfir_name.setText(b.getString("complaintORfir_name"));
            status_name.setText(b.getString("status_name"));
            suspect_name.setText(b.getString("suspect_name"));
            suspect_address.setText(b.getString("suspect_address"));
            suspect_gender.setText(b.getString("suspect_gender"));
            suspect_mobile_no.setText(b.getString("suspect_mobile_no"));
            suspect_dob.setText(b.getString("suspect_dob"));
            investigation_witness_name.setText(b.getString("investigation_witness_name"));
            investigation_witness_address.setText(b.getString("investigation_witness_address"));
            investigation_witness_dob.setText(b.getString("investigation_witness_dob"));
            investigation_witness_gender.setText(b.getString("investigation_witness_gender"));
            investigation_witness_mobile.setText(b.getString("investigation_witness_mobile"));
            victim_name.setText(b.getString("victim_name"));
            victim_address.setText(b.getString("victim_address"));
            victim_gender.setText(b.getString("victim_gender"));
            victim_mobile_no.setText(b.getString("victim_mobile_no"));
            victim_dob.setText(b.getString("victim_dob"));
        }
        addinfobtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                InvestigationFormFragment invstFragment =new InvestigationFormFragment();
                //  AppCompatActivity activity=(AppCompatActivity)view.getContext();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, new InvestigationFormFragment())
                        .addToBackStack(null)
                        .commit();
            }
        });
        return view;
    }
}