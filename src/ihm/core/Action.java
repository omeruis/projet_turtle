/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihm.core;

import javax.swing.JOptionPane;


/**
 * liste et effet des actions disponibles
 * @author Baptiste
 */
public enum Action {
    GO {
        public void action(String str){
            try{
                //str indique le nombre de fois qu'il faut effectuer l'action
                int y = Integer.parseInt(str);
                //Ajout à l'historique
                super.core.addToHistory(new ActionInfo(Action.GO,str,""));
                //Récupére le mouvement actuel
                Move m = super.core.getActivePattern().getActualMove();
                //Pour chaque pas a effectuer
                for (int i =0 ;i<y;i++){
                    //Si la trace est active
                    if(super.core.isTrace()){
                        //On trace avec la couleur actuelle
                        super.core.getFrame().tracer(m,super.core.getPosX(),super.core.getPosY(),super.core.getActualColor());
                    }
                    //La tortue se déplace en accord avec le mouvement
                    super.core.moveTurtle(m);
                }
                //Si la tortue sort de la grille on redimmensionne celle-ci
                super.core.redimensionnement(m);
                //On rafraichie l'interface (affichage de l'historique et dessin)
                refreshHistoryDisplay();
                refreshDrawDisplay();
                
                //refresh();
                
            }
            //On ne fait rien le le paramêtre n'a pas le non type
            catch(NumberFormatException e){
            }
        }
    },
    TURN{
        public void action(String str){
            try{
                //str indique le nombre de fois qu'il faut effectuer l'action
                int y = Integer.parseInt(str);
                //pour chaque fois qu'il faut tourner
                for (int i =0 ;i<y;i++){
                    //passe au mouvement sivant
                    super.core.getActivePattern().nextMove();
                    //repeint l'affichage du motif actuel
                    super.core.getFrame().getCurrentMotif().repaint();
                }
                //ajout a l'historique
                super.core.addToHistory(new ActionInfo(Action.TURN,str,""));
                //rafraichie l'affichage de l'historique
                refreshHistoryDisplay();
            }
            catch(NumberFormatException e){
            }
        }
    },
    DRAW{
        public void action(String str){
            //ajout a l'historique
            super.core.addToHistory(new ActionInfo(Action.DRAW,str,super.core.traceActive()));
            //str definit si la trace est active ou non
            if(str.equals("on")){
                super.core.setTrace(true);
            }
            else{
                if(str.equals("off")){
                    super.core.setTrace(false);
                }
                else{
                    //si str ne convient pas rien n'est fait
                }
            }
        }
    },
    COLOR{
        public void action(String str){
            //ajout a l'historique
            super.core.addToHistory(new ActionInfo(Action.COLOR,str,super.core.getActualColor().toString()));
            //recherche de la couleur correspondante
            for(ColorAble c : ColorAble.values()){
                if(c.toString().equals(str)){
                    super.core.setActualColor(c);
                }
            }
            //rafraichie l'affichage de la couleur actuelle
            super.core.getFrame().getCurrentColor().repaint();
            //rafraichie l'historique
            refreshHistoryDisplay();
        }
    },
    UNDO{
        public void action(String str){
            try{
                //recupere la taille de l'historique
                int historySize = super.core.getHistory().size();
                //recupere la derniere action effectue (ArrayIndexOutOfBoundsException si historique vide)
                ActionInfo lastAction = super.core.getHistory().get(historySize-1);
                //etude de la derniere action
                switch(lastAction.getAction().toString()){
                    case "GO" :
                        //recupere le nombre de pas effectue
                        int nbGo = Integer.parseInt(lastAction.getArg());
                        for(int j=0;j<nbGo;j++){
                            //si trace active (la trace n'a pas ete modifie car GO est la derniere action)
                            if(super.core.isTrace()){
                                super.core.getFrame().getDisplay().remove(super.core.getFrame().getDisplay().getComponentCount()-1);
                            }
                            //replace la tortue a sa position precedente
                            double x=super.core.getPosX();
                            double y=super.core.getPosY();
                            for(ElementalMove m : super.core.getActivePattern().getActualMove().getDeplacements()){
                                x=x-m.getX();
                                y=y-m.getY();
                            }
                            super.core.setPosX(x);
                            super.core.setPosY(y);
                        }

                        break;

                    case "TURN" :
                        int nbTurn = Integer.parseInt(lastAction.getArg());
                        for(int i=0;i<nbTurn;i++){
                            super.core.getActivePattern().previousMove();
                        }
                        break;

                    case "DRAW" :
                        if(lastAction.getPrec().equals("on")){
                            super.core.setTrace(true);
                        }
                        else{
                            super.core.setTrace(false);
                        }
                        break;

                    case "COLOR" :
                        for(ColorAble c : ColorAble.values()){
                            if(lastAction.getPrec().equals(c.toString())){
                                super.core.setActualColor(c);
                            }
                        }
                        break;
                    default :
                        //si aucune action ne correspond l'historique est corrompu
                        JOptionPane.showMessageDialog(null, "Historique corrompu, l'application va se fermer");
                        //fermeture de l'application
                        System.exit(0);
                        break;
                    }
                //on retire l'action annulee
                super.core.removeFromHistory(lastAction);
            }
            catch(ArrayIndexOutOfBoundsException e){
            }
            //rafraichissement global
            refresh();
        }
    },
    INIT{
        public void action(String str){
            //UNDO chaques actions de l'historique
            while(!(super.core.getHistory().isEmpty())){
                this.UNDO.action("");
            }
            //reinitialise la position de la tortue et taille de la grille (necessaire dû au redimensionnement eventuel)
            super.core.setPosX(super.core.getPosInitX());
            super.core.setPosY(super.core.getPosInitY());
            super.core.getFrame().setNbColonne(super.core.getFrame().getNbColonneInit());
            super.core.getFrame().setNbLigne(super.core.getFrame().getNbLigneInit());
            //rafraichissement global
            refresh();
        }
    };
    
    //donne acces au noyau fonctionnel
    private Core core;
    
    //constructeur
    Action(){
    }
    
    //rafraichissment globale
    public void refresh(){
        this.core.getFrame().revalidate();
        this.core.getFrame().repaint();
    }
    
    //rafraichie le dessin
    public void refreshDrawDisplay(){
        this.core.getFrame().getDisplay().repaint();
        this.core.getFrame().getDisplay().revalidate();
    }
    
    //rafraichie l'historique
    public void refreshHistoryDisplay(){
        this.core.getFrame().getDisplayInstructions().revalidate();
    }
    
    public abstract void action(String str);
    
    public void setCore(Core core){
        this.core=core;
    };
    
    
}
