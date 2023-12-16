package com.ltrsoft.policeapp.loinRegistration;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ltrsoft.policeapp.R;
public class ForgetPassFragment extends Fragment {
    public ForgetPassFragment() {}
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.forget_pass_fragment, container, false);
        return  view;
    }
}