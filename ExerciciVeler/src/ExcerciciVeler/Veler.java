package ExcerciciVeler;


import ExcerciciVeler.Vaixell;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 34633
 */
public class Veler extends Vaixell{
    int veles; //Total de veles
    private Scanner DADES = new Scanner(System.in);

    public Veler(String matricula,String nom, float eslora, int cabines, int veles) {
        super(matricula,nom , eslora , cabines);
        this.veles = veles;
    }   

    
    public int getVeles() {
        return veles;
    }

    public void setVeles(int veles) {
        this.veles = veles;
    }    

    public String toString() {
        return super.toString()+ ", Veles=" + veles;
    }

    
    
}
