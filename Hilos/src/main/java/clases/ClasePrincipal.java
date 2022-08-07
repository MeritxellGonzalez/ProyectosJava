//Los hilos nos permiten correr dos códigos de manera simultanea.
package clases;


public class ClasePrincipal {

    public static void main(String[] args) {
//extends
       Proceso1 hilo1 = new Proceso1();
//implements
       Thread hilo2 = new Thread(new Proceso2());
       
       hilo1.start();
       hilo2.start();
    }
}
