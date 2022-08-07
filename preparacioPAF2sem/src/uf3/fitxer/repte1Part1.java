package uf3.fitxer;
import java.io.File;
import java.util.Scanner;

public class repte1Part1 {
    public static void main (String[]args){
        repte1Part1 prg = new repte1Part1();
        prg.inici();
    }

    private void inici() {
        File rutaFitxer = llegirNomFitxer();
        //Cal comprovar si el fitxer realment existeix i si es un fitxer
        if(rutaFitxer.isFile()){
            File novaRuta = treureExtesio(rutaFitxer);
            //Es canvia el nom
            rutaFitxer.renameTo(novaRuta);
            System.out.println("Nom canviat de  " + rutaFitxer +" a " +novaRuta);
        }else{
            System.out.println("Aquest fitxer no existeix.");
        }
    }
    /**Pregunta a l'usuari el nom del fitxer, i d'aquest obté una ruta. 
     * 
     * @return la ruta asociada al text que ha escrit l'usuari
     */

    private File llegirNomFitxer() {
        Scanner lector = new Scanner(System.in);
        System.out.println("Escriu el nom de la ruta en un fitxer existent: ");
        String nomFitxer = lector.nextLine();
        
        //Fixeu-vos com és possible fer un return d'una variable de tipus File,
        //igual que es faria per un enter o una cadena de text.
        
        File f = new File (nomFitxer);
        return f;
    }
    /** Donada una ruta, en crear una nova igual, però sense extensió (.xxx)
     * 
     * @param rutaFitxer
     * @return la ruta sense extensió.
     */

    private File treureExtesio(File original) {
       String nom = original.getName();
       String pare = original.getParent();
       //Cerquem el darrer punt, per trrobar l'extensió
       int posicioPunt = nom.lastIndexOf(".");
       if(posicioPunt >= 0){
           //Eliminem el que hi ha darrera del punt
           String nouNom = nom.substring(0,posicioPunt);
           //Es fa el text per a la nova ruta, sense extensió
           String nouText = pare + File.separator +nouNom;
           File novaRuta = new File(nouText);
           return novaRuta;
       }else{
           //Si no té extensió, es deixa igual...
           return original;
       }
    }
}
