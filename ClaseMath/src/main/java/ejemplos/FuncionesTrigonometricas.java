package ejemplos;

public class FuncionesTrigonometricas {

    public static void main(String[] args) {

        double resultado = 0;
        double anguloEnGrados = 45;
        double anguloEnRadianes = Math.toRadians(anguloEnGrados);

        //Seno
        resultado = Math.sin(anguloEnRadianes);
        System.out.println("Seno de " + anguloEnGrados + "º = " + resultado);

        //Coseno
        resultado = Math.cos(anguloEnRadianes);
        System.out.println("Coseno de " + anguloEnGrados + "º = " + resultado);

        //Tangente
        resultado = Math.tan(anguloEnRadianes);
        System.out.println("Tangente de " + anguloEnGrados + "º = " + resultado);

        double valorIngresado = 0.707;
        
        
        //Arco Coseno
        anguloEnRadianes = Math.acos(valorIngresado);
        anguloEnGrados = Math.toDegrees(anguloEnRadianes);
        System.out.println("Arco coseno de: " + valorIngresado + " = " + anguloEnGrados + "º");
        
        //Arco Seno
        anguloEnRadianes = Math.asin(valorIngresado);
        anguloEnGrados = Math.toDegrees(anguloEnRadianes);
        System.out.println("Arco seno de: " + valorIngresado + " = " + anguloEnGrados + "º");
        
        //Arco Tangente
        anguloEnRadianes = Math.atan(valorIngresado);
        anguloEnGrados = Math.toDegrees(anguloEnRadianes);
        System.out.println("Arco Tangente de: " + valorIngresado + " = " + anguloEnGrados + "º");
    }

}
