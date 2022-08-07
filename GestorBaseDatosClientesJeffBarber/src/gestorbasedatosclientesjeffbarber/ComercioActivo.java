package gestorbasedatosclientesjeffbarber;

public abstract class ComercioActivo implements Comunes {

    private String nombre;
    private String apellidos;
    private String telefono;
    private String mail;

    public ComercioActivo(String nombre, String apellidos, String telefono, String mail) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.mail = mail;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    

}
