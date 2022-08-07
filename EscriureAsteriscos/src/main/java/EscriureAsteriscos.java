
public class EscriureAsteriscos {

    public static final int MAX = 20;
    public static final int MIN = 5;

    public static void main(String[] args) {
        EscriureAsteriscos programa = new EscriureAsteriscos();
        programa.inici();
    }

    public void inici() {

        asterisc(2);
        asterisc(4);
        asterisc(6);
    }

    public void asterisc(int a) {
        for (int i = 0; i < a; i++) {
            System.out.print("*");
        }
        System.out.println();
    }
}
