package barrejararrays;

public class BarrejarArrays {

    public static void main(String[] args) {
        int[] arA = {1, 3, 5, 7, 9, 11, 13, 15};
        int[] arB = {2, 4, 6, 8, 10, 12, 14, 16};

        int[] aNou = new int[arA.length + arB.length];

//Omple la part de A.
        int iNou = 0;
        for (int i = 0; i < arA.length; i++) {
            aNou[iNou] = arA[i];
            iNou = iNou + 2;
        }
//Omple la part de B.
        iNou = 1;
        for (int i = 0; i < arB.length; i++) {
            aNou[iNou] = arB[i];
            iNou = iNou + 2;
        }
        for (int i = 0; i < aNou.length; i++) {
            System.out.println(aNou[i]);
        }
    }
}
