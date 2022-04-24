/*
Name: Adam Strahan
Student Number: C00216499
Date: April 2022
File: Java file for the Campus Map
 */
package com.example.itcarlowmap;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.fragment.app.FragmentActivity;

import com.example.itcarlowmap.databinding.ActivityMapsBinding;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnInfoWindowClickListener {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        //Checks for button click
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                indoors();
            }
        });
    }

    // Called when the user touches the button
    public void indoors() {
        Intent intent = new Intent(this, IndoorMapActivity.class);
        startActivity(intent);
    }

    // Manipulates the map once available.
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Set edges of map to prevent panning
        LatLngBounds campusBounds = new LatLngBounds(
                new LatLng(52.82428065254445, -6.937163472175599), // SW bounds
                new LatLng(52.82810222634178, -6.932453513145448)  // NE bounds
        );
        mMap.setLatLngBoundsForCameraTarget(campusBounds);

        // Set latitude and Longitude for markers
        LatLng barrow = new LatLng(52.82633248077285, -6.936514377593995);
        LatLng lrc = new LatLng(52.82680571650236, -6.935570240020753);
        LatLng nore = new LatLng(52.82758038578372, -6.935843825340271);
        LatLng killeshin = new LatLng(52.8264588935613, -6.936964988708497);
        LatLng gaa = new LatLng(52.82494515728693, -6.936610937118531);
        LatLng burrin = new LatLng(52.82694833447857, -6.936568021774293);
        LatLng haughton = new LatLng(52.827217362568284, -6.937088370323181);
        LatLng dargan = new LatLng(52.82792071729339, -6.936669945716859);
        LatLng slaney = new LatLng(52.82718494963369, -6.936079859733582);
        LatLng aero = new LatLng(52.82818649814219, -6.9341379404068);
        LatLng incubation = new LatLng(52.82810546756788, -6.933719515800477);
        LatLng engineering = new LatLng(52.827959612153286, -6.932952404022218);
        LatLng innovation = new LatLng(52.827716518707504, -6.933789253234864);
        LatLng cim = new LatLng(52.827560938188356, -6.933236718177796);
        LatLng rugby = new LatLng(52.827120123691955, -6.934685111045838);
        LatLng mainEntry = new LatLng(52.82572634254919, -6.937104463577271);
        LatLng mainExit = new LatLng(52.82613151609562, -6.933762431144715);
        LatLng kilkEntry = new LatLng(52.82858516636683, -6.936664581298829);
        LatLng greenEntry = new LatLng(52.827684106145284, -6.932727098464967);

        // Make the markers
        Marker mBarrow = mMap.addMarker(
                new MarkerOptions()
                        .position(barrow)
                        .title("Barrow Centre (F)")
                        .snippet("Sports Hall/Gym/Clubs & Socs/Student Union/Medic"));
        Marker mLRC = mMap.addMarker(
                new MarkerOptions()
                        .position(lrc)
                        .title("Learning Resource Centre (A)")
                        .snippet("Library/UNUM Lab/IT Services"));
        Marker mNore = mMap.addMarker(
                new MarkerOptions()
                        .position(nore)
                        .title("Nore Building (C)")
                        .snippet("Engineering & Science Dept./Research & Physiology Labs"));
        Marker mKilleshin = mMap.addMarker(
                new MarkerOptions()
                        .position(killeshin)
                        .title("Killeshin Centre (E)")
                        .snippet("Business School"));
        Marker mGAA = mMap.addMarker(
                new MarkerOptions()
                        .position(gaa)
                        .title("GAA Stand (G)")
                        .snippet("GAA Seats/Lecture Rooms/Changing Rooms"));
        Marker mBurrin = mMap.addMarker(
                new MarkerOptions()
                        .position(burrin)
                        .title("Burrin Building (D)")
                        .snippet("Management Suite/Design & Drawing Studios/Lectures"));
        Marker mHaughton = mMap.addMarker(
                new MarkerOptions()
                        .position(haughton)
                        .title("Haughton Building (L)")
                        .snippet("Inductions/Events/Large Lecture Rooms"));
        Marker mDargan = mMap.addMarker(
                new MarkerOptions()
                        .position(dargan)
                        .title("Dargan Building (K)")
                        .snippet("Research & Commerce Support Centre/Research CORE's"));
        Marker mSlaney = mMap.addMarker(
                new MarkerOptions()
                        .position(slaney)
                        .title("Slaney Building (CSB)")
                        .snippet("Reception/Shops/Cafeterias"));
        Marker mAero = mMap.addMarker(
                new MarkerOptions()
                        .position(aero)
                        .title("Centre for Aerospace Engineering (H)")
                        .snippet("Hangar/Aerospace Lectures"));
        Marker mIncubation = mMap.addMarker(
                new MarkerOptions()
                        .position(incubation)
                        .title("Enterprise & Research Incubation Building (I)"));
        Marker mEngineering = mMap.addMarker(
                new MarkerOptions()
                        .position(engineering)
                        .title("Engineering & Technology Building (J)"));
        Marker mInnovation = mMap.addMarker(
                new MarkerOptions()
                        .position(innovation)
                        .title("Innovation Building"));
        Marker mCIM = mMap.addMarker(
                new MarkerOptions()
                        .position(cim)
                        .title("CIM Building"));
        Marker mRugby = mMap.addMarker(
                new MarkerOptions()
                        .position(rugby)
                        .title("Rugby Stand")
                        .snippet("Seating at the Rugby Pitch"));
        Marker mMainEntry = mMap.addMarker(
                new MarkerOptions()
                        .position(mainEntry)
                        .title("Main Campus Entrance")
                        .snippet("No Exit")
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
        Marker mMainExit = mMap.addMarker(
                new MarkerOptions()
                        .position(mainExit)
                        .title("Main Campus Exit")
                        .snippet("No Entry")
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
        Marker mKilkEntry = mMap.addMarker(
                new MarkerOptions()
                        .position(kilkEntry)
                        .title("Kilkenny Road Entrance")
                        .snippet("Entry and Exit")
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
        Marker mGreenEntry = mMap.addMarker(
                new MarkerOptions()
                        .position(greenEntry)
                        .title("Green Road Entrance")
                        .snippet("Entry and Exit")
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        // Set the camera location and zoom limitations
        mMap.moveCamera(CameraUpdateFactory.newLatLng(barrow));
        mMap.setMinZoomPreference(17.0f);

        // Sets the info window for the markers
        mMap.setOnInfoWindowClickListener(this);
    }

    // Info window details
    @Override
    public void onInfoWindowClick(Marker marker) {
        Toast.makeText(this, "For more information click 'Indoor Maps'", Toast.LENGTH_LONG).show();
    }
}