package p2_mgonzalez;
/*

MARC MORALES


*/
import java.util.Scanner;

public class ProvaProjecte {

    // constants del programa
    private static final int ID_MIN = 21;
    private static final int ID_MAX = 499;
    private static final int INTENTS = 3;
    private static final int EXP_MIN = 0;
    private static final int EXP_MAX = 90;
    private static final int LONG_LINIA = 80;
    private static final int MAX_FILES = 10;
    private static final int MAX_COLUM = 5;
    private static final String DONA = "Dona        ";
    private static final String HOME = "Home        ";
    private static final String NSNC = "- - -       ";
    private static final String PRIM = "Primaria    ";
    private static final String SEC = "Secundaria   ";
    private static final String SUP = "Superior     ";
    private static final String MAT = "Matemàtiques ";
    private static final String LEC = "Lectura      ";
    private static final String CAS = "Castellà     ";
    private static final String CAT = "Català       ";
    private static final String CIE = "Ciència      ";
    private static final String PRO = "Electrotécnia";
    private static final String ALL = "Totes        ";

    public static void main(String[] args) {

        int[][] arrayUsuaris = new int[MAX_FILES][MAX_COLUM]; //array on recullo les dades del teclat
        int[][] arrayUsuarisOrdenat = new int[MAX_FILES][MAX_COLUM]; //array on guardare les dades ordenades
        String[][] arrayUsuarisString = new String[MAX_FILES][MAX_COLUM]; //array on mostrare les dades per pantalla

        /*
        String[] arraySexe = {"Dona", "Home", "NS/NC"};
        String[] arrayEducacio = {"Primaria", "Secundaria", "Superior"};
        String[] arrayArea = {"Totes", "MatemÃ tiques", "Lectura", "CastellÃ ", "CatalÃ ", "CiÃ¨ncia", "ProgramaciÃ³"};
        int[] arrayPrimaria = null;
        int[] arraySecundaria = null;
        int[] arraySuperior = null;
         */
        String gen = "";
        String niv = "";
        String are = "";

        int id = 0;
        int genere = 0;
        int nivell = 0;
        int area = 0;
        int experiencia = 0;
        int contador = 0;
        int dada_seguir = 2;
        int dada_ordena = 2;
        int dada_mitjana = 2;
        int index = 0;
        int filas = 0; //index files matriu
        int columnas = 0; //index columnes matriu
        int contador_mitj = 0;
        float mitjana_primaria = 0;
        float mitj_prim = 0;
        float mitjana_secundaria = 0;
        float mitj_sec = 0;
        float mitjana_superior = 0;
        float mitj_sup = 0;

        //
        boolean dada_entrada = false;
        boolean dada_correcta = false;
        boolean dada_fi = false;
        boolean mes_voluntaris = true;
        boolean ordenacio = false;
        boolean mitjana = false;
        Scanner scan = new Scanner(System.in);

        //inici programa
        System.out.println("Introdueix usuaris, màxim 10.");
        do {
            mes_voluntaris = false; // d'entrada nomes enregistrem un usuari
            do {
                System.out.println();
                System.out.println("Introdueix el número d'indentitat: ");
                dada_entrada = scan.hasNextInt();
                if (dada_entrada) { //comprobacio id
                    id = scan.nextInt();
                    if (id < ID_MIN || id > ID_MAX) {
                        // dada_entrada = false;
                        contador++;
                        System.err.println("Error de dades.");
                    } else {
                        dada_correcta = true;
                        arrayUsuaris[filas][columnas] = id;
                        columnas++; //incremento una columna
                    }
                    if (contador == INTENTS) {
                        dada_fi = true;
                        filas--; //error de dada, no la guardo
                    }
                }
            } while (!dada_correcta && !dada_fi);

            if (dada_correcta) { //preguntem genere perque id es vÃ lid
                contador = 0;
                dada_correcta = false;
                do {
                    System.out.println("Genere \n\tdona (1), \n\thome (2), \n\tprefereix no respondre(3)? ");
                    dada_entrada = scan.hasNextInt();
                    if (dada_entrada) {
                        genere = scan.nextInt();
                        dada_entrada = false;
                        if (genere > 0 && genere < 4) {
                            dada_correcta = true;
                            arrayUsuaris[filas][columnas] = genere;
                            columnas++; //incremento una columna
                        }
                        if (contador == INTENTS) {
                            dada_fi = true;
                            filas--;//error de dada, no la guardo
                        }
                    }
                } while (!dada_correcta && !dada_fi);
            }
            if (dada_correcta) {//preguntem el nivell si el genere es valid
                contador = 0;
                dada_correcta = false;
                do {
                    System.out.println("Quin nivell d'estudis té?");
                    System.out.println("\n\tPrimaria(0)\n\tSecundària(1)\n\tSuperior(2) ");
                    dada_entrada = scan.hasNextInt();
                    if (dada_entrada) {
                        nivell = scan.nextInt();
                        if (nivell >= 0 && nivell <= 2) {
                            dada_correcta = true;
                            arrayUsuaris[filas][columnas] = nivell;
                            columnas++; //incremento una columna
                        }
                        if (contador == INTENTS) {
                            dada_fi = true;
                            filas--;//error de dada, no la guardo
                        }
                    }
                } while (!dada_correcta && !dada_fi);
            }
            if (dada_correcta) {//preguntem area de suport si el nivell es valid
                contador = 0;
                dada_correcta = false;
                do {
                    System.out.println("Àrea en la que pots donar suport? ");
                    switch (nivell) {
                        case 0:
                            System.out.println(" Matemàtiques(1)\t Lectura(2)\t Castellà (3)\t Català (4)\t Totes(0)");
                            break;
                        case 1:
                            System.out.println(" Matemàtiques(1\t Lectura(2)\t Castellà (3)\t Català (4)\t Ciència(5)\t Electrotécnia(6)\t Totes(0)");
                            break;
                        case 2:
                            System.out.println(" Totes(0)");
                            break;
                    }
                    scan.nextLine();
                    System.out.print("Selecciona: ");
                    dada_entrada = scan.hasNextInt();
                    if (dada_entrada) { //comprobacio de que s'ha entrat la selecciÃ³ correcta dins de cada nivell i assignacio de l'area d'ajuda
                        area = scan.nextInt();
                        if (((nivell == 0) && (area < 0 || area > 4)) || ((nivell == 1) && (area < 0 || area > 6)) || ((nivell == 2) && (area != 0))) {
                            dada_correcta = false;
                            contador++;
                            System.err.println("Error de dades.");
                        } else {
                            dada_correcta = true;
                            arrayUsuaris[filas][columnas] = area;
                            columnas++; //incremento una columna
                        }
                        if (contador == INTENTS) {
                            dada_fi = true;
                            filas--;//error de dada, no la guardo
                        }
                    }
                } while (!dada_correcta && !dada_fi);
            }
            if (dada_correcta) {//preguntem els anys d'experiencia si tot va be
                contador = 0;
                dada_correcta = false;
                do {
                    System.out.print("Quants anys d'experiencia té?: ");
                    dada_entrada = scan.hasNextInt();
                    if (dada_entrada) {
                        experiencia = scan.nextInt();
                        if (experiencia < EXP_MIN || experiencia > EXP_MAX) {//faig una comprovacio de anys ilogics
                            dada_correcta = false;
                            contador++;
                            System.err.println("Error de dades.");
                        } else {
                            dada_correcta = true;
                            arrayUsuaris[filas][columnas] = experiencia;
                            columnas++; //incremento una columna                         
                        }
                    }
                    if (contador == INTENTS) {
                        dada_fi = true;
                        filas--;//error de dada, no la guardo
                    }
                } while (!dada_correcta && !dada_fi);
            }

            //System.out.println(id + genere + nivell + area + experiencia);
            System.out.print("Vols introduir un altre voluntari? (0 - NO // 1 - SI): ");
            dada_entrada = scan.hasNextInt();
            if (dada_entrada) {
                dada_seguir = scan.nextInt();
                if (dada_seguir == 1) {
                    mes_voluntaris = true;
                    dada_entrada = false; //reset de tots els condiconants
                    dada_correcta = false;
                    dada_fi = false;
                    contador = 0;
                    filas++;
                    columnas = 0;

                } else {
                    mes_voluntaris = false;
                    filas += 1;
                    System.out.print("Vols ordenar els resultats? (0 - NO // 1 - SI): ");
                    dada_entrada = scan.hasNextInt();
                    if (dada_entrada) {
                        dada_ordena = scan.nextInt();
                        if (dada_ordena == 1) {
                            ordenacio = true;
                        }
                    }
                    System.out.print("Vols veure la mitjana d'experiÃ¨ncia per estudis? (0 - NO // 1 - SI): ");
                    dada_entrada = scan.hasNextInt();
                    if (dada_entrada) {
                        dada_mitjana = scan.nextInt();
                        if (dada_mitjana == 1) {
                            mitjana = true;
                        }
                    }
                }
            }

        } while (mes_voluntaris);

        System.out.println("\n\033[0;1m\u001B[47;35mId\t\tGenere\t\tNivell\t\t\tArea\t\t\tExperiencia\033[0m");

        for (int i = 0; i < filas; i++) {
            System.out.println("");
            for (int j = 0; j < columnas; j++) {

                switch (arrayUsuaris[i][1]) {
                    case 1:
                        gen = DONA;
                        break;
                    case 2:
                        gen = HOME;
                        break;
                    case 3:
                        gen = NSNC;
                        break;
                }

                switch (arrayUsuaris[i][2]) {
                    case 0:
                        niv = PRIM;
                        break;
                    case 1:
                        niv = SEC;
                        break;
                    case 2:
                        niv = SUP;
                        break;
                }

                switch (arrayUsuaris[i][3]) {
                    case 1:
                        are = MAT;
                        break;
                    case 2:
                        are = LEC;
                        break;
                    case 3:
                        are = CAS;
                        break;
                    case 4:
                        are = CAT;
                        break;
                    case 5:
                        are = CIE;
                        break;
                    case 6:
                        are = PRO;
                        break;
                    case 0:
                        are = ALL;
                        break;
                }
                System.out.print(arrayUsuaris[i][0] + "\t" + gen + "\t" + niv + "\t" + are + "\t" + arrayUsuaris[i][4]);
            }

        }

        System.out.println("");
        for (int j = 0; j < 3; j++) {
            if (j == 0) {
                System.out.println("\n\n\033[0;1m\u001B[47;35mPRIMARIA\033[0m");
                System.out.println("\033[0;1m\u001B[47;35mId\t\tGenere\t\tNivell\t\t\tArea\t\t\tExperiencia\033[0m");

                for (int i = 0; i < filas; i++) {
                    for (int k = 0; k < columnas; k++) {
                        if (arrayUsuaris[i][2] == 0) {

                            mitjana_primaria += arrayUsuaris[i][4];
                            contador_mitj++;

                            switch (arrayUsuaris[i][1]) {
                                case 1:
                                    gen = DONA;
                                    break;
                                case 2:
                                    gen = HOME;
                                    break;
                                case 3:
                                    gen = NSNC;
                                    break;
                            }

                            switch (arrayUsuaris[i][2]) {
                                case 0:
                                    niv = PRIM;
                                    break;
                            }

                            switch (arrayUsuaris[i][3]) {
                                case 1:
                                    are = MAT;
                                    break;
                                case 2:
                                    are = LEC;
                                    break;
                                case 3:
                                    are = CAS;
                                    break;
                                case 4:
                                    are = CAT;
                                    break;
                            }

                        }

                    }

                    System.out.print(arrayUsuaris[i][0] + "\t" + gen + "\t" + niv + "\t" + are + "\t" + arrayUsuaris[i][4] + "\n");
                }

                mitj_prim = mitjana_primaria / contador_mitj;

            }

            System.out.println("");

            if (j == 1) {
                contador_mitj = 0;
                System.out.println("\033[0;1m\u001B[47;35mSECUNDARIA\033[0m");
                System.out.println("\033[0;1m\u001B[47;35mId\t\tGenere\t\tNivell\t\t\tArea\t\t\tExperiencia\033[0m");

                for (int i = 0; i < filas; i++) {
                    for (int k = 0; k < columnas; k++) {
                        if (arrayUsuaris[i][2] == 1) {

                            mitjana_secundaria += arrayUsuaris[i][4];
                            contador_mitj++;

                            switch (arrayUsuaris[i][1]) {
                                case 1:
                                    gen = DONA;
                                    break;
                                case 2:
                                    gen = HOME;
                                    break;
                                case 3:
                                    gen = NSNC;
                                    break;
                            }

                            switch (arrayUsuaris[i][2]) {

                                case 1:
                                    niv = SEC;
                                    break;
                            }

                            switch (arrayUsuaris[i][3]) {
                                case 1:
                                    are = MAT;
                                    break;
                                case 2:
                                    are = LEC;
                                    break;
                                case 3:
                                    are = CAS;
                                    break;
                                case 4:
                                    are = CAT;
                                    break;
                                case 5:
                                    are = CIE;
                                    break;
                                case 6:
                                    are = PRO;
                                    break;
                                case 0:
                                    are = ALL;
                                    break;
                            }

                        }
                    }
                    System.out.print(arrayUsuaris[i][0] + "\t" + gen + "\t" + niv + "\t" + are + "\t" + arrayUsuaris[i][4] + "\n");
                }

                mitj_sec = mitjana_secundaria / contador_mitj;

            }

            System.out.println("");

            if (j == 2) {
                contador_mitj = 0;
                System.out.println("\033[0;1m\u001B[47;35mSUPERIOR\033[0m");
                System.out.println("\033[0;1m\u001B[47;35mId\t\tGenere\t\tNivell\t\t\tArea\t\t\tExperiencia\033[0m");

                for (int i = 0; i < filas; i++) {
                    for (int k = 0; k < columnas; k++) {
                        if (arrayUsuaris[i][2] == 2) {

                            mitjana_superior += arrayUsuaris[i][4];
                            contador_mitj++;

                            switch (arrayUsuaris[i][1]) {
                                case 1:
                                    gen = DONA;
                                    break;
                                case 2:
                                    gen = HOME;
                                    break;
                                case 3:
                                    gen = NSNC;
                                    break;
                            }

                            switch (arrayUsuaris[i][2]) {

                                case 2:
                                    niv = SUP;
                                    break;
                            }

                            switch (arrayUsuaris[i][3]) {

                                case 0:
                                    are = ALL;
                                    break;
                            }

                        }
                    }
                    System.out.print(arrayUsuaris[i][0] + "\t" + gen + "\t" + niv + "\t" + are + "\t" + arrayUsuaris[i][4] + "\n");
                }

                mitj_sup = mitjana_superior / contador_mitj;

            }
            System.out.println("\n\n");
        }

        if (mitjana) {
            System.out.println("==================MITJANA PRIMARIA========");
            System.out.println(mitj_prim + " anys ");
            System.out.println("==================MITJANA SECUNDARIA==========");
            System.out.println(mitj_sec + " anys ");
            System.out.println("===================MITJANA SUPERIOR===========");
            System.out.println(mitj_sup + " anys ");
        }

    }
}

/*
        System.out.println(arrayUsuaris[i][k]);
        
        que queda???
        1. Mostrar los resultados. 
        2. Ordenarlos si asi se desea
        3. Sumar las medias

        *** A tener en cuenta, los datos introducidos son enteros, 
            los datos a mostrar son String, por lo que habrÃ¡ que 
            pasarlos a String antes de sacarlos por pantalla
 */
