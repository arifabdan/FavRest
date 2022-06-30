package com.example.tugassensorgenap2022akbif_310119085;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
//10119085,Arif Abdan Syakur,IF-3
public class MapFragment extends Fragment {
    FusedLocationProviderClient client;
    SupportMapFragment supportMapFragment;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_map, container, false);

        client = LocationServices.getFusedLocationProviderClient(getActivity());
        supportMapFragment = (SupportMapFragment)
                getChildFragmentManager().findFragmentById(R.id.maps);
        
        getCurrentLocation();

        return view;
    }

    private void getCurrentLocation() {
        if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
        && ActivityCompat.checkSelfPermission(getActivity(),Manifest.permission.ACCESS_FINE_LOCATION) !=
        PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.ACCESS_FINE_LOCATION},44);
        }
        Task<Location> task = client.getLastLocation();
        task.addOnSuccessListener(new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                if (location != null){
                    supportMapFragment.getMapAsync(new OnMapReadyCallback() {
                        @Override
                        public void onMapReady(@NonNull GoogleMap googleMap) {
                            LatLng loc = new LatLng(location.getLatitude(),location.getLongitude());
                            LatLng rest1 = new LatLng(-6.918311,107.6137761);
                            LatLng rest2 = new LatLng(-6.9087319,107.6090253);
                            LatLng rest3 = new LatLng(-6.9062129,107.6209634);
                            LatLng rest4 = new LatLng(-6.9163925,107.609451);
                            LatLng rest5 = new LatLng(-6.8901164,107.5960899);
                            MarkerOptions options = new MarkerOptions().position(loc).title("You Are Here");
                            googleMap.addMarker(new MarkerOptions().position(rest1).title("Bakso So'un dan Mie Ayam Lodaya"));
                            googleMap.addMarker(new MarkerOptions().position(rest2).title("Bakmie GM"));
                            googleMap.addMarker(new MarkerOptions().position(rest3).title("KFC"));
                            googleMap.addMarker(new MarkerOptions().position(rest4).title("Luberger"));
                            googleMap.addMarker(new MarkerOptions().position(rest5).title("Ta Wan"));
                            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(loc,12));
                            googleMap.addMarker(options);
                        }
                    });
                }
            }
        });
    }

}