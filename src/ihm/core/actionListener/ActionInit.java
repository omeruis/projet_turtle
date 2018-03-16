/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihm.core.actionListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import ihm.core.Action;

/**
 * tous les modes : applique l'action INIT
 * @author Baptiste
 */
public class ActionInit implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        Action.INIT.action("");
    }
    
}
