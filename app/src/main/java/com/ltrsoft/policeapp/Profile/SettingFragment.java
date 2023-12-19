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
public class SettingFragment extends Fragment {
    public SettingFragment() {
        // Required empty public constructor
    }
    private Spinner language_spinner;
    private Switch notification_switch;
    private TextView contact_tv;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.setting_fragment, container, false);
        language_spinner = view.findViewById(R.id.language_spinner);
        notification_switch = view.findViewById(R.id.notification_switch);
        contact_tv = view.findViewById(R.id.contact_tv);
        return view;
    }
}