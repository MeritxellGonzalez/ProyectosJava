package uf2;

public class CalcularMinim {

    public static void main(String[] args) {
        CalcularMinim prg = new CalcularMinim();
        prg.inici();
    }

    private void inici() {
        int res = minim(3, 6);
        System.out.println("El menor dels dos es " + res);
        int resto = minim(10, 15);
        System.out.println("El menor dels dos es " + resto);
        int diferencia = minim(res, resto);
        System.out.println("El menor dels dos es " + diferencia);

    }

    public int minim(int a, int b) {
        // "a" i "b" contenen els valors a tractar
        int min = b;
        if (a < b) {
            min = a;

        }
        return min;
    }

}
