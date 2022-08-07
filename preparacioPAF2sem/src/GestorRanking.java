
/**public class GestorRanking {

    public final static String TEMP_CAP = "ID          JUGADOR        PAIS    PUNTUACIO";
    public final static String TEMP_LIN = "------------------------------------------------";
    public final static String TEMP_ITEM = "%6s %14s %10s %12s";

    public static void mostraRanking(DadesRanking dRanking) {
        System.out.println(TEMP_LIN + "\n" + TEMP_CAP + "\n" + TEMP_LIN);

        for (int i = 0; i < dRanking.usuaris.length; i++) {
            System.out.println(String.format(TEMP_ITEM,
                    dRanking.usuaris[i][DadesRanking.INDEX_ID],
                    dRanking.usuaris[i][DadesRanking.INDEX_USUARI],
                    dRanking.usuaris[i][DadesRanking.INDEX_PAIS],
                    dRanking.puntuacio[i]));
        }
    }
    public static int demanaEnter(String missatge) {
        Scanner lector = new Scanner(System.in);

        int enter = 0;
        boolean numCorrecte = false;

        System.out.println(missatge);
        do {
            numCorrecte = lector.hasNextInt();
            if (numCorrecte) {
                enter = lector.nextInt();
            }
            if (enter < 0) {
                numCorrecte = false;
                System.out.println("El número introduït ha de ser positiu");
            }
            lector.nextLine();
        } while (!numCorrecte);

        return enter;
    
    }
     public static void actualitzaRanking(DadesRanking dRanking) {

        mostrarTítol("ACTUALITZACIÓ DEL CONSUM");
        String ID = demanaText("Introdueix el ID del Client:");
        if (!existeixUsuari(ID)) {
            mostrarAlerta("El client no existeix");
        } else {
            int puntuacio = demanaEnter("Introdueix la puntuacio a afegir:");
            incrementaPuntuacio(dRanking, ID, puntuacio);
            mostraInformacio("Consum del client" + ID + "actualitzat!");
        }

    }
**/