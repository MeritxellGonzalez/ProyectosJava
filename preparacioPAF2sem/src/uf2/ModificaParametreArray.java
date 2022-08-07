package uf2;

public class ModificaParametreArray {

    public static void main(String[] args) {
        ModificaParametreArray prg = new ModificaParametreArray();
        prg.inici();
    }

    private void inici() {
        int[] i = {1, 2, 3, 4, 5};
        System.out.println("Abans de cridar el mètode \"i[3]\" val " + i[3]);
        modificarParametre(i);
        System.out.println("Després de cridar el mètode \"i[3]\" val " + i[3]);
    }

    private void modificarParametre(int[] a) {
        a[3] = 0;
        System.out.println("Hem modificat el valor a " + a[3]);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
//Podem comprovar que el valor que ocupa la posició 3 de l'array canvia a 0, 
//que es el que val a[3].
