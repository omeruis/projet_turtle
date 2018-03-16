/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet_ihmv2;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import projet_ihmv2.core.actionListener.ValideOption;

/**
 * Panneau des option lançant l'application
 * @author Baptiste
 */
public class OptionPane extends JFrame {
    private JComboBox taille;
    private JSpinner nbLigne;
    private JSpinner nbColonne;
    private JSpinner posX;
    private JSpinner posY;
    private JComboBox modeChoice;
    private JButton valideOption = new JButton("valider");
    
public OptionPane(){
    
    SpinnerNumberModel modelligne = new SpinnerNumberModel();
        modelligne.setValue(20);
        modelligne.setMinimum(1);
        modelligne.setStepSize(1);
        
    SpinnerNumberModel modelcolonne = new SpinnerNumberModel();
        modelcolonne.setValue(20);
        modelcolonne.setMinimum(1);
        modelcolonne.setStepSize(1);
        
    SpinnerNumberModel modelX = new SpinnerNumberModel();
        modelX.setValue(0);
        modelX.setMinimum(0);
        modelX.setStepSize(1);
        
    SpinnerNumberModel modelY = new SpinnerNumberModel();
        modelY.setValue(0);
        modelY.setMinimum(0);
        modelY.setStepSize(1);
        
    String[] modes = {"novice","expert"};
    String[] tailles = {"560x280","760x380","900x450","1200x600"};
    taille = new JComboBox(tailles);
    nbLigne = new JSpinner(modelligne);
    nbColonne = new JSpinner(modelcolonne);
    posX = new JSpinner(modelX);
    posY = new JSpinner(modelY);
    modeChoice = new JComboBox(modes);
    valideOption.addActionListener(new ValideOption(this,taille,nbLigne,nbColonne,posX,posY,modeChoice));
    
    Box positionPointeur = Box.createHorizontalBox();
    positionPointeur.add(new JLabel("x :"));
    positionPointeur.add(posX);
    positionPointeur.add(new JLabel("y :"));
    positionPointeur.add(posY);
    
    Box display = Box.createVerticalBox();
    display.add(new JLabel("choix de la taille :"));
    display.add(taille);
    display.add(new JLabel("choix du nombre de lignes :"));
    display.add(nbLigne);
    display.add(new JLabel("choix du nombre de colonnes :"));
    display.add(nbColonne);
    display.add(new JLabel("choix de la position initiale du pointeur :"));
    display.add(positionPointeur);
    display.add(new JLabel("choix du mode :"));
    display.add(modeChoice);
    display.add(valideOption);
    
    this.add(display);
    
    this.setVisible(true);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setTitle("choix des options :");
    this.pack();
}

}
