/*
**** AMB PARAMETRES ****
1.- Demanar el mes inicial a l'usuari.
2.- Demanar el mes final a l 'usuati.
3.- Sumar tots els dies que té cada mes des del mes inicial fins el final
4.- Mostrar suma
 */
import java.util.Scanner;

public class probaDiesQueTeMesSumaParametritzada {

    int mesEscollit;
    int mesInicialEscollit;
    int mesFinalEscollit;
    int sumaDies = 0;
    int diesQueTeElMesEscollit;

    public static void main(String[] args) {
        probaDiesQueTeMesSumaParametritzada programa = new probaDiesQueTeMesSumaParametritzada();
        programa.inici();
    }

    public void inici() {

        //crida al mètode per demanar el mes INICIAL del que es vol saber quants dies té.
        mesInicialEscollit = demanarMesInicial();
        //crida al mètode per demanar el mes FINAL del que es vol saber quants dies té.
        mesFinalEscollit = demanarMesFinal();
        //compravar que el mes final es mes gran que el mes inicial
        while (mesFinalEscollit < mesInicialEscollit) {
            System.out.println("El valor del mes escollit no pot ser inferior a " + mesInicialEscollit);
            mesFinalEscollit = demanarMesFinal();
        }
        //crida al mètode a on es faràn els calculs per saber el nº de dies del mes demanat
        for (int i = mesInicialEscollit; i <= mesFinalEscollit; i++) {
            //crida de la funció per calcular dies del mes.
            diesQueTeElMesEscollit = calcularDiesQueTeElMes(i);
            sumaDies = sumaDies + diesQueTeElMesEscollit;
        }
        mostrarSuma(diesQueTeElMesEscollit, sumaDies);
    }

    public int demanarMesInicial() {
        int mesInicial = 0;
        Scanner entrada = new Scanner(System.in);
        System.out.println("Indica el número inicial del més de l'any per saber quants dies té");
        mesInicial = entrada.nextInt();
        return mesInicial;
    }

    public int demanarMesFinal() {
        int mesFinal = 0;
        Scanner entrada = new Scanner(System.in);
        System.out.println("Indica el número final del més de l'any per saber quants dies té");
        mesFinal = entrada.nextInt();
        return mesFinal;
    }

    public int calcularDiesQueTeElMes(int mesEscollit) {
        //es fan els càlculs depenent del nº del mes demanat
        int diesTrobats;
        switch (mesEscollit) {
            case 1:
                diesTrobats = 31;
                break;
            case 2:
                diesTrobats = 28;
                break;
            case 3:
                diesTrobats = 31;
                break;
            case 4:
                diesTrobats = 30;
                break;
            case 5:
                diesTrobats = 31;
                break;
            case 6:
                diesTrobats = 30;
                break;
            case 7:
                diesTrobats = 31;
                break;
            case 8:
                diesTrobats = 31;
                break;
            case 9:
                diesTrobats = 30;
                break;
            case 10:
                diesTrobats = 31;
                break;
            case 11:
                diesTrobats = 30;
                break;
            case 12:
                diesTrobats = 31;
                break;
            default:
                diesTrobats = -1;
        }
        return diesTrobats;
    }

    public void mostrarSuma(int diesMesEscollit, int sumaDies) {
        //es mostra el resultat segons sigui correcte o no
        if (diesQueTeElMesEscollit == -1) {
            System.out.print("No existeix el mes");
            System.out.print(mesEscollit);
            System.out.print(". Nomes hi ha 12 mesos");
        } else {
            System.out.print("T'informem que la suma entre els mesos ");
            System.out.print(mesInicialEscollit + " i " + mesFinalEscollit);
            System.out.print(" conté ");
            System.out.print(sumaDies);
            System.out.print(" dies.");
        }
    }

}
