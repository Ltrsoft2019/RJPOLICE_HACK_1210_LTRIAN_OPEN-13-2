package com.ltrsoft.policeapp.Case;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.directions.route.Route;
import com.directions.route.RouteException;
import com.directions.route.RoutingListener;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.ltrsoft.policeapp.R;

import java.util.ArrayList;

public class CaseMapsFragment extends Fragment implements OnMapReadyCallback, RoutingListener {
    public CaseMapsFragment() {
    }
    GoogleMap gmap;
    FusedLocationProviderClient client;
    public Double usrLat, userLong;
    public LatLng destinationlocation, userLocation;
    private ArrayList<Polyline> polylines = null;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.case_maps_fragment, container, false);

        Bundle b = getArguments();
        destinationlocation = new LatLng((Double) b.get("lattitude"), (Double) b.get("longitude"));

        AppCompatActivity activity = (AppCompatActivity) view.getContext();

        SupportMapFragment mapFragment = (SupportMapFragment) activity.getSupportFragmentManager().findFragmentById(R.id.map);

        if (ContextCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(getActivity(), new String[]{
                    Manifest.permission.ACCESS_FINE_LOCATION
            }, 100);
            ActivityCompat.requestPermissions(getActivity(), new String[]{
                    Manifest.permission.ACCESS_COARSE_LOCATION
            }, 200);
        }
     //   mapFragment.getMapAsync(this);
        if (mapFragment != null) {
            mapFragment.getMapAsync(this);
        }
        client = LocationServices.getFusedLocationProviderClient(getContext());
        return view;
    }
    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        gmap = googleMap;
        Toast.makeText(getContext(), "on map called", Toast.LENGTH_SHORT).show();
        if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_COARSE_LOCATION)
                        != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(getActivity(), new String[]{
                    Manifest.permission.ACCESS_FINE_LOCATION
            }, 100);
            ActivityCompat.requestPermissions(getActivity(), new String[]{
                    Manifest.permission.ACCESS_COARSE_LOCATION
            }, 200);
            return;
        }

        gmap.setMyLocationEnabled(true);
        gmap.getUiSettings().setCompassEnabled(true);
        gmap.getUiSettings().setZoomControlsEnabled(true);

      //  fetchMyLocation();
    }
    private void fetchMyLocation() {
        Toast.makeText(getContext(), "in function", Toast.LENGTH_SHORT).show();
        Location location;
        if (ActivityCompat.checkSelfPermission(getContext(), android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(getContext(), android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(getActivity(),new String[]{
                    Manifest.permission.ACCESS_FINE_LOCATION
            },100);
            ActivityCompat.requestPermissions(getActivity(),new String[]{
                    Manifest.permission.ACCESS_COARSE_LOCATION
            },200);
        }//checking permission is granted or not
        Task< Location> task = client.getLastLocation();
        task.addOnSuccessListener(new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                location=location;
                usrLat = location.getLatitude();
                userLong = location.getLongitude();
                userLocation=new LatLng(usrLat,userLong);
                LatLng latLng = new LatLng(usrLat,userLong);
                CameraPosition cameraPosition = new CameraPosition.Builder()
                        .zoom(16f)
                        .target(latLng)
                        .build();
                Toast.makeText(getContext(), "location ="+usrLat+","+userLong, Toast.LENGTH_SHORT).show();
                gmap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
                MarkerOptions markerOptions = new MarkerOptions().position(latLng).title("Latur");
                gmap.addMarker(markerOptions);
            }
        });
    }

    @Override
    public void onRoutingFailure(RouteException e) {
        Toast.makeText(getContext(), "routfailure"+e.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRoutingStart() {
        Toast.makeText(getContext(), "route started", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRoutingSuccess(ArrayList<Route> arrayList, int i) {

    }

    @Override
    public void onRoutingCancelled() {
        Toast.makeText(getContext(), "route cacled", Toast.LENGTH_SHORT).show();
    }
}