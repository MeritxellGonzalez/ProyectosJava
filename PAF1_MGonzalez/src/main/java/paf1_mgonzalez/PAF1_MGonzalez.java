package paf1_mgonzalez;

public class PAF1_MGonzalez {

    public static final int DELICADA = 0;
    public static final int RENTAT_RAPID = 1;
    public static final int LLANA = 2;
    public static final int COLOR = 3;

    public static void main(String[] args) {
        int temperatura = 300;
        int revolucions = 750;
        int roba = 3;

        if (roba == DELICADA) {
            if (roba == RENTAT_RAPID) {
                if (roba == LLANA) {
                    temperatura = 0;
                    revolucions = 750;
                } else {
                    temperatura = 20;
                    revolucions = 300;
                }
            } else {
                if (roba == COLOR) {
                    temperatura = 20;
                    revolucions = 1200;
                } else {
                    temperatura = 30;
                    revolucions = 1000;
                }

            }
            System.out.println("La temperatura recomenada es: " + temperatura + " i les revolucions: " + revolucions);
        } else {
            System.out.println("Mirar les indicacions de l'etiqueta.");
        }
    }
}
