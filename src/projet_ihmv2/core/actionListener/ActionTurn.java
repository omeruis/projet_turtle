/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet_ihmv2.core.actionListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import projet_ihmv2.core.Action;

/**
 * Mode novice : appllique l'action TURN
 * @author Baptiste
 */
public class ActionTurn implements ActionListener{
    private JTextField f;
    
    public ActionTurn(JTextField f){
        this.f=f;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Action.TURN.action(f.getText());
    }
    
}
