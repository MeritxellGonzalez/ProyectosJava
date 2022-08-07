package uf2;
import java.util.Scanner;
public class LlegirEnterTeclatReturn {
    public static void main(String[] args) {
        LlegirEnterTeclatReturn prg = new LlegirEnterTeclatReturn();
        prg.inici();
    }
    private void inici() {        
         System.out.println("Introdueix el nombre:");
         int a = llegirEnterTeclat();
         System.out.println("L'enter ha estat: " + a);
         System.out.println("Introdueix un altre NOMBRE: ");
         a = llegirEnterTeclat();
         System.out.println("L'enter ha estat: " + a);    
    }
    //1. Quin tipus de valor genera? un enter (int)
    public int llegirEnterTeclat() {
    //2. Es fa el codi que llegeix un únic enter del teclat, com s'ha fet sempre       
        Scanner in = new Scanner(System.in);
        int enterLlegit =0;
        boolean llegit = false;
        while(!llegit){
            llegit = in.hasNextInt();
            if (llegit) {
                enterLlegit = in.nextInt();
                
            }else{
                System.out.println("Això no és un enter");
                in.next();
            }   
        }
        in.nextLine();
        //3. Un cop fet, quin variable té el resultat? enterLlegit
        //4. Cal fer un return.
        return enterLlegit;
        
    }

}
