package comptaas;

public class ComptaAs {
    public static final char [] CAD_CARAC = {'a','b','d', 'c', 'a', 'h'};
    public static void main (String[]args){
        int comptador = 0;
        for(int i = 0; i< CAD_CARAC.length; i++){
            if(CAD_CARAC[i] == 'a'){
                comptador++;
            }
        }
        System.out.println("Hi ha " + comptador + " A.");
    }
}
