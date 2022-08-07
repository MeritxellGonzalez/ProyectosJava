package desquiciante_2;

public class Desquiciante_2_2 {

    /*RECORREGUT 
    TOTALMENT 
    OCUPAT*/
    public static final int NOTA_SUSPENS = 5;

    public static void main(String[] args) {
        float[] arrayNotes = {2f, 5.5f, 9f, 10f, 4.9f, 8f, 8.5f, 7f};
        int suspens = 0;
        for (int i = 0; i < arrayNotes.length; i++) {
            System.out.println(i + ". és: " + arrayNotes[i]);
            if (arrayNotes[i] < NOTA_SUSPENS) {
                suspens++;
            }
           
        }
         System.out.println("Han suspés: "+ suspens);
    }

}
