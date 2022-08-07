package ExcerciciVeler;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class PortConn {

    private Connection conn;

    private String selVaixellsSQL = "SELECT nom FROM vaixells WHERE eslora>? and cabines=?";
    private PreparedStatement selVaixellsSt;

    private String insertVaixellsSQL = "INSERT INTO vaixells  VALUES (?,?,?,?)";
    private PreparedStatement insertVaixellsSt;

    public void estableixConnexio() {
        String urlBaseDades = "jdbc:derby://localhost:1527/PortL";
        String usuari = "app";
        String contrasenya = "root123";
        try {

            conn = DriverManager.getConnection(urlBaseDades, usuari, contrasenya);
            selVaixellsSt = conn.prepareStatement(selVaixellsSQL);

            insertVaixellsSt = conn.prepareStatement(insertVaixellsSQL);

        } catch (SQLException e) {
            conn = null;
            System.out.println(e.getMessage());
        }
    }

    public void tancaConnexio() {
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            conn = null;
        }
    }

    public void mostrarNoms(int valorA, int valorB) throws SQLException {
        /* TODO heu de mostrar els noms dels vaixells amb una eslora major que el valorA
        i el nombre de cabines igual al valorB passats per paràmetre, fent servir el
        PreparedStatement, és a dir, heu d’executar el select i recórrer el resultat per
        mostrar les dades segons els paràmetres introduïts.
         */

        try {
            if (conn == null) {
                estableixConnexio();
            }

            selVaixellsSt.setFloat(1, valorA);
            selVaixellsSt.setInt(2, valorB);
            ResultSet rsConsulta = selVaixellsSt.executeQuery();

            while (rsConsulta.next()) {
                System.out.println(rsConsulta.getString(1));
            }

        } catch (Exception e) {

            throw new SQLException("ERROR!!!!");
        } finally {
            tancaConnexio();
        }
    }
    
     public void insertarVaixell (String matricula, String nom, float eslora, int cabines) throws SQLException{
        
        try {
            
            if (conn == null) {
                estableixConnexio();
            }
            insertVaixellsSt.setString(1, matricula);
            insertVaixellsSt.setString(2, nom);
            insertVaixellsSt.setFloat(3, eslora);
            insertVaixellsSt.setInt(4, cabines);
            insertVaixellsSt.executeUpdate();
            
            
            
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            //Siempre poner el finally, ya que si hay un error siempre se va a ejecutart esto una vez pete
            tancaConnexio();
        }
        
    }
    
}
