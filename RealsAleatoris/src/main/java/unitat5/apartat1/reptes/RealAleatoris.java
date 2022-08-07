/*Repte 4. Modifiqueu el programa anterior per mostrar per pantalla dos valors 
reals aleatoris de manera que la classe Random s’inicialitzi 
mb un paràmetre de tipus long. Aquest nou programa hauria de formar part d’un 
package anomenat unitat5.apartat1.reptes. 
Executeu-lo diverses vegades. Quina és la diferència entre usar un constructor 
o un altre en inicialitzar la classe?*/
package unitat5.apartat1.reptes;

import java.util.Random;

public class RealAleatoris {

    public static void main(String[] args) {
        RealAleatoris programa = new RealAleatoris();
        programa.inici();
    }

    public void inici() {
//Inicialització. Per exemple, s'usa el valor 100 com "arrel" (seed).
        Random rnd = new Random(100L);

        double valorA = rnd.nextDouble() * 100;
        double valorB = rnd.nextDouble() * 100;
        System.out.println("S'han generat els valors " + valorA + " i " + valorB);
    }
}
