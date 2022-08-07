package notafinal;

public class NotaFinal {

    public static final float TOTAL_LLIURAMENTS = 10;

    public static void main(String[] args) {
        //Declarem variables.
        float notaProva = 7, notaFinal = 5, notaLliuraments = 0, notaPractiques = 5, numLliuraments = 6;
        boolean noSeguidaAC = false;
        //num.lliuraments
        if (notaProva < 7) {
            System.out.println("AVÍS: Estás suspés per prova final");
        } else {
            if ((numLliuraments) < (TOTAL_LLIURAMENTS * 70) / 100) {
                noSeguidaAC = true;
                System.out.println("AVÏS: Suspés, no has seguit l'avaluació continua.");
            } else {
                if (numLliuraments == TOTAL_LLIURAMENTS) {
                    notaLliuraments = 10;
                } else {
                    if ((numLliuraments) >= (TOTAL_LLIURAMENTS * 90) / 100) {
                        notaLliuraments = 8;
                    } else {
                        if ((numLliuraments) >= (TOTAL_LLIURAMENTS * 80) / 100) {
                            notaLliuraments = 6;
                        } else {
                            if ((numLliuraments) >= (TOTAL_LLIURAMENTS * 70) / 100) {
                                notaLliuraments = 4;
                            }
                        }
                    }
                }
            }
        }
        //NOTA FINAL
        notaFinal = (((notaProva * 20) / 100) + ((notaLliuraments * 10) / 100) + ((notaPractiques * 70) / 100));
        if ((notaFinal < 5) && (noSeguidaAC == true)) {
            System.out.println("Recomanacions: cal seguir avaluació contínua");
        } else {
            System.out.println("Recomanacions: fer els exercicis preparatoris per a la PAF2");
        }
    }
}
