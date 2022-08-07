/*
* Repte 5: modifiqueu el programa de manera que se cerqui si algú ha tret un 0,
* però només en el segon exercici (posició 1 de cada fila). 
* Reflexioneu atentament sobre si ara realment cal usar dues estructures de repetició o no.
*/

package cercazero;
/**
 *
 * @author Meritxell González
 */
public class CercaZero {

    public static void main(String[] args) {
        float[][] arrayNotes = {
            {4.5f, 6f, 5f, 8f},
            {10f, 8f, 7.5f, 9.5f},
            {3f, 2.5f, 0f, 6f},
            {6f, 8.5f, 6f, 4f},
            {9f, 7.5f, 7f, 8f}
            };
        int estudiant = -1;
        /*
    EN AQUEST CAS NO ES NECESSARI DE DOS ESTRUCTURES DE REPETICIÓ, PERQUÈ EN AQUEST CAS,
    UN VALOR SEMPRE SERÀ EL MATEIX ÉS A DIR, LA POSICIÓ 1 DE CADA FILA. PER TANT AMB UNA ESTRUCTURA DE REPETICIÓ N'ÉS SUFICIENT.
         */
        for(int numFila = 0; numFila < arrayNotes.length; numFila++){
            if(arrayNotes[numFila][1]== 0){
                estudiant = numFila;
            }
        }
        if(estudiant == -1){
            System.out.println("Ningú té un 0.");
        }else{
            System.out.println("Algún estudiant ha tret un 0.");
        }
    }

}
