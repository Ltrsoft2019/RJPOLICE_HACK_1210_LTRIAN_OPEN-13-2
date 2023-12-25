package com.ltrsoft.policeapp.Navigation;
import static android.content.Context.MODE_PRIVATE;

import static androidx.core.content.ContextCompat.getSystemService;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.ltrsoft.policeapp.Message.Message_fragment;
import com.ltrsoft.policeapp.Status.StatusFragment;
import com.ltrsoft.policeapp.News.NewsFragment;
import com.ltrsoft.policeapp.Profile.ProfileFragment;
import com.ltrsoft.policeapp.R;
public class NavigationFragment extends Fragment {

    public NavigationFragment() {

        // Required empty public constructor
    }
    private BottomNavigationView bottomNavigationView;

    private static final String PREF_NAME = "MyPreferences";
    private static final String KEY_IS_LOGGED_IN = "isLoggedIn";
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
                replaceFragment(new Message_fragment());
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
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }




}