
package PAFAtraccio;

import PAFAtraccio.Atraccio;
import java.util.ArrayList;
import java.util.List;

public class ParcAtraccions {
    private String nom;
    private String adreca;
    
    /*TODO heu de crear un atribut anomenat parcAtraccions que sigui un List que 
    heu d'implementar mitjançant un ArrayList per guardar les atraccions del parc d'atraccions.
    */ 
    private List<Atraccio> parcAtraccio = new ArrayList();

    public ParcAtraccions(String nom, String adreca) {
        this.nom = nom;
        this.adreca = adreca;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdreca() {
        return adreca;
    }

    public void setAdreca(String adreca) {
        this.adreca = adreca;
    }

    public List<Atraccio> getAtraccio() {
        return parcAtraccio;
    }

    public void setAtraccio(List<Atraccio> parcAtraccio) {
        this.parcAtraccio = parcAtraccio;
    }
    
    public void afegirAtraccio(Atraccio atraccions){
        for (int i = 0; i < parcAtraccio.size(); i++) {
            parcAtraccio.add(atraccions);
        }
        
    }
    
    public void eliminarAtraccio(Atraccio atraccions){
       for( int i = 0; i < parcAtraccio.size(); i++){
            if(parcAtraccio.equals(i)){
               parcAtraccio.remove(atraccions);
            }
        }          
    }
    
    public void modificarNomAtraccio(Atraccio atraccions, String nom){
       
        for(int i = 0; i < parcAtraccio.size(); i++){
            if(parcAtraccio.get(i).getNom().equalsIgnoreCase(atraccions.getNom())){
                parcAtraccio.get(i).setNom(nom);
            }
        }
    }
}

