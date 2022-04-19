package bg.tu_varna.sit.example.data.access;

import bg.tu_varna.sit.example.common.Utils;
import bg.tu_varna.sit.example.data.entities.Courier;
import bg.tu_varna.sit.example.data.entities.Poruchki;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

class SQLClassTest {

    @Test
    @Order(1)
    public void hireCourier(){

        SQLClass.hireCourier("www", "1234");
        ArrayList<Courier> result = new ArrayList<>();
        for(Courier c : SQLClass.getCouriers()){

            if(c.username.trim().equals("www")) result.add(c);
        }
        assertEquals(1, result.size());
    }

    @Test
    @Order(2)
    public void fireCourier(){
        SQLClass.fireCourier("www");
        ArrayList<Courier> result = new ArrayList<>();
        for(Courier c : SQLClass.getCouriers()){
            if(c.username == "www") result.add(c);
        }
        assertEquals(0, result.toArray().length);

    }



    @Test
    void loginCourier() {

        boolean result = SQLClass.loginCourier("niki", "1234");
        assertEquals(true, result);
        System.out.println("Login courier successful");
    }

    @Test
    void loginAdmin() {
        boolean result = SQLClass.loginAdmin("ivan", "666666");
        assertEquals(true, result);
        System.out.println("Login admin successful");

    }



    @Test
    void testCanceled() {
        ArrayList<Poruchki> list = new ArrayList<Poruchki>();
        Poruchki p = new Poruchki();
        p.status = 1;
        list.add(p);
        p = new Poruchki();
        p.status = 2;
        list.add(p);

        List<Poruchki> result = Utils.filterCanceled(list);
        assertEquals(1, result.toArray().length);
    }

    @Test
    void getTypeID() {

        int envelope = SQLClass.getTypeID("envelope");
        int id_package = SQLClass.getTypeID("package");
        int big_package = SQLClass.getTypeID("big package");
        int heavy_load = SQLClass.getTypeID("heavy load");
        assertAll("Correct ID",
                () -> assertEquals(1, envelope),
                () -> assertEquals(2, id_package),
                () -> assertEquals(3, big_package),
                () -> assertEquals(4, heavy_load)
        );

    }

    @Test
    void filterJobDone() {
        ArrayList<Poruchki> list = new ArrayList<Poruchki>();
        Poruchki p = new Poruchki();
        p.id_kourier = 1;
        p.data = Date.valueOf("2022-01-15");
        list.add(p);
        p = new Poruchki();
        p.id_kourier = 2;
        p.data = Date.valueOf("2022-02-28");
        list.add(p);
        p = new Poruchki();
        p.id_kourier = 1;
        p.data = Date.valueOf("2022-01-16");
        list.add(p);

        List<Poruchki> result = Utils.filterJobDone(list, 1, Date.valueOf("2022-01-10"), Date.valueOf("2022-01-20"));
        assertEquals(2, result.toArray().length);

    }

    @Test
    void filterJobDoneFail() {
        ArrayList<Poruchki> list = new ArrayList<Poruchki>();
        Poruchki p = new Poruchki();
        p.id_kourier = 1;
        p.data = Date.valueOf("2022-01-15");
        list.add(p);


        List<Poruchki> result = Utils.filterJobDone(list, 2, Date.valueOf("2022-01-10"), Date.valueOf("2022-01-20"));
        assertEquals(0, result.toArray().length);

    }

    @Test
    void filterClient() {
        ArrayList<Poruchki> list = new ArrayList<Poruchki>();
        Poruchki p = new Poruchki();
        p.id_klient = 1;
        list.add(p);
        p = new Poruchki();
        p.id_klient = 2;
        list.add(p);

        List<Poruchki> result = Utils.filterClient(list,1);
        assertEquals(1, result.toArray().length);
    }










}