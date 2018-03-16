/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihm.core.actionListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import ihm.core.Action;

/**
 * mode novice : applique l'action GO
 * @author Baptiste
 */
public class ActionGo implements ActionListener {
    private JTextField f;
    
    public ActionGo(JTextField f){
        this.f=f;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Action.GO.action(f.getText());
    }
    
}
