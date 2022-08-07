/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PAFAtraccio;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


/**
 *
 * @author root
 */
public class FormAccesMR implements ActionListener {

    private final int AMPLADA = 400;
    private final int ALCADA = 200;

    private JFrame finestra;

    private JLabel pregunta;

    private JButton si;
    private JButton no;

    private boolean resposta;

    public FormAccesMR() {
        /*TODO Heu de crear una finestra com la que es mostra a la imatge, tenint en compte:
           - L'atribut etiqueta i els botons han d'estar incrustats en la finestra directament.
           - L'etiqueta ha de mostrar la pregunta "L'atracció té accés de mobilitat reduïda?"
           - El nom del botó si ha de ser "Sí" i el del botó no a de ser "No"
           - El nom de la finestra ha de ser "Accés de mobilitat reduïda" i les seves mides la dels 
             atributs constants AMPLADA i ALCADA.
           - Heu de respectar el format de la finestra de la imatge.
         */
        finestra = new JFrame("Accés de mobilitat reduida");
        finestra.setLayout(new GridLayout(0, 1));

        pregunta = new JLabel("L'atracció té accés de mobilitat reduïda?");
        si = new JButton("Si");
        no = new JButton("no");

        
        finestra.add(pregunta);
        finestra.add(si);
        finestra.add(no);

        
        finestra.setSize(AMPLADA, ALCADA);
        finestra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        finestra.setVisible(true);
        
        afegirListenerBotons();
    }

    public void afegirListenerBotons() {

       this.si.addActionListener(this);
       this.no.addActionListener(this);
    }

    public void actionPerformed(ActionEvent esdeveniment) {
        boolean resposta;
        if(esdeveniment.getSource() == "Si"){
              resposta = true;
        }
        resposta = false;
        }
        

    public JFrame getFinestra() {
        return finestra;
    }

    public void setFinestra(JFrame finestra) {
        this.finestra = finestra;
    }

    public JLabel getPregunta() {
        return pregunta;
    }

    public void setPregunta(JLabel pregunta) {
        this.pregunta = pregunta;
    }

    public JButton getSi() {
        return si;
    }

    public void setSi(JButton si) {
        this.si = si;
    }

    public JButton getNo() {
        return no;
    }

    public void setNo(JButton no) {
        this.no = no;
    }

    public boolean isResposta() {
        return resposta;
    }

    public void setResposta(boolean resposta) {
        this.resposta = resposta;
    }
    
}
