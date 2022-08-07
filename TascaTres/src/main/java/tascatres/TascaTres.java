package tascatres;

public class TascaTres {

    int piramide = 5;
    int estrellitas = 1;

    public static void main(String[] args) {
        TascaTres programa = new TascaTres();
        programa.inici();
    }

    public void inici() {
        ImprimirDiesSetmana();
        dibuixTriangle();
    }

    public void ImprimirDiesSetmana() {
        System.out.println("1. Dilluns");
        System.out.println("2. Dimarts");
        System.out.println("3. Dimecres");
        System.out.println("4. Dijous");
        System.out.println("5. Divendres");
        System.out.println("6. Dissabte");
        System.out.println("7. Diumenge");
        System.out.println(" ");
        System.out.println("-------------------");
        System.out.println(" ");
    }

    public void dibuixTriangle() {
        //alçada piramide
        for (int i = 0; i < piramide; i++) {
            //fila
            for (int j = 0; j < estrellitas; j++) {
                System.out.print("*");
            }
            /*increment de asteriscs per a cada linea fins que arribi al máxim 
            de l'alçada assignada.
             */
            estrellitas++;
            System.out.println();
        }
    }
}
