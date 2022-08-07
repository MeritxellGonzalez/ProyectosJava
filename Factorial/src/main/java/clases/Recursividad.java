package clases;

public class Recursividad {
    public int Factorial(int parametro){
        if (parametro > 0) {
            int valor_calculado = parametro * Factorial(parametro - 1);
            return valor_calculado;
        }
        return 1;
    }
}
