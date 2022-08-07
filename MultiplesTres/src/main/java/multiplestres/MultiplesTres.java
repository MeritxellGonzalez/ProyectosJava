package multiplestres;

public class MultiplesTres {

    public static void main(String[] args) {
        //int aValors[] = {1, 12, 4, 5, 7, 3, 2, 9, 6, 7};
        int aValors[]= {1, 13, 4, 5, 7, 3, 2, 8, 5, 7};
        int i = 0;
        int numMultiples = 0;
        while (numMultiples < 2 && i < aValors.length) {
            if (aValors[i] % 3 == 0) {
                numMultiples++;
                if (numMultiples == 2) {
                    System.out.println("El segon multiple es: " + aValors[i] + " .");
                }
            }
            i++;
        }
        if(numMultiples<2){
            System.out.println("Hi ha almenys 2 multiples de 3");
        }
    }
}
