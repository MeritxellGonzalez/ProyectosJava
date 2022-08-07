package termostat;

import java.util.Scanner;

public class Termostat {

    public static final double TEMP_LIMIT = 21.0;

    public static void main(String[] args) {
        Scanner termo = new Scanner(System.in);
        double temperatura;
        System.out.println("Quina es la temperatura?");
        temperatura = termo.nextInt();
        if (temperatura >= TEMP_LIMIT) {
            System.out.println("Activant l'aire acondicionat");
        } else {
            System.out.println("Aturant l'aire acondicionat");
        }
    }
}
