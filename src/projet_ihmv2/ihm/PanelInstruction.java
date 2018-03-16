/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet_ihmv2.ihm;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import projet_ihmv2.core.actionListener.ActionApply;

/**
 * Mode Expert : JPanel permettant d'ecrire les instructions a appliquer et de les appliquer
 * @author Baptiste
 */
public class PanelInstruction extends JPanel{
    JTextArea zoneSaisie=new JTextArea();
    JScrollPane display = new JScrollPane(zoneSaisie);
    JButton apply = new JButton("Apply");
    
    public PanelInstruction(){
        Box b = Box.createVerticalBox();
        apply.addActionListener(new ActionApply(this.zoneSaisie));
        b.add(this.display);
        b.add(Box.createHorizontalGlue());
        b.add(this.apply);
        this.add(b);
    }

    public JTextArea getZoneSaisie() {
        return zoneSaisie;
    }

}
