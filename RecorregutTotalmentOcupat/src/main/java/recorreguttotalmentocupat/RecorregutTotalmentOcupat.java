package recorreguttotalmentocupat;

public class RecorregutTotalmentOcupat {

    public static final int NOTA_SUSPENS = 5;
    public static final int NOTA_EXCELENT = 9;

    public static void main(String[] args) {

        float[] arrayNotes = {2f, 5.5f, 9f, 10f, 4.9f, 8f, 8.5f, 7f};
        boolean[] arrayExcelent = new boolean[arrayNotes.length];
        int Qsuspesos = 0;
        float sumNotes = 0;
        float notaMitj;
        float notaMesAlta = 0;
        float notaMesBaixa = 10;

        //Comencem el codi  
        for (int i = 0; i < arrayNotes.length; i++) {
            System.out.println(i + ". és: " + arrayNotes[i]);
            if (arrayNotes[i] < NOTA_SUSPENS) {
                Qsuspesos++;
            }
            //Total nota pel calcul de la nota mitjana.
            sumNotes = sumNotes + arrayNotes[i];
            //Nota més alta i nota més baixa

            if (notaMesAlta < arrayNotes[i]) {
                notaMesAlta = arrayNotes[i];
            }
            if (notaMesBaixa > arrayNotes[i]) {
                notaMesBaixa = arrayNotes[i];
            }

            //Posició excel·lents
            if (arrayNotes[i] >= NOTA_EXCELENT) {
                arrayExcelent[i] = true;
            } else {
                arrayExcelent[i] = false;
            }
        }
        //Impressió de dades;
        System.out.println("La quantitat de suspesos és: " + Qsuspesos + ". ");
        notaMitj = sumNotes / arrayNotes.length;
        System.out.printf("\nLa nota mitjana és: %.2f", notaMitj);
        System.out.printf("\nLa nota més baixa és: %.2f", notaMesBaixa );
        System.out.printf("\nLa nota més alta és: %.2f", notaMesAlta );
        //Exercici 3, en quina posició están els excel·lents.
        for (int i = 0; i < arrayExcelent.length; i++) {
            if (arrayExcelent[i]) {
                System.out.println("\nhi ha un " + arrayNotes[i] + " en la posició " + i + ". ");
            }
        }
    }
}
