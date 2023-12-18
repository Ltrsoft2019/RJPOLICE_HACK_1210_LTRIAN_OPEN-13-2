package com.ltrsoft.policeapp.Case;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.ltrsoft.policeapp.R;
public class CaseDetailFragment extends Fragment {
    public CaseDetailFragment() {}
    public TextView id,name,location,time;
    public Button get_loaction,add_info_btn;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.case_detail_fragment, container, false);
       // Toast.makeText(getContext(), "this is course detail fragment", Toast.LENGTH_SHORT).show();

        get_loaction=view.findViewById(R.id.location);
        add_info_btn = view.findViewById(R.id.investigation_form);

        id=view.findViewById(R.id.case_i);
        name=view.findViewById(R.id.case_n);
        location=view.findViewById(R.id.case_l);
        time=view.findViewById(R.id.case_t);
        Bundle b = getArguments();
        id.setText(b.getString("case_id"));
        name.setText(b.getString("case_name"));
        location.setText(b.getString("case_location"));
        time.setText(b.getString("case_time"));

        get_loaction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CaseMapsFragment mapsFragment =new CaseMapsFragment();
               // AppCompatActivity activity=(AppCompatActivity)view.getContext();
                Bundle bundle = new Bundle();
                bundle.putDouble("lattitude",18.2505);
                bundle.putDouble("longitude",76.4997);
                mapsFragment.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, mapsFragment)
                        .commit();
            }
        });


        add_info_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                InvestigationFormFragment invstFragment =new InvestigationFormFragment();
                AppCompatActivity activity=(AppCompatActivity)view.getContext();
                activity.getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, invstFragment)
                        .commit();
            }
        });
        return view;
    }

}