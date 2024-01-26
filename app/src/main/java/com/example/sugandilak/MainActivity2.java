package com.example.sugandilak;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;

import pl.droidsonroids.gif.GifImageView;

public class MainActivity2 extends AppCompatActivity {
    int id;
    ArrayList<String> textos = new ArrayList<>();
    ArrayList<Integer> img = new ArrayList<>();
    ArrayList<Integer> audios = new ArrayList<>();
    FragmentManager fragmentManager = getSupportFragmentManager();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Bundle b = getIntent().getExtras();
        id = b.getInt("id");

        recogerTextos();
    }

    void recogerTextos() {
        switch(id){
            case 1: String s1 = "Kaixo! Elorrioko Sortzez Garbiaren Basilika izenaz ezagutzen den monumentu historikoaren aurrean zaudete! Goazen bere historia ezagutzera!! Elorrioko ondare artistikoko monumentu aipagarriena da. Eraikin oso handia da, ia 50 metroko luzera eta 25 metroko zabalera du. Bere eraikuntzari dagokionez, oro har, hiru fase bereiz ditzakegu:";
                String s2 = "Lehendabizi, etapa gotikoa daukagu, 1464tik 1530ra doana. Historiako etapa honetan basilika eraikitzeko lehenengo urratsak eman zituzten. Epealdi honetan aurreko portada eta atzeko portada egin zituzten. Basilikari begira, identifikatu ditzakezue?";
                String s3 = "Horrez gain,  plazatik ikusten den arkupea ere epealdi honetan egin zen. Ikusten duzue zelako forma duen?";
                String s4 = "Azkenik, epealdi honetako estilo gotikoa basilikaren arrosa-leihoan hauteman dezakegu. Badakizu zer den arrosa lehio bat?";
                String s5 = "Bigarrenik, etapa errenazentista nabarmendu daiteke, 1530.urtetik 1620. urtera doana. Etapa horretan hormak amaitu zituzten. Begiratu arretaz hormei, zeozer somatzen duzue?";
                String s6 = "Horrez gain, leihateak ere ireki ziren. Zenbatu ditzakezu zenbat lehio dauden?";
                String s7 = "Orain, joan gaitezen Basilika barrutik ikustera! Ikusten dituzue zelako zutabeak eriki zituzten?";
                String s8 = "Eta gangak?";
                String s9 = "Azkenik, Etapa barrokoa daukago, 1620tik 1767ra. Etapa honetan eraikinaren barruko osagarri batzuk egin ziren. Besteak beste korua eta erretaulak? Ikusten duzue zein disdiratsuak diren?";
                String s10 = "Eta amaitzeko, kanpotik ikusten den kanpadorrea ere egin zuten. Norbaitek ikus dezake zenbat kanpai dauden?";

                textos.add(s1);
                textos.add(s2);
                textos.add(s3);
                textos.add(s4);
                textos.add(s5);
                textos.add(s6);
                textos.add(s7);
                textos.add(s8);
                textos.add(s9);
                textos.add(s10);

                int imgid1 = R.drawable.imgp1;
                int imgid2 = R.drawable.imgp2;
                int imgid3 = R.drawable.imgp3;
                int imgid4 = R.drawable.imgp4;
                int imgid5 = R.drawable.imgp5;
                int imgid6 = R.drawable.imgp6;
                int imgid7 = R.drawable.imgp7;
                int imgid8 = R.drawable.imgp8;
                int imgid9 = R.drawable.imgp9;

                img.add(null);
                img.add(imgid1);
                img.add(imgid2);
                img.add(imgid3);
                img.add(imgid4);
                img.add(imgid5);
                img.add(imgid6);
                img.add(imgid7);
                img.add(imgid8);
                img.add(imgid9);

                int audio1 = R.raw.eliza1;
                int audio2 = R.raw.eliza2;
                int audio3 = R.raw.eliza3;
                int audio4 = R.raw.eliza4;
                int audio5 = R.raw.eliza5;
                int audio6 = R.raw.eliza6;
                int audio7 = R.raw.eliza7;
                int audio8 = R.raw.eliza8;
                int audio9 = R.raw.eliza9;
                int audio10 = R.raw.eliza10;

                audios.add(audio1);
                audios.add(audio2);
                audios.add(audio3);
                audios.add(audio4);
                audios.add(audio5);
                audios.add(audio6);
                audios.add(audio7);
                audios.add(audio8);
                audios.add(audio9);
                audios.add(audio10);

                break;

            case 2: String s = "Kaixo berriro. Orain Balentin Berriotxoa ezagutuko dugu. Horretarako, adi egon behar zarete hurrengo historiari. Eta hori entzun eta gero, argazki eta marrazki desberdinak ordenatu beharko dituzue, Balentin Berriotxoaren bizitza sortzeko.";
                textos.add(s);
                int audio = R.raw.balentin1;
                audios.add(audio);
                break;

            case 3: String ssss = "Kaixo! Orain Elorrioko jai tradizional bat ezagutuko dugu!! Ezagutzen dituzue Errebonbiloak?\n" +
                    "Urtero, urriko lehenengo igandean, \"Errebonbilloak\" izeneko jaia egiten da Elorrion.\n" +
                    "1571. urtean, Lepantoko batailan flota kristauak turkiarrari irabazi zion. Bataila hartan, Elorrioko gazteek parte hartu omen zuten, eta, Elorriora itzultzean, pozik jarri zirenez, zenbait tiro bota zituzten airera, berriz etxean zirela poztasunez adierazten.\n" +
                    "Orain, urtero, urriko lehenengo igandean, Errebonbilloek Elorrioko kaleak zeharkatzen dituzte gertakizun hori gogoratzeko. \n" +
                    "Ulertu duzue? Goazen frogatzera! \n" +
                    "Esandakoa ulertu duzuela frogatzeko hurrengo letra sopa bete beharko duzue. Ánimo!!!\n";
                textos.add(ssss);
                int audiossss = R.raw.rebonbiloak;
                audios.add(audiossss);
                break;

            case 4: String sss ="Kaixo! Nekatuta? Argiñetako Nekropolira heldu zara! Badakizu zer den hau?\n" +
                    "Euskal Herriko Erdi Aroko hilobi-multzo garrantzitsuena da, bai osagai kopuruagatik, bai antzina-antzinako kronologiagatik. Harrizko hogeta hiru sarkofago eta disko-formako bost hilarri dauzka; horietako batzuk, XIX. mendera arte, gertuko auzoetan zehar sakabanatuta egon ziren. Egungo antolamendua ez da jatorrizkoa.\n" +
                    "Orain dela gutxi egindako behaketa arkeologikoetan, hilobi gehiago eta herrixka baten hondarrak eta beste hainbat antzinako pieza aurkitu dira. Horrexegatik, esan daiteke behaketa prozesuan dagoen zonalde bat dela. \n" +
                    "Informazio ulertu ahal duzu? Bilatu ezazue karta bakoitzaren bikotea.\n";
                textos.add(sss);
                int audiosss = R.raw.argineta;
                audios.add(audiosss);
                break;


            case 5: String ss ="Urkiolako parke naturalean, Anboto mendia aurkitzen dugu, Bizkaiko mendi ikusgarriena eta arriskutsuena. Anboto Bizkaiko mendi garrantzitsuenetako bat da, baina ez bakarrik bertako paisaiengatik, baita euskal mitologian duen garrantziagatik ere. Hemen agertzen da euskal mitologiako pertsonaiarik ezagunena, Anbotoko Mari. “Anbotoko dama” edo “Anbotoko zorgina” bezala ere ezaguna dena. Mari kobazuloetan bizi da, eta hor jendea doa bizitatzera baina bere etxean sartu ahal izateko hiru gauza bete behar dira:\n" +
                    "* Lehenengoa ”Hika” erabiltzea\n" +
                    "* Bigarrena Haitzulora sartzen zaren moduan atera behar zarela\n" +
                    "* Hirugarrena Ezin zarela inoiz eseri, nahiz eta beraren baimena izan.\n" +
                    "Lurreko eta meteoroetako andrea da Mari. Eta bere eginkizunetako bat gezurra, lapurketa eta harrotasuna zigortzea da. Ikus dezagun Mariren bideo bat gehiago ezagutzeko!!\n";
                textos.add(ss);
                int audioss = R.raw.mari1;
                audios.add(audioss);
                break;

        }

        abrirFragmentExplicacion();
    }

    void abrirFragmentExplicacion() {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.idfragment, ExplicacionFragment.getInstance(textos, img, audios, id));
        fragmentTransaction.commit();
    }

    void abrirFragmentJuego1(){
        ArrayList<PreguntaImagen> listapi = new ArrayList<>();
        listapi = recogerPreguntasImagen();
        FragmentTransaction fragmentTransaction1 = fragmentManager.beginTransaction();
        fragmentTransaction1.add(R.id.idfragment, FragmentPreguntaImagen.getInstance(listapi));
        fragmentTransaction1.commit();
    }

    void abrirFragmentJuego2(){
        FragmentTransaction fragmentTransaction2 = fragmentManager.beginTransaction();
        fragmentTransaction2.add(R.id.idfragment, Juego2Fragment.getInstance());
        fragmentTransaction2.commit();
    }

    void abrirFragmentJuego5(){
        Intent i = new Intent(MainActivity2.this, Laberinto.class);
        startActivity(i);
    }

    void abrirFragmentJuego4(){
        FragmentTransaction fragmentTransaction4 = fragmentManager.beginTransaction();
        fragmentTransaction4.add(R.id.idfragment, PrimerFragment.getInstance());
        fragmentTransaction4.commit();
    }
    void abrirFragmentJuego3(){
        FragmentTransaction fragmentTransaction3 = fragmentManager.beginTransaction();
        fragmentTransaction3.add(R.id.idfragment, SopaDeLetrasFragment.getInstance());
        fragmentTransaction3.commit();
    }

    void abrirFragmentSopaDeLetras() {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.idfragment, SopaDeLetrasFragment.getInstance());
        fragmentTransaction.commit();
    }



    ArrayList<PreguntaImagen> recogerPreguntasImagen(){
        ArrayList<PreguntaImagen> pi = new ArrayList<>();
        PreguntaImagen pi1 = new PreguntaImagen(R.drawable.imgp1, "Gotikoa");
        PreguntaImagen pi2 = new PreguntaImagen(R.drawable.imgp2, "Gotikoa");
        PreguntaImagen pi3 = new PreguntaImagen(R.drawable.imgp3, "Gotikoa");
        PreguntaImagen pi4 = new PreguntaImagen(R.drawable.imgp4, "Errenazentista");
        PreguntaImagen pi5 = new PreguntaImagen(R.drawable.imgp5, "Errenazentista");
        PreguntaImagen pi6 = new PreguntaImagen(R.drawable.imgp6, "Errenazentista");
        PreguntaImagen pi7 = new PreguntaImagen(R.drawable.imgp7, "Errenazentista");
        PreguntaImagen pi8 = new PreguntaImagen(R.drawable.imgp8, "Barrokoa");
        PreguntaImagen pi9 = new PreguntaImagen(R.drawable.imgp9, "Barrokoa");

        pi.add(pi1);
        pi.add(pi2);
        pi.add(pi3);
        pi.add(pi4);
        pi.add(pi5);
        pi.add(pi6);
        pi.add(pi7);
        pi.add(pi8);
        pi.add(pi9);

        return pi;
    }

    void volverMapa(int id){
        Intent i = new Intent(MainActivity2.this, MainActivity.class);
        i.putExtra("id", id);
        startActivity(i);
    }
}
