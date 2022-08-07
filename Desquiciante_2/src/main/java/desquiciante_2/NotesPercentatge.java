package desquiciante_2;

public class NotesPercentatge {

    public static final double SUSPES = 7;
    public static final double TOTLLIURAMENT = 100;

    public static void main(String[] args) {
        double numLliuraments = 80;
        boolean noSeguidaAC = true;
        double notaFinal = 0;
        double notaProva = 9;
        double notaLliuraments = 0;
        double NotaPrac = 9;

        if (notaProva < SUSPES) {
            System.err.println("Has suspendid, chaval!");

        } else {
            if (numLliuraments < 70) {
                System.out.println("Estás suspés. No has seguit l'AC");
                noSeguidaAC = true;
            } else {
                if (numLliuraments == TOTLLIURAMENT) {
                    notaLliuraments = 10;
                } else {
                    if (numLliuraments >= 90) {
                        notaLliuraments = 8;
                    }else{
                        if(numLliuraments >= 80){
                            notaLliuraments = 6;
                        }else{
                            if(numLliuraments >= 70){
                                notaLliuraments = 4;
                            }
                        }
                    }
                }
            }
        }
        notaFinal = (((notaProva*20)/100)+((notaLliuraments*10)/100) +((NotaPrac *70)/100));
        System.out.println(notaFinal);
        if(notaFinal < 5){
            if(noSeguidaAC == true){
                System.out.println("Cal seguir amb l'AC");
            }else{
                System.out.println("Fes els exercicis preparatoris per a la PAF2");
            }
        }

    }
}
