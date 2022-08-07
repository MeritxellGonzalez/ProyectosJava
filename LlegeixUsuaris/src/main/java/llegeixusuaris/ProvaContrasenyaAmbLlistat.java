package llegeixusuaris;

import java.util.Scanner;

public class ProvaContrasenyaAmbLlistat {

    /*
    DECLARACIÓ DE CONSTANTS
     */
    public static final int VALOR_MIN = 0;
    public static final int VALOR_MAX = 1000;
    public static final int VMIN_PER = 1;
    public static final int VMAX_PER = 10;

    public static void main(String[] args) {
        
        int QPersones = 0;
        boolean dadaCorrecta = true;

        
        String Aux;
        String NomUsuari[];//Creació de la variable Array
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

        NomUsuari = new String[QPersones];
        //demana codi per a cada índex que hi ha disponible.
        //entrada.nextLine();
        System.out.println("Escriu els " + QPersones + " noms que vols introduir:");

        for (int i = 0; i < QPersones; i++) {
            System.out.println("Escriu el nom:");
            NomUsuari[i] = entrada.next();
            //CREACIÓ DE LA CONTRASENYA
            contrasenya = NomUsuari[i].replace('a', '4');
            contrasenya = contrasenya.replace('e', '3');
            contrasenya = contrasenya.replace('i', '1');
            contrasenya = contrasenya.replace('o', '0');
            contrasenya = contrasenya.replace('u', '*');
            //MAJUSCULES
            contrasenya = contrasenya.replace('A', '4');
            contrasenya = contrasenya.replace('E', '^');
            contrasenya = contrasenya.replace('I', '1');
            contrasenya = contrasenya.replace('O', '0');
            contrasenya = contrasenya.replace('U', '¬');

            System.out.println("\nEl nom introduït es: \n\t" + NomUsuari[i] + "\ni la seva contrasenya es: \n\t" + contrasenya + ".\t");
        }

        //Mostrem llistat Array
        System.out.println("\nLListat de tots els noms introduïts:");
        for (int i = 0; i < QPersones; i++) {
            System.out.println(NomUsuari[i] + " ------>");
        }
        
        //Ordenem l'Array.
        for (int i = 0; i < NomUsuari.length - 1; i++) {

            for (int j = i + 1; j < NomUsuari.length; j++) {
                if (NomUsuari[i].compareTo(NomUsuari[j]) > 0) {
                    //La posició tractada té un valor més alt que el de la cerca. 
                    //Els intercanviem
                    Aux = NomUsuari[i];
                    NomUsuari[i] = NomUsuari[j];
                    NomUsuari[j] = Aux;
                }

            }

        }
        //Mostrem llistat un cop ordenat
        System.out.println("\nLlistat ordenat :");
        for (int i = 0; i < QPersones; i++) {
            System.out.println("\t\t<------ " + NomUsuari[i]);
        }
    }

}
