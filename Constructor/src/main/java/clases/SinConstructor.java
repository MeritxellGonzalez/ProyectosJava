
package clases;
import java.util.Scanner;


public class SinConstructor {
    private Scanner entrada = new Scanner(System.in);
    String nombre = "";
    
    public void PedirNombre(){
        System.out.println("¿Cómo te llamas?");
        nombre = entrada.nextLine();
    }
    
    public void Imprimir(){
        System.out.println("Tu nombre es: " + nombre);
    }
}
