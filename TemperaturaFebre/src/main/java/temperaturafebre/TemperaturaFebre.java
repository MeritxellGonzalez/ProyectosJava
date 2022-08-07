package temperaturafebre;

public class TemperaturaFebre {

    public static void main(String[] args) {
        //Declaració de variables.
        int edat = 12;
        int temperatura = 40;
        int dosisParacetamol = 15;
        int pesNen = 45;
        //Instruccions sobre que fer en cas de febricula.
        if (temperatura < 38) {
            System.out.println("El nen està bé");
        } else {
            if (temperatura < 39) {
                System.out.println("Es recomenable donar-li un bany per a baixar la temperatura");
            } else {
                if (edat < 3) {
                    System.out.println("Consultar amb el metge");
                } else {
                    if(edat < 12){
                        dosisParacetamol = dosisParacetamol * pesNen;
                    }else if(edat >= 12){
                        dosisParacetamol = 500;
                        System.out.println("Suministrar cada 8h: " + dosisParacetamol);
                    }else{
                        if(temperatura >=40){
                            System.out.println("Per més de 40, cal portar-lo a l'hospital");
                        }
                    }
                }
            }
        }

    }
}
