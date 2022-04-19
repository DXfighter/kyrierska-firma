package bg.tu_varna.sit.example.common;

import bg.tu_varna.sit.example.data.entities.Poruchki;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;



public class Utils {



    public static List filterCanceled(List<Poruchki> list){
        ArrayList<Poruchki> result = new ArrayList<Poruchki>();
        for(Poruchki p : list){
            if(p.status == 5 || p.status == 2) result.add(p);
        }
        return result;
    }

    public static List filterJobDone(List<Poruchki> list, int courier, Date data01, Date data02){

        ArrayList<Poruchki> result = new ArrayList<Poruchki>();
        for(Poruchki p : list){
            if(p.id_kourier == courier && p.data.after(data01) && p.data.before(data02))
                result.add(p);
        }
        return result;
    }

    public static List filterClient(List<Poruchki> list, int client){
        ArrayList<Poruchki> result = new ArrayList<Poruchki>();
        for(Poruchki p : list){
            if(p.id_klient == client)
            result.add(p);
        }
        return result;
    }
}
