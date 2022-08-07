
package PAFAtraccio;

public class Atraccio {
     private String nom;
    private String zona; //zona del parc d'atraccions a la qual pertany l'atracció
    private boolean teAccesMR; //Indica si l'atracció té un accés especial per persones amb mobilitat reduïda

    public Atraccio(String nom, String zona, boolean teAccesMR) {
        this.nom = nom;
        this.zona = zona;
        this.teAccesMR = teAccesMR;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public boolean isTeAccesMR() {
        return teAccesMR;
    }

    public void setTeAccesMR(boolean teAccesMR) {
        this.teAccesMR = teAccesMR;
    }

    
    public void teAccesMR() throws ExcepcioAtraccio{
        if(isTeAccesMR() == true){
            throw new ExcepcioAtraccio("1");
        }
        throw new ExcepcioAtraccio("0");
        
    }
}
