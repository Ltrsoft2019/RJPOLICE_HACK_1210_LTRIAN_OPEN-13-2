package com.ltrsoft.policeapp.Case;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ltrsoft.policeapp.R;
public class SuspectFormFragment extends Fragment {
    public SuspectFormFragment() {}
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.suspect_form_fragment, container, false);
        return view;
    }
}