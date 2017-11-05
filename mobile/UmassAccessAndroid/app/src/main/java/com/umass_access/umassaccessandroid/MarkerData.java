package com.umass_access.umassaccessandroid;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by Kirs on 11/4/2017.
 */

public class MarkerData {

    int id, markerTypeId,  upvotes, downvotes, userID;
    double longitude, latitude;
    int[] marker_type = {"Construction", "Holes", "Car Accidents", "Ambulance", "Firetruck",
                        "Broken Door", "Vehicular Obstructions", "Broken Power Lines"};

    public MarkerData(int id, int markerTypeId, double longitude, double latitude, int userID){
        this.id= id;
        this.markerTypeId = markerTypeId;
        this.longitude = longitude;
        this.latitude = latitude;
        this.upvotes = 0;
        this.downvotes = 0;
        this.userID = userID;
    }

    public static String getMarkerType(int markerTypeId){
        return(marker_type[markerTypeId]);
    }

    public static void addMarkerToMap(GoogleMap map, MarkerData markerD){
        LatLng coordinates = new LatLng(markerD.getLongitude(),markerD.getLongitude());
        Marker newMarker = map.addMarker(new MarkerOptions()
                .position(coordinates)
                .title(getMarkerType(markerD.getMarkerTypeId())));
        newMarker.setTag(markerD);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMarkerTypeId() {
        return markerTypeId;
    }

    public void setMarkerTypeId(int markerTypeId) {
        this.markerTypeId = markerTypeId;
    }

    public int getUpvotes() {
        return upvotes;
    }

    public void setUpvotes(int upvotes) {
        this.upvotes = upvotes;
    }

    public int getDownvotes() {
        return downvotes;
    }

    public void setDownvotes(int downvotes) {
        this.downvotes = downvotes;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
}
