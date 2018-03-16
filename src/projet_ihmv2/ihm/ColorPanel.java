/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet_ihmv2.ihm;

import javax.swing.JPanel;
import projet_ihmv2.core.ColorAble;

/**
 * JPanel de la couleur d'un objet ColorAble
 * @author Baptiste
 */
public class ColorPanel extends JPanel {
    private ColorAble c;
    
    public ColorPanel(ColorAble c){
        this.c=c;
        this.setBackground(c.getColor());
    }
    
    public ColorAble getColorAble(){
        return this.c;
    }
}
