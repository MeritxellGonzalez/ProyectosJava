package tascaquatre;

import java.util.Scanner;

public class DiesMesPerDividir {

    public static void main(String[] args) {
        //Es crea una intència del programa
        DiesMesPerDividir programa = new DiesMesPerDividir();
        //Es crida el mètode inici per tal de comencçar l'execució
        programa.inici();
    }

    public void inici() {
        int mesDemanat;
        int diesQueTeElMesDemanat;

        mesDemanat = demanarMes();
        diesQueTeElMesDemanat = calcularDiesQueTeElMes(mesDemanat);
        mostrarDiesDelMes(mesDemanat, diesQueTeElMesDemanat);
    }

    public int demanarMes() {
        Scanner scanner = new Scanner(System.in);
        int resposta;
        System.out.println(
                "Indica el número del més de l'any per saber quants dies té:");
        resposta = scanner.nextInt();
        return resposta;
    }

    public int calcularDiesQueTeElMes(int mesACalcular) {
        int diesTrobats;

        switch (mesACalcular) {
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

    public void mostrarDiesDelMes(int mesDemanat, int diesQueTeElMesDemanat) {
        if (diesQueTeElMesDemanat == -1) {
            System.out.print("No existeix el mes ");
            System.out.print(mesDemanat);
            System.out.print(". Només hi ha 12 mesos.");
        } else {
            System.out.print("T'informem que el més ");
            System.out.print(mesDemanat);
            System.out.print(" conté ");
            System.out.print(diesQueTeElMesDemanat);
            System.out.println(" dies");
        }

    }
}
