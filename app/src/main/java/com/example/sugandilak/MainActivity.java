package com.example.sugandilak;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import com.example.sugandilak.EntidadesDB.ElorrioDatabase;
import com.example.sugandilak.EntidadesDB.Ubicacion;
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
import java.util.List;

public class MainActivity extends AppCompatActivity {

    MapView mapa;
    FloatingActionButton but;
    ArrayList<OverlayItem> puntos = new ArrayList<>();
    IMapController mapController;
    int datos = 3;
    boolean primeravez = true;

    ElorrioDatabase ddbb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Configuration.getInstance().load(getApplicationContext(), PreferenceManager.getDefaultSharedPreferences(getApplicationContext()));
        setContentView(R.layout.activity_main);

        Bundle b = getIntent().getExtras();
        if (b != null) {
            datos = b.getInt("id");
            primeravez = false;
        }else{
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.fragmentBienvenida, FragmentBienvenida.newInstance());
            fragmentTransaction.commit();
        }
        ddbb = ElorrioDatabase.getInstance(this);
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
                if(index == datos){
                    Intent i = new Intent(MainActivity.this, MainActivity2.class);
                    i.putExtra("id", id);
                    startActivity(i);
                }
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

            for (int i = 0; i < (puntos.size()-(puntos.size() - datoss)); i++) {
               puntos.get(i).setMarker(d2);
            }
        }
    }

    void añadirPuntos(){

        List<Ubicacion> lista = ddbb.ubicacionDAO().conseguirTodasUbicaciones();

        for(int i = 0; i<lista.size(); i++){
            GeoPoint geo1 = new GeoPoint(lista.get(i).getLatitud(), lista.get(i).longitud);
            OverlayItem punto1 = new OverlayItem(lista.get(i).getNombre_ubicacion(), "Número "+lista.get(i).getId_ubicacion(), geo1);
            puntos.add(punto1);
        }
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