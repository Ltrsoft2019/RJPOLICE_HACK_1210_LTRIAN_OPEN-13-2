package com.ltrsoft.policeapp.Navigation;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.ltrsoft.policeapp.Status.StatusFragment;
import com.ltrsoft.policeapp.Message.MessageFragment;
import com.ltrsoft.policeapp.News.NewsFragment;
import com.ltrsoft.policeapp.Profile.ProfileFragment;
import com.ltrsoft.policeapp.R;
public class NavigationFragment extends Fragment {

    public NavigationFragment() {

        // Required empty public constructor
    }
    private BottomNavigationView bottomNavigationView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.navigation_fragment, container, false);
        bottomNavigationView = view.findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.status);
        replaceFragment(new StatusFragment());
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            int itemId = item.getItemId();

            if (itemId == R.id.status) {
                replaceFragment(new StatusFragment());
            } else if (itemId == R.id.message) {
                replaceFragment(new MessageFragment());
            } else if (itemId == R.id.user) {
                replaceFragment(new ProfileFragment());
            } else if (itemId == R.id.news) {
                replaceFragment(new NewsFragment());
            }
            return true;

        });
        return view;
    }
    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.commit();
    }
}