/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihm.core;

import java.awt.Component;
import java.awt.Point;
import java.util.ArrayList;
import ihm.front.Fenetre;
import ihm.front.MovePanel;
import ihm.front.BlockInstruction;

/**
 * noyau fonctionnel (ou tortue)
 * @author Baptiste
 */
public class Core {
    //positon initiale de la tortue
    private double posInitX; 
    private double posInitY;
    //positon actuel de la tortue
    private double posX; 
    private double posY;
    private boolean trace; //definie si la trace est active
    private ColorAble actualColor; //couleur de trace actuel
    private Pattern activePattern; //paterne de mouvement actuellement utilise
    private Fenetre frame; //acces a l'interface
    private ArrayList<ActionInfo> history = new ArrayList<>(); //histrorique
    
    //contructeur
    public Core(){
        this.trace=true;
    }
    
    //initialisation des attributs du core (necessite l'existance de l'interface)
    public void init(Fenetre f,Pattern initialPattern,Point positionInit){
        try{
            
            this.frame=f;
            this.posInitX=positionInit.x;
            this.posInitY=positionInit.y;
            this.posX=positionInit.x;
            this.posY=positionInit.y;
            //initialise les attributs de l'interface qui necessites le noyau fonctionnel
            this.frame.initCore(this);
            this.activePattern=initialPattern;
            this.setActualColor(ColorAble.BLACK);
            this.frame.drawActualPattern(this);
            this.frame.drawActualMove(this);
            for(Action a : Action.values()){
                a.setCore(this);
            }
            //affichage de l'interface
            this.frame.setVisible(true);
            this.frame.pack();
        }
        catch(ArrayIndexOutOfBoundsException e){
            
        }
    }
    
    
    //setteurs

    public void setPosX(double posX) {
        this.posX = posX;
    }

    public void setPosY(double posY) {
        this.posY = posY;
    }

    public void setActualColor(ColorAble actualColor) {
        this.actualColor = actualColor;
        this.frame.getCurrentColor().setBackground(actualColor.getColor());
    }

    public void setTrace(boolean trace) {
        if(this.frame.getMod()==0){
            ((BlockInstruction)this.frame.getCommands()).getDraw().setSelected(trace);
        }
        this.trace = trace;
    }
    
    //getteurs

    public double getPosInitX() {
        return posInitX;
    }

    public double getPosInitY() {
        return posInitY;
    }

    public double getPosX() {
        return posX;
    }

    public double getPosY() {
        return posY;
    }

    public boolean isTrace() {
        return trace;
    }

    public ColorAble getActualColor() {
        return actualColor;
    }

    public Pattern getActivePattern() {
        return activePattern;
    }
    
    public Fenetre getFrame(){
        return this.frame;
    }

    public ArrayList<ActionInfo> getHistory() {
        return history;
    }
    
    public String traceActive(){
        if(isTrace()){
            return "on";
        }
        else{
            return "off";
        }
    }
    
    //mouvement de la tortue
    public void moveTurtle(Move m){
        for (ElementalMove em : m.getDeplacements()){
            this.posX=this.posX+em.getX();
            this.posY=this.posY+em.getY();
        }
    }
    
    //redimensionnement de la grille si la tortue en sort
    public void redimensionnement(Move m){
        //sortie par la gauche
        if(this.posX<0){
            //change le nombre de colonnes
            this.frame.setNbColonne(this.frame.getNbColonne()-(int)this.posX);
            for(Component c : this.frame.getDisplay().getComponents()){
                if(c instanceof MovePanel){
                    //chaque dessin deja effectue est decale pour conserver la coherence du dessin
                    ((MovePanel) c).setInitx(((MovePanel) c).getInitx()-this.posX);
                }
            }
            //prositionne la tortue sur le bord (car sinon toujours en dehors de la grille)
            this.posX=0.0;
        }
        //depassement par la droite
        if(this.posX>this.frame.getNbColonne()){
            this.frame.setNbColonne((int)this.posX);
            this.posX=this.frame.getNbColonne();
        }
        //depassement par le dessus
        if(this.posY<0){
            this.frame.setNbLigne(this.frame.getNbLigne()-(int)this.posY);
            for(Component c : this.frame.getDisplay().getComponents()){
                if(c instanceof MovePanel){
                    ((MovePanel) c).setInity(((MovePanel) c).getInity()-this.posY);
                }
            }
            this.posY=0.0;
        }
        //depassement par le dessous
        if(this.posY>this.frame.getNbLigne()){
            this.frame.setNbLigne((int)this.posY);
            this.posY=this.frame.getNbLigne();
        }
    }
    
    //ajout a l'historique d'une ActionInfo
    public void addToHistory(ActionInfo a){
        this.history.add(a);
        this.frame.addToInstructions(a);
    }
    
    //suppression d'une ActionInfo de l'historique
    public void removeFromHistory(ActionInfo a){
        this.history.remove(this.history.size()-1);
        this.frame.removeFromInstructions();
    }
}
