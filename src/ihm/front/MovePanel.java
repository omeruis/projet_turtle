/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihm.front;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import javax.swing.JPanel;
import ihm.core.ColorAble;
import ihm.core.Core;
import ihm.core.ElementalMove;
import ihm.core.Move;

/**
 * JPanel contenant et dessinant un mouvement
 * @author Baptiste
 */
public class MovePanel extends JPanel {
    private Core core;
    private double initx;
    private double inity;
    private Move m;
    private ColorAble c;
    
    public MovePanel(Move m,Core core,ColorAble c){
        this.initx=core.getPosX();
        this.inity=core.getPosY();
        this.core=core;
        this.m=m;
        this.c=c;
    }

    public void setInitx(double initx) {
        this.initx = initx;
    }

    public void setInity(double inity) {
        this.inity = inity;
    }

    public double getInitx() {
        return initx;
    }

    public double getInity() {
        return inity;
    }
    
    
    @Override
    public void paintComponent(Graphics g) {
        //donne acces à la tailles des graduation de la grille contenant le MovePanel
        DisplayPanel d = this.core.getFrame().getGrid();
        double posX=this.initx*d.getDivisionSizeX();
        double posY=this.inity*d.getDivisionSizeY();
        g.setColor(c.getColor());
        Graphics2D g2 = (Graphics2D)g;
        g2.setStroke(new BasicStroke(4));
        for(ElementalMove em : m.getDeplacements()){
            Line2D lx = new Line2D.Double(posX,posY,posX+em.getX()*d.getDivisionSizeX(),posY+em.getY()*d.getDivisionSizeY());
            g2.draw(lx);
            posX = posX+em.getX()*d.getDivisionSizeX();
            posY = posY+em.getY()*d.getDivisionSizeY();
        }
        
    }
    
}
