package ex9_3;

import java.util.Scanner;

public class EX9_3 {

    public static final int VALOR_MAX = 5;
    public static final int VALOR_MIN = 0;
    public static final int INTENTS_NUM_MAX = 3;

    public static void main(String[] args) {
        //Declarem variables.
        Scanner entrada = new Scanner(System.in);
        int numIntents = 1, valorUsuari = 0, intentsRestants;
        boolean dadaCorrecta = false;
        //Iniciem while
        //Determinem si es un sencer i si esta entre el 0 i el 5.
        while (!dadaCorrecta) {
            System.out.println("Introdueix un nombre que estigui entre " + VALOR_MIN + " i, entre " + VALOR_MAX + " :");
            dadaCorrecta = entrada.hasNextInt();
            if (!dadaCorrecta) {
                System.out.println("No s'ha introduit un valor VÀLID.");
                entrada.next();
            } else {//es un sencer
                valorUsuari = entrada.nextInt();
                if ((valorUsuari < VALOR_MIN) || (valorUsuari > VALOR_MAX) && (numIntents < INTENTS_NUM_MAX)) {
                    System.out.println("El valor introduit " + valorUsuari + " no esta entre " + VALOR_MIN + " i " + VALOR_MAX);
                    dadaCorrecta = false;
                    numIntents++;
                    intentsRestants = INTENTS_NUM_MAX - numIntents;
                    System.out.println("Et queden " +intentsRestants+ " intents.");
                }
            }
        }
        //Mostrem resultats.
        if(dadaCorrecta && numIntents <= INTENTS_NUM_MAX){
            System.out.println("Dada correcta. El valor introduït és: " + valorUsuari + ".");           
        }else{
            System.out.println("Ja no et resten més intents.");
        }
    }
}
