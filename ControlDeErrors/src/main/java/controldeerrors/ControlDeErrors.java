package controldeerrors;

import java.util.Scanner;

public class ControlDeErrors {
    //Declaració de constants.
    public static final float DESCOMPTE = 8;
    public static final float COMPRA_MIN = 100;
    public static final float DESCOMPTE_MAX = 10;

    public static void main(String[]args){
        //Declaració de variables.
        Scanner lector = new Scanner (System.in);
        float preu;
        float descompteFet = 0;
        System.out.println("Quin és el preu del producte? ");
        preu = lector.nextFloat();
        //Verifiquem que la dada entrada es un núm.
        if(preu > 0){
            if (preu >= COMPRA_MIN){
                descompteFet = preu * DESCOMPTE/ 100;
                
            }if (descompteFet > DESCOMPTE_MAX){
                descompteFet = DESCOMPTE_MAX;
            }
            preu = preu - descompteFet;
            System.out.println("El preu final per pagar és de " + preu +" euros");
        }else{
            System.out.println("Preu incorrecte. És negatiu.");
        }
        
 
    
    }
}
