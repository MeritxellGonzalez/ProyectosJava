package unitat5.apartat1.repte3;
import utilitats.array.CalcArrayReal;
public class RegistreTemperatures {

    public static void main(String[] args) {
        RegistreTemperatures prg = new RegistreTemperatures();
        prg.inici();
    }
    public void inici(){
        double[] temps = {20.0, 21.5, 19.0, 18.5, 17.5, 19.0, 22.25, 21.75};
        CalcArrayReal calculador = new CalcArrayReal();
        double max = calculador.calcularMaxim(temps);
        double min = calculador.calcularMinim(temps);
        double dif = max - min;
        System.out.println("La diferència de temperatura màxima " + dif + ".");
        
    }
}
