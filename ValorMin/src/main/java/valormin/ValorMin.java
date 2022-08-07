package valormin;

public class ValorMin {

    public static final double[] aValors = {1, 5.5, 6.4, 7.3, 0.2, 4.3, 0.01};

    public static void main(String[] args) {
        double vMin = aValors[0];
        for (int i = 0; i < aValors.length; i++) {
            if (aValors[i] < vMin) {
                vMin = aValors[i];
            }
        }
        System.out.println("El valor mínim és: " + vMin + ".");
    }
}
