//------------Exercici 1 - Joc de proves-------------
package eac5.periode1.tasca2;

public class EAC5_PERIODE1_TASCA2 {

    public static void main(String[] args) {
        EAC5_PERIODE1_TASCA2 prg = new EAC5_PERIODE1_TASCA2();
        prg.prova();
    }

    void prova() {
        int pos;
        double[] col = {10.5, 1.0, 8.9, 5.2, 1.0, 7.5, -5.8, 0, 18.1};
        
        pos = cercarPosicioValor(col, col[0]);
        System.out.print("cercarPosicioValor(col, col[0]) = ");
        System.out.println(pos);
        
        pos = cercarPosicioValor(col, col[col.length-1]);
        System.out.print("cercarPosicioValor(col, col[col.length-1]) = ");
        System.out.println(pos);

        pos = cercarPosicioValor(col, col[3]);
        System.out.print("cercarPosicioValor(col, col[3]) = ");
        System.out.println(pos);
        
        pos = cercarPosicioValor(col, 1);
        System.out.print("cercarPosicioValor(col, 1) = ");
        System.out.println(pos);

        pos = cercarPosicioValor(col, 1000);
        System.out.print("cercarPosicioValor(col, 1000) = ");
        System.out.println(pos);
    }
    
    
    public int cercarPosicioValor(double[] colleccio, double aCercar) {
        boolean trobat = false;
        int posicio = 0;

        while (posicio < colleccio.length && !trobat) {
            trobat = colleccio[posicio] == aCercar;
            if(!trobat){
            posicio++;
            }
        }

        return posicio;
    }
}
