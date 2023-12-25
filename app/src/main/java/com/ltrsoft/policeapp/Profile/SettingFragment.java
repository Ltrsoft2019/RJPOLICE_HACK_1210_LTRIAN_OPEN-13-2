package com.ltrsoft.policeapp.Profile;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import com.ltrsoft.policeapp.R;
public class SettingFragment extends Fragment {
    public SettingFragment(){}
    private Spinner language_spinner;
    private Switch notification_switch;
    private TextView contact_tv;
    private String [] language = {"English","Hindi"};
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.setting_fragment, container, false);
        language_spinner = view.findViewById(R.id.language_spinner);
        notification_switch = view.findViewById(R.id.notification_switch);
        contact_tv = view.findViewById(R.id.contact_tv);

        ArrayAdapter <String> adapter= new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1,language);
        language_spinner.setAdapter(adapter);

        return view;
    }
}