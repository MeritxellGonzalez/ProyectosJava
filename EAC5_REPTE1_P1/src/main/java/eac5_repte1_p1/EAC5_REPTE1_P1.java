/*
Repte 1. Feu un programa que, donats dos arrays de valors reals, 
us digui quin dels dos té el valor mitjà més alt. 
Aprofiteu el principi de modularitat per fer-lo, 
de manera que la seva classe principal només tingui 
definits els mètodes main i inici.
*/

package eac5_repte1_p1;

public class EAC5_REPTE1_P1 {

    public static void main(String[] args) {
        EAC5_REPTE1_P1 prg = new EAC5_REPTE1_P1();
        prg.inici();
    }

    public void inici() {
        double[] temperatures = {32.0, 35.0, 37.05, 33.0, 39.00, 38.10, 37.0, 36.5};
        CalculsArrayReal calc = new CalculsArrayReal();
        double max = calc.calcMax(temperatures);
        double min = calc.calcMin(temperatures);
        double mitjana = calc.calcMitj(temperatures);
        System.out.println("La temperatura màxima és " + max + ".");
        System.out.println("La nota temperatura és " + min + ".");
        System.out.println("La mitjana de les temperatures és " + mitjana + ".");
    }
}
