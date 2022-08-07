package clases;
import java.util.Scanner;


public class ClasePrincipal {
    public static void main(String[]args){
        
        Scanner entrada = new Scanner(System.in);
        System.out.print("Introduce el número para calcular su factorial: ");
        int numero = entrada.nextInt();
        Recursividad recursividad = new Recursividad();
        
        int factorial = recursividad.Factorial(numero);
        System.out.println("El factorial de " + numero + " es " + factorial);
    }
}
