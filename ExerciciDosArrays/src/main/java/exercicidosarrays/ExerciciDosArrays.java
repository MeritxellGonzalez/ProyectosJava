package exercicidosarrays;

import java.util.Scanner;

public class ExerciciDosArrays {

    public static final int MAX = 5;

    public static void main(String[] args) {
        int i = 0;
        Scanner entrada = new Scanner(System.in);
        boolean dadaCorrecta = false;
        int[] valors = new int[MAX];
        System.out.println("Introdueix " + MAX + " valors i el programa et dira si hi ha cap 0 i, en quina posició està.");
        while (i < valors.length) {
            if (entrada.hasNextInt()) {
                valors[i] = entrada.nextInt();
                i++;
            }else{
                entrada.next();
            }
        }
        entrada.nextLine();
        i = 0;
        while((i < valors.length) && (!dadaCorrecta)){
            if(valors[i] == 0){
                dadaCorrecta = true;
            }
            i++;
        }
        if(dadaCorrecta){
            System.out.println("Hi ha un 0 en la posició " + i);
        }else{
            System.out.println("No hi ha cap zero");
        }
    }
}
