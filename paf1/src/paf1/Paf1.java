/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paf1;

/**
 *
 * @author 34633
 */
public class Paf1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        

    
public static String demanaText(String missatge){
        Scanner lector = new Scanner(System.in);
        String text = "";
        do {
            System.out.println(missatge);
            text = lector.nextLine();
            if (text.isEmpty()) {
                System.out.println("El text ha de contindre caracters");
            }
        } while (text.isEmpty());
        return text;
    }

}

public static void mostrarDadesJugador (DadesRanking dRanking, int posicioJugador) {
        Scanner lector = new Scanner(System.in);
        arraySelec = usuaris[];
        for (int i = 0; i < usuaris.length; i++) {
            System.out.println(usuaris[posicioJugador] + " " + textOpcions[i]);
        }
        arraySelec = lector.next();
        return arraySelec;
    }
}

public static void opcioActualizarRanking(DadesRanking dRanking){
        boolean trobat = false;
        int pos = 0;
        mostrarTitol("Actualitzacio del ranking");
        String ID = demanaText("Quin es el Id del usari??");
        if (!existeixUsuari(dRanking, ID)) {
            mostrarAlerta("No hi ha enrregistrat cao compte amb aquest IBAN");
        }else{
            while (pos < dRanking.usuaris.length && !trobat) {                
                if (dades.usuaris[pos][DadesRanking.INDEX_ID].equalsIgnoreCase(ID)) {
                    trobat = true;
                }else{
                    pos++;
                }
                int puntuacio = demanaEnter("Introdueix la variacio de la puntuacio a aplicar");
            }
            dRanking.puntuacio[pos] += puntuacio;
            mostrarInformacio("puntuació" + ID + " actualitzat a: " + dRanking.puntuacio[pos]); 
        }
    }