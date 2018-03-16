/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihm.core.resizeListener;

import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.JComponent;
import ihm.front.Fenetre;
import ihm.front.PanelInstruction;

/**
 * Redimensionnes les composants du sercteur gauche de l'interface graphique
 * @author Baptiste
 */
public class LeftsideListener extends ComponentAdapter{
    private Fenetre f;
    
    public LeftsideListener(Fenetre f){
        this.f=f;
    }

    @Override
    public void componentResized(ComponentEvent e) {
        Dimension dimension = ((JComponent)e.getSource()).getSize();
        switch(this.f.getMod()){
            case 0:
                this.f.getInstructions().setPreferredSize(new Dimension(dimension.width,2*dimension.height/3));
                this.f.getCommands().setPreferredSize(new Dimension(dimension.width,dimension.height/3));
                break;
            case 1:
                ((PanelInstruction)this.f.getCommands()).getZoneSaisie().setPreferredSize(new Dimension(dimension.width-40,dimension.height-40));
                ((PanelInstruction)this.f.getCommands()).getZoneSaisie().revalidate();
                break;
        }
        this.f.getLeftSide().revalidate();
        this.f.getCommands().revalidate();
        
    }
}
