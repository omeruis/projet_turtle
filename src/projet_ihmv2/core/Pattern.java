/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet_ihmv2.core;

import projet_ihmv2.core.Move;

/**
 * paternes de mouvements
 * @author Baptiste
 */
public class Pattern {
    private Move[] pattern;
    private int actualMove; //definie l'indice du mouvement actuel dans le tableau pattern
    
    public Pattern(Move[] paterne){
        this.pattern=paterne;
        this.actualMove=0;
    }
    
    //mouvement suivant
    public void nextMove(){
        if(this.actualMove==this.pattern.length-1){
            this.actualMove=0;
        }
        else{
            this.actualMove=this.actualMove+1;
        }
    }
    
    //mouvement precedent
    public void previousMove(){
        if(this.actualMove==0){
            this.actualMove=this.pattern.length-1;
        }
        else{
            this.actualMove=this.actualMove-1;
        }
    }
    
    public Move getActualMove(){
        return this.pattern[this.actualMove];
    }
    
    public Move[] getMoves(){
        return this.pattern;
    }
    
    //paternes codes en dur
    
    public static Pattern pattern1(){
        Move[] m = {Move.move1(),Move.move2(),Move.move3(),Move.move4(),Move.move5()};
        return new Pattern(m);
    }
    
    public static Pattern pattern2(){
        Move[] m = {Move.move1(),Move.move6(),Move.move5(),Move.move3(),Move.move2()};
        return new Pattern(m);
    }
    
}
