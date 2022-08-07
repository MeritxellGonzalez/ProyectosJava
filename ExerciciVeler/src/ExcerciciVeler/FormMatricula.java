package ExcerciciVeler;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class FormMatricula implements ActionListener {

    private final int AMPLADA = 250;
    private final int ALCADA = 200;
    
    private JFrame finestra;

    private JLabel lMatricula;
    private JTextField tMatricula;
    private JButton matricular;

    public FormMatricula() {
        /* TODO
		Heu de crear una finestra com la que es mostra a la imatge, tenint en compte:
           - L'atribut etiqueta, camp de text i botó han d'estar incrustats en la finestra directament.
           - El nom del botó ha de ser "Matricular".
           - El nom de la finestra ha de ser "Matriculació vaixell" i les seves mides la dels atributs
			constants AMPLADA i ALCADA.
           - El camp de text quan obrim la finestra mostrarà "7º-PM-1-01-11" què serà una matrícula d'exemple.
           - Heu de respectar el format de la finestra de la imatge.
         */

        finestra = new JFrame("Matriculació vaixell");
        finestra.setLayout(new GridLayout(0, 1));

        lMatricula = new JLabel("Matrícula");
        tMatricula = new JTextField("7º-PM-1-01-11");
        matricular = new JButton("Matricular");

        // AFEGIM EL JLABEL DE MATRICULA, EL TEXTFIELD PREVIAMENT OMPLERT I EL BOTO MATRICULAR
        finestra.add(lMatricula);
        finestra.add(tMatricula);
        finestra.add(matricular);

        // PER MOSTRAR LA FINESTRA
        finestra.setSize(AMPLADA, ALCADA);
        finestra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        finestra.setVisible(true);
        
        afegirListenerBotons();

    }

    public void afegirListenerBotons() {

        this.matricular.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent esdeveniment) {
        Vaixell nouVaixell = new Vaixell(tMatricula.getText(), "Vaixell", 13.5F, 4){}; 
        PortConn port = new PortConn();
        try {
            port.insertarVaixell(nouVaixell.getMatricula(), nouVaixell.getNom(), nouVaixell.getEslora(), nouVaixell.getCabines());
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(FormMatricula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
         
    }

    public JFrame getFinestra() {
        return finestra;
    }

    public void setFinestra(JFrame finestra) {
        this.finestra = finestra;
    }

    public JLabel getlMatricula() {
        return lMatricula;
    }

    public void setlMatricula(JLabel lMatricula) {
        this.lMatricula = lMatricula;
    }

    public JTextField gettMatricula() {
        return tMatricula;
    }

    public void settMatricula(JTextField tMatricula) {
        this.tMatricula = tMatricula;
    }

    public JButton getMatricular() {
        return matricular;
    }

    public void setMatricular(JButton matricular) {
        this.matricular = matricular;
    }
}
