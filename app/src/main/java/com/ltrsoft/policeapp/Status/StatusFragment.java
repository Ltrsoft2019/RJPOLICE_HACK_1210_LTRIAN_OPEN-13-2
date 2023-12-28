package com.ltrsoft.policeapp.Status;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.ltrsoft.policeapp.Case.CaseFragment;
import com.ltrsoft.policeapp.Case.CaseMapsFragment;
import com.ltrsoft.policeapp.Investigation.InvestigationFragment;
import com.ltrsoft.policeapp.R;
public class StatusFragment extends Fragment {
    public StatusFragment() {}
    private BottomNavigationView navigationView;
    private Button cases,invst;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.status_fragment, container, false);
        cases=view.findViewById(R.id.casefrg);
        invst=view.findViewById(R.id.invstfrg);

        replaceFragment(new CaseFragment());
        cases.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new CaseFragment());
            }
        });
        invst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new InvestigationFragment());
            }
        });
        return view;
    }
    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.status_container, fragment);
        fragmentTransaction.commit();
    }
}