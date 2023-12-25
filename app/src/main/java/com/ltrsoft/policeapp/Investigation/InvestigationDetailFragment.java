package com.ltrsoft.policeapp.Investigation;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.ltrsoft.policeapp.R;
public class InvestigationDetailFragment extends Fragment {
    public InvestigationDetailFragment() {}
    private TextView investigation_id,investigation_start_date,investigation_end_date,investigation_location,investigation_complaint_id
            ,investigation_incedant_reporting,investigation_evidance_property,investigation_description,investigation_created_at;

   private String fir;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.investigation_detail_fragment, container, false);

        investigation_id=view.findViewById(R.id.investigation_id);
        investigation_start_date=view.findViewById(R.id.investigation_start_date);
        investigation_end_date=view.findViewById(R.id.investigation_end_date);
        investigation_location=view.findViewById(R.id.investigation_location);
        investigation_complaint_id=view.findViewById(R.id.investigation_complaint_id);
        investigation_incedant_reporting=view.findViewById(R.id.investigation_incedant_reporting);
        investigation_evidance_property=view.findViewById(R.id.investigation_evidance_property);
        investigation_description=view.findViewById(R.id.investigation_description);
        investigation_created_at=view.findViewById(R.id.investigation_created_at);

        Bundle b = getArguments();
        fir=b.getString("fir");

        Toast.makeText(getContext(), ""+fir, Toast.LENGTH_SHORT).show();



        return view;
    }
}