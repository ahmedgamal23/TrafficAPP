package com.example.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.PolylineOptions;

public class main_map extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    Button button_s;

    // below are the latitude and longitude of 4 different locations.
    LatLng bahtem = new LatLng(Main2Activity.Lat1 , Main2Activity.Lng1);
    LatLng fisrt = new LatLng(Main2Activity.Lat2 , Main2Activity.Lng2);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_map);

        button_s = findViewById(R.id.btn_skip);
        button_s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(main_map.this , bus_details.class);
                startActivity(intent);
            }
        });

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        // inside on map ready method
        // we will be displaying polygon on Google Maps.
        // on below line we will be adding polyline on Google Maps.
        mMap.addPolyline((new PolylineOptions()).add(bahtem , fisrt).
                // below line is use to specify the width of poly line.
                        width(5)
                // below line is use to add color to our poly line.
                .color(Color.RED)
                // below line is to make our poly line geodesic.
                .geodesic(true));
        // on below line we will be starting the drawing of polyline.
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(bahtem, 13));
    }
}
