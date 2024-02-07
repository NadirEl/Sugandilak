package com.example.sugandilak;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import com.example.sugandilak.EntidadesDB.AudioApp;
import com.example.sugandilak.EntidadesDB.ElorrioDatabase;
import com.example.sugandilak.EntidadesDB.Imagen;
import com.example.sugandilak.EntidadesDB.Pregunta;
import com.example.sugandilak.EntidadesDB.PreguntaImagen;
import com.example.sugandilak.EntidadesDB.Texto;
import com.example.sugandilak.EntidadesDB.Ubicacion;
import com.example.sugandilak.EntidadesDB.Video;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


import android.content.Intent;
import android.preference.PreferenceManager;
import android.view.View;

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
    //la view del mapa
    MapView mapa;
    //boton para centrar el mapa
    FloatingActionButton but;
    //array de los puntos de ubicacion
    ArrayList<OverlayItem> puntos = new ArrayList<>();
    IMapController mapController;
    int datos = 0;
    boolean primeravez = true;
    //base de datos
    ElorrioDatabase ddbb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Configuration.getInstance().load(getApplicationContext(), PreferenceManager.getDefaultSharedPreferences(getApplicationContext()));
        setContentView(R.layout.activity_main);

        Bundle b = getIntent().getExtras();
        //instanciamos la base de datos
        ddbb = ElorrioDatabase.getInstance(this);
        if (b != null) {
            //si hay id, no es la primera vez y lo recogemos
            datos = b.getInt("id");
            primeravez = false;
        }else{
            //si es la primera vez, aparece el fragment de bienvenida y se carga la base de datos
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.fragmentBienvenida, FragmentBienvenida.newInstance());
            fragmentTransaction.commit();

            cargarBBDD();
        }
        but = findViewById(R.id.button);
        mapa = findViewById(R.id.mapaView);

        //seteamos el control del mapa
        mapa.setMultiTouchControls(true);
        //centramos el mapa
        GeoPoint centro = new GeoPoint(43.135, -2.5391);

        mapController = mapa.getController();
        mapController.setCenter(centro);
        mapController.setZoom(16.0);

        //boton que centra en el sitio de las ubicaciones, en caso de perdernos en el mapa
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mapController.setCenter(centro);
                mapController.setZoom(16.0);
            }
        });


        //añadimos los puntos, y ponemos los colores correspondientes
        añadirPuntos();
        eliminarPuntos(datos);

        //si clicka la ubicación, sale el nombre de la ubicación
        ItemizedOverlayWithFocus<OverlayItem> overlays = new ItemizedOverlayWithFocus<OverlayItem>(getApplicationContext(), puntos, new ItemizedIconOverlay.OnItemGestureListener<OverlayItem>() {
            @Override
            public boolean onItemSingleTapUp(int index, OverlayItem item) {
                return true;
            }

            @Override
            public boolean onItemLongPress(int index, OverlayItem item) {
                //si se mantiene, se comprueba que se va en orden
                int id = index+1;
                if(index == datos){
                    //y se va al activity del juego corresppondiente
                    Intent i = new Intent(MainActivity.this, MainActivity2.class);
                    i.putExtra("id", id);
                    startActivity(i);
                }
                return true;
            }
        });

        //se colocan los puntos
        overlays.setFocusItemsOnTap(true);
        mapa.getOverlays().add(overlays);


    }

    //funcion que dependiendo de donde estemos, los puntos aparecem em rojo o en verde
    void eliminarPuntos(int datoss) {
        Drawable d = getDrawable(R.drawable.location);
        Drawable d2 = getDrawable(R.drawable.location2);
        if (primeravez) {
            // si es la primera vez, todos en rojo
            for (int i = 0; i < puntos.size(); i++) {
                puntos.get(i).setMarker(d);
            }
        } else {
            //primero pone todos en rojo
            for (int i = 0; i < puntos.size(); i++) {
                puntos.get(i).setMarker(d);
            }
            // y despues dependiendo del id, se ponen algunos en verde
            for (int i = 0; i < (puntos.size()-(puntos.size() - datoss)); i++) {
               puntos.get(i).setMarker(d2);
            }
        }
    }

    //función que añade los puntos, que se recogen de la base de datos
    void añadirPuntos(){

        List<Ubicacion> lista = ddbb.ubicacionDAO().conseguirTodasUbicaciones();

        for(int i = 0; i<lista.size(); i++){
            //se crea el punto de geolocalizacion, con la latitud y longitud
            GeoPoint geo1 = new GeoPoint(lista.get(i).getLatitud(), lista.get(i).longitud);
            //se crea el punto en el mapa y se añade a la lista
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

    //función que carga la base de datos
    void cargarBBDD(){


        ddbb.textoDAO().deleteAllTexto();
        ddbb.audioDAO().deleteAllAudio();
        ddbb.imagenDAO().deleteAllImagenes();
        ddbb.preguntaImagenDAO().deleteAllPreguntaImagen();
        ddbb.videoDAO().deleteAllVideo();
        ddbb.preguntaDAO().deleteAllPregunta();
        ddbb.ubicacionDAO().deleteAllUbicacion();

        Ubicacion u1 = new Ubicacion(1, "BASÍLICA DE LA PURA CREACIÓN", 43.1302778, -2.5425);
        Ubicacion u2 = new Ubicacion(2, "SAN VALENTÍN BERRIOTXOA", 43.12994, -2.5423);
        Ubicacion u3 = new Ubicacion(3, "REBOMBILLOAS", 43.13019, -2.54200);
        Ubicacion u4 = new Ubicacion(4, "NECRÓPOLIS DE ARGIÑETA", 43.14, -2.536);
        Ubicacion u5 = new Ubicacion(5, "ANBOTOKO MARI", 43.1397, -2.53545);

        ddbb.ubicacionDAO().insertarUbicacion(u1);
        ddbb.ubicacionDAO().insertarUbicacion(u2);
        ddbb.ubicacionDAO().insertarUbicacion(u3);
        ddbb.ubicacionDAO().insertarUbicacion(u4);
        ddbb.ubicacionDAO().insertarUbicacion(u5);

        Texto t1 = new Texto(1, "Kaixo! Elorrioko Sortzez Garbiaren Basilika izenaz ezagutzen den monumentu historikoaren aurrean zaudete! Goazen bere historia ezagutzera!! Elorrioko ondare artistikoko monumentu aipagarriena da. Eraikin oso handia da, ia 50 metroko luzera eta 25 metroko zabalera du. Bere eraikuntzari dagokionez, oro har, hiru fase bereiz ditzakegu:");
        Texto t2 = new Texto(1, "Lehendabizi, etapa gotikoa daukagu, 1464tik 1530ra doana. Historiako etapa honetan basilika eraikitzeko lehenengo urratsak eman zituzten. Epealdi honetan aurreko portada eta atzeko portada egin zituzten. Basilikari begira, identifikatu ditzakezue?");
        Texto t3 = new Texto(1, "Horrez gain,  plazatik ikusten den arkupea ere epealdi honetan egin zen. Ikusten duzue zelako forma duen?");
        Texto t4 = new Texto(1, "Azkenik, epealdi honetako estilo gotikoa basilikaren arrosa-leihoan hauteman dezakegu. Badakizu zer den arrosa lehio bat?");
        Texto t5 = new Texto(1, "Bigarrenik, etapa errenazentista nabarmendu daiteke, 1530.urtetik 1620. urtera doana. Etapa horretan hormak amaitu zituzten. Begiratu arretaz hormei, zeozer somatzen duzue?");
        Texto t6 = new Texto(1, "Horrez gain, leihateak ere ireki ziren. Zenbatu ditzakezu zenbat lehio dauden?");
        Texto t7 = new Texto(1, "Orain, joan gaitezen Basilika barrutik ikustera! Ikusten dituzue zelako zutabeak eriki zituzten?");
        Texto t8 = new Texto(1, "Eta gangak?");
        Texto t9 = new Texto(1, "Azkenik, Etapa barrokoa daukago, 1620tik 1767ra. Etapa honetan eraikinaren barruko osagarri batzuk egin ziren. Besteak beste korua eta erretaulak? Ikusten duzue zein disdiratsuak diren?");
        Texto t10 = new Texto(1, "Eta amaitzeko, kanpotik ikusten den kanpadorrea ere egin zuten. Norbaitek ikus dezake zenbat kanpai dauden?");

        ddbb.textoDAO().insertarTexto(t1);
        ddbb.textoDAO().insertarTexto(t2);
        ddbb.textoDAO().insertarTexto(t3);
        ddbb.textoDAO().insertarTexto(t4);
        ddbb.textoDAO().insertarTexto(t5);
        ddbb.textoDAO().insertarTexto(t6);
        ddbb.textoDAO().insertarTexto(t7);
        ddbb.textoDAO().insertarTexto(t8);
        ddbb.textoDAO().insertarTexto(t9);
        ddbb.textoDAO().insertarTexto(t10);

        Texto t11 = new Texto(2, "Kaixo berriro. Orain Balentin Berriotxoa ezagutuko dugu. Horretarako, adi egon behar zarete hurrengo historiari. Eta hori entzun eta gero, argazki eta marrazki desberdinak ordenatu beharko dituzue, Balentin Berriotxoaren bizitza sortzeko.");

        ddbb.textoDAO().insertarTexto(t11);

        Texto t12 = new Texto(3, "Kaixo! Orain Elorrioko jai tradizional bat ezagutuko dugu!! Ezagutzen dituzue Errebonbiloak?\n" +
                "Urtero, urriko lehenengo igandean, \"Errebonbilloak\" izeneko jaia egiten da Elorrion.\n" +
                "1571. urtean, Lepantoko batailan flota kristauak turkiarrari irabazi zion. Bataila hartan, Elorrioko gazteek parte hartu omen zuten, eta, Elorriora itzultzean, pozik jarri zirenez, zenbait tiro bota zituzten airera, berriz etxean zirela poztasunez adierazten.\n" +
                "Orain, urtero, urriko lehenengo igandean, Errebonbilloek Elorrioko kaleak zeharkatzen dituzte gertakizun hori gogoratzeko.\n" +
                "Ulertu duzue? Goazen frogatzera!\n" +
                "Esandakoa ulertu duzuela frogatzeko hurrengo letra sopa bete beharko duzue. Ánimo!!!");

        ddbb.textoDAO().insertarTexto(t12);

        Texto t13 = new Texto(4, "Kaixo! Nekatuta? Argiñetako Nekropolira heldu zara! Badakizu zer den hau?\n" +
                "Euskal Herriko Erdi Aroko hilobi-multzo garrantzitsuena da, bai osagai kopuruagatik, bai antzina-antzinako kronologiagatik. Harrizko hogeta hiru sarkofago eta disko-formako bost hilarri dauzka; horietako batzuk, XIX. mendera arte, gertuko auzoetan zehar sakabanatuta egon ziren. Egungo antolamendua ez da jatorrizkoa.\n" +
                "Orain dela gutxi egindako behaketa arkeologikoetan, hilobi gehiago eta herrixka baten hondarrak eta beste hainbat antzinako pieza aurkitu dira. Horrexegatik, esan daiteke behaketa prozesuan dagoen zonalde bat dela.\n" +
                "Informazio ulertu ahal duzu? Bilatu ezazue karta bakoitzaren bikotea.\n");

        ddbb.textoDAO().insertarTexto(t13);

        Texto t14 = new Texto(5, "Urkiolako parke naturalean, Anboto mendia aurkitzen dugu, Bizkaiko mendi ikusgarriena eta arriskutsuena. Anboto Bizkaiko mendi garrantzitsuenetako bat da, baina ez bakarrik bertako paisaiengatik, baita euskal mitologian duen garrantziagatik ere. Hemen agertzen da euskal mitologiako pertsonaiarik ezagunena, Anbotoko Mari. “Anbotoko dama” edo “Anbotoko zorgina” bezala ere ezaguna dena. Mari kobazuloetan bizi da, eta hor jendea doa bizitatzera baina bere etxean sartu ahal izateko hiru gauza bete behar dira:\n" +
                "* Lehenengoa ”Hika” erabiltzea\n" +
                "* Bigarrena Haitzulora sartzen zaren moduan atera behar zarela\n" +
                "* Hirugarrena Ezin zarela inoiz eseri, nahiz eta beraren baimena izan.\n" +
                "Lurreko eta meteoroetako andrea da Mari. Eta bere eginkizunetako bat gezurra, lapurketa eta harrotasuna zigortzea da. Ikus dezagun Mariren bideo bat gehiago ezagutzeko!!\n");

        ddbb.textoDAO().insertarTexto(t14);

        Imagen im1 = new Imagen(1, 0);
        Imagen im2 = new Imagen(1, R.drawable.imgp1);
        Imagen im3 = new Imagen(1, R.drawable.imgp2);
        Imagen im4 = new Imagen(1, R.drawable.imgp3);
        Imagen im5 = new Imagen(1, R.drawable.imgp4);
        Imagen im6 = new Imagen(1, R.drawable.imgp5);
        Imagen im7 = new Imagen(1, R.drawable.imgp6);
        Imagen im8 = new Imagen(1, R.drawable.imgp7);
        Imagen im9 = new Imagen(1, R.drawable.imgp8);
        Imagen im10 = new Imagen(1, R.drawable.imgp9);


        ddbb.imagenDAO().insertarImagen(im1);
        ddbb.imagenDAO().insertarImagen(im2);
        ddbb.imagenDAO().insertarImagen(im3);
        ddbb.imagenDAO().insertarImagen(im4);
        ddbb.imagenDAO().insertarImagen(im5);
        ddbb.imagenDAO().insertarImagen(im6);
        ddbb.imagenDAO().insertarImagen(im7);
        ddbb.imagenDAO().insertarImagen(im8);
        ddbb.imagenDAO().insertarImagen(im9);
        ddbb.imagenDAO().insertarImagen(im10);

        AudioApp a1 = new AudioApp(1, R.raw.eliza1);
        AudioApp a2 = new AudioApp(1, R.raw.eliza2);
        AudioApp a3 = new AudioApp(1, R.raw.eliza3);
        AudioApp a4 = new AudioApp(1, R.raw.eliza4);
        AudioApp a5 = new AudioApp(1, R.raw.eliza5);
        AudioApp a6 = new AudioApp(1, R.raw.eliza6);
        AudioApp a7 = new AudioApp(1, R.raw.eliza7);
        AudioApp a8 = new AudioApp(1, R.raw.eliza8);
        AudioApp a9 = new AudioApp(1, R.raw.eliza9);
        AudioApp a10 = new AudioApp(1, R.raw.eliza10);

        ddbb.audioDAO().insertarAudio(a1);
        ddbb.audioDAO().insertarAudio(a2);
        ddbb.audioDAO().insertarAudio(a3);
        ddbb.audioDAO().insertarAudio(a4);
        ddbb.audioDAO().insertarAudio(a5);
        ddbb.audioDAO().insertarAudio(a6);
        ddbb.audioDAO().insertarAudio(a7);
        ddbb.audioDAO().insertarAudio(a8);
        ddbb.audioDAO().insertarAudio(a9);
        ddbb.audioDAO().insertarAudio(a10);

        AudioApp a11 = new AudioApp(2, R.raw.balentin1);

        ddbb.audioDAO().insertarAudio(a11);

        AudioApp a12 = new AudioApp(3, R.raw.rebonbiloak);

        ddbb.audioDAO().insertarAudio(a12);

        AudioApp a13 = new AudioApp(4, R.raw.argineta);

        ddbb.audioDAO().insertarAudio(a13);

        AudioApp a14 = new AudioApp(5, R.raw.mari1);

        ddbb.audioDAO().insertarAudio(a14);

        PreguntaImagen pi1 = new PreguntaImagen(R.drawable.imgp1, "Gotikoa");
        PreguntaImagen pi2 = new PreguntaImagen(R.drawable.imgp2, "Gotikoa");
        PreguntaImagen pi3 = new PreguntaImagen(R.drawable.imgp3, "Gotikoa");
        PreguntaImagen pi4 = new PreguntaImagen(R.drawable.imgp4, "Errenazentista");
        PreguntaImagen pi5 = new PreguntaImagen(R.drawable.imgp5, "Errenazentista");
        PreguntaImagen pi6 = new PreguntaImagen(R.drawable.imgp6, "Errenazentista");
        PreguntaImagen pi7 = new PreguntaImagen(R.drawable.imgp7, "Errenazentista");
        PreguntaImagen pi8 = new PreguntaImagen(R.drawable.imgp8, "Barrokoa");
        PreguntaImagen pi9 = new PreguntaImagen(R.drawable.imgp9, "Barrokoa");

        ddbb.preguntaImagenDAO().insertarPreguntaImagen(pi1);
        ddbb.preguntaImagenDAO().insertarPreguntaImagen(pi2);
        ddbb.preguntaImagenDAO().insertarPreguntaImagen(pi3);
        ddbb.preguntaImagenDAO().insertarPreguntaImagen(pi4);
        ddbb.preguntaImagenDAO().insertarPreguntaImagen(pi5);
        ddbb.preguntaImagenDAO().insertarPreguntaImagen(pi6);
        ddbb.preguntaImagenDAO().insertarPreguntaImagen(pi7);
        ddbb.preguntaImagenDAO().insertarPreguntaImagen(pi8);
        ddbb.preguntaImagenDAO().insertarPreguntaImagen(pi9);

        Pregunta p1 = new Pregunta(5,1, "Nondik mugitzen da Mari?", "Mendietatik", "Itsasotik", "Zerutik", "Mendietatik");
        Pregunta p2 = new Pregunta(5,2, "Ze mendietan ibiltzen da Mari?", "Udalaitz", "Hiru erregeen maila", "Pirineos", "Udalaitz");
        Pregunta p3 = new Pregunta(5,3, "Non dago Anboto?", "Bizkaia", "Araba", "Gipuzkoa", "Bizkaia");
        Pregunta p4 = new Pregunta(5,4, "Zenbat urtez bizi da aukeratzen duen gailurrean?", "5 urte", "8 urte", "7 urte", "7 urte");
        Pregunta p5 = new Pregunta(5,5, "Zeren antza hartzen du Marik zerutik mugitzeko?", "Suzko higitai eta euriaren edo kaskabarraren antza", "Txorien antza", "Trumoi eta tximisten antza", "Suzko higitai eta euriaren edo kaskabarraren antza");
        Pregunta p6 = new Pregunta(5,6,"Zeri buruz daki asko Marik?", "Eguraldia", "Ekonomia", "Informatika", "Eguraldia");
        Pregunta p7 = new Pregunta(5,7, "Zer ustea dago Mariren ingururuan?", "Gizakiak sortu zituela", "Planetak sortu zituela", "Planetak sortu zituela", "Planetak sortu zituela");

        ddbb.preguntaDAO().insertarPregunta(p1);
        ddbb.preguntaDAO().insertarPregunta(p2);
        ddbb.preguntaDAO().insertarPregunta(p3);
        ddbb.preguntaDAO().insertarPregunta(p4);
        ddbb.preguntaDAO().insertarPregunta(p5);
        ddbb.preguntaDAO().insertarPregunta(p6);
        ddbb.preguntaDAO().insertarPregunta(p7);

        Video v = new Video(5, R.raw.video);

        ddbb.videoDAO().insertarVideo(v);
    }


}