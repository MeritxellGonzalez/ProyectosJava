package clases;

public class ClasePrincipal {

    public static void main(String[] args) {

        //1r estado: creación.
        
        Hilo_Proceso hilo1 = new Hilo_Proceso();
        Hilo_Proceso hilo2 = new Hilo_Proceso();
        
        //2n estado: ejecución.
        
        hilo1.start();
        
         // 3r Estado: bloquear por tiempo determinado.
        try{
        hilo1.sleep(1000);
        }catch(InterruptedException e){
            System.out.println("Error en el hilo1 " + e);
        }
        
        hilo2.start();
         //4rto estado: Muerte
        hilo2.stop();
        
       try{
           hilo2.sleep(1000);
       }catch(InterruptedException e){
           System.out.println("Error en el hilo2 " + e);
       }
      
       
    }

}
