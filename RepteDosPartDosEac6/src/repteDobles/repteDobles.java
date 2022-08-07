package repteDobles;

import java.io.File;
import java.io.PrintStream;

public class repteDobles {

    public static void main(String[] args) {
        repteDobles prg = new repteDobles();
        prg.inici();
    }

    public void inici() {
        PrintStream escriptor = null;
        try {
            //S'intenta obrir el fitxer
            File f = new File("enters.txt");
            escriptor = new PrintStream(f);
            //S'escriu el primer valor, que no necessita un espai abans.
            int valor = 1;
            escriptor.print(valor);
            //Es van generant la resta de valors i escrivint
            for (int i = 1; i < 20; i++) {
                //Cada 5 elements, s'escriu un salt de línia
                if (i % 5 == 0) {
                    escriptor.print("\n");
                } else {
                    //si no, s'escriu com a delimitador un espai en blanc
                    escriptor.print(" ");
                }
                //Es calcula i escriu el nou valor.
                valor = valor * 2;
                escriptor.print(valor);
            }
            System.out.println("Fitxer escrit satisfactòriament.");
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        escriptor.close();
    }
}
