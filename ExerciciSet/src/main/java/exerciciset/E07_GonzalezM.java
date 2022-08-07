package exerciciset;

import java.util.Scanner;

public class E07_GonzalezM {

    public static final int IVA_SUPREDUIT = 4;
    public static final int IVA_REDUIT = 8;
    public static final int IVA_NORMAL = 21;
    public static final int ENVIAMENT_BAIX = 100;
    public static final int ENVIAMENT_MITG = 101;
    public static final int ENVIAMENT_ALT = 500;

    public static void main(String[] args) {
        //Declaració de les variables.
        int opcio, unitats, categoria, iva, cost;
        float preu, preuSenseIva, preuFinal;
        Scanner e = new Scanner(System.in);
        boolean dadaCorrecta;

        //Menú incial:
        System.out.println("1.Cálcul preu final: ");
        System.out.println("2. IVA aplicat: ");
        System.out.println("3. Cost de l'enviament: ");
        System.out.println(" Quina opció vol triar? ");

        //Validem dades.
        dadaCorrecta = e.hasNextInt();
        if (dadaCorrecta) {
            opcio = e.nextInt();
            if (opcio == 1) {
                //Demanem dades a l'usuari i mostrem:
                System.out.println("Preu base:");
                preu = e.nextFloat();
                System.out.println("Número d'unitats:");
                unitats = e.nextInt();
                System.out.println("Categoria:");
                categoria = e.nextInt();
                switch (categoria) {
                    case 1:
                    case 2:
                        iva = IVA_SUPREDUIT;
                        break;
                    case 3:
                    case 4:
                        iva = IVA_REDUIT;
                        break;
                    default:
                        iva = IVA_NORMAL;
                }
                preuFinal = (preu + preu * iva / 100) * unitats;
                System.out.println("El preu final és: " + preuFinal);
            } else {
                if (opcio == 2) {
                    System.out.println("Preu base: ");
                    preu = e.nextFloat();
                    System.out.println("Número d'unitats: ");
                    unitats = e.nextInt();
                    System.out.println("Categoria: ");
                    categoria = e.nextInt();
                    switch (categoria) {
                        case 1:
                        case 2:
                            iva = IVA_SUPREDUIT;
                            break;
                        case 3:
                        case 4:
                            iva = IVA_REDUIT;
                            break;
                        default:
                            iva = IVA_NORMAL;
                    }
                    preuFinal = (preu + preu * iva / 100) * unitats;
                    System.out.println("El preu final és: " + preuFinal);
                } else {
                    if (opcio == 3) {
                        System.out.println("Preu base: ");
                        preu = e.nextFloat();
                        System.out.println("Número d'unitats: ");
                        unitats = e.nextInt();
                        //Calculem el preu sense IVA;
                        preuSenseIva = preu * unitats;

                        //Preu del cost de l'enviament.
                        if (preuSenseIva < ENVIAMENT_BAIX) {
                            cost = 3;
                        } else {
                            if (preuSenseIva < ENVIAMENT_MITG) {
                                cost = 20;
                            } else {
                                cost = 50;
                            }
                        }
                        System.out.println("El cost d'enviament es: " + cost);
                    } else {
                        System.out.println("No has seleccionat cap de les opcions del menú.");
                    }
                }
            }
        }

    }
}
