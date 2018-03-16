/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet_ihmv2.ihm;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import projet_ihmv2.core.Core;

/**
 * GridPanel dessinant le pointeur de la tortue
 * @author Baptiste
 */
public class DisplayPanel extends GridPanel {
    private Core core;
    
    public DisplayPanel(int nbColonne,int nbLigne,Core core) {
        super(nbColonne,nbLigne);
        this.core=core;
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        if(this.core!=null){
            Graphics2D g2 = (Graphics2D)g;
            Ellipse2D e = new Ellipse2D.Double(core.getPosX()*super.getDivisionSizeX()-4, core.getPosY()*super.getDivisionSizeY()-4, 8, 8);
            g2.fill(e);
        }
        
    }
    
}
