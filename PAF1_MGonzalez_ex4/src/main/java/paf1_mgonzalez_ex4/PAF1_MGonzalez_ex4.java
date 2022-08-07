package paf1_mgonzalez_ex4;

public class PAF1_MGonzalez_ex4 {

    public static void main(String[] args) {
        float[] arrayNotes = {7f, 4.5f, 9f, 9.75f, 4.9f, 5f, 7.5f, 3f};
        float acumulat = 0;
        float mitjana = 0;
        float baixa1 = 10;
        float baixa2 = 10;
        for (int i = 0; i < arrayNotes.length; i++) {
            acumulat = acumulat + arrayNotes[i];
            System.out.print(arrayNotes[i]+"\t");
        }
        mitjana = acumulat / arrayNotes.length;
        System.out.println("\nLa mitjana és " + mitjana);

        for (int i = 0; i < arrayNotes.length; i++) {
            if (arrayNotes[i] < baixa1) {
                baixa1 = arrayNotes[i];
            }
        }
        for(int i = 0; i< arrayNotes.length-1; i++){
            if(arrayNotes[i]< baixa2){
                baixa2 = arrayNotes[i];
            }
        }
        System.out.println("La nota més baixa és: " + baixa1);
        System.out.println("La segona nota més baixa "+baixa2);
    }
}
