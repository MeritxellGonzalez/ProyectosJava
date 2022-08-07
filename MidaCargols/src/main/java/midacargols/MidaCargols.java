package midacargols;

import java.util.Scanner;

public class MidaCargols {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int mida = entrada.nextInt();
        System.out.println("Quina és la mida del cargol?");
        entrada.nextLine();
        switch (mida) {
            //Fins la mida 2 ens ho classificara com a petit
            case 1:
            case 2:
                System.out.println("Petit");
                break;
            //Fins a la clase 4, ens ho classificara com a mitja
            case 3: 
            case 4:
                System.out.println("Mitjà");
                break;
            //Fins a la clase 7, com a gran
            case 5:
            case 6:
            case 7:
                System.out.println("Gran");
                break;
                //Fins la clase 10, com a molt gran.
            case 8:
            case 9:
            case 10:
                System.out.println("Molt gran");
                break;
                //Fora d'aquestes mides, no es correcte.
            default:
                System.out.println("La mida del cargol no correspon");
        }
    }
}