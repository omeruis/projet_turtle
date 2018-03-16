/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihm.core.resizeListener;

import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.SwingUtilities;
import ihm.front.Fenetre;

/**
 * Redimensionnes les composants de droite de l'interface graphique
 * @author Baptiste
 */
public class RightsideListener extends ComponentAdapter{
    private Fenetre f;
    
    public RightsideListener(Fenetre f){
        this.f=f;
    }

    @Override
    public void componentResized(ComponentEvent e) {
        Dimension dimension = e.getComponent().getSize();
        this.f.getPattern().setPreferredSize(new Dimension(dimension.width/4,dimension.height/2));
        this.f.getInfoPattern().setPreferredSize(new Dimension(dimension.width/2,dimension.height/3));
        this.f.repaint();
    }
}
