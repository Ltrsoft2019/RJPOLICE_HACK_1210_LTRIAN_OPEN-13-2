package com.ltrsoft.policeapp.Investigation;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.ltrsoft.policeapp.R;
public class InvestigationFragment extends Fragment {
    public InvestigationFragment() {}
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.investigation_fragment, container, false);
        Toast.makeText(getContext(), "Investigation fragment clicked", Toast.LENGTH_SHORT).show();
        return view;
    }
}