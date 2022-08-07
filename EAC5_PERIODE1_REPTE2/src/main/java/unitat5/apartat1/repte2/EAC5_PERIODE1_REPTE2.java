/*Repte 2. Genereu un projecte en el vostre IDE amb un package anomenat 
unitat5.apartat1.repte2.
Feu que dins d’aquest package s’incloguin les classes de 
l’exemple del registre de les notes i executeu-lo, comprovant que funciona 
correctament.*/

package unitat5.apartat1.repte2;

public class EAC5_PERIODE1_REPTE2 {

    public static void main(String[] args) {
        EAC5_PERIODE1_REPTE2 programa = new EAC5_PERIODE1_REPTE2();
        programa.inici();
    }

    public void inici() {
        double[] notes = {2.0, 5.5, 7.25, 3.0, 9.5, 8.25, 7.0, 7.5};
//Per cridar els mètodes cal inicialitzar la classe que els conté
        CalcArrayReal calculador = new CalcArrayReal();
//Un cop fet, cal cridar-los usant com a prefix l'identificador
        double max = calculador.calcularMaxim(notes);
        double min = calculador.calcularMinim(notes);
        double mitjana = calculador.calcularMitjana(notes);
        System.out.println("La nota màxima és " + max + ".");
        System.out.println("La nota mínima és " + min + ".");
        System.out.println("La mitjana de les notes és " + mitjana + ".");
    }
}
