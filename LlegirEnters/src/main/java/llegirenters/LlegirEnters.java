package llegirenters;
import java.io.File;
import java.util.Scanner;
public class LlegirEnters {
    public static final int NUM_VALORS = 10;
    public static void main (String[]args){
        LlegirEnters prg = new LlegirEnters();
        prg.inici();
    }
    public void inici(){
        try{
            File f = new File("Enters.txt");
            Scanner lector = new Scanner(f);
            for (int i = 0; i< NUM_VALORS; i++){
                int valor = lector.nextInt();
                System.out.println("El valor llegit es: "+ valor);
            }
            lector.close();
        }catch(Exception e){
            System.out.println("Error: " + e);
        }
    }

}
