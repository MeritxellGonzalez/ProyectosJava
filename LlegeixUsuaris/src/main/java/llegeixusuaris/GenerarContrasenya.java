package llegeixusuaris;

import java.util.Scanner;

public class GenerarContrasenya {

    public static void main(String[] args) {
        String nom;
        String contrasenya = null;
        Scanner entrada = new Scanner(System.in);
        boolean dadaCorrecta;

        System.out.println("Introdueix el nom de l'usuari: ");
        dadaCorrecta = entrada.hasNext();
        if (dadaCorrecta) {
            nom = entrada.next();
            dadaCorrecta = true;
            if (dadaCorrecta) {
                for (int i = 0; i < nom.length(); i++) {
                    contrasenya = nom.replace('a', '4');
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
                }
               System.out.println("\nEl nom introduït es: \n\t" + nom + "\ni la seva contrasenya es: \n\t" + contrasenya); 
            }
        }

    }
}
