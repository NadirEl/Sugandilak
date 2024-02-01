package com.example.sugandilak;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.example.sugandilak.EntidadesDB.ElorrioDatabase;
import com.example.sugandilak.EntidadesDB.Texto;
import com.example.sugandilak.EntidadesDB.TextoDAO;

import java.util.List;

public class InsertandoDatosMuñeca extends AppCompatActivity {

    String s1 = "Kaixo! Elorrioko Sortzez Garbiaren Basilika izenaz ezagutzen den monumentu historikoaren aurrean zaudete! Goazen bere historia ezagutzera!! Elorrioko ondare artistikoko monumentu aipagarriena da. Eraikin oso handia da, ia 50 metroko luzera eta 25 metroko zabalera du. Bere eraikuntzari dagokionez, oro har, hiru fase bereiz ditzakegu:";
    String s2 = "Lehendabizi, etapa gotikoa daukagu, 1464tik 1530ra doana. Historiako etapa honetan basilika eraikitzeko lehenengo urratsak eman zituzten. Epealdi honetan aurreko portada eta atzeko portada egin zituzten. Basilikari begira, identifikatu ditzakezue?";
    String s3 = "Horrez gain,  plazatik ikusten den arkupea ere epealdi honetan egin zen. Ikusten duzue zelako forma duen?";
    String s4 = "Azkenik, epealdi honetako estilo gotikoa basilikaren arrosa-leihoan hauteman dezakegu. Badakizu zer den arrosa lehio bat?";
    String s5 = "Bigarrenik, etapa errenazentista nabarmendu daiteke, 1530.urtetik 1620. urtera doana. Etapa horretan hormak amaitu zituzten. Begiratu arretaz hormei, zeozer somatzen duzue?";
    String s6 = "Horrez gain, leihateak ere ireki ziren. Zenbatu ditzakezu zenbat lehio dauden?";
    String s7 = "Orain, joan gaitezen Basilika barrutik ikustera! Ikusten dituzue zelako zutabeak eriki zituzten?";
    String s8 = "Eta gangak?";
    String s9 = "Azkenik, Etapa barrokoa daukago, 1620tik 1767ra. Etapa honetan eraikinaren barruko osagarri batzuk egin ziren. Besteak beste korua eta erretaulak? Ikusten duzue zein disdiratsuak diren?";
    String s10 = "Eta amaitzeko, kanpotik ikusten den kanpadorrea ere egin zuten. Norbaitek ikus dezake zenbat kanpai dauden?";


    String s = "Kaixo berriro. Orain Balentin Berriotxoa ezagutuko dugu. Horretarako, adi egon behar zarete hurrengo historiari. Eta hori entzun eta gero, argazki eta marrazki desberdinak ordenatu beharko dituzue, Balentin Berriotxoaren bizitza sortzeko.";
    String ssss = "Kaixo! Orain Elorrioko jai tradizional bat ezagutuko dugu!! Ezagutzen dituzue Errebonbiloak?\n" +
            "Urtero, urriko lehenengo igandean, \"Errebonbilloak\" izeneko jaia egiten da Elorrion.\n" +
            "1571. urtean, Lepantoko batailan flota kristauak turkiarrari irabazi zion. Bataila hartan, Elorrioko gazteek parte hartu omen zuten, eta, Elorriora itzultzean, pozik jarri zirenez, zenbait tiro bota zituzten airera, berriz etxean zirela poztasunez adierazten.\n" +
            "Orain, urtero, urriko lehenengo igandean, Errebonbilloek Elorrioko kaleak zeharkatzen dituzte gertakizun hori gogoratzeko. \n" +
            "Ulertu duzue? Goazen frogatzera! \n" +
            "Esandakoa ulertu duzuela frogatzeko hurrengo letra sopa bete beharko duzue. Ánimo!!!\n";
    String sss ="Kaixo! Nekatuta? Argiñetako Nekropolira heldu zara! Badakizu zer den hau?\n" +
            "Euskal Herriko Erdi Aroko hilobi-multzo garrantzitsuena da, bai osagai kopuruagatik, bai antzina-antzinako kronologiagatik. Harrizko hogeta hiru sarkofago eta disko-formako bost hilarri dauzka; horietako batzuk, XIX. mendera arte, gertuko auzoetan zehar sakabanatuta egon ziren. Egungo antolamendua ez da jatorrizkoa.\n" +
            "Orain dela gutxi egindako behaketa arkeologikoetan, hilobi gehiago eta herrixka baten hondarrak eta beste hainbat antzinako pieza aurkitu dira. Horrexegatik, esan daiteke behaketa prozesuan dagoen zonalde bat dela. \n" +
            "Informazio ulertu ahal duzu? Bilatu ezazue karta bakoitzaren bikotea.\n";
    String ss ="Urkiolako parke naturalean, Anboto mendia aurkitzen dugu, Bizkaiko mendi ikusgarriena eta arriskutsuena. Anboto Bizkaiko mendi garrantzitsuenetako bat da, baina ez bakarrik bertako paisaiengatik, baita euskal mitologian duen garrantziagatik ere. Hemen agertzen da euskal mitologiako pertsonaiarik ezagunena, Anbotoko Mari. “Anbotoko dama” edo “Anbotoko zorgina” bezala ere ezaguna dena. Mari kobazuloetan bizi da, eta hor jendea doa bizitatzera baina bere etxean sartu ahal izateko hiru gauza bete behar dira:\n" +
            "* Lehenengoa ”Hika” erabiltzea\n" +
            "* Bigarrena Haitzulora sartzen zaren moduan atera behar zarela\n" +
            "* Hirugarrena Ezin zarela inoiz eseri, nahiz eta beraren baimena izan.\n" +
            "Lurreko eta meteoroetako andrea da Mari. Eta bere eginkizunetako bat gezurra, lapurketa eta harrotasuna zigortzea da. Ikus dezagun Mariren bideo bat gehiago ezagutzeko!!\n";


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ElorrioDatabase db = ElorrioDatabase.getInstance(this);

        db.textoDAO().insertarTexto(s1);
        db.textoDAO().insertarUbicacion(1);
        db.textoDAO().insertarTexto(s2);
        db.textoDAO().insertarUbicacion(1);
        db.textoDAO().insertarTexto(s3);
        db.textoDAO().insertarUbicacion(1);
        db.textoDAO().insertarTexto(s4);
        db.textoDAO().insertarUbicacion(1);
        db.textoDAO().insertarTexto(s5);
        db.textoDAO().insertarUbicacion(1);
        db.textoDAO().insertarTexto(s6);
        db.textoDAO().insertarUbicacion(1);
        db.textoDAO().insertarTexto(s7);
        db.textoDAO().insertarUbicacion(1);
        db.textoDAO().insertarTexto(s8);
        db.textoDAO().insertarUbicacion(1);
        db.textoDAO().insertarTexto(s9);
        db.textoDAO().insertarUbicacion(1);
        db.textoDAO().insertarTexto(s10);
        db.textoDAO().insertarUbicacion(1);
        db.textoDAO().insertarTexto(s);
        db.textoDAO().insertarUbicacion(2);
        db.textoDAO().insertarTexto(ssss);
        db.textoDAO().insertarUbicacion(3);
        db.textoDAO().insertarTexto(sss);
        db.textoDAO().insertarUbicacion(4);
        db.textoDAO().insertarTexto(ss);
        db.textoDAO().insertarUbicacion(5);







    }


}
