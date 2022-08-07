
package UF6;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
 *
 * @author 34633
 */
public class ParcAtraccionsConn {
    
    private Connection conn;

    /*TODO Heu d'assignar a l'atribut selAtraccionsSQL, la sentència SQL que retorni els
      noms de les atraccions del parc d'atraccions, d'una zona determinada amb accés per
      persones amb mobilitat reduïda, tenint en compte que el valor del camp corresponent a
      aquesta dada és 1 si existeix aquest accés.
    */
    private String selAtraccionsSQL = "SELECT nom FROM atraccions WHERE zona>? and teAccesMR= 1";

    private PreparedStatement selAtraccionsSt;

    public void estableixConnexio() {
        /* TODO heu d'establir la connexió amb la base de dades i inicialitzar
           l'atribut selAtraccionsSt creant un nou PreparedStatement amb la sentència
           SQL de l'atribut selAtraccionsSQL, incorporant les sentències que hi falten 
           en aquest mètode.
         */

        String urlBaseDades = "jdbc:derby://localhost:1527/Atraccions";
        String usuari = "app";
        String contrasenya = "app123";
        try {
            conn = DriverManager.getConnection(urlBaseDades, usuari, contrasenya);
            selAtraccionsSt = conn.prepareStatement(selAtraccionsSQL);

        } catch (SQLException e) {
            conn = null;
            System.out.println(e.getMessage());
        }
    }
    

    public void tancaConnexio(){
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            conn = null;
        }
    }

    public void mostrarNoms(String zona) throws SQLException {
        /* TODO heu de mostrar els noms de les atraccions amb accés per persones amb
         mobilitat reduïda fent servir el PreparedStatement, és a dir, heu d’executar 
         el select i recórrer el resultat per mostrar les dades segons els paràmetres introduïts.    
         */
        try {
            if (conn == null) {
                estableixConnexio();
            }

            selAtraccionsSt.setString(1, zona);
            
            ResultSet rsConsulta = selAtraccionsSt.executeQuery();

            while (rsConsulta.next()) {
                System.out.println(rsConsulta.getString(1));
            }

        } catch (Exception e) {

            throw new SQLException("ERROR!!!!");
        } finally {
            tancaConnexio();
        }
    }
}

