package notes;

import java.util.Scanner;

public class Notes {

    public static void main(String[] args) {
        float nota;
        Scanner lector = new Scanner(System.in);
        System.out.println("Quina nota has tret?");
        nota = lector.nextFloat();
        System.out.println("La teva nota final és: ");
        if((nota>= 9)&&(nota<=10)){
            System.out.println("Enhorabona, tens un Excel·lent ");
        }else if ((nota>= 6.5)&&(nota < 9)){
            System.out.println("Enhorabona, tens un notable");
        }else if((nota>=5)&&(nota<6.5)){
            System.out.println("Enhorabona, has aprovat");
        }else{
            System.out.println("Has suspés");
        }
        
    }
}
