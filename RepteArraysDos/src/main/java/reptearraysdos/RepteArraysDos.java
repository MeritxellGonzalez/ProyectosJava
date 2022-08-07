package reptearraysdos;

public class RepteArraysDos {
    public static void main (String []args){
        float[]arrayNotes = {2f, 5.5f, 9f, 10f, 4.9f, 8f, 8.5f, 7f, 6.6f, 5f, 9f, 7f};
        float notaMax = 0;
        for (int i = 0; i<arrayNotes.length; i++){
            if(notaMax < arrayNotes.length){
                notaMax = arrayNotes[i];
            }
        
        }
        System.out.println("La nota màxima és " + notaMax + " .");
    }
}
