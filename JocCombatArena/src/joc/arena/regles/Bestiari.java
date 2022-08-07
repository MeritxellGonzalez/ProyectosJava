package joc.arena.regles;

import java.util.Random;

public class Bestiari {
    //Taula de traducció d'identificadors a noms

    private String[] noms = {"Aventurer",
        "Nan", "Kobold",
        "Orc", "Profund",
        "Bruixot maligne", "Ogre",
        "Guerrer del caos", "Troll",
        "Elemental terrestre", "Hidra"};
//Jugador: ID = 0
    private int[] jugador = {0, 1, 0, 10, 10, 3, 3, 3, 3};
//Adversaris possibles al joc
    private int[][] adversaris = {
        {1, 1, 25, 8, 8, 3, 3, 3, 3},
        {2, 1, 30, 10, 10, 4, 4, 2, 2},
        {3, 2, 35, 12, 12, 4, 4, 3, 3},
        {4, 2, 40, 14, 14, 3, 3, 4, 4},
        {5, 3, 45, 15, 15, 3, 3, 5, 5},
        {6, 3, 50, 16, 16, 5, 5, 2, 2},
        {7, 4, 55, 15, 15, 4, 4, 4, 4},
        {8, 4, 60, 18, 18, 3, 3, 5, 5},
        {9, 5, 70, 22, 22, 4, 4, 6, 6},
        {10, 5, 80, 30, 30, 8, 8, 2, 2}
    };
//Inicialització usant una variable global
    private Lluitador lluitador = new Lluitador();

    /**
     * Generar un nou jugador
     *
     * @return un array amb les dades d'un jugador inicial.
     */
    public int[] generarJugador() {
        lluitador.renovar(jugador);
        return jugador;
    }

    /**
     * Donat un nom, gerea l'adversari corresponent. Si aquest nom no existeix,
     *
     * @param nomAdv Nom de l'adversari a obtenir
     * @return El Lluitador amb aques nom, o null si no existeix
     */
    public int[] cercaAdversari(String nomAdv) {
        for (int i = 0; i < adversaris.length; i++) {
            int id = lluitador.llegirID(adversaris[i]);
            String nom = traduirIDANom(id);
            if (nom.equalsIgnoreCase(nomAdv)) {
                lluitador.renovar(adversaris[i]);
                return adversaris[i];
            }

        }
        return null;
    }

    /**
     * Donat un nivell, genera l'adversari corresponent a l'atzar. Es tracta
     * d'un adversari que sigui d'aquest nivell almenys.
     *
     * @param nivell Nivell proper al de l'adversari a obtenir
     * @return Un adversari
     */
    public int[] triarAdversariAtzar(int nivell) {
        Random rnd = new Random();
        int[] adversari = null;
        boolean cercar = true;
        while (cercar) {
            int i = rnd.nextInt(adversaris.length);
            adversari = adversaris[i];
            int nivellAdv = lluitador.llegirNivell(adversari);
            int dif = nivell = nivellAdv;
            if ((dif >= -1) && (dif <= 1)) {
                cercar = false;
            }
        }
        lluitador.renovar(adversari);
        return adversari;
    }
    /**
     * Transforma un identificador de lluitador al seu nom.
     * 
     * @param id Identificador
     * @return La cadena de text amb el nom.
     */
    public String traduirIDANom(int id){
        if ((id>= 0)&&(id< noms.length)) {
            return noms[id];
        }
        return "DESCONEGUT";
    }

}
