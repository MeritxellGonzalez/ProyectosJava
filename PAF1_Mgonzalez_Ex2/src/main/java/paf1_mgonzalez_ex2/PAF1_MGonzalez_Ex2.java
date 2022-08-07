package paf1_mgonzalez_ex2;

public class PAF1_MGonzalez_Ex2 {

    public static final int DTE_MAX = 30;
    public static final int DTE_MITG = 20;
    public static final int DTE_MIN = 15;
    public static final int MANTENIMENT = 200;

    public static void main(String[] args) {
        int preuBase = 10000;
        int total;
        boolean mantenimentContractat = true;
        if (preuBase >= 5000) {
            preuBase -= (preuBase * DTE_MAX) / 100;
        } else if (preuBase >= 1000) {
            preuBase -= (preuBase * DTE_MITG) / 100;
        } else if (preuBase >= 500) {
            preuBase -= (preuBase * DTE_MIN) / 100;
        } else {
            System.out.println("No hi ha descomptes disponibles.");

        }
        if (mantenimentContractat == true) {
            total = preuBase + MANTENIMENT;
            System.out.println("El preu total és: " + total);
        } else {
            mantenimentContractat = false;
            System.out.println("El preu total és: " + preuBase);
        }
    }
}
