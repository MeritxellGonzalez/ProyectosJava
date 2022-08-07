/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app6hospital;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.io.RandomAccessFile;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileUtils {

    public enum AccionsPacients {
        ALTA,
        INGRES
    }

    public static final int FITXER_NOM_POS = 0;
    public static final int FITXER_MIDA_POS = 1;
    public static final int FITXER_TIPUS_POS = 2;

    private String directoriDades;

    private static final String LOG_FILE = "pacients_log.bin";
    private static final String DATA_FILE = "urgcovid.txt";

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
     * Funció per esborrar el fitxer amb el nom que es rep com a paràmetre. La
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
     * Funció per carregar l'ocupació dels box del
     *
     * @return una variable del tipus DadesCOVID amb les dades carregades
     */
    public DadesCOVID carregaOcupacio() {

        String nomFitxer = directoriDades + File.separator + DATA_FILE;

        DadesCOVID dCovid;

        String splitDades[] = carregaDadesFitxer(nomFitxer);
        int numLinies = 0;

        if (splitDades.length > 0) {
            numLinies = Integer.parseInt(splitDades[0].replace(",", ""));
        }

        dCovid = new DadesCOVID(numLinies <= 0 ? 25 : numLinies);

        for (int i = 1; i < numLinies; i++) {

            String dadesPacientSplit[] = splitDades[i].split(",");
            if (dadesPacientSplit.length == 3) {
                String idPacient = dadesPacientSplit[0].trim();
                String dataIngres = dadesPacientSplit[1].trim();
                String gravetat = dadesPacientSplit[2].trim();
                // El numero es -1 ja qu ela primera linia hi ha el num pacients
                dCovid.addPacient(idPacient, dataIngres, gravetat, i - 1);
            }
        }

        return dCovid;
    }

    /**
     * Funció per carregar les dades d'un fitxer de text
     *
     * @param nomFitxer nom del fitxer que conté les dades a carregar
     * @return String amb tot el contingut del fitxer
     */
    private String[] carregaDadesFitxer(String nomFitxer) {
        String dades[] = new String[0];
        try {
            Scanner file = new Scanner(new File(nomFitxer));

            if (file.hasNextLine()) {
                String primeraLinia = file.nextLine();
                int numLinias = Integer.parseInt(primeraLinia.replace(",", ""));
                dades = new String[numLinias + 1]; // El num de bosx + la primera linia
                dades[0] = primeraLinia;
            }

            int posicio = 1;
            while (file.hasNextLine()) {
                dades[posicio] = file.nextLine();
                posicio++;
            }

            file.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileUtils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileUtils.class.getName()).log(Level.SEVERE, null, ex);
        }

        return dades;
    }

    /**
     * Funció per guardar l'ocupació del servei d'urgencies en un monent donat
     *
     * @param dadesCovid variable amb les dades de tots els pacients ingressats
     */
    public void guardaOcupacio(DadesCOVID dadesCovid) {

        String nomFitxer = directoriDades + File.separator + DATA_FILE;

        // Preparem les dades per guardar-es en el fitxer
        // primer guardarem la mida de l'array i despres tots els pacients
        String dades = dadesCovid.pacientsUrgenciesCOVID.length
                + ","
                + System.getProperty("line.separator");

        for (int i = 0; i < dadesCovid.pacientsUrgenciesCOVID.length; i++) {
            dades += formatPacient(dadesCovid.pacientsUrgenciesCOVID[i]);
        }

        try {
            PrintStream filePrintStream = new PrintStream(nomFitxer);
            filePrintStream.append(dades);

            filePrintStream.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileUtils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * funció Helper per crear una línia amb les dades d'un pacient en el format
     * que el guardarem en el fitxer
     *
     * @param pacient dades del pacient
     * @return String amb les dades en format d'una línia
     */
    private String formatPacient(String[] pacient) {

        String dades = String.join(",",
                pacient[DadesCOVID.ID_PACIENT],
                pacient[DadesCOVID.ID_DATAINGRES],
                pacient[DadesCOVID.ID_GRAVETAT],
                System.getProperty("line.separator")
        );
        return dades;
    }

    /**
     * Funció per guardar l'alta d'un pacient en el fitxer que conté l'historic
     * de dades
     *
     * @param pacient dades del pacient
     * @param costEstada cost de l'estada del pacient
     * @param dataAlta data de l'alta
     */
    public void guardarAltaEnHistoric(String dadesPacient[], long costEstada, String dataAlta) {

        String nomFitxer = directoriDades + File.separator + LOG_FILE;

        try {
            RandomAccessFile fileWriter = new RandomAccessFile(nomFitxer, "rw");
            fileWriter.seek(fileWriter.length());

            fileWriter.writeChars(formataPacientLog(dadesPacient, costEstada, dataAlta));

            fileWriter.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileUtils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Funció per buscar les dades d'un pacient en l'historic de pacients
     *
     * @param idPacient id del pacient a busca en l'historic
     * @return Array amb les dades del pacient
     */
    public String[] getHistoricPacient(String idPacient) {

        String nomFitxer = directoriDades + File.separator + LOG_FILE;
        String[] pacient = new String[5];

        int midaPacient = calculaMidaPacientDades();

        try {
            RandomAccessFile pacientsFile = new RandomAccessFile(nomFitxer, "r");
            int posicio = 0;

            while (posicio < pacientsFile.length()) {
                pacientsFile.seek(posicio);

                String id = llegeixChars(pacientsFile, DadesCOVID.ID_PACIENT_LENGTH + 1).replace(",", "");

                if (id.trim().equals(idPacient)) {
                    pacient[DadesCOVID.ID_PACIENT] = id;
                    pacient = llegeigPacient(pacientsFile, pacient);
                }

                posicio += midaPacient;
            }

            pacientsFile.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileUtils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileUtils.class.getName()).log(Level.SEVERE, null, ex);
        }

        return pacient;
    }

    /**
     * Funció Helper per realitzar el format d'un pacient en el format necessari
     * per el fitxer de dades
     *
     * @param pacient dades del pacient
     * @param costEstada cost de l'estada del pacient
     * @param dataAlta data de l'alta
     * @return String amb les dades en el format correcte
     */
    private String formataPacientLog(String[] dadesPacient, long costEstada, String dataAlta) {

        String pacientLogData = String.join("",
                String.format("%1$" + DadesCOVID.ID_PACIENT_LENGTH + "s", dadesPacient[DadesCOVID.ID_PACIENT]),
                String.format("%1$" + DadesCOVID.ID_DATA_LENGTH + "s", dadesPacient[DadesCOVID.ID_DATAINGRES]),
                String.format("%1$" + DadesCOVID.ID_GRAVETAT_LENGTH + "s", dadesPacient[DadesCOVID.ID_GRAVETAT]),
                String.format("%1$" + DadesCOVID.ID_COST_LENGTH + "s", costEstada),
                String.format("%1$" + DadesCOVID.ID_DATA_LENGTH + "s", dataAlta)
        );

        return pacientLogData;
    }

    /**
     * Funció per llegir un pacient concret del fitxer de dades
     *
     * @param pacientsFile el fitxer de dades
     * @param pacient les dades del pacient (ja conte l'id)
     * @return array amb les dades del pacient llegides del fitxer
     */
    private String[] llegeigPacient(RandomAccessFile pacientsFile, String[] pacient) {

        String data = llegeixChars(pacientsFile, DadesCOVID.ID_DATA_LENGTH);
        String gravetat = llegeixChars(pacientsFile, DadesCOVID.ID_GRAVETAT_LENGTH);
        String cost = llegeixChars(pacientsFile, DadesCOVID.ID_COST_LENGTH);
        String dataalta = llegeixChars(pacientsFile, DadesCOVID.ID_DATA_LENGTH);

        pacient[DadesCOVID.ID_DATAINGRES] = data.trim();
        pacient[DadesCOVID.ID_GRAVETAT] = gravetat.trim();
        pacient[DadesCOVID.ID_COST] = cost.trim();
        pacient[DadesCOVID.ID_DATAALTA] = dataalta.trim();

        return pacient;

    }

    /**
     * Funció helper per lleger una quantitat donada de char en un fitxer binari
     *
     * @param pacientsFile el fitxer binari
     * @param mida quants char s'han de llegir
     * @return el String amb les dades llegides
     */
    private String llegeixChars(RandomAccessFile pacientsFile, int mida) {
        String data = "";

        try {

            for (int i = 0; i < mida; i++) {
                data += "" + pacientsFile.readChar();
            }
        } catch (IOException ex) {
            Logger.getLogger(FileUtils.class.getName()).log(Level.SEVERE, null, ex);
        }

        return data;
    }

    /**
     * Funció helper per calcular la mida de les dades d'un pacient en el fitxer
     * binari
     *
     * @return
     */
    private int calculaMidaPacientDades() {
        int mida
                = (Character.BYTES * DadesCOVID.ID_PACIENT_LENGTH)
                + (Character.BYTES * DadesCOVID.ID_DATA_LENGTH)
                + (Character.BYTES * DadesCOVID.ID_GRAVETAT_LENGTH)
                + (Character.BYTES * DadesCOVID.ID_DATA_LENGTH)
                + (Character.BYTES * DadesCOVID.ID_COST_LENGTH);

        return mida;
    }
}
