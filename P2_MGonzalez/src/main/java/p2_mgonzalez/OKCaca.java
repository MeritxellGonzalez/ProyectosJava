package p2_mgonzalez;

import java.util.Scanner;

public class OKCaca {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int[][] arrayVoluntaris = new int[10][5];
        int id;
        boolean dadaCorrecta = true;

        System.out.println("Diguem la ID?");

        id = entrada.nextInt();
        arrayVoluntaris[0][0] = id;
        for (int i = 0; i < arrayVoluntaris.length; i++) {
            for (int j = 0; i < arrayVoluntaris[i].length; j++) {
                if (id >= 21 && id <= 499) {
                    id = arrayVoluntaris[i][j];
                    System.out.println("[" + i + "] , " + "[" + j + "] = " + arrayVoluntaris[i][j]);
                }
            }
        }
        System.out.println(arrayVoluntaris[0][0]);
        for (int i = 0; i < arrayVoluntaris.length; i++) {
            for (int j = 0; j < arrayVoluntaris[i].length; j++) {
                System.out.println("[" + i + "] , " + "[" + j + "] = " + arrayVoluntaris[i][j]);
            }
        }
    }

}
