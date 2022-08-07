
package clases;
import java.util.Scanner;

public class ConConstructor {
    
    public ConConstructor(){
        Scanner entrada = new Scanner(System.in);
        String nombre = "";
        
        System.out.println("¿Cómo te llamas?");
        nombre = entrada.nextLine();
        System.out.println("Tu nombre es: " + nombre);
    }
}
