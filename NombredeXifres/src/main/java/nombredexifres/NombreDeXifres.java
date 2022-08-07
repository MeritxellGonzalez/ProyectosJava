package nombredexifres;

import java.util.Scanner;

public class NombreDeXifres {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        int numXifres = 0;

        System.out.println("Quin valor vols analitzar?");
        entrada.nextLine();
        int num = entrada.nextInt(); //acumulador
        
        do {
            num = num / 10;
            numXifres++;
        } while (num != 0);
        System.out.println("El nombre de xifres és " + numXifres + ".");

    }
}
