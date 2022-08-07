package uf2;

public class MitjanaMaxima {
    public static void main (String[]args){
        MitjanaMaxima prg = new MitjanaMaxima();
        prg.inici();
    }

    private void inici() {
        double [] arrayA = {7,8.9,9.2,6.3,5.2};
        double [] arrayB = {6,9.6,6.5,8.8,7.6,9.9};
        
        CalculsArrayReals calculs = new CalculsArrayReals();
        
        double mitjanaA = calculs.calcularMitjana(arrayA);
        double mitjanaB = calculs.calcularMitjana(arrayB);
        // He creat la classe diferenciaMitjana() i, la he invocat aquí.
        // Es el mateix resultat que l'exemple anterior.
        calculs.diferenciaMitjana(mitjanaA, mitjanaB);
        
    }

    

}
