
package operaciones;
import java.util.Scanner;


public class ClasePadre {
    protected int vUno, vDos, resultado;
    Scanner entrada = new Scanner(System.in);
    
    //este método pide los datos al user.
    public void PedirDatos(){
        System.out.print("Dame el primer valor: ");
        vUno = entrada.nextInt();
        
        System.out.print("Dame el segundo valor: ");
        vDos = entrada.nextInt();
        
    }
    //este método muestra el resultado.
    public void MostrarResultado(){
        System.out.println(resultado);
    }
}
