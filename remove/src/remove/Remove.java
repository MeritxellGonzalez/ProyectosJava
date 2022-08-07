/*Recoger el String en una variable (Parametro)
Cambiarla a char
De la cadena pasada, tenemos que recorrerla (FOR)
Una vez recorrida, el caracter que este en primera posición y en última, se remplaza por un espacio.
*/
package remove;

public class Remove {
    
    public static String remove(String str) {
       String s1 = str;
       char [] c = s1.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if(i == 0){
                System.out.println(c[i]);
            }
            else if(i == c.length){
                System.out.println(c[i]);
            }
        }
      return str;
    }
    
}
