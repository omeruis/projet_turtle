/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet_ihmv2.core.resizeListener;

import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import projet_ihmv2.ihm.Fenetre;


/**
 * Redimensionnes les composants principaux de l'interface graphique
 * @author Baptiste
 */
public class FenetreListener extends ComponentAdapter{
    private Fenetre f;
    
    public FenetreListener(Fenetre f){
        this.f=f;
    }

    @Override
    public void componentResized(ComponentEvent e) {
        Dimension dimension = e.getComponent().getSize();
        this.f.getLeftSide().setPreferredSize(new Dimension(dimension.width/5,dimension.height));
        this.f.getDisplay().setPreferredSize(new Dimension(dimension.width/2,dimension.height));
        this.f.getRightSide().setPreferredSize(new Dimension(dimension.width/4,dimension.height));
        this.f.repaint();
    }

    
}
