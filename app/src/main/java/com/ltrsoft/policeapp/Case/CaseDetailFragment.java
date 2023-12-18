package com.ltrsoft.policeapp.Case;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.ltrsoft.policeapp.R;
public class CaseDetailFragment extends Fragment {
    public CaseDetailFragment() {}
    public TextView id,name,location,time;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.case_detail_fragment, container, false);
       // Toast.makeText(getContext(), "this is course detail fragment", Toast.LENGTH_SHORT).show();

        id=view.findViewById(R.id.case_i);
        name=view.findViewById(R.id.case_n);
        location=view.findViewById(R.id.case_l);
        time=view.findViewById(R.id.case_t);
        Bundle b = getArguments();
        id.setText(b.getString("case_id"));
        name.setText(b.getString("case_name"));
        location.setText(b.getString("case_location"));
        time.setText(b.getString("case_time"));
        return view;
    }
}