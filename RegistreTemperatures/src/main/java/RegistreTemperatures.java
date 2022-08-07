// EXERCICI 1 --- PERIODE 2---

import java.util.Scanner;

public class RegistreTemperatures {

    private static final int MAX_SETMANES = 52;

    private int numTemperatures = 0;
    private float[] temperatures = new float[MAX_SETMANES * 7];
    private int dia = 1;
    private int mes = 1;

    //Mètodes associats al problema geneal
    public static void main(String[] args) {
        RegistreTemperatures programa = new RegistreTemperatures();
        programa.inici();
    }

    public void inici() {
        llegirTemperaturesTeclat();
        incrementarData();
        mostrarData();
        calculaMitjana();
        calculaDiferencia();
        mostrarDiferencia();
        
    }

    //Mostrar associats al primer nivell de descomposicio
    public void mostrarMenu() {

    }

    public void tractarOpcio() {

    }

    //Mètodes associats al segon nivell de descomposició
    public void registreTemeperaturesSetmanals() {

    }

    public void mostrarMitjana() {

    }

    public void mostrarDiferemcia() {

    }

    public void finalitzarExecucio() {

    }

    //Mètodes associats al tercer nivell de descomposició
    public void llegirTemperaturesTeclat() {
        System.out.println("Escriu les temperaturers d'aquesta setmana: ");
        Scanner entrada = new Scanner(System.in);
        int numLlegides = 0;
        while (numLlegides < 7) {
            if (entrada.hasNextFloat()) {
                temperatures[numTemperatures] = entrada.nextFloat();
                numLlegides++;
                numTemperatures++;
            } else {
                entrada.next();
            }
        }
        entrada.nextLine();
    }

    public void incrementarData() {
        //Quants dies té aquest mes?
        int diesAquestMes = 0;
        if (mes == 2) {
            diesAquestMes = 28;
        } else if ((mes == 4) || (mes == 6) || (mes == 9) || (mes == 11)) {
            diesAquestMes = 30;
        } else {
            diesAquestMes = 31;
        }
        dia = dia + 7;
        //Hem passat de mes?
        if (dia > diesAquestMes) {
            dia = dia - diesAquestMes;
            mes++;
            //Hem passat d'any?
            if (mes > 12) {
                mes = 1;
            }
        }
    }

    public void mostrarData() {
        System.out.println(dia + " de ");
        switch (mes) {
            case 1:
                System.out.println("Gener");
                break;
            case 2:
                System.out.println("Febrer");
                break;
            case 3:
                System.out.println("Març");
                break;
            case 4:
                System.out.println("Abril");
                break;
            case 5:
                System.out.println("Maig");
                break;
            case 6:
                System.out.println("Juny");
                break;
            case 7:
                System.out.println("Juliol");
                break;
            case 8:
                System.out.println("Agost");
                break;
            case 9:
                System.out.println("Setembre");
                break;
            case 10:
                System.out.println("Octubre");
                break;
            case 11:
                System.out.println("Novembre");
                break;
            case 12:
                System.out.println("Decembre");
            //break;
        }
    }

    public void calculaMitjana() {
        float acumulador = 0;

        for (int i = 0; i < numTemperatures; i++) {
            acumulador = acumulador + temperatures[i];
        }
        System.out.println((acumulador / numTemperatures));

    }

    public void calculaDiferencia() {
        /*
        Repte 3: Codifiqueu el mètode calculaDiferencia. Explicat amb més detall,
aquest mètode cerca els valors més alt i més baix d’entre els enregistrats i calcula
la diferència entre ells. Un cop calculat, mostra el valor resultant per pantalla, tal
com fa calculaMitjana.
        */
        float max = temperatures [0];
        float min = temperatures [0];
        for(int i =1; i< numTemperatures; i++){
            if(temperatures[i]<min){
                min = temperatures[i];
            }
            if(temperatures[i]>max){
                max = temperatures[i];
            }
        }
        System.out.println((max-min));
    }
    public void mostrarDiferencia(){
        //Repte 4: Codifiqueu el mètode mostrarDiferencia.
        if(numTemperatures > 0){
            System.out.println("Fins avui ");
            mostrarData();
            System.out.println("La diferencia màxima ha estat: ");
            calculaDiferencia();
            System.out.println(" graus.");
        }else{
            System.out.println("No hi ha temperatures registrades.");
        }
    }
}
