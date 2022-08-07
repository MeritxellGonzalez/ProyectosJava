package funcionsiarrays1;

public class FuncionsIArrays1 {

    public static void main(String[] args) {
        FuncionsIArrays1 prg = new FuncionsIArrays1();
        prg.inici();
    }

    void inici() {

        /* Per investigar què passa si fem canvis a un paràmetre de tipus 
 * bàsic, com per exemple un int 
         */
        int varEnter = 5;
        System.out.print(
                "Abans de cridar a la funció canviarValorParametreInt(varEnter) ");
        System.out.print("la variable varEnter val: ");
        System.out.println(varEnter);
        canviarValorParametreInt(varEnter);
        System.out.print(
                "Despres de cridar a la funció canviarValorParametreInt(varEnter) ");
        System.out.print("la variable varEnter val: ");
        System.out.println(varEnter);
    }

    void canviarValorParametreInt(int param) {
        int valorACanviar = 10;
        System.out.print("Dins la funció canviarValorParametreInt(param), ");
        System.out.print("abans del canvi [param=10] el paràmetre val: ");
        System.out.println(param);
        param = valorACanviar;
        System.out.print("Dins la funció canviarValorParametreInt(param), ");
        System.out.print("després del canvi [param=10] el paràmetre val: ");
        System.out.println(param);
    }
}
