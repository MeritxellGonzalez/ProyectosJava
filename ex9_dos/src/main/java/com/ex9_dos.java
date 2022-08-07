package com;

public class ex9_dos {
  public static void main(String[] args) {
        int i, resultat;
        boolean seguir=true;
        i = resultat = 0;
        while ((resultat<10)&&(seguir)){
            resultat = resultat + i;
            System.out.println(i+": "+resultat+" ");
            i++;
            if(i>19){
                seguir=false;
            }
        }
    }
}
