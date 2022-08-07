/*per donar color ho he tret d'aquesta pàgina web: 
https://javadesde0.com/coloreando-los-mensajes-consola-netbeans/*/
package eac5.p3.mgonzalez;
import java.util.Scanner;

public class UtilsES {

    static final String LINEAS = "-----------------------------------------------------------------------";
    static final String ANELLES = "\033[37;34mO\u001B[0m\033[37;33mO\u001B[0m"
            + "\033[37;30mO\u001B[0m\033[37;32mO\u001B[0m\033[37;31mO\u001B[0m";
    static final String ICON_PERCENT = "\033[37;31m\uD83D\uDCAF\u001B[0m\u001B[0m\t";
    static final String ICON_LLISTAT = "\uD83D\uDD6E";
    static final String ICON_ARRIBA = "\uD83D\uDCE5";
    static final String ICON_MARXA = "\uD83D\uDCE4";
    static final String MISSATGE_PREGUNTA_MARXAATLETA = "Validar marxa d'atleta";
    static final String NO_ENTER = "NO ES UN ENTER!!!";
    static final String VERMELL_ERR_P = "\033[37;31m";
    static final String VERMELL_ERR_F = "\u001B[0m";
    static final short CONTROL_ERROR = 999;

    public static int demanarEnter(String missatge, String missatgeError) {

        Scanner teclat = new Scanner(System.in);
        int valor;
        boolean correcte;

        do {
            System.out.println(missatge);
            correcte = teclat.hasNextInt();
            if (!correcte) {
                teclat.next();
                System.out.println(missatgeError);
            }
        } while (!correcte);
        valor = teclat.nextInt();
        teclat.nextLine();

        return valor;
    }

    public static String demanarString(String missatge, String missatgeError) {

        Scanner teclat = new Scanner(System.in);
        System.out.println(missatge);
        String text = teclat.nextLine();

        while (text.isEmpty()) {
            System.out.println(missatgeError);
            System.out.println(missatge);
            text = teclat.nextLine();
        }

        return text;
    }

    public static int demanarTipusMedalla(String[] valorsMedalles, String missatge, String missatgeError) {

        int valor = 0;
        boolean correcte = false;

        do {
            imprimirIncrementNumeric(valorsMedalles);
            valor = demanarEnter(missatge, missatgeError);
            if (valor >= 1 && valor < valorsMedalles.length + 1) {
                correcte = true;
            }
        } while (!correcte);

        return valor - 1; // Aixo es temporal, haureu de retornar el valor correcte		 
    }

    public static int demanarPais(String[][] valorsPaisos, String missatge, String missatgeError) {

        int valor = 0;
        boolean correcte = false;

        do {
            imprimirIncrementNumeric(valorsPaisos[1]);
            valor = demanarEnter(missatge, missatgeError);
            if (valor >= 1 && valor < valorsPaisos[1].length + 1) {
                correcte = true;
            } else {
                System.out.println(missatgeError);
            }
        } while (!correcte);

        return valor - 1; // Aixo es temporal, haureu de retornar el valor correcte		 
    }

    public static void imprimirIncrementNumeric(String arrayAImprimir[]) {
        for (int i = 0; i < arrayAImprimir.length; ++i) {
            System.out.println(String.format("%1$" + 3 + "s", i + 1 + ".")
                    + arrayAImprimir[i]);
        }
    }

    public static void imprimeixMissatgeComiat(String codiAtleta, int pos, DadesVila dadesVila) {
        String missatge
                = MISSATGE_PREGUNTA_MARXAATLETA + ":" + VERMELL_ERR_P + codiAtleta + VERMELL_ERR_F
                + " amb pais d'origien: " + dadesVila.atletesVilaOlimpica[pos][DadesVila.ID_PAIS]
                + " havent guanyat: " + dadesVila.atletesVilaOlimpica[pos][DadesVila.ID_MEDALLES];

        System.out.println(missatge);
    }

    @Deprecated
    private int comprovarEspaiBuit(DadesVila dadesVila) {

        for (int i = 0; i < dadesVila.NUM_ATLETES; ++i) {

            if (dadesVila.atletesVilaOlimpica[i][1] == "") {
                return i;
            }
        }
        return CONTROL_ERROR;
    }
}

