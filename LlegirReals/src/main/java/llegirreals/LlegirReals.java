package llegirreals;

import java.io.File;
import java.util.Scanner;



public class LlegirReals {

    public static final int NUM_VALORS = 15;

    public static void main(String[] args) {
        LlegirReals programa = new LlegirReals();
        programa.inici();
    }

    public void inici() {
        Scanner lector = null;
        try {
        //S’intenta obrir el fitxer
            File f = new File("reals.txt");
            lector = new Scanner(f);
            //De moment, el màxim és el primer valor
            double maxim = lector.nextDouble();
            //Recorrem la resta de valors
            for (int i = 1; i < NUM_VALORS; i++) {
                double valor = lector.nextDouble();
                //El nou valor és més gran?
                if (maxim < valor) {
                    maxim = valor;
                }
            }
            System.out.println("El valor més gran és: " + maxim);
        } catch (Exception e) {
            //Excepció!
            System.out.println("Error: " + e);
        }
        //Amb error o sense, cal tancar el fitxer
        lector.close();
    }
}
