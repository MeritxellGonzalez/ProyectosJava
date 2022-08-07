
import java.util.Scanner;

public class ExerciciUnArrays {

    public static final int MAX = 6;

    public static void main(String[] args) {
        int numeros[] = new int[MAX];
        int i = 0;
        int valor;
        int MesGran;
        boolean dadaCorrecta = false;

        Scanner entrada = new Scanner(System.in);
        System.out.println("Introdueix els valor fins a màxim " + MAX);
        //Validem si la dada introduïda es un sencer.
        for (i = 0; i < MAX; i++) {
            dadaCorrecta = entrada.hasNextInt();
            if (dadaCorrecta == true) {
                valor = entrada.nextInt();
                numeros[i] = valor;
            } else {
                System.out.println("La dada Introduïda no es un sencer");
            }
        }
        //Busquem el máxim;
        MesGran = numeros[0];
        for (i = 1; i < MAX; i++) {
            if (numeros[i] > MesGran) {
                MesGran = numeros[i];
            }
        }
        //Imprimim el valor més gran.
        System.out.println("El valor més gran és: " + MesGran);

    }
}
