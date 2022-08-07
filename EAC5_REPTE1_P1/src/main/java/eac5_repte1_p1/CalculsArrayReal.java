

//-----CLASSE PER AL CALCUL MAX, MIN I MITJANA----
package eac5_repte1_p1;

public class CalculsArrayReal {

    public double calcMax(double[] array) {
        double max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
            }
        }
        return max;
    }

    public double calcMin(double[] array) {
        double min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (min > array[i]) {
                if (min > array[i]) {
                    min = array[i];
                }
            }
        }
        return min;
    }

    public double calcMitj(double[] array) {
        double suma = 0;
        for (int i = 0; i < array.length; i++) {
            suma = suma + array[i];
        }
        return suma / array.length;
    }
}
