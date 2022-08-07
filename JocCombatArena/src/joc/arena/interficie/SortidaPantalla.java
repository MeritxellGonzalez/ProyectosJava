package joc.arena.interficie;

import joc.arena.regles.Bestiari;
import joc.arena.regles.Lluitador;

public class SortidaPantalla {
/** Mostra per pantalla el missatge d'inici del joc
 * 
 */
   public void missatgeBenvinguda(){
       System.out.println("Benvingut al Joc de l'Arena");
       System.out.println("===========================");
       System.out.println("Escull amb astúcia la teva estratègia per sobreviure...");
   }
   /**Mostrar l'estat d'un lluitador per pantalla.
    * 
    * @param ll lluitador a visutalitzar
    */
   public void mostrarLluitador(int[]ll){
       Lluitador lluitador = new Lluitador();
       Bestiari bestiari = new Bestiari();
       int id = lluitador.llegirID(ll);
       String nom = bestiari.traduirIDANom(id);
       System.out.print(nom);
       System.out.print("\tNivell: " + lluitador.llegirNivell(ll));
       System.out.print("\t(punts: " + lluitador.llegirPunts(ll) + ")");
       System.out.print("\tVIDA: " + lluitador.llegirVida(ll));
       System.out.print(" ("+ lluitador.llegirVidaMax(ll) +") ");
       System.out.print("\tATAC: " + lluitador.llegirAtac(ll));
       System.out.println("\tDEFENSA: " + lluitador.llegirDefensa(ll));
   }
   /** Mostrar l'estat actual del jugador contra el seu adversari.
    * 
    * @param jugador Jugador
    * @param adversari Adversari
    */
   public void mostrarVersus(int[]jugador, int[]adversari){
       System.out.println("JUGADOR: ");
       mostrarLluitador(jugador);
       System.out.println("VS");
       System.out.println("ADVERSARI: ");
       mostrarLluitador(adversari);
   }
}
