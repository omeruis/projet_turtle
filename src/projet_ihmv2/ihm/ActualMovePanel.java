/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet_ihmv2.ihm;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import projet_ihmv2.core.Core;
import projet_ihmv2.core.ColorAble;
import projet_ihmv2.core.ElementalMove;
import projet_ihmv2.core.Move;

/**
 * JPanel contenant et dessinant le mouvement actuel definie pas le noyau fonctionnel
 * @author Baptiste
 */
public class ActualMovePanel extends JPanel {
    private Core core;
    private ColorAble cTrace;
    private ColorAble cGoal;
    
    public ActualMovePanel(Core core){
        this.core=core;
        this.cTrace=core.getActualColor();
        this.cGoal=core.getActualColor().nextColor();
    }
    
    @Override
    public void paintComponent(Graphics g) {
        int h = this.getHeight();
        int w = this.getWidth();
        
        Move m = this.core.getActivePattern().getActualMove();
        int[] depassement = m.depassement(1); //minX,maxX,minY,maxY
        int minX = depassement[0];
        int maxX = depassement[1];
        int minY = depassement[2];
        int maxY = depassement[3];
        int nbDivisionX = maxX-minX+2;
        int nbDivisionY = maxY-minY+2;
            
            
        int minDivX = w/nbDivisionX;
        int minDivY = h/nbDivisionY;
        
        for(int i=0;i<nbDivisionX+1;i++){
            g.drawLine(i*minDivX, 0, i*minDivX, h);
        }
        
        for(int i=0;i<nbDivisionY+1;i++){
            g.drawLine(0, i*minDivY, w, i*minDivY);
            
        }
        
        g.setColor(this.cTrace.getColor());
        Graphics2D g2 = (Graphics2D)g;
        g2.setStroke(new BasicStroke(2));
        int posX=minDivX-minX*minDivX;
        int posY=minDivY-minY*minDivY;
        g2.fillOval(posX-4, posY-4, 8, 8);
        for(ElementalMove em : m.getDeplacements()){
            g2.drawLine(posX,posY,posX+em.getX()*minDivX,posY+em.getY()*minDivY);
            posX = posX+em.getX()*minDivX;
            posY = posY+em.getY()*minDivY;
        }
        g2.setColor(this.cGoal.getColor());
        g2.fillOval(posX-4, posY-4, 8, 8);
    }
}
