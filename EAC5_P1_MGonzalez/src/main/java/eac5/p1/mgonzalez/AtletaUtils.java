/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eac5.p1.mgonzalez;

/*
* @author Alejandro Santiago
 */
import java.util.Scanner;
import java.util.Arrays;

public class AtletaUtils {

    /**
     * Funcio per contar els atletes d'una nacionalitat concreta a la vila
     * olimpica en un moment donat
     *
     * @param atletesVilaOlimpica
     * @param pais
     * @return number d'atletes del pais rebut com a parametre
     */
    public static int comptarAtletesPais(String[][] atletesVilaOlimpica, String pais) {

        int comptadorPais = 0;

        for (int i = 0; i < atletesVilaOlimpica.length; i++) {
            for (int j = 0; j < atletesVilaOlimpica[i].length; j++) {

                if ((atletesVilaOlimpica[i][j]) == pais) {

                    comptadorPais++;
                }
            }
        }

        return comptadorPais; // Aixo es temporal, haureu de retornar el valor correcte		 
    }

    /**
     * Funcio per calcular el percentatge dels atleted d'un pais envers el total
     *
     * @param atletesVilaOlimpica
     * @param pais
     * @return
     */
    public static float calculaPercAtletaPais(String[][] atletesVilaOlimpica, String pais) {

        float percentatge = comptarAtletesPais(atletesVilaOlimpica, pais) * 100 / (float)atletesVilaOlimpica.length;

        return percentatge; // Aixo es temporal, haureu de retornar el valor correcte		 
    }
}

