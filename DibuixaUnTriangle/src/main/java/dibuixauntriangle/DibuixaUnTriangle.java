package dibuixauntriangle;

import java.util.Scanner;

public class DibuixaUnTriangle {
    public static void main (String[]args){
        Scanner entrada = new Scanner (System.in);
        int alt;
        
        
        System.out.println("Quina alçada vols per al triangle?");
        alt = entrada.nextInt();
        entrada.nextLine();
        
        int numAs = 1;
        //Una interacció per línia.
        for(int i = 0; i<alt; i++){
            //Escribim un cert número de lletras, començant per 1.
            for(int j = 0; j < numAs; j++){
                System.out.print("a");
            }
            numAs++;
            System.out.println();
        }
      
    }
}
