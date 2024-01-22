package com.example.sugandilak;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;


import com.google.android.material.floatingactionbutton.FloatingActionButton;


import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import org.osmdroid.api.IMapController;
import org.osmdroid.config.Configuration;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.ItemizedIconOverlay;
import org.osmdroid.views.overlay.ItemizedOverlayWithFocus;
import org.osmdroid.views.overlay.OverlayItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {



    MapView mapa;
    FloatingActionButton but;
    ArrayList<OverlayItem> puntos = new ArrayList<>();
    IMapController mapController;
    int datos = 0;
    boolean primeravez = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Configuration.getInstance().load(getApplicationContext(), PreferenceManager.getDefaultSharedPreferences(getApplicationContext()));
        setContentView(R.layout.activity_main);

        Bundle b = getIntent().getExtras();
        if (b != null) {
            datos = b.getInt("id");
            primeravez = false;
        }
        but = findViewById(R.id.button);
        mapa = findViewById(R.id.mapaView);


        mapa.setMultiTouchControls(true);
        GeoPoint centro = new GeoPoint(43.135, -2.5391);

        mapController = mapa.getController();
        mapController.setCenter(centro);
        mapController.setZoom(16.0);

        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mapController.setCenter(centro);
                mapController.setZoom(16.0);
            }
        });



        añadirPuntos();
        eliminarPuntos(datos);


        ItemizedOverlayWithFocus<OverlayItem> overlays = new ItemizedOverlayWithFocus<OverlayItem>(getApplicationContext(), puntos, new ItemizedIconOverlay.OnItemGestureListener<OverlayItem>() {
            @Override
            public boolean onItemSingleTapUp(int index, OverlayItem item) {
                return true;
            }

            @Override
            public boolean onItemLongPress(int index, OverlayItem item) {
                int id = index+1;

                Intent i = new Intent(MainActivity.this, MainActivity2.class);
                i.putExtra("id", id);
                startActivity(i);


                return true;
            }
        });

        overlays.setFocusItemsOnTap(true);
        mapa.getOverlays().add(overlays);


    }

    void eliminarPuntos(int datoss) {
        Drawable d = getDrawable(R.drawable.location);
        Drawable d2 = getDrawable(R.drawable.location2);
        if (primeravez) {
            for (int i = 0; i < puntos.size(); i++) {
                puntos.get(i).setMarker(d);
            }
        } else {
            for (int i = 0; i < puntos.size(); i++) {
                puntos.get(i).setMarker(d);
            }

            //for (int i = datoss; i < (puntos.size()-(puntos.size() - datoss)); i++) {
               // puntos.get(i).setMarker(d);
            //}
        }
    }

    void añadirPuntos(){
        GeoPoint geo1 = new GeoPoint(43.1302778, -2.5425);
        GeoPoint geo2 = new GeoPoint(43.12994, -2.5423);
        GeoPoint geo3 = new GeoPoint(43.13019, -2.54200);
        GeoPoint geo4 = new GeoPoint(43.14, -2.536);
        GeoPoint geo5 = new GeoPoint(43.1397, -2.53545);
        OverlayItem punto1 = new OverlayItem("BASÍLICA DE LA PURA CREACIÓN", "Número 1", geo1);
        OverlayItem punto2 = new OverlayItem("SAN VALENTÍN BERRIOTXOA", "Número 2", geo2);
        OverlayItem punto3 = new OverlayItem("REBOMBILLOAS", "Número 3", geo3);
        OverlayItem punto4 = new OverlayItem("NECRÓPOLIS DE ARGIÑETA", "Número 4", geo4);
        OverlayItem punto5 = new OverlayItem("ANBOTOKO MARI", "Número 5", geo5);
        puntos.add(punto1);
        puntos.add(punto2);
        puntos.add(punto3);
        puntos.add(punto4);
        puntos.add(punto5);
    }

    @Override
    public void onPause() {
        super.onPause();
        mapa.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        mapa.onResume();
    }


}