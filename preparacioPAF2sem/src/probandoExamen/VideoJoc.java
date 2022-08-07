package probandoExamen;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VideoJoc {

    public static void main(String[] args) {
        VideoJoc prg = new VideoJoc();
        prg.inici();

    }

    private void inici() {
        String nomFitxer = "Registres.txt";
        String nomUsuari = "Usuari1";
        llegeixRankingRaf(nomFitxer, nomUsuari);
    }

    private int llegeixRankingRaf(String nomFitxer, String nomUsuari) {

        //PrintStream print = null;
        File fitxer = new File(nomFitxer);
        int puntuacio = -1;
        int midaRegistreUsuari = ((Character.BYTES * 15 + Character.BYTES * 5
                + Character.BYTES * (System.getProperty("line.separator").length())));
        long posicio = 0;
        boolean usuariTrobat = false;
        try {
            //per a crear l'arxiu hauriem de escriure el parametre de lectura
            // i, escriptura "RW"
            
            RandomAccessFile raf = new RandomAccessFile(fitxer, "r");
            while (posicio < raf.length() && !usuariTrobat) {
                raf.seek(posicio);
                String nextUser = "";
                String puntuacioString = "";
                for (int i = 0; i < 15; i++) {
                    nextUser += raf.readChar();
                }
                if (nextUser.trim().equalsIgnoreCase(nomUsuari)) {
                    for (int i = 0; i < 5; i++) {
                        puntuacioString += raf.readChar();
                    }
                    puntuacio = Integer.parseInt(puntuacioString.trim());
                    usuariTrobat = true;
                }
                posicio += midaRegistreUsuari;
            }
            raf.close();
        } catch (IOException e) {
            Logger.getLogger(VideoJoc.class.getName()).log(Level.SEVERE, "Error", e);
        }
        return puntuacio;
    }

}
