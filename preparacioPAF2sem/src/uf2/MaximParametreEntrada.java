package uf2;
public class MaximParametreEntrada {
    public static void main (String[]args){
        MaximParametreEntrada prg = new MaximParametreEntrada();
        prg.inici();
    }
    private void inici() {
        //Usem literals
     mostrarMaxim(4, 10);
        //Usem variables
     int i = 0;
     int j = -3;
     mostrarMaxim(i, j);
        //Usem expressions, amb literals o variables.
     mostrarMaxim(2+3, i+8);   
    }
    //Té dos paràmetres d'entrada de tipus enter
    //El seu valor inicial depèn dels valors assignats a cada invocació
    private void mostrarMaxim(int a, int b) {
        System.out.println("El maxim entre "+a+ " i "+b+" es...");
        if (a>b) {
            System.out.println(a);
        }else if(a<b){
            System.out.println(b);
        }else{
            System.out.println("Són iguals.");
        }
    }
}
