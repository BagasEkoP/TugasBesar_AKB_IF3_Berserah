package com.example.tugasbesar_akb_if3_berserah;

//Tanggal Pengerjaan : 3 Agustus 2022
//NIM   : 10119107
//Nama  : Bagas Eko Pambudi
//NIM   : 10119093
//Nama  : Rafli Solihudin
//Kelas : IF-3

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsFragment extends Fragment {

    private OnMapReadyCallback callback = new OnMapReadyCallback() {

        /**
         * Manipulates the map once available.
         * This callback is triggered when the map is ready to be used.
         * This is where we can add markers or lines, add listeners or move the camera.
         * In this case, we just add a marker near Sydney, Australia.
         * If Google Play services is not installed on the device, the user will be prompted to
         * install it inside the SupportMapFragment. This method will only be triggered once the
         * user has installed Google Play services and returned to the app.
         */
        public void onMapReady(GoogleMap googleMap) {
            LatLng lokasi1 = new LatLng(-6.8329637, 107.6034296);
            googleMap.addMarker(new MarkerOptions().position(lokasi1).title("Farm House Susu Lembang"));

            LatLng lokasi2 = new LatLng(-6.8329637, 107.6034296);
            googleMap.addMarker(new MarkerOptions().position(lokasi2).title("The Great Asia Afrika"));

            LatLng lokasi3 = new LatLng(-6.8516538, 107.5933647);
            googleMap.addMarker(new MarkerOptions().position(lokasi3).title("Amazing Artgames"));

            LatLng lokasi4 = new LatLng(-6.8172926, 107.6099568);
            googleMap.addMarker(new MarkerOptions().position(lokasi4).title("Lembang Wonderland"));

            LatLng lokasi5 = new LatLng(6.8168954, 107.6151046);
            googleMap.addMarker(new MarkerOptions().position(lokasi5).title("Floating Market Lembang"));

            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(lokasi1, 25));
        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_maps, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SupportMapFragment mapFragment =
                (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(callback);
        }
    }
}