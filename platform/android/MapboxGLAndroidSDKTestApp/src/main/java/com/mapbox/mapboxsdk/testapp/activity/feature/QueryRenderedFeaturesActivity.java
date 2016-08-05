package com.mapbox.mapboxsdk.testapp.activity.feature;

import android.graphics.PointF;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;

import com.mapbox.mapboxsdk.camera.CameraUpdateFactory;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback;
import com.mapbox.mapboxsdk.testapp.R;
import com.mapbox.services.commons.geojson.Feature;

import java.util.List;

/**
 * Demo's query rendered features
 */
public class QueryRenderedFeaturesActivity extends AppCompatActivity {
    private static final String TAG = QueryRenderedFeaturesActivity.class.getSimpleName();

    public MapView mapView;
    private MapboxMap mapboxMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_runtime_style);
        setupActionBar();

        final float density = getResources().getDisplayMetrics().density;

        //Initialize map as normal
        mapView = (MapView) findViewById(R.id.mapView);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(final MapboxMap mapboxMap) {
                QueryRenderedFeaturesActivity.this.mapboxMap = mapboxMap;

                mapboxMap.setOnMapClickListener(new MapboxMap.OnMapClickListener() {
                    @Override
                    public void onMapClick(@NonNull LatLng point) {
                        final PointF pixel = mapboxMap.getProjection().toScreenLocation(point);
                        Log.i(TAG, String.format("Requesting features for %sx%s (%sx%s adjusted for density)", pixel.x, pixel.y, pixel.x / density, pixel.y / density));
                        List<Feature> features = mapboxMap.queryRenderedFeatures(pixel);
                        Log.i(TAG, String.format("Got %s features", features.size()));
                    }
                });

                //Little taste of home
                mapboxMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(52.0907, 5.1214), 12));
            }
        });
    }

    public MapboxMap getMapboxMap() {
        return mapboxMap;
    }

    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void setupActionBar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowHomeEnabled(true);
        }
    }
}
