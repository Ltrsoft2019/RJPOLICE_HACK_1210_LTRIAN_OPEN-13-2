package com.ltrsoft.policeapp.Case;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.ltrsoft.policeapp.R;
public class WitnessFormFragment extends Fragment {

    public WitnessFormFragment() {    }
    public ImageView back;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.witness_fragment, container, false);
       //  back = view.findViewById(R.id.witness_back);
        return view;
    }
}