/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app6hospital;



public class DadesCOVID {

    static final short ID_PACIENT = 0;
    static final short ID_DATAINGRES = 1;
    static final short ID_GRAVETAT = 2;
    static final short ID_COST = 3;
    static final short ID_DATAALTA = 4;

    static final short ID_PACIENT_LENGTH = 6;
    static final short ID_DATA_LENGTH = 20;
    static final short ID_GRAVETAT_LENGTH = 10;
    static final short ID_COST_LENGTH = 10;

    public String[][] pacientsUrgenciesCOVID;
    public int numPacientsIngressats = 0;
    public int codiUltimPacient = 0;

    public DadesCOVID(int nBox) {
        pacientsUrgenciesCOVID = new String[nBox][3];
        for (int i = 0; i < pacientsUrgenciesCOVID.length; i++) {
            pacientsUrgenciesCOVID[i][ID_PACIENT] = "";
            pacientsUrgenciesCOVID[i][ID_DATAINGRES] = "";
            pacientsUrgenciesCOVID[i][ID_GRAVETAT] = "";
        }
    }

    public void addPacient(String idPacient, String dataIngres, String gravetat, int posicio) {
        if (!idPacient.equals("")) {
            numPacientsIngressats++;
            pacientsUrgenciesCOVID[posicio][DadesCOVID.ID_PACIENT] = idPacient;
            pacientsUrgenciesCOVID[posicio][DadesCOVID.ID_DATAINGRES] = dataIngres;
            pacientsUrgenciesCOVID[posicio][DadesCOVID.ID_GRAVETAT] = gravetat;
            int numPacient = Integer.parseInt(idPacient.replace("PA", ""));
            if (numPacient > codiUltimPacient) {
                codiUltimPacient = numPacient;
            }
        }
    }
}