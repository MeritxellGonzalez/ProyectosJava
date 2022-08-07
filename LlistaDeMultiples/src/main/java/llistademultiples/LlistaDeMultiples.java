/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package llistademultiples;

import java.util.Scanner;

public class LlistaDeMultiples {
    public static void main (String[]args){
        Scanner entrada = new Scanner(System.in);
        int n1;
        int n2;
        int valor;
        
        System.out.println("Quin valor li vols donar a n1?");
        n1 = entrada.nextInt();
        entrada.nextLine();
        
        System.out.println("Quin valor li vols donar a n2 (ha de ser major que n1)?");
        n2 = entrada.nextInt();
        entrada.nextLine();
        
        if(n1<n2){
            valor = n1;
            for(int i = 2; valor <= n2; i++){
                System.out.println(valor);
                valor = n1*i;
                        
            }
        }else{
            System.out.println("Oh! n2 no és més gran que n1");
        }
    }
}
