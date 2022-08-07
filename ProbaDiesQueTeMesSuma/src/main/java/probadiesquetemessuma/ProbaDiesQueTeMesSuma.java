/*
**** SENSE PARAMETRES ****
1.- Demanar el mes inicial a l'usuari.
2.- Demanar el mes final a l 'usuati.
3.- Sumar tots els dies que té cada mes des del mes inicial fins el final
4.- Mostrar suma
 */
package probadiesquetemessuma;

import java.util.Scanner;

public class ProbaDiesQueTeMesSuma {

    int mesEscollit;
    int mesInicialEscollit;
    int mesFinalEscollit;
    int diesQueTeElMesEscollit;
    int sumaDies = 0;

    public static void main(String[] args) {
        //Es crea una itinerancia del programa.
        ProbaDiesQueTeMesSuma programa = new ProbaDiesQueTeMesSuma();
        // Es crida el métode inici per tal de començar l'execució.
        programa.inici();
    }

    public void inici() {
        //Es crida el mètode per demanar el mes Inicial del que es vol saber quants dies té
        demanarMesInicial();
        //Es crida el mètode per demanar el mes Inicial del que es vol saber quants dies té
        demanarMesFinal();
        //Comprovar que mesFinalEscollit és major que mesInicialEscollit
        while(mesFinalEscollit<mesInicialEscollit){
            System.out.println("El valor del mes escollit no pot ser inferior a " +mesInicialEscollit);
            demanarMesFinal();
        }
        //Crida  al mètode on es faràn els càlculs per saber el nº de dies del mes demanat
        for(int i = mesInicialEscollit; i<=mesFinalEscollit;i++){
            mesEscollit = i;
            calcularDiesQueTeElMes();
            sumaDies = sumaDies + diesQueTeElMesEscollit;
        }
        //crida al mètode el qual mostrarà la suma dels dies dels mesos indicats.
        mostrarSuma();
    }
    
    public void demanarMesInicial(){
        Scanner entrada = new Scanner(System.in);
        System.out.println("Indica el número Incial del mes de l'any per saber quants dies té:");
        mesInicialEscollit = entrada.nextInt();
    }
    public void demanarMesFinal(){
        Scanner entrada = new Scanner(System.in);
        System.out.println("Indica el número Final del mes de l'any per saber quants dies té");
        mesFinalEscollit = entrada.nextInt();
    }
    public void calcularDiesQueTeElMes(){
        //es fan els càlculs depenent del nº del mes demanat
        switch(mesEscollit){
            case 1:
                diesQueTeElMesEscollit = 31;
                break;
            case 2:
                diesQueTeElMesEscollit = 28;
                break;
            case 3:
                diesQueTeElMesEscollit = 31;
                break;
            case 4:
                diesQueTeElMesEscollit = 30;
                break;
            case 5:
                diesQueTeElMesEscollit = 31;
                break;
            case 6:
                diesQueTeElMesEscollit = 30;
                break;
            case 7:
                diesQueTeElMesEscollit = 31;
                break;
            case 8:
                diesQueTeElMesEscollit = 31;
                break;
            case 9:
                diesQueTeElMesEscollit = 30;
                break;
            case 10:
                diesQueTeElMesEscollit = 31;
                break;
            case 11:
                diesQueTeElMesEscollit = 30;
                break;
            case 12:
                diesQueTeElMesEscollit = 31;
                break;
            default:
                diesQueTeElMesEscollit= -1;
        }
    }
    public void mostrarSuma(){
        //es mostra el resultat segons sigui correcte o no
        if(diesQueTeElMesEscollit == -1){
            System.out.print("No existeix el mes");
            System.out.print(mesEscollit);
            System.out.print(". Nomes hi ha 12 mesos");
        }else{
            System.out.print("T'informem que la suma entre els mesos ");
            System.out.print(mesInicialEscollit+ " i " +mesFinalEscollit);
            System.out.print(" conté ");
            System.out.print(sumaDies);
            System.out.print(" dies.");
        }
    }
}
