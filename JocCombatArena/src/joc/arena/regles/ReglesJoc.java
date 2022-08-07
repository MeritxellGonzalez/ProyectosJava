package joc.arena.regles;

import java.util.Random;

public class ReglesJoc {
/** Resol el llançament d'un grup de monedes
 * 
 * @param numMonedes Nombre de monedes que s'han llençat
 * @return Nombre de cares obtingudes
 */
    public int ferTirada(int numMonedes){
        Random rnd = new Random();
        int numCares = 0;
        for (int i = 0; i < numMonedes; i++) {
            boolean tirada = rnd.nextBoolean();
            if(tirada){
                numCares++;
            }
        }
        return numCares;
    }
}
