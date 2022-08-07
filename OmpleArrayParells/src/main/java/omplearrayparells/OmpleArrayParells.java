package omplearrayparells;

import java.util.Scanner;

public class OmpleArrayParells {

    public static void main(String[] args) {
        //Incialitzem variables.
        Scanner entrada = new Scanner(System.in);
        System.out.println("Quin és el valor per a i ?");
        int i = entrada.nextInt();
        entrada.nextLine();
        int aParell [] = new int [i];
        aParell[0] = 0;
        //Aquí diem que fer en cas de que el nombre no sigui parell
        for(int j = 1; j < aParell.length; j++ ){
            aParell[j] = aParell [j - 1]+2;
        }
        //Aquí si es parell.
        for (int j = 0; j < aParell.length; j++){
            System.out.println(aParell[j]);
        }
    }
}
