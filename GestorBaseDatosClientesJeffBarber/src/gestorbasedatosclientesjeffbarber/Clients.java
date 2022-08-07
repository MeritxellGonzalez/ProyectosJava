package gestorbasedatosclientesjeffbarber;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author 34633
 */
public class Clients extends ComercioActivo {

    private static Scanner DADES = new Scanner(System.in);
    private List<ComercioActivo> comercio = new ArrayList();
    private int id;

    public Clients(int id, String nombre, String apellidos, String telefono, String mail) {
        super(nombre, apellidos, telefono, mail);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<ComercioActivo> getComercio() {
        return comercio;
    }

    public void setComercio(List<ComercioActivo> comercio) {
        this.comercio = comercio;
    }

    /**
     * TO DO: Función que genera de manera automatica y que incrementa en uno el
     * ID del cliente.
     *
     * 
     */
     public int aleatoriID(){
        int id = 000;
         for (int i = 0; i < 0; i++) {
             id++;
             setId(id);
         }
        return id;
    }
    
    public void addDatos(Clients clients) {
        String nom,apellidos,telef, mail;
        int id = getId();
        if (buscarDatos(super.getNombre())) {
            System.out.println("El ID del client es: " + aleatoriID());
            setId(id);
            
            System.out.println("Quin es el nom?");
            nom = DADES.next();
            setNombre(nom);
            DADES.close();
            
            System.out.println("Quins son els cognoms?");
            apellidos = DADES.next();
            setApellidos(apellidos);
            DADES.close();
            
            System.out.println("Quin és el teu telefon de contacte?");
            telef = DADES.next();
            setTelefono(telef);
            DADES.close();
            
            System.out.println("Quin és el teu mail de contacte?");
            mail = DADES.next();
            setMail(mail);
            
            DADES.close();
            comercio.add(clients);
        }

        System.out.println("Client amb " + getId() + " , afegit correctament");
    }

    @Override
    public void updateDatos(String nombre) {

        String respuesta = DADES.next();
        if (buscarDatos(nombre) == true) {
            System.out.println("El número de telefon actual és: " + super.getTelefono() + " per quin el vols cambiar ?");
            super.setTelefono(respuesta);
            System.out.println("El correu electrónic actual és: " + super.getMail() + " per quin el vols cambiar ?");
            super.setMail(respuesta);
        }
        DADES.close();
    }

    public void deleteDatos(Clients clients) {
        int opcioResposta = DADES.nextInt();
        if (buscarDatos(super.getNombre()) == true) {
            comercio.remove(clients);
        } else { // En caso de que no exista, damos la opción de añadir.
            System.out.println("Vols afegir-lo com a nou client? 1-SI 0-NO");
            if (opcioResposta == 1) {
                addDatos(clients);
                System.out.println("Client afegit correctament");
            }
            DADES.close();

        }

    }

    private Boolean buscarDatos(String nombre) {
        String apellidos = super.getApellidos();
        boolean existeix = false;
        for (int i = 0; i < comercio.size(); i++) {
            if (nombre.equalsIgnoreCase(super.getNombre()) && apellidos.equalsIgnoreCase(super.getApellidos())) {
                existeix = true;
            }

        }
        return false;
    }

    @Override
    public void showDatos() {
        String nombre = super.getNombre();
        if (buscarDatos(nombre)) {
            System.out.println("\nLes dades del client amb " + getId() + " son:");
            System.out.println("\nEl nom del client és: " + super.getNombre());
            System.out.println("\nEls seus cognoms són: " + super.getApellidos());
            System.out.println("\nEl seu telefon és: " + super.getTelefono());
            System.out.println("\nEl seu mail és: " + super.getMail());
        }
        System.out.println("No existeix.Vols afegir-lo? 1 = SI 0 = NO");
        Clients client = new Clients(getId(), getNombre(), getApellidos(), getTelefono(), getMail());
        int respostaPregunta = DADES.nextInt();
        if (respostaPregunta == 1) {
            addDatos(client);
        }
        DADES.close();
        
    }

}
