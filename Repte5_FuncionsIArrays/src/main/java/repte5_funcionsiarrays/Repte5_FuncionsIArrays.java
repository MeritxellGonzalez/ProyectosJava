/*
  Repte 5: feu un programa que, donat un conjunt de cinc notes parcials
emmagatzemades en un array de reals, mostri el text de la nota final 
(la mitjana de totes cinc). Pista/Nota: tingueu en compte que el 
paràmetre d’entrada de l’exemple mitjana és un array d’enters. 
(No podeu usar el seu codi directament, 
l’haureu de modificar.)
 */
package repte5_funcionsiarrays;

/**
 *
 * @author Meritxell González
 * 
 */
public class Repte5_FuncionsIArrays {
    public static void main (String[]args){
        Repte5_FuncionsIArrays programa = new Repte5_FuncionsIArrays();
        programa.inici();
    }
    public void inici(){
        double [] valors = {3.5,4.5,6.5,7.5,9.8};
        double res = mitjana(valors);
        System.out.println("La nota final de les notes entrades (la seva mitjana és): " + res);
    }
   //Paràm. entrada: el valor a processar és un array
    //Parám. sortida: el resultat de fer el càlcul, un real (té decimals)
    public double mitjana (double notes[]){
        //array conté el valor a tractar
        double acumulador = 0;
        for (int i = 0; i < notes.length; i++){
            acumulador = acumulador + notes[i];
        }
     return acumulador/notes.length;   
    }
}
