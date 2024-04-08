package edu.polytech.ihmtd2dechet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;


import android.app.Fragment;

import android.app.FragmentTransaction;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import org.osmdroid.api.IMapController;
import org.osmdroid.config.Configuration;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.ItemizedIconOverlay;
import org.osmdroid.views.overlay.ItemizedOverlayWithFocus;
import org.osmdroid.views.overlay.OverlayItem;

import java.util.ArrayList;

public class MapActivity extends AppCompatActivity  {
    private MapView map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        setContentView(R.layout.activity_map);

        // Open Street Map
        includeMap();
    }
    @Override
    public void onPause(){
        super.onPause();
        map.onPause();
    }
    @Override
    public void onResume(){
        super.onResume();
        map.onResume();
    }
    private void includeMap() {
        Configuration.getInstance().load(getApplicationContext(), PreferenceManager.getDefaultSharedPreferences(getApplicationContext()));
        map = findViewById(R.id.mapView);
        map.setTileSource(TileSourceFactory.MAPNIK);    // render
        map.setBuiltInZoomControls(true);               // roomable
        GeoPoint startPoint = new GeoPoint(43.65020, 7.00517);
        IMapController mapController = map.getController();
        mapController.setZoom(18.0);
        mapController.setCenter(startPoint);

        ArrayList<OverlayItem> items= new ArrayList<>();
        items.add(new OverlayItem("Signalement 1", "", new GeoPoint(43.65020, 7.00517)));
        items.add(new OverlayItem("Signalement 2", "", new GeoPoint(43.64950, 7.00517)));

        ItemizedOverlayWithFocus<OverlayItem> mOverlay = new ItemizedOverlayWithFocus<OverlayItem>(getApplicationContext(),
                items, new ItemizedIconOverlay.OnItemGestureListener<OverlayItem>() {
            @Override
            public boolean onItemSingleTapUp(int index, OverlayItem item) {
                return true;
            }

            @Override
            public boolean onItemLongPress(int index, OverlayItem item) {
                return false;
            }
        });

        mOverlay.setFocusItemsOnTap(true);
        map.getOverlays().add(mOverlay);
    }


}