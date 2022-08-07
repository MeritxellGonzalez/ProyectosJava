package uf2;

public class EscriureEstrelles {

    public static void main(String[] args) {
        EscriureEstrelles prg = new EscriureEstrelles();
        prg.inici();
    }

    private void inici() {
        estrelles(4);
        estrelles(8);
        estrelles(16);

    }
    //Té un paràmetre d'entrada de tipus enter.
    private void estrelles(int i) {
        //Mentre que J sigui menor que i J augmentara i, imprimira un "*".
        for (int j = 0; j < i; j++) {
            System.out.print("*");
        }
        System.out.println();
    }
}
