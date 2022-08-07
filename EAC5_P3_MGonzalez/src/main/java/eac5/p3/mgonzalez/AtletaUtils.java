
package eac5.p3.mgonzalez;
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

            if (atletesVilaOlimpica[i][DadesVila.ID_PAIS] == pais) {
                comptadorPais++;
            }
        }
        return comptadorPais;
    }

    /**
     * Funcio per calcular el percentatge dels atleted d'un pais envers el total
     *
     * @param atletesVilaOlimpica
     * @param pais
     * @return
     */
    public static float calculaPercAtletaPais(String[][] atletesVilaOlimpica, String pais, DadesVila dadesVila) {

        float percentatge = comptarAtletesPais(atletesVilaOlimpica, pais) * 100 / (float) dadesVila.numAtletesRegistrats;

        if (percentatge == 0) {
            return 0.0f;
        }
        return percentatge;
    }
}
