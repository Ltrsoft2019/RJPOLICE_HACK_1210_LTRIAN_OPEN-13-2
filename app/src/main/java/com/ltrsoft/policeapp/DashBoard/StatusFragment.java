package com.ltrsoft.policeapp.DashBoard;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.ltrsoft.policeapp.Case.CaseFragment;
import com.ltrsoft.policeapp.FeedBackFragment;
import com.ltrsoft.policeapp.Investigation.InvestigationFragment;
import com.ltrsoft.policeapp.Message.MessageFragment;
import com.ltrsoft.policeapp.News.NewsFragment;
import com.ltrsoft.policeapp.Profile.ProfileFragment;
import com.ltrsoft.policeapp.R;
public class StatusFragment extends Fragment {
    public StatusFragment() {}
    private BottomNavigationView navigationView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.status_fragment, container, false);
        navigationView = view.findViewById(R.id.status_navigation);
        navigationView.setSelectedItemId(R.id.cases);
        navigationView.setOnItemReselectedListener(new NavigationBarView.OnItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem item) {
              int  itemId=item.getItemId();
                if (itemId == R.id.cases) {
                    replaceFragment(new CaseFragment());
                } else if (itemId == R.id.investigation) {
                    replaceFragment(new InvestigationFragment());
                }
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