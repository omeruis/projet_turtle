/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihm.core.actionListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import ihm.front.Fenetre;

/**
 * tous les modes : quitte l'application
 * @author Baptiste
 */
public class ActionQuit implements ActionListener {
    private Fenetre f;
    
    public ActionQuit(Fenetre f){
        this.f=f;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        f.dispose();
    }
    
}
