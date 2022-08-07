package reptedospartdoseac6;

import java.util.Scanner;
import java.io.File;
import java.io.PrintStream;

public class RepteDosPartDosEac6 {

    public static final int NUM_VALORS = 20;

    public static void main(String[] args) {
        RepteDosPartDosEac6 prg = new RepteDosPartDosEac6();
        prg.inici();
    }

    public void inici() {
        try{
            //S'intenta obrir el fitxer
            File f = new File("enters.txt");
            PrintStream escriptor = new PrintStream(f);
            //S'escriu el primer valor, que no necessita un espai abans.
            int valor = 1;
            escriptor.print(valor);
            //Es van generant la resta de valors i escrivint
            for(int i = 1; i < 20; i++){
                //S'escriu abans com delimitador un espai en blanc
                escriptor.print("");
                //Es calcula i escriu el nou valor
                valor = valor*2;
                escriptor.print(valor);
            }
            //Cal tancar el fitxer
            escriptor.close();
            System.out.println("Fitxer escrit satisfactòriament.");
        }catch(Exception e){
            System.out.println("Error: " + e);
        }
    }
}
