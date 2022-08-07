package joc.arena.regles;

import java.util.Random;

public class Lluitador {

    public final static int ID = 0;
    public final static int NIVELL = 1;
    public final static int PUNTS = 2;
    public final static int VIDA = 3;
    public final static int VIDA_MAX = 4;
    public final static int ATAC = 5;
    public final static int ATAC_MAX = 6;
    public final static int DEFENSA = 7;
    public final static int DEFENSA_MAX = 8;

    /**
     * Inflingeix dany a un lluitador, restant punts de vida, fins a un mínim de
     * 0.
     *
     * @param lluitador Lluitador que rep el dany
     * @param punts Punts de vida que perd.
     */
    public void danyar(int[] lluitador, int punts) {
        if (lluitador[VIDA] > punts) {
            lluitador[VIDA] = lluitador[VIDA] - punts;
        } else {
            lluitador[VIDA] = 0;
        }
    }

    /**
     * Guareix al lluitador, que recupera punts de vida. Mai pot superar el
     * màxim possible.
     *
     * @param lluitador Lluitar a guarir
     * @param punts Punts recuperats
     */
    public void guarir(int[] lluitador, int punts) {
        lluitador[VIDA] = lluitador[VIDA] + punts;
        if (lluitador[VIDA] > lluitador[VIDA_MAX]) {
            lluitador[VIDA] = lluitador[VIDA_MAX];

        }
    }

    /**
     * Aplica una penalització al lluitador. Es fa a l'atzar entre el valor
     * d'atac i el de defensa. Se li resta un punt, fins a un valor mínim d'1.
     *
     * @param lluitador Lluitador a penalitzar
     * @param grau Grau de penalització
     */
    public void penalitzar(int[] lluitador, int grau) {
        //Es tria quina habilitat penalitzar
        Random rnd = new Random();
        int penalitzar = ATAC;
        if (rnd.nextBoolean()) {
            penalitzar = DEFENSA;
        }
        //Es penalitza. Mínim baixa a 1.
        lluitador[penalitzar] -= grau;
        if (lluitador[penalitzar] < 1) {
            lluitador[penalitzar] = 1;

        }
    }

    /**
     * Renova un lluitador, anul·lant totes les penalitzacions i danys.
     *
     * @param lluitador Lluitador a renovar.
     */
    public void renovar(int[] lluitador) {
        restaurar(lluitador);
        lluitador[VIDA] = lluitador[VIDA_MAX];
    }

    public void restaurar(int[] lluitador) {
        lluitador[ATAC] = lluitador[ATAC_MAX];
        lluitador[DEFENSA] = lluitador[DEFENSA_MAX];
    }

    /**
     * Resol l'atorgament de punts a l'aventure en derrotar un adversari. La
     * quantitat de punts depèn de la diferència de nivells entre els dos. Si es
     * guanyen prous punts, s'avisa si cal pujar de nivell.
     *
     * @param aventurer Aventurer
     * @param adversari Adversari
     * @returns Si s'ha pujat de nivell (cada 100 punt).
     */
    public boolean atorgarPunts(int[] aventurer, int[] adversari) {
        //Es calcula el mutiplicador
        float multiplicador = 0;
        int numMultiplicadors = adversari[NIVELL] - aventurer[NIVELL] + 2;
        for (int i = 0; i < numMultiplicadors; i++) {
            multiplicador += 0.5;
        }
        //Punts finals a atorgar
        int puntsAdversari = llegirPunts(adversari);
        int puntsAtorgats = Math.round(puntsAdversari * multiplicador);
        //Puja de nivell?
        aventurer[PUNTS] += puntsAtorgats;
        int nouNivell = 1 + aventurer[PUNTS] / 100;
        if (nouNivell > aventurer[NIVELL]) {
            return true;
        }
        return false;
    }

    public void pujarNivell(int[] lluitador) {
        lluitador[NIVELL]++;
        Random rnd = new Random();
        if (rnd.nextBoolean()) {
            //S'incrementa atac.
            lluitador[ATAC_MAX]++;
        } else {
            lluitador[DEFENSA_MAX]++;
        }
        lluitador[VIDA_MAX] += 2;
        //Es deixa nou de trinca
        renovar(lluitador);
    }

    //Mètodes d'accions vinculades a l'estat del lluitador
    /**
     * Resol una tirada d'atac d'un lluitador. Es llencen tantes monedes com el
     * seu valor d'atac.
     *
     * @param lluitador LLuitador que fa la tirada
     * @return El nombre de cares obtingudes.
     */
    public int tirarAtac(int[] lluitador) {
        ReglesJoc monedes = new ReglesJoc();
        return monedes.ferTirada(lluitador[ATAC]);
    }

    /**
     * Resol una tirada de defensa d'un lluitador. Es llencen tantes monedes com
     * el seu valor de defensa.
     *
     * @param lluitador LLuitador que fa la tirada
     * @return El nombre de cares obtingudes.
     */
    public int tirarDefensa(int[] lluitador) {
        ReglesJoc monedes = new ReglesJoc();
        return monedes.ferTirada(lluitador[DEFENSA]);
    }

    /**
     * Donat un lluitador, tria a l'atzar quina estratègia usar en una ronda de
     * combat
     *
     * @param lluitador
     * @return Acció triada
     */
    public int triarEstrategiaAtzar(int[] lluitador) {
        Random rnd = new Random();
        int limitDefensa = 3;
        //Si li queda poca vida, defensa del 50% dels cops
        if (lluitador[VIDA] < 2) {
            limitDefensa = 1;
        }
        int accio = rnd.nextInt(10);
        if ((accio >= 0) && (accio < limitDefensa)) {
            return Combat.ATAC;
        } else if ((limitDefensa >= 3) && (accio < 6)) {
            return Combat.DEFENSA;
        } else if ((accio >= 6) && (accio < 8)) {
            return Combat.ENGANY;
        } else {
            return Combat.MANIOBRA;
        }
    }

    //Mètodes per facilitar la lectura de dades.
    public int llegirID(int[] lluitador) {
        return lluitador[ID];
    }

    public int llegirNivell(int[] lluitador) {
        return lluitador[NIVELL];
    }

    public int llegirPunts(int[] lluitador) {
        return lluitador[PUNTS];
    }

    public int llegirVida(int[] lluitador) {
        return lluitador[VIDA];
    }

    public int llegirVidaMax(int[] lluitador) {
        return lluitador[VIDA_MAX];
    }

    public int llegirAtac(int[] lluitador) {
        return lluitador[ATAC];
    }

    public int llegirDefensa(int[] lluitador) {
        return lluitador[DEFENSA];
    }

    public boolean esMort(int[] lluitador) {
        return (lluitador[VIDA] == 0);
    }

    
}
