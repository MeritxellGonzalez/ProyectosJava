package repteunarrays;

public class RepteUnArrays {
    public static void main (String[]args){
        //Cal emmagatzemar 100 enters
        int[] arrayParells = new int[100];
        //S'omplirà cada posició.
        for (int i = 0; i < arrayParells.length; i++){
            arrayParells[i] = i*2;
            System.out.println("[ " + i +" ]");
        }
    }
}
