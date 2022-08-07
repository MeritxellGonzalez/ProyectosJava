package utilitats.arrays;

import unitat5.apartat1.repte3.CalculsArrayReals;

public class RegistreTemperautresReutClasses {

    public static void main(String[] args) {
        RegistreTemperautresReutClasses prg = new RegistreTemperautresReutClasses();
        prg.inici();
    }

    private void inici() {
        double[] temperatures = {20.0, 21.5, 19.0, 17.5, 19.0, 22.25, 21.75};
        //INICIALITZACIÓ MÈTODES CLASSE CalculsArrayReals
        CalculsArrayReals calculador = new CalculsArrayReals();
        //Un cop fet s'ha d'usar com a prefix l'identificador "calculador" 
        //per a cridar els mètodes a usar
        double max = calculador.calcularMaxim(temperatures);
        double min = calculador.calcularMinim(temperatures);
        double diferencia = max - min;
        System.out.println("La diferencia de temperatures maxima "
                + diferencia + ".");

    }
}
