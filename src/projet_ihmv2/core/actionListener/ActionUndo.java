/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet_ihmv2.core.actionListener;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import projet_ihmv2.core.Core;
import projet_ihmv2.core.Action;

/**
 * Tous les modes : applique l'action UNDO
 * @author Baptiste
 */
public class ActionUndo implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        Action.UNDO.action("");
    }
}
