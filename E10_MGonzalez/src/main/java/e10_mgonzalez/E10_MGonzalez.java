package e10_mgonzalez;

import java.util.Scanner;

public class E10_MGonzalez {

    public static final int VALOR_MIN = 20;
    public static final int VALOR_MAX = 100;
    public static final int VALOR_EXIT = -1;
    public static final int INTENTS_MAX = 2;

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        int valorIntroduit = 0;
        int sumar = 0;
        int intents = 0;

        boolean dadaCorrecta;
        boolean vlimit = false;//Primer semàfor, del primer do-while
        boolean vnegatiu = true;//Segon semàfor, del segon do-while

        //Estructura do-while per als intents.
        do {
            //Estructura do-while per als condicionants.

            do {
                System.out.println("Introdueix el número:");
                dadaCorrecta = entrada.hasNextInt();
                if (dadaCorrecta) {
                    valorIntroduit = entrada.nextInt();
                    if (valorIntroduit >= VALOR_MIN && valorIntroduit <= VALOR_MAX) {
                        vlimit = true;
                        intents += 1;

                    } else {
                        System.out.println("error");
                    }

                    if (valorIntroduit == VALOR_EXIT) {
                        System.out.println(" ");
                        vnegatiu = false;
                    }
                    if (vlimit) {
                        for (int i = 0; i <= valorIntroduit; i++) {
                            if (i % 2 != 0) {
                                System.out.print(i + ", ");
                                sumar += i;

                            }
                        }
                        System.out.println("\nLa suma total dels senars fins el " + valorIntroduit + " és: " + sumar);
                    }

                } else {
                    entrada.nextLine();
                }
            } while ((!vlimit) && (vnegatiu));
        } while ((intents < INTENTS_MAX) && (vnegatiu));

    }
}
