package eac6.p1.mgonzalez;

/**
 *
 * @author David Amorós
 */
import java.io.File;

public class FileUtils {

    public static final int FITXER_NOM_POS = 0;
    public static final int FITXER_MIDA_POS = 1;
    public static final int FITXER_TIPUS_POS = 2;

    private String directoriDades;

    public void inicialitza() {

        directoriDades = System.getProperty("user.dir") + File.separator + "dades";

    }

    /**
     * Funció per canviar de directori al director indicat com a paràmetre. Si
     * rep ".." pujarà 1 nivell.
     *
     * @param directori nom del directori a realitzar el canvi
     * @return true si ha pogut completar l'operació, false en la resta de casos
     */
    public Boolean canviarDirectori(String directori) {

        String directoriNou = "";

        if (directori.equals("..")) {
            File pujarDirectori = new File(directoriDades);

            if (pujarDirectori.exists() && pujarDirectori.getParentFile() != null) {
                directoriNou = pujarDirectori.getParentFile().getAbsolutePath();
            }
        } else {
            directoriNou = directoriDades + File.separator + directori;
        }
        File comp = new File(directoriNou);
        if (comp.exists()) {
            directoriDades = directoriNou;
            return true;

        } else {
            return false;
        }
    }

    /**
     * Funció per obtenir el llistat del contingut d'una ruta donada com a
     * paràmetre
     *
     * @param path ruta on volem llistar el contingut
     * @return Un array de Strings amb els llistat de fitxers i directoris a la
     * ruta indicada, la mida i si és fitxer o directori. Un array buit si
     * alguna cosa no ha anat be
     */
    public String[][] getLlistaContingut(String path) {

        File fitxer = new File(path);
        File[] llista = fitxer.listFiles();
        String[][] contingut = new String[llista.length][3];

        for (int i = 0; i < llista.length; i++) {
            long mida = llista[i].length();
            contingut[i][FITXER_NOM_POS] = llista[i].getName();

            if (llista[i].isDirectory()) {

                contingut[i][FITXER_TIPUS_POS] = "d";
                contingut[i][FITXER_MIDA_POS] = "0";

            } else {
                contingut[i][FITXER_TIPUS_POS] = "f";
                contingut[i][FITXER_MIDA_POS] = Long.toString(mida);
            }
        }

        return contingut;
    }

    /**
     * Funcion Get de la variable directoriDades
     *
     * @return el valor de la variable directoriDades
     */
    public String getDirectoryDades() {

        return directoriDades;
    }

    /**
     * Funció per esborrar el fitxer amb el nom que es rep com a paràmetre. La
     * localització del fitxer ha de ser a la carpeta de dades
     *
     * @param nomFitxer nom del fitxer a esborrar
     * @return true si s'ha pogut esborrar, false en la resta de casos
     */
    public boolean esborraFitxer(String nomFitxer) {

        if (nomFitxer.isEmpty()) {
            return false;
        }
        File fitxer = new File(directoriDades + File.separator + nomFitxer);
        return fitxer.delete();
    }
}
