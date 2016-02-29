package com.igm.android.storyboard;
/*
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class Carte extends Fragment {
	private double lat=0;
	private double lng=0;
	public Carte(double latt,double lngg){
		this.lat=latt;
		this.lng=lngg;
	}
	MapView m;
	  GoogleMap map;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, 
			Bundle savedInstanceState) {
		// inflat and return the layout
		View v = inflater.inflate(R.layout.mainmap, container, false);
		m = (MapView) v.findViewById(R.id.mapView);
		m.onCreate(savedInstanceState);
		map = m.getMap();
        //map.getUiSettings().setMyLocationButtonEnabled(false);
        //map.setMyLocationEnabled(true);
        map.addMarker(new MarkerOptions().position(new LatLng(lat,lng)));

        MapsInitializer.initialize(this.getActivity());

        // Updates the location and zoom of the MapView
        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(new LatLng(lat, lng), 10);
        map.animateCamera(cameraUpdate);

        return v;
		
	
		
		
	}
	
	@Override
	public void onResume() {
		super.onResume();
		m.onResume();
	}
	
	@Override
	public void onPause() {
		super.onPause();
		m.onPause();
	}
	
	@Override
	public void onDestroy() {
		super.onDestroy();
		m.onDestroy();
	}
	
	@Override
	public void onLowMemory() {
		super.onLowMemory();
		m.onLowMemory();
	}
}*/