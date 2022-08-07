package porvespaf;

public class Fruita extends Producte {

    private String temporada;

    public Fruita(String nom, String seccio, double preu, String temporada) {
        super(nom, seccio, preu);
        this.temporada = temporada;
    }

    public String getTemporada() {
        return temporada;
    }

    public void setTemporada(String temporada) {
        this.temporada = temporada;
    }

    public void imprimirFruita() {
        super.imprimirProducte();
        System.out.println("Es de la temporada: " + getTemporada());
    }

    
}
