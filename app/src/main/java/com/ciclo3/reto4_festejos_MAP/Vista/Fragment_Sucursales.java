package com.ciclo3.reto4_festejos_MAP.Vista;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.ciclo3.reto4_festejos_MAP.BuildConfig;
import com.ciclo3.reto4_festejos_MAP.R;

import org.osmdroid.config.Configuration;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapController;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.ItemizedIconOverlay;
import org.osmdroid.views.overlay.ItemizedOverlayWithFocus;
import org.osmdroid.views.overlay.OverlayItem;
import org.osmdroid.views.overlay.mylocation.GpsMyLocationProvider;
import org.osmdroid.views.overlay.mylocation.MyLocationNewOverlay;

import java.util.ArrayList;


public class Fragment_Sucursales extends Fragment {

    View v;

    private MapView myOpenMapView;
    private MapController myMapController;
    GeoPoint Bogota;
    GeoPoint Sucursal_sur;
    GeoPoint Sucursal_centro;
    GeoPoint Sucursal_Norte;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment__sucursales, container, false);
        //-----------------------------------------------------------------------------

        myOpenMapView = (MapView) v.findViewById(R.id.Map);


        Configuration.getInstance().setUserAgentValue(BuildConfig.APPLICATION_ID);

        /*   punto de geolocalizacion de ejemplo */
        Bogota = new GeoPoint(4.5985, -74.0759);
        Sucursal_sur = new GeoPoint(4.62705, -74.2130);
        Sucursal_centro = new GeoPoint(4.5977, -74.0990);
        Sucursal_Norte = new GeoPoint(4.6889, -74.0603);

        //GeoPoint Madrid = new GeoPoint(40.416775, -3.70379);

        myOpenMapView.setBuiltInZoomControls(true);

        myMapController = (MapController) myOpenMapView.getController();
        myMapController.setCenter(Sucursal_centro);
        myMapController.setZoom(12);

        myOpenMapView.setMultiTouchControls(true);

        /* -------------------------------------------------------------------------------------------------- */
        final MyLocationNewOverlay myLocationoverlay = new MyLocationNewOverlay(new GpsMyLocationProvider(getContext()), myOpenMapView);
        myOpenMapView.getOverlays().add(myLocationoverlay); //No añadir si no quieres una marca
        myLocationoverlay.enableMyLocation();

        myLocationoverlay.runOnFirstFix(new Runnable() {
            public void run() {
                myMapController.animateTo(myLocationoverlay.getMyLocation());
            }
        });
        /* -------------------------------------------------------------------------------------------------- */

        ArrayList<OverlayItem> puntos = new ArrayList<OverlayItem>();
        puntos.add(new OverlayItem("Bogota", "Ciudad capital de Bogota", Bogota));
        puntos.add(new OverlayItem("Sede sur", "Bosa", Sucursal_sur));
        puntos.add(new OverlayItem("Sede centro", "Santa Isabel", Sucursal_centro));
        puntos.add(new OverlayItem("Sede Norte", "calle 100", Sucursal_Norte));

        ItemizedIconOverlay.OnItemGestureListener<OverlayItem> tap = new ItemizedIconOverlay.OnItemGestureListener<OverlayItem>() {
            @Override
            public boolean onItemLongPress(int arg0, OverlayItem arg1) {
                return false;
            }
            @Override
            public boolean onItemSingleTapUp(int index, OverlayItem item) {
                return true;
            }
        };

        ItemizedOverlayWithFocus<OverlayItem> capa = new ItemizedOverlayWithFocus<OverlayItem>(getContext(), puntos, tap);
        capa.setFocusItemsOnTap(true);
        myOpenMapView.getOverlays().add(capa);

        //-----------------------------------------------------------------------------
        return v;
    }
}