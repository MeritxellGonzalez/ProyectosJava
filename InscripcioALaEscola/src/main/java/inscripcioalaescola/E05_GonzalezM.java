package inscripcioalaescola;

import java.util.Scanner;

/**
 *
 * @author Meri
 */
public class E05_GonzalezM {

    public static final int NUMORDRE_MINIM = 1;
    public static final int NUM_ORDRE_MAX = 499;
    public static final int RESPOSTA_NO = 0;
    public static final int RESPOSTA_SI = 1;
    public static final int PUNTS_GERMA = 40;
    public static final int PUNTS_ZONA = 30;
    public static final int PUNTS_TREBALLZONA = 20;
    public static final int PUNTS_DISCA = 10;
    public static final int PUNTS_FAMILIANUM = 15;
    public static final int PUNTS_FAMILIAANTICALUM = 5;

    public static void main(String[] args) {
        //Declaracio de variables.
        int numOrdre, germa, zona, treballZona, disca, familiaNombrosa, familiaExAlumne;
        int punts = 0;
        boolean dadaCorrecta;
        Scanner e = new Scanner(System.in);

        //Demanem dades del alumne
        System.out.println("Quin és el número de registre del nen/a? ");
        dadaCorrecta = e.hasNextInt();
        if (dadaCorrecta) {
            numOrdre = e.nextInt();
            if ((numOrdre < NUMORDRE_MINIM) || (numOrdre > NUM_ORDRE_MAX)) {
                dadaCorrecta = false;
                System.out.println("El número de registre es erroni");
            //Si la dada es correcte, entrem dintre del qüestionari
            } else {
                System.out.println("Té cap germà a l'escola? \n 0 = No\n 1 = Si");
                dadaCorrecta = e.hasNextInt();
                if (dadaCorrecta) {
                    germa = e.nextInt();
                    if ((germa < RESPOSTA_NO) || (germa > RESPOSTA_SI)) {
                        dadaCorrecta = false;
                        System.out.println("Dada incorrecta");
                    } else {//Preguntem si viu a la zona
                        System.out.println("Viu a la zona on està ubicada la escola? \n 0 = No\n 1 = Si");
                        dadaCorrecta = e.hasNextInt();
                        if (dadaCorrecta) {
                            zona = e.nextInt();
                            if ((zona < RESPOSTA_NO) || (zona > RESPOSTA_SI)) {
                                dadaCorrecta = false;
                                System.out.println("Entrada incorrecta");
                            } else {//Preguntem si el pare o mare treballa a la zona
                                System.out.println("El pare o mare treballen a la zona vora de l'escola?\n 0 = No \n 1 = Si");
                                dadaCorrecta = e.hasNextInt();
                                if (dadaCorrecta) {
                                    treballZona = e.nextInt();
                                    if ((treballZona < RESPOSTA_NO) || (treballZona > RESPOSTA_SI)) {
                                        dadaCorrecta = false;
                                        System.out.println("Entrada incorrecta");
                                    } else {//Si té cap discapacitat
                                        System.out.println("Té cap discapacitat o malaltia cronica ? \n 0 = No \n 1 = Si");
                                        dadaCorrecta = e.hasNextInt();
                                        if (dadaCorrecta) {
                                            disca = e.nextInt();
                                            if ((disca < RESPOSTA_NO) || (disca > RESPOSTA_SI)) {
                                                dadaCorrecta = false;
                                                System.out.println("Entrada incorrecta");
                                            } else {//Familia nombrosa o monoparental
                                                System.out.println("Sou considerats com a família nombrosa o monoparental?\n 0 = No\n 1 = Si");
                                                dadaCorrecta = e.hasNextInt();
                                                if (dadaCorrecta) {
                                                    familiaNombrosa = e.nextInt();
                                                    if ((familiaNombrosa < RESPOSTA_NO) || (familiaNombrosa > RESPOSTA_SI)) {
                                                        dadaCorrecta = false;
                                                        System.out.println("Entrada incorrecta");
                                                        //Familiar antic alumne
                                                    } else {
                                                        System.out.println("El pare, mare, germa o tutor legal ha estat alumne del centre?\n 0 = No\n 1 = Si");
                                                        dadaCorrecta = e.hasNextInt();
                                                        if(dadaCorrecta){
                                                            familiaExAlumne = e.nextInt();
                                                            if((familiaExAlumne<RESPOSTA_NO)||(familiaExAlumne>RESPOSTA_SI)){
                                                                dadaCorrecta = false;
                                                                System.out.println("Entrada incorrecta");
                                                            }else{//Només guardem les respostes que han estat favorables, per a la suma total dels punts
                                                                if(germa == 1){
                                                                    punts = PUNTS_GERMA;
                                                                }
                                                                if(zona == 1){
                                                                    punts += PUNTS_ZONA;
                                                                
                                                                }else{
                                                                    if(treballZona == 1){
                                                                        punts += PUNTS_TREBALLZONA;
                                                                    }
                                                                }
                                                                if(disca == 1){
                                                                    punts += PUNTS_DISCA;
                                                                }
                                                                if(familiaNombrosa == 1){
                                                                    punts += PUNTS_FAMILIANUM;
                                                                }
                                                                if(familiaExAlumne == 1){
                                                                    punts += PUNTS_FAMILIAANTICALUM;
                                                                }
                                                                System.out.println("La puntuació total es: " + punts);
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}