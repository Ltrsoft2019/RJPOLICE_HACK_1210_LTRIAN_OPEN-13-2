package com.ltrsoft.policeapp.Profile;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import com.ltrsoft.policeapp.R;

public class ProfileDetailFragment extends Fragment {
    public ProfileDetailFragment() {    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.profile_detail_fragment, container, false);

        return view;
    }
}