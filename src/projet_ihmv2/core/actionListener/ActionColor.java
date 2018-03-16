/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet_ihmv2.core.actionListener;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import projet_ihmv2.core.Action;
import projet_ihmv2.ihm.ColorPanel;

/**
 * mode novice : change la couleur si clique sur l'une de celles presentees
 * @author Baptiste
 */
public class ActionColor extends MouseAdapter {
    private ColorPanel f;
    
    public ActionColor(ColorPanel f){
        this.f=f;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Action.COLOR.action(f.getColorAble().toString());
    }

}
