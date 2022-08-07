package probandoExamen;

import java.util.Scanner;

public class GestorGas {

    private static final String TEMP_CAP = "ID                CLIENT   CONSUM(litres)";
    private static final String TEMP_LIN = "-----------------------------------------";
    private static final String TEMP_ITEM = "%4s %20s %9.2f";

    public static void mostraConsums(DadesGas dGas) {
        System.out.println(TEMP_LIN + "\n" + TEMP_CAP + "\n" + TEMP_LIN);

        for (int i = 0; i < dGas.clientsGas.length; i++) {
            System.out.println(String.format(TEMP_ITEM,
                    dGas.clientsGas[i][DadesGas.IDEX_IDCLI],
                    dGas.clientsGas[i][DadesGas.IDEX_NOMCLI],
                    dGas.despesaMes[i]));
        }
    }
//PREGUNTA 3

    public static int demanaEnterPos(String missatge) {
        Scanner lector = new Scanner(System.in);
        int enter = 0;
        boolean numCorrecte = false;
        System.out.println(missatge);
        do {
            numCorrecte = lector.hasNextInt();
            if (numCorrecte) {
                enter = lector.nextInt();
            }
            if (enter < 0) {
                numCorrecte = false;
                System.out.println("El número introduït ha de ser positiu");
            }
            lector.nextLine();
        } while (!numCorrecte);

        return enter;

    }
//PREGUNTA 4

    public static String demanaText(String missatge) {
        Scanner lector = new Scanner(System.in);
        String text = "";
        do {
            System.out.println(missatge);
            text = lector.nextLine();
            if (text.isEmpty()) {
                System.out.println("El text no pot estar buit");
            }
        } while (text.isEmpty());

        return text;
    }

//PREGUNTA 5
    /**
     * En el inici se'ns demana crear demanaEnterPos però les dades del consum
     * es guarden en un array de dades de tipus double, com que la suma entre
     * int i double es compatible s'obviara el fet que no es poden entrar
     * resultats amb decimals.
     */
    public static void actualitzaConsumGas(DadesGas dadesGas) {
        System.out.println("ACTUALITZACIÓ DEL CONSUM");
        String ID = demanaText("Introdueix el ID del Client:");
        if(!existeixClient(ID)){
            mostrarAlerta("El Client no existeix");
        }else{
            int consum = demanaEnterPos("Introdueix el consum a afegir:");
            incrementaConsum(dadesGas, ID, consum);
            mostrainfoProcesFinalitzat("Consum del client " + ID +" actualitzat!");
        }
    }

    private static boolean existeixClient(String ID) {
        
     return true;   
    }

    private static void mostrarAlerta(String error) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static void incrementaConsum(DadesGas dadesGas, String ID, int consum) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static void mostrainfoProcesFinalitzat(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
