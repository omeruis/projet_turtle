/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihm.front;

import javax.swing.JPanel;
import ihm.core.ColorAble;

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
