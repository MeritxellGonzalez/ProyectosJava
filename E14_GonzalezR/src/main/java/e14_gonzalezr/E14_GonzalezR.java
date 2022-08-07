package e14_gonzalezr;

public class E14_GonzalezR {

    public static final int COLUMNES = 4;
    public static final int DONA = 1;
    public static final int HOME = 0;

    public static void main(String[] args) {
        int[][] participants = {
            {3457, 1, 51, 52},
            {3467, 1, 32, 41},
            {3568, 0, 14, 57},
            {3570, 0, 12, 63},
            {3571, 1, 45, 63},
            {3572, 0, 17, 46},
            {3573, 0, 12, 44},
            {3574, 0, 30, 42},
            {3575, 1, 24, 77},
            {3578, 0, 57, 48}
        };
        int tempMinHome = 0;
        int tempsMinDona = 0;
        int posicioGuanyador = 0;
        int posicioGuanyadora = 0;
        System.out.println("Els participants són: ");
        System.out.println("\ndorsal sexe edat temps");
        for (int i = 0; i < participants.length; i++) {
            System.out.println();
            for (int j = 0; j < COLUMNES; j++) {
                System.out.print(participants[i][j] + "    ");
            }
        }
        for (int i = 0; i < participants.length; i++) {
            if (participants[i][1] == HOME) {
                if (tempMinHome == 0) {
                    tempMinHome = participants[i][3];
                    posicioGuanyador = i;
                } else {
                    if (participants[i][3] < tempMinHome) {
                        tempMinHome = participants[i][3];
                        posicioGuanyador = i;
                    }
                }
            } else {
                if (tempsMinDona == DONA) {
                    tempsMinDona = participants[i][3];
                    posicioGuanyadora = i;

                } else {
                    if (participants[i][3] < tempsMinDona) {
                        tempsMinDona = participants[i][3];
                        posicioGuanyadora = i;
                    }
                }
            }
        }
        System.out.println("\n\nEl guanyador és:\n\t" + participants[posicioGuanyador][0] + " " + participants[posicioGuanyador][1] + " " + participants[posicioGuanyador][2] + " " + participants[posicioGuanyador][3]);
        System.out.println("\nLa guanyadora és:\n\t" + participants[posicioGuanyadora][0] + " " + participants[posicioGuanyadora][1] + " " + participants[posicioGuanyadora][2] + " " + participants[posicioGuanyadora][3]);

    }
}
