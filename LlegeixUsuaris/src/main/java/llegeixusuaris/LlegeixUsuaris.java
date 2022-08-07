package llegeixusuaris;

import java.util.Scanner;

public class LlegeixUsuaris {

    public static final int VALOR_MIN = 0;
    public static final int VALOR_MAX = 1000;
    public static final int VMIN_PER = 1;
    public static final int VMAX_PER = 10;

    public static void main(String[] args) {

        int QPersones = 0;
        int codisAux;
        boolean dadaCorrecta = true;

        //Creació de la variable Array
        int PosicioArr[];
        String NomUsuari[];
        String contrasenya;
        Scanner entrada = new Scanner(System.in);
        //Preguntem quantes persones

        System.out.println("Quantes persones es volen entrar (1-10): ");
        dadaCorrecta = entrada.hasNextInt();
        //Validem si es un número sencer i, si esta entre 1-10;
        if (dadaCorrecta) {
            QPersones = entrada.nextInt();
            if (QPersones > VMIN_PER && QPersones < VMAX_PER) {
                System.out.println("\nHas introduit: " + QPersones + " persones.");
                dadaCorrecta = true;
            } else {
                dadaCorrecta = false;
                System.out.println("ERROR");
            }
        }

        PosicioArr = new int[QPersones];
        //demana codi per a cada índex que hi ha disponible.
        //entrada.nextLine();
        System.out.println("\nCodi d'usuari introduït: ");
        if (entrada.hasNextInt()) {
            int Codi = 0;
            if (Codi >= VALOR_MIN && Codi <= VALOR_MAX) {
                for (int i = 0; i < QPersones; i++) {
                    PosicioArr[i] = entrada.nextInt();
                }

                //Mostrem llistat Array
                System.out.println("\nLListat d'usuaris introduïts:");
                for (int i = 0; i < QPersones; i++) {
                    System.out.println(PosicioArr[i]);
                }
                //Ordenem l'Array.
                //Del núm. més petit
                for (int i = 0; i < PosicioArr.length - 1; i++) {
                    //Al núm. més gran
                    for (int j = i + 1; j < PosicioArr.length; j++) {
                        if (PosicioArr[i] > PosicioArr[j]) {
                            //La posició tractada té un valor més alt que el de la cerca. 
                            //Els intercanviem
                            codisAux = PosicioArr[i];
                            PosicioArr[i] = PosicioArr[j];
                            PosicioArr[j] = codisAux;
                        }

                    }

                }
                //Mostrem llistat un cop ordenat
                System.out.println("\nLlistat ordenat de tots els codis entrats:");
                for (int i = 0; i < QPersones; i++) {
                    System.out.println(PosicioArr[i]);
                }
            }

        }
    }
}
