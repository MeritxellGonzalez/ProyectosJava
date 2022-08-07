package uf3.fitxer;
import java.io.File;
import java.util.Scanner;
public class MitjanaVocals {
    public static final String MARCA_FI = "fi";
    public static void main(String[] args) {
        MitjanaVocals prg = new MitjanaVocals();
        prg.inici();
    }
    public void inici() {
        try {
            File f = new File("Document.txt");
            Scanner lector = new Scanner(f);
            int numParaules = 0;
            int numVocals = 0;
            boolean llegir = true;
            while (llegir) {
                String paraula = lector.next();
                if (MARCA_FI.equals(paraula)) {
                    llegir = false;
                } else {
                    numParaules++;
                    numVocals = numVocals + comptarVocals(paraula);
                }
            }
            System.out.println("Hi ha " + numParaules + " paraules.");
            System.out.println("Hi ha " + numVocals + " vocals.");
            double mitjana = numVocals / numParaules;
            System.out.println("La mitjana és " + mitjana);
            lector.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
    /**
     * Compta les vocals en una paraula
     *
     * @param paraula Cadena de text on cal comptar les vocals
     * @return Nombre de vocals.
     */
    public int comptarVocals(String paraula) {
        int res = 0;
        paraula = paraula.toLowerCase();
        for (int i = 0; i < paraula.length(); i++) {
            if (esVocal(paraula.charAt(i))) {
                res++;
            }
        }
        return res;
    }
    /**
     * Diu si, donat un caràcter en minúscula, aquest és o no una vocal.
     *
     * @param c
     * @return
     */
    public boolean esVocal(char c) {
        switch (c) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
                return true;
            default:
                return false;
        }
    }
}
