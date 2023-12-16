package com.ltrsoft.policeapp.Case;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.ltrsoft.policeapp.R;
public class CaseFragment extends Fragment {
    public CaseFragment() {}
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.case_fragment, container, false);
        Toast.makeText(getContext(), "Case fragment clicked", Toast.LENGTH_SHORT).show();
        return view;
    }
}