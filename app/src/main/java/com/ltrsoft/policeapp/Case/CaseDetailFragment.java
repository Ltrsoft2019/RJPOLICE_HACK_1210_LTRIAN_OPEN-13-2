package com.ltrsoft.policeapp.Case;

import static androidx.core.content.ContextCompat.getSystemService;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ltrsoft.policeapp.R;
public class CaseDetailFragment extends Fragment {
    public CaseDetailFragment() {}
    public TextView adress,incident_date,victim,compalin_desc,crime_type,complain_name;
    public Button get_loaction,add_info_btn;
    public ImageButton casePdf;
    public ImageView back;
    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.case_detail_fragment, container, false);
       // Toast.makeText(getContext(), "this is course detail fragment", Toast.LENGTH_SHORT).show();

        get_loaction=view.findViewById(R.id.location);
        add_info_btn = view.findViewById(R.id.investigation_form);
        casePdf = view.findViewById(R.id.case_pdf);
        back = view.findViewById(R.id.case_back);

        complain_name = view.findViewById(R.id.complain_name);
        crime_type = view.findViewById(R.id.crime_type);
        compalin_desc = view . findViewById(R.id.compalin_desc);
        victim=view.findViewById(R.id.victim);
        adress=view.findViewById(R.id.adress);
        incident_date=view.findViewById(R.id.incident_date);


        Bundle b = getArguments();
        complain_name.setText("Ganesh Sagave");
        crime_type.setText("Murder");
        compalin_desc.setText("XYZ killed by abc");
        victim.setText("Ganesh");
        adress.setText("Latur");
        incident_date.setText("12-02-1444");


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, new CaseFragment())
                        .addToBackStack(null)
                        .commit();
            }
        });

        get_loaction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CaseMapsFragment mapsFragment =new CaseMapsFragment();
               // AppCompatActivity activity=(AppCompatActivity)view.getContext();
                Bundle bundle = new Bundle();
                bundle.putDouble("lattitude",18.2505);
                bundle.putDouble("longitude",76.4997);
                mapsFragment.setArguments(bundle);

                LocationManager locationManager = (LocationManager) requireActivity().getSystemService(Context.LOCATION_SERVICE);

                if (locationManager != null) {
                    boolean isGpsEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
                    boolean isNetworkEnabled = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);

                    if (isGpsEnabled || isNetworkEnabled) {
                        getActivity().getSupportFragmentManager().beginTransaction()
                                .replace(R.id.fragment_container, mapsFragment)
                                .addToBackStack(null)
                                .commit();
                    } else {
                        showEnableLocationDialog();
                    }
                }


            }
        });
        add_info_btn.setOnClickListener(new View.OnClickListener() {
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
    private void showEnableLocationDialog() {
        Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
      /*  CaseMapsFragment mapsFragment =new CaseMapsFragment()
        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, mapsFragment)
                .addToBackStack(null)
                .commit();*/
        startActivity(intent);
    }

}