package desquiciante_2;

import java.util.Scanner;

public class desquiciante_2 {

    public static final int MAX_CONTADOR = 3;

    public static void main(String[] args) {
         
        Scanner entrada = new Scanner (System.in);
        int valorUsuari = 0;
        int contador = 0;
        boolean valorNOk = false;
        
        while (valorNOk == false && contador < MAX_CONTADOR ){
            contador++;
            System.out.println("Introdueix valor entre 0 i 5: ");
            valorUsuari = entrada.nextInt();
            //entrada.nextLine();
            if((valorUsuari >=0)&&(valorUsuari <=5)){
                valorNOk = true;
                
            }else{
                System.err.println("Dada incorrecta. Torna a intentar-ho:");
                //entrada.next();
            }
        }System.out.println(contador);
        System.out.println("Dada correcta. Has introduít: " + valorUsuari);
    }
}
