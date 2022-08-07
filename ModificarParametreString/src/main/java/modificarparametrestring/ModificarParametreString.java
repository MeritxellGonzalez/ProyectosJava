package modificarparametrestring;

public class ModificarParametreString {

    public static void main(String[] arrgs) {
        ModificarParametreString programa = new ModificarParametreString();
        programa.inici();
    }

    public void inici() {
        String i = "Bon dia";
        System.out.println("Abans de cridar el mètodo el valor de i val " + i );
        modificarParametre(i);
        System.out.println("Després de cridar el mètode el valor de i val " + i);
    }
    public void modificarParametre(String a){
        a = "Bona tarda";
        System.out.println("Hem modificat el valor a " + a);
        
    }
}
/*
Evidentment, com es tracta d'un String no variará el valor inicial de la variable.
Ja que els Strings es tracten com les dades reals, NO PODEN SER ALTERADES.
*/