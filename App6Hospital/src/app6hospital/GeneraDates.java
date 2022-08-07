/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app6hospital;

import java.util.Calendar;
import java.util.Random;

public class GeneraDates {

    private String data;
    private Random rnd = new Random();
    static final String DATA_LLAVOR = "01-11-2020 00:00";

    /*Constructor que genera la primera data a partir de la data llavor*/
    public GeneraDates() {

        rnd.setSeed(234);
        data = DATA_LLAVOR;

    }

    /*Mètode novaData que genera una data posterior a data entre 1 i 24 hores*/
    public String novaData() {
        Calendar cal = Calendar.getInstance();
        int diaD = diaData(data);
        int mesD = mesData(data);
        int anyD = anyData(data);
        int horaD = horaData(data);
        int minD = minData(data);
        cal.set(anyD, mesD, diaD, horaD, minD);
        long dataMilis = (long) (cal.getTimeInMillis() + rnd.nextInt(1000 * 3600 * 23) + 1000 * 3600);
        cal.setTimeInMillis(dataMilis);
        data = String.format("%02d", cal.get(Calendar.DAY_OF_MONTH)) + "-" + String.valueOf(cal.get(Calendar.MONTH)) + "-" + cal.get(Calendar.YEAR) + " " + String.format("%02d", cal.get(Calendar.HOUR)) + ":" + String.format("%02d", cal.get(Calendar.MINUTE));
        return data;

    }

    /*Mètodes que,donada una data, retornen any, mes... */
    public int anyData(String dt) {
        return Integer.parseInt(dt.substring(6, 10));
    }

    public int mesData(String dt) {
        return Integer.parseInt(dt.substring(3, 5));
    }

    public int diaData(String dt) {
        return Integer.parseInt(dt.substring(0, 2));
    }

    public int horaData(String dt) {
        return Integer.parseInt(dt.substring(11, 13));

    }

    public int minData(String dt) {
        return Integer.parseInt(dt.substring(14, 16));
    }

}
