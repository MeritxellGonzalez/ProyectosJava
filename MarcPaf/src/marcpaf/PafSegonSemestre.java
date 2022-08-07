package marcpaf;

import java.io.File;
import java.io.PrintStream;

public class PafSegonSemestre {

    public static void main(String[] args) {
        PafSegonSemestre prg = new PafSegonSemestre();
        prg.inici();
    }

    private void inici() {
        int nomFitxer = 4;
        int dies[] = {12, 15, 16, 20};
        int mesos[] = {01, 13, 11, 04};
        int anys[] = {1990, 1995, 2004, 2021};
        double mesura[] = {20.2, 12.3, 18.6, 12.2};
        escriure(nomFitxer, dies, mesos, anys, mesura);
    }

    public File escriure(int nomFitxer, int[] dies, int[] mesos, int[] anys, double[] mesura) {
        String nomFitxerString = String.valueOf(nomFitxer).replaceAll("4", "escriure.txt");
        File f = new File(nomFitxerString);
        PrintStream escriptor = null;
        try {
            escriptor = new PrintStream(f);
            int posicio = dies.length;

            for (int i = 0; i < posicio; i++) {
                int year = anys[i];
                int mes = mesos[i];
                int dia = dies[i];

                double mesures = mesura[i];
                if (dia > 31) {
                    mes++;
                    dia = 1;

                }
                if (mes > 12) {
                    mes = 1;
                    year++;

                }
                escriptor.println(year
                        + " / " + mes
                        + " / " + dia + " - " + mesures);

            }
            System.out.println("Fitxer creat correctament");
            escriptor.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return f;
    }

}
