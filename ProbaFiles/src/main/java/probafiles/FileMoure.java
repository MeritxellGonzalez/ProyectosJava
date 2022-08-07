package probafiles;

import java.io.File;

public class FileMoure {
    public static void main(String[]args){
        FileMoure prg = new FileMoure();
        prg.inici();
    }
    public void inici(){
        File origenCarpeta = new File("C:/Temp/Fotos");
        File destiCarpeta = new File("C:/Temp/Media/Fotografies");
        File origenDocument = new File("C:/Temp/Media/Fotografies/Document.txt");
        File destiDocument = new File("C:/Temp/Document.txt");
        boolean resultat = origenCarpeta.renameTo(destiCarpeta);
        System.out.println("S'ha mogut i reanomenat la carpeta? " + resultat);
        resultat = origenDocument.renameTo(destiDocument);
        System.out.println("S'ha mogut el document? " + resultat);
    }
}
