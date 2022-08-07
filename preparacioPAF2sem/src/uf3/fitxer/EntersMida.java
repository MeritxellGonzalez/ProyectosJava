
package uf3.fitxer;
import java.io.File;
import java.util.Scanner;

public class EntersMida {
    public static void main (String[]args){
        EntersMida prg = new EntersMida();
        prg.inici();
    }
    public void inici(){
        try {
            File f = new File("EntersMida.txt");
            Scanner lector = new Scanner(f);
            
            int mida = lector.nextInt();
            System.out.println("Hi ha " + mida + " valors.");
            
            for (int i = 0; i < mida; i++) {
                int valor = lector.nextInt();
                
                System.out.println(i+".El valor llegit es: " + valor);
            }
            lector.close();
        } catch (Exception e) {
            System.out.println("Error: " + e );
        }
    }
    
}
