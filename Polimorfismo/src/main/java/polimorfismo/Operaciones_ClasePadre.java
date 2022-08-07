package polimorfismo;
import java.util.Scanner;

public abstract class Operaciones_ClasePadre {
    protected int vUno,vDos,resultado;
    Scanner entrada = new Scanner(System.in);
    
    public void PedirDatos(){
        System.out.print("Dame el primer valor: ");
        vUno = entrada.nextInt();
        
        System.out.print("Dame el segundo valor: ");
        vDos = entrada.nextInt();  
    }
    
    public abstract void Operaciones();
    
    public void MostrarResultado(){
        System.out.print(resultado);
    }
}
