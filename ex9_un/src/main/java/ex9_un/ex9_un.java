
package ex9_un;

public class ex9_un {
    public static void main(String[] args) {
        int i, resultat;
        i = resultat = 0;
        while ((i<20)){
            resultat = resultat + i*2;
            System.out.println(i+": "+resultat+" ");
            i++;
            if(resultat>10){
                resultat=0;
            }
        }
    }

}
