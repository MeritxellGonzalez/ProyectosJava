package funcionsiarrays2;

public class FuncionsIArrays2 {

    public static void main(String[] args) {
        FuncionsIArrays2 prg = new FuncionsIArrays2();
        prg.inici();
    }

    void inici() {
        /* Per investigar què passa si fem canvis als elements d'un paràmetre           
* de tipus Array.
         */
        int[] varArray = new int[8];
        for (int i = 0; i < varArray.length; i++) {
            varArray[i] = i * 2;
        }

        System.out.print("Abans de cridar a la funció ");
        System.out.print("canviarValorElementsParametreArray(varArray) ");
        System.out.print("la variable varArray val: ");
        printIntArray(varArray);

        canviarValorElementsParametreArray(varArray);

        System.out.print("Despres de cridar a la funció ");
        System.out.print("canviarValorElementsParametreArray(varArray) ");
        System.out.print("la variable varArray val: ");
        printIntArray(varArray);
    }

    void canviarValorElementsParametreArray(int[] param) {
        int valorACanviar = 0;
        System.out.print("Dins la funció canviarValorElementsParametreArray(param), ");
        System.out.print("abans del canvi [param[i]=0] el paràmetre val: ");
        printIntArray(param);
        for (int i = 2; i < param.length; i += 2) {
            param[i] = valorACanviar;
        }
        System.out.print("Dins la funció canviarValorElementsParametreArray(param), ");
        System.out.print("després del canvi [param[i]=0] el paràmetre val: ");
        printIntArray(param);
    }

    void printIntArray(int[] valors) {
        //Funció per veure els valors de l’array en format {x1, x2, …. xn}

        int limitFor = valors.length - 1;
        System.out.print("{ ");
        for (int i = 0; i < limitFor; i++) {
            System.out.print(valors[i]);
            System.out.print(", ");
        }
        if (limitFor >= 0) {
            System.out.print(valors[limitFor]);
        }
        System.out.println(" }");
    }

}
