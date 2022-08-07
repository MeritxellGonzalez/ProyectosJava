package uf2;

public class RegistreNotes {

    public static void main(String[] args) {
        RegistreNotes prg = new RegistreNotes();
        prg.inici();
    }

    private void inici() {
        double[] notes = {2.0, 5.5, 7.25, 3.0, 9.5, 8.25, 7.0, 7.5};
        CalculsArrayReals calculador = new CalculsArrayReals();
        double max = calculador.calcularMaxim(notes);
        double min = calculador.calcularMinim(notes);
        double mitjana = calculador.calcularMitjana(notes);
        System.out.println("La nota maxima es " + max);
        System.out.println("La nota minima es " + min);
        System.out.println("La mitjana de les notes es " + mitjana);

    }

}
