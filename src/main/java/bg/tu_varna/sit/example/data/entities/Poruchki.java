package bg.tu_varna.sit.example.data.entities;

import java.sql.Date;

public class Poruchki {
    public  String poruchka;
    public Date data;
    public  int id;
    public  int id_klient;
    public  int id_kourier;
    public  int id_vid;
    public  String adres;
    public  int status;

    public  String polychatel;
    @Override
    public String toString(){
        return id_klient + " " + poruchka + " " +  adres + " " + data + "  " + polychatel+" " + status; }

}
