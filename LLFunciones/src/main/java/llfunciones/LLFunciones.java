/*
*Clase para las funciones lógicas de una lavadora
*/
package llfunciones;
/**
 * 
 * @author Meritxell
 */

public class LLFunciones {
    
    private int kilos = 0, llenadoCompleto = 0, TipoDeRopa = 0, LavadoCompleto = 0, SecadoCompleto = 0;
    
    public LLFunciones(int kilos, int TipoDeRopa){
        this.kilos = kilos;
        this.TipoDeRopa = TipoDeRopa;
        
    }
    private void Llenado(){//esta es el metodo de llenado de la lavadora
        if(kilos <= 12){
            llenadoCompleto = 1;
            System.out.println("Llenando...");
            System.out.println("Llenado completo.");
        }else{
            System.out.println("La carga de ropa es muy pesada, reduce la carga");
        }
    }
    private void Lavado(){//este metodo es para el lavado
        Llenado();
        if(llenadoCompleto == 1){
            if(TipoDeRopa == 1){
                System.out.println("Ropa blanca/ Lavado suave");
                System.out.println("Lavando...");
                LavadoCompleto = 1;
            } else if(TipoDeRopa == 2){
                System.out.println("Ropa de color / lavado intenso");
                System.out.println("Lavando...");
                LavadoCompleto = 1;
            }else{
                System.out.println("El tipo de ropa no esta disponible");
                System.out.println("Se lavara como ropa de color/ Lavado intenso");
            }   LavadoCompleto = 1;
            
        }
    }
    private void Secado(){//este metodo es para el secado
        Lavado();
        if(LavadoCompleto == 1){
            System.out.println("Secando...");
            SecadoCompleto = 1;    
        }
    }
    public void CicloFinalizado(){//este es el metodo que los programadores de Samsung pueden ver
        Secado();
        if(SecadoCompleto == 1){
            System.out.println("Tu ropa esta lista");    
        }
    }
    
    //setter y getter
    
    public int getTipoDeRopa(){
        return TipoDeRopa;
    }
    
    public void setTipoDeRopa(int TipoDeRopa){
        this.TipoDeRopa = TipoDeRopa;
    }
}
