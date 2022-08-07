package paf1_mgonzalez_ex3;

public class PAF1_MGonzalez_ex3 {

    public static final int MAX_VALOR = 40;

    public static void main(String[] args) {
        int resultat;
        int valorBase1 = 7, valorBase2 = 2;

        int multiplicacio1 = 0, multiplicacio2 = 0;

        System.out.println("Taula del 7\n\n");
        for (int i = 0; i < MAX_VALOR + 1; i++) {

            multiplicacio1 = valorBase1 * i;

            System.out.println(valorBase1 + " x " + i + " = " + multiplicacio1 + "\t\n");

        }
        System.out.println("\n\nTaula del Dos (invertida)\n\n");
        for (int j = MAX_VALOR ; j > 0 -1; j--) {
            multiplicacio2 = valorBase2 * j;

            System.out.println(valorBase2 + " x " + j + " = " + multiplicacio2 + "\t\n");
        }
        System.out.println(multiplicacio2);
       resultat = multiplicacio1 - multiplicacio2;
       
        if(resultat <= 5){
            System.out.println(multiplicacio1 + " i " + multiplicacio2 + " es diferencien de poc (menys de 5)");
        }
    }
}
