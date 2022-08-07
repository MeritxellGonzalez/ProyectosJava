package ExcerciciVeler;

import java.util.ArrayList;
import java.util.List;


public class Port {
     private String nom;
    
     
     private List<Vaixell> port = new ArrayList();


    public Port(String nom) {
        this.nom = nom;
    }
    
    //GETTER I SETTER

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Vaixell> getPort() {
        return port;
    }

    public void setPort(List<Vaixell> port) {
        this.port = port;
    }
    
    
    public void afegirVaixell(Vaixell vaixell){
         for (int i = 0; i < port.size(); i++) {
            port.add(vaixell);
        }
        
    }
    
    public void eliminarVaixell(Vaixell vaixell){
        for( int i = 0; i < port.size(); i++){
            if(vaixell.equals(i)){
               port.remove(vaixell);
            }
        }
        
    }
    
    public void mostrarMatricula(){
        Vaixell vaixell = null;
        for(int i = 0; i < port.size(); i++){
            if(vaixell.getEslora()> 20){
                System.out.println("La matricula es: "+ vaixell.getMatricula());
            }
        }
        
    }
   
}
