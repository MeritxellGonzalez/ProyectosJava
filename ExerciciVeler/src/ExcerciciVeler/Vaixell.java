package ExcerciciVeler;


import ExcerciciVeler.Matricula;
import ExcerciciVeler.ExcepcioVaixell;
import java.util.Scanner;



/**
 *
 * @author 34633
 */

public abstract class Vaixell implements Matricula {
    private Scanner DADES = new Scanner(System.in);
    
    private String matricula;
    private String nom;
    private float eslora;
    private int cabines;
    
    
     public Vaixell(String matricula, String nom, float eslora, int cabines ) {
        this.matricula = matricula;
        this.nom = nom;
        this.eslora = eslora;
        this.cabines = cabines;
        
    }
    
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
     
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public float getEslora() {
        return eslora;
    }

    public  void setEslora(float eslora) {
        this.eslora = eslora;
    }

    public int getCabines() {
        return cabines;
    }

    public void setCabines(int cabines) {
        this.cabines = cabines;
    }

    
    
    public boolean estaMatriculat(){
        
      if (matricula == null){ //No està matriculat
          return false; 
      }
          return true;
      
       
    }
    
    public String matricular() {
        System.out.println("Digues quina es la matricula?");
        String resposta = DADES.next();
        return resposta;
    }
    
    public static void comprovarMatricula(Vaixell vaixell) throws ExcepcioVaixell {

            if(vaixell.estaMatriculat() == true){
                throw new ExcepcioVaixell("default");
            }
            throw new ExcepcioVaixell("0");
        }
        
    } 

