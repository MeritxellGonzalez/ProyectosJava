package exsisarrays;

public class ExSisArrays {

    public static int NOM = 0;
    public static int DORSAL = 1;
    public static int EDAT = 2;
    public static int CATEGORIA = 3;
    public static int TEMPS = 4;
    public static int NUM_CAMPS = 5;

    public static void main(String[] args) {
        String[][] dadesCorredors;
    }
    int cercarDorsal (String dorsal, String[][] dadesCorredors){
        boolean sortir = false;
        int posicio = 0;
        while(posicio<dadesCorredors.length && !sortir){
            sortir = dadesCorredors[posicio][DORSAL].equals(dorsal);
            if(!sortir){
                posicio++;
            }
        }
        return posicio;
    }

}
