package e8_mgonzalez;

import java.util.Scanner;

public class E8_MGonzalez {

    public static final int NUM_MAX = 100;
    public static final int LIMIT_NUM_INF = 1;
    public static final int LIMIT_NUM_MAX = 20;

    public static void main(String[] args) {
        //Definim variables
        int numIntr = 0, i = 0;//Contador
        Scanner entrada = new Scanner(System.in);
        boolean valor;
        //semafor
        boolean valorOk = false;

       //Verifiquem condició
        while (!valorOk) {
            System.out.println("Entra el valor: ");
            valor = entrada.hasNextInt();
            if (valor) {
                numIntr = entrada.nextInt();
                if ((numIntr >= LIMIT_NUM_INF) && (numIntr <= LIMIT_NUM_MAX)) {
                    valorOk = true;
                }
            } else {
                entrada.nextLine();
            }
        }//Al complirse es fa la segona part de l'exercici.
        while (i <= NUM_MAX) {
            if (i % numIntr == 0) {
                System.out.println(i);
            }
            i++;//aument del contador.
        }
    }
}
