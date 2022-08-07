package exercici.tasca2.periode1;

public class EXERCICI_TASCA2_PERIODE1 {

    public static void main(String[] args) {
        EXERCICI_TASCA2_PERIODE1 prg = new EXERCICI_TASCA2_PERIODE1();
        prg.exercici3();
    }

    void exercici3() {
        long valor = 11;
        int i = 0;
        int pot = 4;
        int calc = 1;

        while (i < pot) {
            i++;
            calc *= valor;
        }

        System.out.println("Resultat: " + calc);
    }

}
