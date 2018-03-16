/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet_ihmv2.ihm;

import java.awt.Color;
import java.awt.Dimension;
import java.util.Arrays;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.OverlayLayout;
import projet_ihmv2.core.ActionInfo;
import projet_ihmv2.core.ColorAble;
import projet_ihmv2.core.Core;
import projet_ihmv2.core.Move;
import projet_ihmv2.core.actionListener.ActionApply;
import projet_ihmv2.core.actionListener.ActionInit;
import projet_ihmv2.core.actionListener.ActionQuit;
import projet_ihmv2.core.actionListener.ActionReplay;
import projet_ihmv2.core.actionListener.ActionUndo;
import projet_ihmv2.core.resizeListener.FenetreListener;
import projet_ihmv2.core.resizeListener.LeftsideListener;
import projet_ihmv2.core.resizeListener.RightsideListener;

/**
 *
 * @author Baptiste
 */
public class Fenetre extends JFrame {
    private Core core;
    private final int nbColonneInit;
    private final int nbLigneInit;
    private int nbColonne;
    private int nbLigne;
    
    
    private Box all = Box.createHorizontalBox();
    private Box leftSide = Box.createVerticalBox();
    private Box rightSide= Box.createVerticalBox();
    private Box infoPattern = Box.createHorizontalBox();
    private Box bButtonsUp = Box.createHorizontalBox();
    private Box bButtonsDown = Box.createHorizontalBox();
    
    private JPanel pattern = new JPanel();
    private JPanel currentMotif = new JPanel();
    private JPanel currentColor = new JPanel();
    private JPanel commands;
    private JPanel displayInstructions = new JPanel();
    private JScrollPane instructions = new JScrollPane(displayInstructions);
    private JPanel display = new JPanel();
    private DisplayPanel grid;
    
    private JButton buttonInit = new JButton("INIT");
    private JButton buttonUndo = new JButton("UNDO");
    private JButton buttonReplay = new JButton("REPLAY");
    private JButton buttonQuit = new JButton("QUIT");
    
    private int mod = 0;
    
    
    
