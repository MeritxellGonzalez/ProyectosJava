package probafiles;
import java.io.File;
import java.util.Date;

public class probaFlesTres {
    public static void main(String[]args){
        probaFlesTres prg = new probaFlesTres();
        prg.inici();
    }
    public void inici(){
        File document = new File("C:/Temp/Document.txt");
        System.out.println(document.getAbsoluteFile());
        Date data = new Date(document.lastModified());
        System.out.println("Darrera modificació: " + data);
        System.out.println("Mida: " + document.length());
    }
}
