
package clases;


public class ClasePrincipal {
    public static void main(String [] args){
        ClasePadre_abstracta mensajero = new ClaseHija_Consulta();
        mensajero.setSaldo(1500);
        mensajero.Operaciones();
    }
}
