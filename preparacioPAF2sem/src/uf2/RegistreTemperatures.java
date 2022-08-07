package uf2;

import java.util.Scanner;

public class RegistreTemperatures {

    //CONSTATNS
    public static final int MAX_SETMANES = 52;
    public static final String LIN_SEPARADORES = "---------------------------------------------------";
    public static final String REGISTRE_TEMP = "RT";
    public static final String REGISTRE_TEMP_DESC = " Registre temperatures setmanals.";
    public static final String CONSULTAR_TEMP_MITJ = "MJ";
    public static final String CONSULTAR_TEMP_MITJ_DESC = " Consultar temperatura mitjana";
    public static final String CONSULTAR_DIF_ALTA = "DF";
    public static final String CONSULTAR_DIF_ALTA_DESC = " Consultar diferència màxima";
    public static final String FIN = "FI";
    public static final String FI_DESC = " SORTIR";

    //GLOBALS
    private boolean fi = false;
    private int numTemperatures = 0;
    private float[] temperatures = new float[MAX_SETMANES * 7];
    private int dia = 1;
    private int mes = 1;

    public static void main(String[] args) {
        RegistreTemperatures prg = new RegistreTemperatures();
        prg.inici();

    }
//IMPLEMENTACIÓ PROBLEMA GENERAL

    private void inici() {
        while (!fi) {
            mostrarMenu();
            tractarOpcio();
        }

    }
//IMPLEMENTACIÓ DEL PRIMER NIVELL DE DESCOMPOSICIÓ

    private void mostrarMenu() {
        System.out.println(LIN_SEPARADORES);
        System.out.println(REGISTRE_TEMP + "  " + REGISTRE_TEMP_DESC);
        System.out.println(CONSULTAR_TEMP_MITJ + "  " + CONSULTAR_TEMP_MITJ_DESC);
        System.out.println(CONSULTAR_DIF_ALTA + "  " + CONSULTAR_DIF_ALTA_DESC);
        System.out.println(FIN + "  " + FI_DESC);
        System.out.print("OPCIÓ: ");
    }

    private void tractarOpcio() {
        Scanner in = new Scanner(System.in);
        String opcio = in.nextLine();
        
            if (opcio.equalsIgnoreCase(REGISTRE_TEMP)) {
                registraTemperatura();
            } else if (opcio.equalsIgnoreCase(CONSULTAR_TEMP_MITJ)) {
                mostrarMitjana();
            } else if (opcio.equalsIgnoreCase(CONSULTAR_DIF_ALTA)) {
                mostrarDiferencia();
            } else if (opcio.equalsIgnoreCase(FIN)) {
                fi = true;
            } else {
                System.out.println("Opció incorrecta!\n");
            }
        }
        
    
//IMPLEMENTACIÓ DEL SEGON NIVELL DE DESCOMPOSICIÓ.

    private void registraTemperatura() {
        if ((numTemperatures + 7) >= temperatures.length) {
            System.out.println("No hi queda espai");
        } else {
            llegirTemperaturesTeclat();
            incrementarData();
        }
    }

    private void mostrarMitjana() {
        if (numTemperatures > 0) {
            System.out.println("Fins avui ");
            mostrarData();
            System.out.println("La mitjana ha estat: ");
            calculaMitjana();
            System.out.println(" graus.");
        } else {
            System.out.println("No hi ha temperatures registrades");
        }
    }

    private void mostrarDiferencia() {
        if (numTemperatures > 0) {
            System.out.println("Fins avui ");
            mostrarData();
            System.out.println("La mitjana ha estat: ");
            calculaDiferencia();
            System.out.println(" graus.");
        } else {
            System.out.println("No hi ha temperatures registrades");
        }
    }
//IMPLEMENTACIÓ DEL TERCER NIVELL DE DESCOMPOSICIÓ

    private void llegirTemperaturesTeclat() {
        System.out.println("Escriu les temperatures d'aquesta setmana: ");
        Scanner in = new Scanner(System.in);
        int numLlegides = 0;
        while (numLlegides < 7) {
            if (in.hasNextFloat()) {
                temperatures[numTemperatures] = in.nextFloat();
                numLlegides++;
                numTemperatures++;
            } else {
                in.next();
            }
        }
        in.nextLine();
    }

    private void incrementarData() {
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
        //hem passat de mes?
        if (dia > diesAquestMes) {
            dia = dia - diesAquestMes;
            mes++;
            //hem passat d'any?
            if (mes > 12) {
                mes = 1;
            }
        }
    }

    private void mostrarData() {
        System.out.print(dia + " de ");
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
                System.out.println("Desembre");
        }
    }

    private void calculaMitjana() {
        float acumulador = 0;
        for (int i = 0; i < numTemperatures; i++) {
            acumulador = acumulador + temperatures[i];
        }
        System.out.println((acumulador / numTemperatures));
    }

    private void calculaDiferencia() {
        float minim = temperatures[0];
        float maxim = temperatures[0];
        for (int i = 1; i < numTemperatures; i++) {
            if (temperatures[i] < minim) {
                minim = temperatures[i];
            }
            if (temperatures[i] > maxim) {
                maxim = temperatures[i];
            }

        }
        System.out.println((maxim - minim));
    }

}
