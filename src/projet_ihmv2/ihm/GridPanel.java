/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet_ihmv2.ihm;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import javax.swing.JPanel;

/**
 * JPanel dessinant une grille de la taille souhaitee
 * @author Baptiste
 */
public class GridPanel extends JPanel{
    private int nbDivisionX;
    private int nbDivisionY;
    
    public GridPanel(int nbColonne, int nbLigne){
        this.nbDivisionX=nbColonne;
        this.nbDivisionY=nbLigne;
    }

    public void setNbDivisionX(int nbDivisionX) {
        this.nbDivisionX = nbDivisionX;
    }

    public void setNbDivisionY(int nbDivisionY) {
        this.nbDivisionY = nbDivisionY;
    }
    
    
    public int getNbDivisionY(){
        return this.nbDivisionY;
    }
    
    public int getNbDivisionX(){
        return this.nbDivisionX;
    }
    
    public double getDivisionSizeX(){
        return this.getWidth()/((double)this.nbDivisionX);
    }
    
    public double getDivisionSizeY(){
        return this.getHeight()/((double)this.nbDivisionY);
    }
    
    
    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        int h = this.getHeight();
        int w = this.getWidth();
        
        for(int i=0;i<nbDivisionX+1;i++){
            Line2D lx = new Line2D.Double(i*this.getDivisionSizeX(), 0, i*this.getDivisionSizeX(), h);
            g2.draw(lx);
        }
        for(int i=0;i<nbDivisionY+1;i++){
            Line2D ly = new Line2D.Double(0, i*this.getDivisionSizeY(), w, i*this.getDivisionSizeY());
            g2.draw(ly);
        }
    }
}
