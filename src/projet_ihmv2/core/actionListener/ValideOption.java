/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet_ihmv2.core.actionListener;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import projet_ihmv2.Application;
import projet_ihmv2.OptionPane;

/**
 * Valides les options passees en parametres dans le panneau des options
 * @author Baptiste
 */
public class ValideOption implements ActionListener {
    private OptionPane OptionPane;
    private JComboBox taille;
    private JSpinner nbLigne;
    private JSpinner nbColonne;
    private JSpinner posX;
    private JSpinner posY;
    private JComboBox modeChoice;
    
    public ValideOption(OptionPane optionPane,JComboBox taille,JSpinner nbLigne,JSpinner nbColonne,JSpinner posX,JSpinner posY,JComboBox modeChoice){
        this.OptionPane=optionPane;
        this.taille=taille;
        this.nbLigne=nbLigne;
        this.nbColonne=nbColonne;
        this.posX=posX;
        this.posY=posY;
        this.modeChoice=modeChoice;
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            int argTaille = Integer.parseInt(((String)taille.getSelectedItem()).split("x")[1]);
            int argnbLigne = (int)nbLigne.getValue();
            int argnbColonne = (int)nbColonne.getValue();
            int argposX = (int)posX.getValue();
            int argposY = argnbLigne-(int)posY.getValue();
            String mode = (String)modeChoice.getSelectedItem();
            int argMode=0;
            if(mode.equals("novice")){
                argMode=0;
            }
            else{
                if(mode.equals("expert")){
                    argMode=1;
                }
            }
            if((argposX<=argnbColonne)||(argposY<=argnbLigne)){
                Application turtle = new Application(argTaille,argnbColonne,argnbLigne,new Point(argposX,argposY),argMode);
                this.OptionPane.dispose();
            }
            else{
                JOptionPane d = new JOptionPane();
                d.showMessageDialog( null, "La position initiale n'appartient pas à la grille.", 
                      "Erreur argument position initiale", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        catch(NumberFormatException error){
            
        }
        
    }
    
}
