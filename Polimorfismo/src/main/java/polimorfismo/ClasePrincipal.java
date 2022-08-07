
package polimorfismo;


public class ClasePrincipal {
    public static void main(String[]args){
        Operaciones_ClasePadre mensajero_Suma = new ClaseHija_Suma();
        mensajero_Suma.PedirDatos();
        mensajero_Suma.Operaciones();
        mensajero_Suma.MostrarResultado();
        
        Operaciones_ClasePadre mensajero_Resta = new ClaseHija_Resta();
        mensajero_Resta.PedirDatos();
        mensajero_Resta.Operaciones();
        mensajero_Resta.MostrarResultado();
        
    }
}
