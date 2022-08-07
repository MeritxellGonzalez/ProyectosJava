package uf2;

import java.util.Scanner;

public class LlegiuDoubleTeclatReturn {

    public static void main(String[] args) {
        LlegiuDoubleTeclatReturn prg = new LlegiuDoubleTeclatReturn();
        prg.inici();
    }

    private void inici() {
        System.out.println("Introdueix el nombre:");
        double a = llegeixDoubleTeclat();
        System.out.println("El nombre ha estat: " + a);
        System.out.println("Introdueix un altre NOMBRE: ");
        a = llegeixDoubleTeclat();
        System.out.println("El nombre ha estat: " + a);
    }

    private double llegeixDoubleTeclat() {
        Scanner in = new Scanner(System.in);
        double doubleLlegit = 0.0;
        boolean llegit = false;
        while (!llegit) {
            llegit = in.hasNextDouble();
            if (llegit) {
                doubleLlegit = in.nextDouble();
            } else {
                System.out.println("No és una dada de tipus Double");
                in.next();
            }
        }
        in.nextLine();

        return doubleLlegit;
    }
}
