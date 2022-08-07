package polimorfismo;

public class ClaseHija_Suma extends Operaciones_ClasePadre{
    @Override
    //@Override es para sobrescribir un código cómo por ejemplo el método que se ve después.
    public void Operaciones(){
        resultado = vUno + vDos;
        
    }
}
