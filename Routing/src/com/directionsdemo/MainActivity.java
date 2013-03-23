package com.directionsdemo;

import com.directions.route.Routing;
import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.view.Menu;

public class MainActivity extends MapActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MapView mapView = (MapView)findViewById(R.id.mapview);
        MapController myMapController = mapView.getController();
        mapView.setBuiltInZoomControls(true);
        myMapController.setZoom(17);
        myMapController.setCenter(new GeoPoint((int)(((14.622263+14.619506)/2)*1E6),(int)(((121.086100+121.099516)/2)*1E6)));
        new Routing(mapView,Color.GREEN).execute(new GeoPoint((int)(14.622263*1E6),(int)(121.086100*1E6)), new GeoPoint((int)(14.619506*1E6),(int)(121.099516*1E6)));
        
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

	@Override
	protected boolean isRouteDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}
}
