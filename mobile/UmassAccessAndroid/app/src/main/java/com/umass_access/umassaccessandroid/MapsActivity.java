package com.umass_access.umassaccessandroid;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import static com.umass_access.umassaccessandroid.MarkerData.getMarkerType;

public class MapsActivity extends FragmentActivity implements GoogleMap.OnMarkerClickListener, OnMapReadyCallback  {
    private GoogleMap mMap;
    static String[] marker_type_list = {"Ambulence",
                                        "Down Power Line",
                                        "Broken Power Door",
                                        "Car Accident",
                                        "Car Blockage",
                                        "Construction",
                                        "Dead Animal",
                                        "Fallen Branches",
                                        "Firetruck",
                                        "Flooded Area",
                                        "Closed Path",
                                        "PotHole"};

    static LatLng[] position_list = { new LatLng(42.388417, -72.524316),
                                      new LatLng(42.395524, -72.533099),
                                      new LatLng(42.393679, -72.528658),
                                      new LatLng(42.388512, -72.532105),
                                      new LatLng(42.389803, -72.531468),
                                      new LatLng(42.393678, -72.528024),
                                      new LatLng(42.392990, -72.528484),
                                      new LatLng(42.395588, -72.531342),
                                      new LatLng(42.388836, -72.528139),
                                      new LatLng(42.389545, -72.526484),
                                      new LatLng(42.388572, -72.524764),
                                      new LatLng(42.394109, -72.520836)
    };

    static int[] imageId_list = {
            R.drawable.ambulance,
            R.drawable.brokenpowerline,
            R.drawable.brokenwheelchairdoor,
            R.drawable.caraccident,
            R.drawable.carwalkwayblockage,
            R.drawable.constructionblockage,
            R.drawable.deadanimal,
            R.drawable.fallentree,
            R.drawable.firetruck,
            R.drawable.floodedarea,
            R.drawable.pathclosed,
            R.drawable.potholelargehole
    };

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

        // get a reference to the already created main layout
        RelativeLayout mainLayout = (RelativeLayout) findViewById(R.id.activity_maps_id);

        // inflate the layout of the popup window
        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.upvote_window, null);

        // create the popup window
        int width = LinearLayout.LayoutParams.WRAP_CONTENT;
        int height = LinearLayout.LayoutParams.WRAP_CONTENT;
        boolean focusable = true; // lets taps outside the popup also dismiss it
        final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);

        // show the popup window
        popupWindow.showAtLocation(mainLayout, Gravity.CENTER, 0, 0);

        // dismiss the popup window when touched
        popupView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                popupWindow.dismiss();
                return true;
            }
        });

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
                        .position(position_list[position])
                        .title(marker_type_list[position])
                        .snippet("Be Careful!"));
                MarkerData newMarkerData = new MarkerData(0,0, position_list[position].longitude, position_list[position].latitude, 0);
                newMarker.setTag(newMarkerData);
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                //Write your code if there's no result

            }
        }
    }//onActivityResult
}
