/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihm.core.actionListener;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;

/**
 * Vide les champs de texts par un clique
 * @author Baptiste
 */
public class ActionTextFieldClean extends MouseAdapter {
    private JTextField tf;
    
    public ActionTextFieldClean(JTextField tf){
        this.tf=tf;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        tf.setText("");
        tf.removeMouseListener(this);
    }

    
}
