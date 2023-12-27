package com.ltrsoft.policeapp.Case;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Location;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.codebyashish.googledirectionapi.AbstractRouting;
import com.codebyashish.googledirectionapi.ErrorHandling;
import com.codebyashish.googledirectionapi.RouteDrawing;
import com.codebyashish.googledirectionapi.RouteInfoModel;
import com.codebyashish.googledirectionapi.RouteListener;
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
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.maps.model.RoundCap;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.ltrsoft.policeapp.R;

import java.util.ArrayList;


public class CaseMapsFragment extends Fragment implements OnMapReadyCallback,RouteListener {
    public CaseMapsFragment() {}
    GoogleMap gmap;
    FusedLocationProviderClient client;
    public Double usrLat=180.9787;
    public AppCompatActivity activity;
    public Double userLong=120.787;
    public LatLng destinationlocation, userLocation;
    private ArrayList<Polyline> polylines = null;
    FloatingActionButton actionButton;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.case_maps_fragment, container, false);
         actionButton = view.findViewById(R.id.floating);
        Bundle b = getArguments();
        double lat=b.getDouble("lattitude");
        double lon = b.getDouble("longitude");
//        Toast.makeText(activity, "lat="+lat, Toast.LENGTH_SHORT).show();
        destinationlocation = new LatLng(lat,lon);
        activity = (AppCompatActivity) view.getContext();

        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);

        if (ContextCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(getActivity(), new String[]{
                    Manifest.permission.ACCESS_FINE_LOCATION
            }, 100);
            ActivityCompat.requestPermissions(getActivity(), new String[]{
                    Manifest.permission.ACCESS_COARSE_LOCATION
            }, 200);
        }
       if (mapFragment != null) {
            mapFragment.getMapAsync(this);
        }
        client = LocationServices.getFusedLocationProviderClient(getContext());
        return view;
    }
    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        gmap = googleMap;
        LatLng latLng = new LatLng(usrLat,userLong);
        CameraPosition cameraPosition = new CameraPosition.Builder()
                .zoom(16f)
                .target(latLng)
                .build();
        gmap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
        MarkerOptions markerOptions = new MarkerOptions().position(latLng).title("Latur");
        gmap.addMarker(markerOptions);



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
       fetchMyLocation();
        //getRoute(userLocation,destinationlocation);
    }

    private void getRoute(LatLng userLocation, LatLng destinationlocation) {
       // userLocation=new LatLng(18.4088,76.5604);
        destinationlocation=new LatLng(18.2505,76.4997);
        if (userLocation!=null&&destinationlocation!=null) {
            RouteDrawing routeDrawing = new RouteDrawing.Builder()
                    .context(getContext())  // pass your activity or fragment's context
                    .travelMode(AbstractRouting.TravelMode.DRIVING)
                    .alternativeRoutes(true)
                    .withListener(this)
                    .waypoints(userLocation, destinationlocation)
                    .alternativeRoutes(true)
                    .build();
            routeDrawing.execute();
        }
        else {
           // Toast.makeText(activity, "null", Toast.LENGTH_SHORT).show();
            if (userLocation != null) {
                Toast.makeText(activity, "userloaction is null", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(activity, "destination location", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void fetchMyLocation() {
       // Toast.makeText(getContext(), "in function", Toast.LENGTH_SHORT).show();
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
                if (location!=null) {
                    usrLat = location.getLatitude();
                    userLong = location.getLongitude();
                    userLocation = new LatLng(usrLat, userLong);
                    LatLng latLng = new LatLng(usrLat, userLong);
                    CameraPosition cameraPosition = new CameraPosition.Builder()
                            .zoom(16f)
                            .target(latLng)
                            .build();
                    //       Toast.makeText(getContext(), "location ="+userLocation.longitude+","+userLong, Toast.LENGTH_SHORT).show();
                    gmap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
                    MarkerOptions markerOptions = new MarkerOptions().position(latLng).title("Latur");
                    gmap.addMarker(markerOptions);
                    getRoute(userLocation, destinationlocation);
                }
                else {
                    Toast.makeText(activity, "location is null", Toast.LENGTH_SHORT).show();
                }
            }
        });
        task.addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(activity, "failed"+e.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    @Override
    public void onRouteFailure(ErrorHandling e) {
        Log.e("error","err="+e.getMessage());
        Toast.makeText(activity, "route failed"+e.toString(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRouteStart() {
       Toast.makeText(activity, "route started", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRouteSuccess(ArrayList<RouteInfoModel> list, int indexing) {
        Toast.makeText(activity, "route succed", Toast.LENGTH_SHORT).show();
        if (polylines != null) {
            polylines.clear();
        }
        PolylineOptions polylineOptions = new PolylineOptions();
        ArrayList<Polyline> polylines = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (i == indexing) {
                Log.e("TAG", "onRoutingSuccess: routeIndexing" + indexing);
                polylineOptions.color(Color.BLUE);
                polylineOptions.width(8);
                polylineOptions.addAll(list.get(indexing).getPoints());
                polylineOptions.startCap(new RoundCap());
                polylineOptions.endCap(new RoundCap());
                Polyline polyline = gmap.addPolyline(polylineOptions);
                polylines.add(polyline);
            }
        }
    }

    @Override
    public void onRouteCancelled() {
        Toast.makeText(activity, "route cancled", Toast.LENGTH_SHORT).show();
    }
}