package ExcerciciVeler;



/**
 *
 * @author 34633
 */
public class ExcepcioVaixell extends Exception {
     private String codiExcepcio;

    public ExcepcioVaixell(String codiExcepcio) {

        this.codiExcepcio = codiExcepcio;

    }

    public String getMessage() {

        switch (codiExcepcio) {
            case "0":
                return "El vaixell no està matriculat";
            default:
                return "El vaixell està matriculat";
        }
    }
    
}
