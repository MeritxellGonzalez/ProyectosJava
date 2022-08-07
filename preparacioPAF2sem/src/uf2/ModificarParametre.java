package uf2;
public class ModificarParametre {
    public static void main(String[] args) {
        ModificarParametre prg = new ModificarParametre();
        prg.inici();
    }
    private void inici() {
        int i = 10;
        System.out.println("Abans de cridar el mètode \"i\"val " + i);
        modificarParametre(i);
        System.out.println("Després de cridar el mètode \"i\"val " + i);
    }
    private void modificarParametre(int a) {
        //Ara hi ha una variable "a" declarada
        //El seu valor depèn de com s'ha invocat el mètode.
        a = 0;
        System.out.println("Heu modificat el valor a " + a);
    }
}
//Es pot comprovar com el valor de a, no es modifica. Perque estem tractant
//amb tipus de dades primitives per aquest motiu, no es modifica el seu valor.
//Però si aquest exercici el provessïm amb una variable "a" de tipus Array, si 
//es modificaria el seu valor.
//Encanvi, amb les variables String, no es modificaria tampoc.