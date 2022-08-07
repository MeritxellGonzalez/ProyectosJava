/*L’objectiu d’aquesta activitat 
és aprendre a usar estructures 
de repetició per recórrer intervals de valors.

Feu un programa anomenat MostraInterval que 
llegeixi des del teclat dos valors enters n1 i n2, comprovi que amb n1 < n2 
(i mostri un error si no és així), i finalment escrigui 
tots els nombres enters dins l’interval [n1, n2] en ordre creixent.
package intervaldevalors;*\

/**
 *
 * @author 34633
 */
import java.util.Scanner;

public class IntervalDeValors {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int n1;
        int n2;

        //Demanem el primer valor
        System.out.println("Quin valor li vols donar a n1?");
        n1 = entrada.nextInt();
        entrada.nextLine();

        //Demanem el segon valor
        System.out.println("Quin valor li vols donar a n2?");
        n2 = entrada.nextInt();
        entrada.nextLine();
      

        //Condicionant
        if (n1 < n2) {
            //ES. DE REPETICIÓ: Mentre q n1 sigui menor que n2, incrementa n1 en 1.
            for (int i = n1; i<=n2; i++){
                System.out.println(i);
            }
        }else{
            System.out.println("Oh! El valor de " + n2 +  " no és més gran que " + n1);
        }
    }
}