    /**
     * Créer l'interface de l'Application, de taille : (2*taille,taille), nbColonne et nbLigne definissent les dimensions de la grille
     * @param taille
     * @param nbColonne
     * @param nbLigne
     * @param mod 0 pour débutant, 1 pour expert
     */
    public Fenetre(int taille,int nbColonne,int nbLigne,int mod){     
        
        this.nbColonneInit=nbColonne;
        this.nbLigneInit=nbLigne;
        this.nbColonne=nbColonne;
        this.nbLigne=nbLigne;
        this.mod=mod;
        
        //Center
        
        
        //rightSide
        
        rightSide.add(pattern);
            pattern.setLayout(new OverlayLayout(pattern));
            pattern.setBorder(BorderFactory.createLineBorder(Color.black));
        rightSide.add(infoPattern);
            infoPattern.add(currentMotif);
                currentMotif.setLayout(new OverlayLayout(currentMotif));
                currentMotif.setBorder(BorderFactory.createLineBorder(Color.black));
            infoPattern.add(currentColor);
                currentColor.setBorder(BorderFactory.createLineBorder(Color.black));
        rightSide.add(bButtonsUp);
            bButtonsUp.add(buttonInit);   
                buttonInit.addActionListener(new ActionInit());
            bButtonsUp.add(buttonUndo);
                buttonUndo.addActionListener(new ActionUndo());
        rightSide.add(bButtonsDown);
            bButtonsDown.add(buttonReplay);
            bButtonsDown.add(buttonQuit);
                buttonQuit.addActionListener(new ActionQuit(this));
            
            
          
        
        //leftSide
        
        
        
        switch(this.mod){
            case 0 :
                
            leftSide.add(instructions);
                instructions.setViewportView(displayInstructions);
                    displayInstructions.setLayout(new BoxLayout(displayInstructions,BoxLayout.PAGE_AXIS));
                
                
                this.commands= new BlockInstruction();
                break;
                
            case 1 :
                this.commands=new PanelInstruction();
                break;
                
            default :
                JOptionPane.showMessageDialog(this, "Mode non supporté. L'application va se fermer");
                System.exit(0);
                break;
        }
        leftSide.add(commands);
        leftSide.setBorder(BorderFactory.createLineBorder(Color.black));
        
        
        //all
        
        all.add(leftSide);
        leftSide.setPreferredSize(new Dimension(taille/2,taille));
        
        all.add(display);
            display.setLayout(new OverlayLayout(display));
            display.setBorder(BorderFactory.createLineBorder(Color.black));
            display.setPreferredSize(new Dimension(taille,taille));
        
        all.add(rightSide);
        rightSide.setPreferredSize(new Dimension(taille/2,taille));
        rightSide.addComponentListener(new RightsideListener(this));
        leftSide.addComponentListener(new LeftsideListener(this));
        this.addComponentListener(new FenetreListener(this));
        
        //Fenetre and display
        
        this.add(all);
        this.setPreferredSize(new Dimension(2*taille,taille));
        this.setTitle("Application Turtue ihm");
        
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public int getNbColonne() {
        return nbColonne;
    }

    public int getNbLigne() {
        return nbLigne;
    }

    public void setNbColonne(int nbColonne) {
        this.nbColonne = nbColonne;
        this.grid.setNbDivisionX(nbColonne);
    }

    public void setNbLigne(int nbLigne) {
        this.nbLigne = nbLigne;
        this.grid.setNbDivisionY(nbLigne);
    }
    
    public JButton getButtonInit() {
        return buttonInit;
    }

    public JButton getButtonUndo() {
        return buttonUndo;
    }

    public JButton getButtonReplay() {
        return buttonReplay;
    }
    

    public int getMod() {
        return mod;
    }

    public int getNbColonneInit() {
        return nbColonneInit;
    }

    public int getNbLigneInit() {
        return nbLigneInit;
    }


    public Box getLeftSide() {
        return leftSide;
    }
        public JPanel getCommands() {
            return commands;
        }
        public JPanel getDisplayInstructions() {
            return displayInstructions;
        }
        public JScrollPane getInstructions() {
            return instructions;
        }
    
    public DisplayPanel getGrid(){
        return grid;
    }
        public JPanel getDisplay(){
            return display;
        }

    public Box getRightSide() {
        return rightSide;
    }
        public JPanel getCurrentMotif() {
            return currentMotif;
        }
        public JPanel getCurrentColor() {
            return currentColor;
        }
        public Box getInfoPattern() {
            return infoPattern;
        }
        

    public JPanel getPattern() {
        return pattern;
    }
    
    
    
    
    public void initCore(Core core){
        this.core=core;
        this.grid = new DisplayPanel(this.nbColonne,this.nbLigne,this.core);
        display.add(grid);
        buttonReplay.addActionListener(new ActionReplay(this.core));
    }
    
    
    public void tracer(Move m,double x,double y,ColorAble c){
        this.display.add(new MovePanel(m,this.core,c));
        
    }

    public void addToInstructions(ActionInfo a) {
        switch(this.mod){
            case 0 :
                this.displayInstructions.add(new JLabel(a.getAction().toString()+"("+a.getArg()+")"));
                break;
            case 1 :
                String text = ((PanelInstruction)this.commands).getZoneSaisie().getText();
                StringBuilder builder = new StringBuilder();
                builder.append(text);
                if(!text.equals("")){
                    builder.append("\n");
                }
                builder.append(a.getAction().toString()+"("+a.getArg()+")");
                ((PanelInstruction)this.commands).getZoneSaisie().setText(builder.toString());
        }
        
    }
    
    public void removeFromInstructions(){
        switch(this.mod){
            case 0 :
                this.displayInstructions.remove(this.displayInstructions.getComponentCount()-1);
                break;
            case 1 :
                String[] lines = ((PanelInstruction)this.commands).getZoneSaisie().getText().split("\\n");
                StringBuilder builder = new StringBuilder();
                int i=0;
                lines[lines.length-1]="";
                while(lines[i]!=""){
                    builder.append(lines[i]);
                    builder.append("\n");
                    i++;
                }
                ((PanelInstruction)this.commands).getZoneSaisie().setText(builder.toString());
        }
    }

    public void drawActualPattern(Core core) {
        this.pattern.add(new ActualPatternPanel(core));
    }

    public void drawActualMove(Core core) {
        this.currentMotif.add(new ActualMovePanel(core));
    }
    
}
