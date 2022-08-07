package listas_tipo_pila;

import javax.swing.JOptionPane;

public class Pila {
    private Nodo UltimoValorIngresado;
    int tamano = 0;
    String Lista = "";
    
    public Pila(){
        UltimoValorIngresado = null;
        tamano = 0;
    }
    //Método para saber si nuestra pila está vacia
    public boolean PilaVacia(){
        return UltimoValorIngresado == null;
    }
    
    //Método para insertar un nodo en la pila
    public void InsertarNodo(int nodo){
        Nodo nuevo_nodo = new Nodo (nodo);
        nuevo_nodo.siguiente = UltimoValorIngresado;
        UltimoValorIngresado = nuevo_nodo;
        tamano++;
    }
    
    //Método para eliminar un nodo de la pila
    public int EliminarNodo(){
        int auxiliar = UltimoValorIngresado.informacion;
        UltimoValorIngresado = UltimoValorIngresado.siguiente;
        tamano--;
        return auxiliar;       
    }
    
    //Método para conocer el último valor ingresado
    public int MostrarUltimoValorIngresado(){
        return UltimoValorIngresado.informacion;        
    }
    
    //Método para conocer el tamaño de nuestra Pila
    public int TamanoPila(){
        return tamano;        
    }
    
    //Método para vaciar la pila
    
    public void VaciarPilar(){
        while(!PilaVacia()){
            EliminarNodo();
        }
    }
    //Metodo para mostrar el contenido de la pila
    public void MostrarValores(){
        Nodo recorrido = UltimoValorIngresado;
        
        while(recorrido != null){
            Lista += recorrido.informacion + "\n";
            recorrido = recorrido.siguiente;
        }
        JOptionPane.showMessageDialog(null, Lista);
        Lista = "";
    }
}
