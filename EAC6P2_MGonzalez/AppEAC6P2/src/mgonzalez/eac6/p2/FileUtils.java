/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mgonzalez.eac6.p2;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.io.RandomAccessFile;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileUtils {

    public static final int FITXER_NOM_POS = 0;
    public static final int FITXER_MIDA_POS = 1;
    public static final int FITXER_TIPUS_POS = 2;

    private String directoriDades;

    private static final String LOG_FILE = "atletes_log.bin";
    private static final String DATA_FILE = "vilatletes.txt";

    public void inicialitza() {
        // Per defecte es el directori de treball + /dades 
        directoriDades = System.getProperty("user.dir") + File.separator + "dades";
        mostraDirectoryDades();
    }

    /**
     * Funció per canviar de directori al director indicat com a paràmetre. Si
     * rep ".." pujarà 1 nivell.
     *
     * @param directori nom del directori a realitzar el canvi
     * @return true si ha pogut completar l'operació, false en la resta de casos
     */
    public Boolean canviarDirectori(String directori) {

        String newDirectoriDades = "";

        // Si l'usuari vol pujar un nivell en els directoris
        if (directori.equals("..")) {
            File novaLocalitzacio = new File(directoriDades);
            if (novaLocalitzacio.exists() && novaLocalitzacio.getParentFile() != null) {
                newDirectoriDades = novaLocalitzacio.getParentFile().getAbsolutePath();
            }
        } else { // O si vol canviar a un nou directori
            newDirectoriDades = directoriDades + File.separator + directori;
        }

        // comprovació que tot ha anat bé
        File testNewDir = new File(newDirectoriDades);

        if (testNewDir.exists()) {
            directoriDades = newDirectoriDades;
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

        File file = new File(path);
        File[] llistatDirectori = file.listFiles();

        String[][] contingut = new String[llistatDirectori.length][3];

        // Loop a tot el contingut del directori
        for (int i = 0; i < llistatDirectori.length; i++) {
            long mida = llistatDirectori[i].length();

            contingut[i][FITXER_NOM_POS] = llistatDirectori[i].getName();
            contingut[i][FITXER_MIDA_POS] = Long.toString(mida);

            // Si es fitxer, afegim f si no d
            if (llistatDirectori[i].isDirectory()) {
                contingut[i][FITXER_TIPUS_POS] = "d";
            } else {
                contingut[i][FITXER_TIPUS_POS] = "f";
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
     * Funció per esborrar el fitxer amb el nom que es rep com a parèmetre. La
     * localització del fitxer ha de ser a la carpeta de dades
     *
     * @param nomFitxer nom del fitxer a esborrar
     * @return true si s'ha pogut esborrar, false en la resta de casos
     */
    public boolean esborraFitxer(String nomFitxer) {
        // Sanity check
        if (nomFitxer.isEmpty()) {
            return false;
        }

        File file = new File(directoriDades + File.separator + nomFitxer);
        return file.delete();
    }

    /**
     * Funció interna per mostrar el directori de dades (test)
     */
    private void mostraDirectoryDades() {
        System.out.println(directoriDades);
    }

    /**
     * Funció per carregar l'ocupació de les habitacions de la vila
     *
     * @return una variable del tipus DadesVila amb les dades carregades
     */
    public DadesVila carregaOcupacio() {

        String nomFitxer = directoriDades + File.separator + DATA_FILE;

        DadesVila dVila;

        String splitDades[] = carregaDadesFitxer(nomFitxer);
        for (int i = 0; i < splitDades.length; i++) { 
            System.out.println(splitDades[i]); 
        }

        dVila = new DadesVila();
        dVila.inicialita();

        if (splitDades.length == 0) {
            System.out.println("\n\tInicialitzem nova Vila. Estem creant el registre.Gràcies.");
        } else {
            dVila.codiUltimAtleta = Integer.parseInt(splitDades[1].replace(",", ""));
            int posLineaSplit = 2;
            for (int i = 0; i < dVila.atletesVilaOlimpica.length; i++) {

                String dadesAtletesSplit[] = splitDades[posLineaSplit].split(",");
                if (dadesAtletesSplit.length == 3) {
                    String idAtleta = dadesAtletesSplit[0].trim();
                    String idpais = dadesAtletesSplit[1].trim();
                    String idmedalla = dadesAtletesSplit[2].trim();
                    dVila.addAtleta(idAtleta, idpais, idmedalla, i);
                }
                posLineaSplit++;
            }

        }

        return dVila;
    }

    /**
     * FALTA EXPLICACIÓ DEL QUE FA AQUESTA FUNCIÓ
     *
     * @param nomFitxer
     * @return
     */
    private String[] carregaDadesFitxer(String nomFitxer) {
        String dades[] = new String[0];
        try {
            Scanner file = new Scanner(new File(nomFitxer));
            if (file.hasNextLine()) {
                String primeraLinea = file.nextLine();
                int numLinias = Integer.parseInt(primeraLinea.replace(",", ""));
                dades = new String[numLinias + 2];
                dades[0] = primeraLinea;
            }
            int posicio = 1;
            while (file.hasNextLine()) {
                dades[posicio] = file.nextLine();
                posicio++;
            }
            file.close();

        } catch (IOException ex) {
            Logger.getLogger(FileUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dades;
    }

    /**
     * Funció per guardar l'ocupació de la vila olímpica en un monent donat
     *
     * @param dVila variable amb les dades de tots els atletes registrats
     */
    public void guardaOcupacio(DadesVila dVila) {
        int ultAtl = dVila.codiUltimAtleta;
        String nomFitxer = directoriDades + File.separator + DATA_FILE;
        String dades = dVila.atletesVilaOlimpica.length 
                + ","
                + System.getProperty("line.separator")
                +ultAtl 
                + ","
                +System.getProperty("line.separator");
        for (int i = 0; i < dVila.atletesVilaOlimpica.length; i++) {
            dades += formatAtleta(dVila.atletesVilaOlimpica[i]);
        }
        try {
            PrintStream filePrintStream = new PrintStream(nomFitxer);
            filePrintStream.append(dades);
            filePrintStream.close();

        } catch (IOException ex) {
            Logger.getLogger(FileUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private String formatAtleta(String[] atleta) {
        String dades = String.join(",",
                atleta[DadesVila.ID_ATLETA],
                atleta[DadesVila.ID_PAIS],
                atleta[DadesVila.ID_MEDALLES],
                System.getProperty("line.separator")
        );
        return dades;
    }

    public void guardarAltaEnHistoric(String dadesAtleta[]) {

        String nomFitxer = directoriDades + File.separator + LOG_FILE;
        try {
            RandomAccessFile fileEscriptura = new RandomAccessFile(nomFitxer, "rw");
            fileEscriptura.seek(fileEscriptura.length());

            fileEscriptura.writeChars(formataAtletaLog(dadesAtleta));

            fileEscriptura.close();

        } catch (IOException ex) {
            Logger.getLogger(FileUtils.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Funció per buscar les dades d'un atleta en l'historic de atletes
     *
     * @param idatleta id de l'atleta a busca en l'historic
     * @return Array amb les dades de l'atleta
     */
    public String[] getHistoricAtleta(String codiAtleta) {

        String nomFitxer = directoriDades + File.separator + LOG_FILE;
        String[] atleta = new String[3];

        int midaAtleta = calculaMidaAtletesDades();
        try {
            RandomAccessFile atletesFile = new RandomAccessFile(nomFitxer, "r");
            int posicio = 0;
            while (posicio < atletesFile.length()) {
                atletesFile.seek(posicio);

                String id = llegeixChars(atletesFile, DadesVila.ID_ATLETA_LENGTH).replace(",", " ");

                if (id.replace(" ", "").equalsIgnoreCase(codiAtleta)) {
                    atleta[DadesVila.ID_ATLETA] = id.replace(" ", "");
                    atleta = llegeixAtleta(atletesFile, atleta);
                }
                posicio += midaAtleta;
            }
            atletesFile.close();
        } catch (IOException ex) {
            Logger.getLogger(FileUtils.class.getName()).log(Level.SEVERE, null, ex);
        }

        return atleta;
    }

    private String formataAtletaLog(String[] dadesAtleta) {

        String atletaLogData = String.join("",
                String.format("%1$" + DadesVila.ID_ATLETA_LENGTH + "s", dadesAtleta[DadesVila.ID_ATLETA]),
                String.format("%1$" + DadesVila.ID_PAIS_LENGTH + "s", dadesAtleta[DadesVila.ID_PAIS]),
                String.format("%1$" + DadesVila.ID_MEDALLES_LENGTH + "s", dadesAtleta[DadesVila.ID_MEDALLES])
        );

        return atletaLogData;
    }

    private String[] llegeixAtleta(RandomAccessFile atletesFile, String[] atleta) {
        String pais = (String) llegeixChars(atletesFile, DadesVila.ID_PAIS_LENGTH);
        String medalles = (String) llegeixChars(atletesFile, DadesVila.ID_MEDALLES_LENGTH);

        atleta[DadesVila.ID_PAIS] = pais.replace(" ", "");
        atleta[DadesVila.ID_MEDALLES] = medalles.replace(" ", "");

        return atleta;
    }

    private String llegeixChars(RandomAccessFile atletesFile, int mida) {
        String data = "";
        try {
            for (int i = 0; i < mida; i++) {
                data += atletesFile.readChar();
            }
        } catch (IOException ex) {
            Logger.getLogger(FileUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }

    private int calculaMidaAtletesDades() {
        int mida
                = (Character.BYTES * DadesVila.ID_ATLETA_LENGTH)
                + (Character.BYTES * DadesVila.ID_PAIS_LENGTH)
                + (Character.BYTES * DadesVila.ID_MEDALLES_LENGTH);
        return mida;
    }

}
