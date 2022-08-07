package joc.arena.interficie;

import joc.arena.regles.Bestiari;
import joc.arena.regles.Combat;
import java.util.Scanner;

public class InterficieJoc {
    /**Tria l'adversari del jugador segons la seva resposta.
     * @param nivell
     * @return Cadena de text amb la resposta
     */
    public int[]triarAdversari(int nivell){
        System.out.println("Contra quin adversari vols lluitar aquest combat? ");
        Scanner lector = new Scanner(System.in);
        String resposta = lector.nextLine();
        Bestiari bestiari = new Bestiari();
        int[]adversari = bestiari.cercaAdversari(resposta);
        if (adversari == null) {
            System.out.println("Aquest enemic no existeix. Es tria a l'atzar");
            adversari = bestiari.triarAdversariAtzar(nivell);
        }
        return adversari;
    }
    /**Pregunta a l'ursuari quina estratègia vol usar, d'entre les quatre possibles.
     * 
     * @return Accio a dur a terme, d'acord a les constants de la classe Combat.
     */
    public int preguntarEstrategia(){
        Scanner lector = new Scanner (System.in);
        System.out.println("Quina estrategia vols seguir aquesta ronda?");
        System.out.println("[A]tacar\t[D]efensar\t[E]nganyar\t[M]aniobra");
        System.out.println("----------------------------------------------");
        boolean preguntar = true;
        int accio = -1;
        while (preguntar) {            
            System.out.println("Acció: ");
            String resposta = lector.nextLine();
            if ("A".equalsIgnoreCase(resposta)) {
                accio = Combat.ATAC;
                preguntar = false;
            }else if ("D".equalsIgnoreCase(resposta)) {
                accio = Combat.DEFENSA;
                preguntar = false;
            }else if("E".equalsIgnoreCase(resposta)){
                accio = Combat.ENGANY;
                preguntar = false;               
            }else if("M".equalsIgnoreCase(resposta)){
                accio=Combat.MANIOBRA;
                preguntar = false;
            }else{
                System.out.println("Acció incorrecta");
            }
        }
        return accio;
    }
    

    
}
