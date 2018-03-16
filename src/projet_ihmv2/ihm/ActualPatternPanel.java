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
import projet_ihmv2.core.Pattern;

/**
 * JPanel contenant et dessinant le paterne actuel definie pas le noyau fonctionnel
 * @author Baptiste
 */
public class ActualPatternPanel extends JPanel {
    private Core core;
    private ColorAble cTrace;
    private ColorAble cGoal;
    
    public ActualPatternPanel(Core core){
        this.core=core;
        this.cTrace=core.getActualColor();
        this.cGoal=core.getActualColor().nextColor();
    }
    
    @Override
    public void paintComponent(Graphics g) {
        int h = this.getHeight();
        int w = this.getWidth();
        
        
        
        int maxX = 0;
        int minX = 0;
        int maxY = 0;
        int minY = 0;
        
        Pattern p = this.core.getActivePattern();
        for(Move m : p.getMoves()){
            int[] depassement = m.depassement(1); //minX,maxX,minY,maxY
            if(depassement[0]<minX){
                minX=depassement[0];
            }
            if(depassement[1]>maxX){
                maxX=depassement[1];
            }
            if(depassement[2]<minY){
                minY=depassement[2];
            }if(depassement[3]>maxY){
                maxY=depassement[3];
            }
        }
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
        
        Graphics2D g2 = (Graphics2D)g;
        g2.setStroke(new BasicStroke(2));
        ColorAble c = this.cGoal.nextColor();
        int i=1;
        for(Move m : p.getMoves()){
            g2.setColor(this.cTrace.getColor());
            int posX=minDivX-minX*minDivX;
            int posY=minDivY-minY*minDivY;
            g2.fillOval(posX-7, posY-7, 14, 14);
            g2.setColor(c.getColor());
            for(ElementalMove em : m.getDeplacements()){
                g2.drawLine(posX,posY,posX+em.getX()*minDivX,posY+em.getY()*minDivY);
                g.drawLine(posX,posY,posX+em.getX()*minDivX,posY+em.getY()*minDivY);
                posX = posX+em.getX()*minDivX;
                posY = posY+em.getY()*minDivY;
            }
            c=c.nextColor();
            g2.setColor(this.cGoal.getColor());
            g2.fillOval(posX-4, posY-4, 8, 8);
            g2.drawString(Integer.toString(i), posX+4, posY-4);
            i++;
        }
    }
}
