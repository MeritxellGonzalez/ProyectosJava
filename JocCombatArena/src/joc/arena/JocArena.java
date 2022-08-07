package joc.arena;

import joc.arena.interficie.InterficieJoc;
import joc.arena.interficie.SortidaPantalla;
import joc.arena.regles.Bestiari;
import joc.arena.regles.Combat;
import joc.arena.regles.Lluitador;

public class JocArena {

    public static final int MAX_COMBAT = 10;
    private InterficieJoc entrada = new InterficieJoc();
    private SortidaPantalla sortida = new SortidaPantalla();
    private Lluitador lluitador = new Lluitador();
    private Combat combat = new Combat();
    private Bestiari bestiari = new Bestiari();

    public static void main(String[] args) {
        JocArena prg = new JocArena();
        prg.inici();

    }

    private void inici() {
        sortida.missatgeBenvinguda();
        int[] jugador = bestiari.generarJugador();
        int numCombat = 0;
        boolean jugar = true;
        while (jugar) {
            numCombat++;
            //abans de cada combat restaura al jugador.
            lluitador.restaurar(jugador);
            //inici d'un combat
            System.out.println("*** COMBAT " + numCombat);
            System.out.println("Estat actual del jugador: ");
            sortida.mostrarLluitador(jugador);
            System.out.println("***************************");
            //S'obté l'adversari
            int[] adversari = entrada.triarAdversari(lluitador.llegirNivell(jugador));
            combatre(jugador, adversari);
            jugar = fiCombat(jugador, adversari);
            if (numCombat == MAX_COMBAT) {
                System.out.println("Has sobreviscut a tots els combats. Enhorabona!!");
            }
        }
        System.out.println("Estat final del jugador: ");
        sortida.mostrarLluitador(jugador);
    }

    private void combatre(int[] jugador, int[] adversari) {
        boolean combatre = true;
        int numRonda = 0;
        while (combatre) {
            numRonda++;
            if (numRonda % 5 == 0) {
//A les rondes múltiples de cinc es restauren l'atac i la defensa
                lluitador.restaurar(jugador);
                lluitador.restaurar(adversari);
            }
            System.out.println("--- RONDA " + numRonda);
            sortida.mostrarVersus(jugador, adversari);
            System.out.println("--------------------------");
            int accioJug = entrada.preguntarEstrategia();
            int accioAdv = lluitador.triarEstrategiaAtzar(adversari);
            System.out.print("Has triat " + combat.estrategiaAText(accioJug));
            System.out.println(" i el teu enemic " + combat.estrategiaAText(accioAdv));
            combat.resoldreEstrategies(jugador, accioJug, adversari, accioAdv);
            if (lluitador.esMort(jugador) || lluitador.esMort(adversari)) {
                combatre = false;
            }
        }
    }

    private boolean fiCombat(int[] jugador, int[] adversari) {
        if (lluitador.esMort(jugador)) {
//Has perdut (Nota: tambe inclou el cas que tots dos moren alhora)
            System.out.println("Has estat derrotat... :-(");
            return false;
        }
        System.out.println("Has guanyat el combat :-)");
        boolean pujarNivell = lluitador.atorgarPunts(jugador, adversari);
        if (pujarNivell) {
            System.out.println("Has pujat de nivell!!");
            lluitador.pujarNivell(jugador);
        }
        return true;
    }
}
