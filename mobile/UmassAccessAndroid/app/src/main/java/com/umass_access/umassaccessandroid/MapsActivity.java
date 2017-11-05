package com.umass_access.umassaccessandroid;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import static com.umass_access.umassaccessandroid.MarkerData.getMarkerType;

public class MapsActivity extends FragmentActivity implements GoogleMap.OnMarkerClickListener, OnMapReadyCallback  {
    private GoogleMap mMap;
    static LatLng construction = new LatLng(42.394109, -72.527355);
    static LatLng dubois = new LatLng(42.389735, -72.528279);
    static LatLng ilc  = new LatLng(42.391006, -72.526201);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        //TODO: Say hi to the server and populate the map with markers
        // Get the Intent that started this activity and extract the string

    }

    /** Called when the user taps the Send button */
    public void openBlockerMenu(View view) {
        Intent intent = new Intent(this, BlockerMenuActivity.class);
        startActivityForResult(intent, 1);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setMinZoomPreference(15);

        // Add some markers to the map, and add a data object to each marker.
        LatLng umass = new LatLng(42.391097, -72.526838);
        Marker mUmass = mMap.addMarker(new MarkerOptions()
                .position(umass)
                .title("Umass"));
        MarkerData umassData = new MarkerData(0,0, umass.longitude, umass.latitude, 0);
        mUmass.setTag(umassData);
        mMap.addMarker(new MarkerOptions().position(umass));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(umass));
        // Set a listener for marker click.
        mMap.setOnMarkerClickListener(this);
    }

    @Override
    public boolean onMarkerClick(final Marker marker) {
        //TODO
        /*
        // Retrieve the data from the marker.
        Integer clickCount = (Integer) marker.getTag();

        // Check if a click count was set, then display the click count.
        if (clickCount != null) {
            clickCount = clickCount + 1;
            marker.setTag(clickCount);
            Toast.makeText(this,
                    marker.getTitle() +
                            " has been clicked " + clickCount + " times.",
                    Toast.LENGTH_SHORT).show();
        }
        */
        // Return false to indicate that we have not consumed the event and that we wish
        // for the default behavior to occur (which is for the camera to move such that the
        // marker is centered and for the marker's info window to open, if it has one).
        return false;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 1) {
            if(resultCode == Activity.RESULT_OK){
                int position=data.getIntExtra("result", 0);
                Marker newMarker = mMap.addMarker(new MarkerOptions()
                        .position(ilc)
                        .title("ILC"));
                MarkerData newMarkerData = new MarkerData(0,0, ilc.longitude, ilc.latitude, 0);
                newMarker.setTag(newMarkerData);
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                //Write your code if there's no result
                Marker newMarker = mMap.addMarker(new MarkerOptions()
                        .position(dubois)
                        .title("Dubois Library"));
                MarkerData newMarkerData = new MarkerData(0,0, dubois.longitude, dubois.latitude, 0);
                newMarker.setTag(newMarkerData);
            }
        }
    }//onActivityResult
}
