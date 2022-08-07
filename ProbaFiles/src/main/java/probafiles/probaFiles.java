package probafiles;
import java.io.File;

public class probaFiles {
    public static void main(String[]args){
        probaFiles prg = new probaFiles();
        prg.inici();
    }
    public void inici(){
        File fotos = new File("C:/Temp/Fotos");
        File document = new File("C:/Temp/Document.txt");
        boolean resultat = fotos.mkdir();
        System.out.println("Creada carpeta "+ fotos.getName()+ "? " + resultat);
        if(!resultat){
            boolean delCarpeta = fotos.delete();
            System.out.println("Esborra carpeta " + fotos.getName() +  "? " + delCarpeta);
            boolean delFitxer = document.delete();
            System.out.println("Esborrar fitxer "+ document.getName()+ "? " + delFitxer);
        }
        
    }
}
