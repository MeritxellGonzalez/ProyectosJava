package uf2;
public class ModificarParametreString {
    public static void main (String[]args){
        ModificarParametreString prg = new ModificarParametreString();
        prg.inici();
    }
    private void inici() {
        String i = "Hola";
        System.out.println("Abans de cridar el mètode \"i\" val " + i);
        modificarParametres(i);
        System.out.println("Després de cridar el mètode \"i\" val " + i);
    }
    private void modificarParametres(String a) {
     a = "Adeu"; 
     System.out.println("Hem modificat el valor a " + a);
    }
}
//Efectivament, passa exactament amb els valors primitius.