/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet_ihmv2.core;




/**
 * Mouvements plus complexes composants les paternes de mouvements
 * @author Baptiste
 */
public class Move {
    private ElementalMove[] deplacements;
    
    
    public Move(ElementalMove[] deplacements){
        this.deplacements=deplacements;
    }
    
    public ElementalMove[] getDeplacements(){
        return deplacements;
    }
    
    //definie quelle place prendrais a dessiner le mouvement
    public int[] depassement(int nbMove){
        int[] res = {0,0,0,0}; //minX,maxX,minY,maxY
        int x = 0;
        int y = 0;
        for(int i=0;i<nbMove;i++){
            for(ElementalMove em : this.getDeplacements()){
                x=x+em.getX();
                y=y+em.getY();
                if(x<res[0]){
                    res[0]=x;
                }
                if(x>res[1]){
                    res[1]=x;
                }
                if(y<res[2]){
                    res[2]=y;
                }
                if(y>res[3]){
                    res[3]=y;
                }

            }
        }
        return res;
    }
    
    //mouvements codes en dur
    
    public static Move move1(){
        ElementalMove[] m = {new ElementalMove(3,1),ElementalMove.DOWN,ElementalMove.RIGHT};
        return new Move(m);
    }
    public static Move move2(){
        ElementalMove[] m = {ElementalMove.RIGHT,ElementalMove.RIGHT,ElementalMove.UP};
        return new Move(m);
    }
    public static Move move3(){
        ElementalMove[] m = {ElementalMove.UP,ElementalMove.UP,ElementalMove.LEFT};
        return new Move(m);
    }
    public static Move move4(){
        ElementalMove[] m = {ElementalMove.LEFT,ElementalMove.LEFT,ElementalMove.DOWN,ElementalMove.DOWN_RIGHT,ElementalMove.DOWN_LEFT,ElementalMove.UP_LEFT,ElementalMove.UP_RIGHT,ElementalMove.UP,ElementalMove.UP,ElementalMove.LEFT};
        return new Move(m);
    }
    
    public static Move move5(){
        ElementalMove[] m = {ElementalMove.DOWN_RIGHT,ElementalMove.DOWN_LEFT,ElementalMove.UP_LEFT,ElementalMove.UP_RIGHT};
        return new Move(m);
    }
    
    public static Move move6(){
        ElementalMove[] m = {new ElementalMove(2,1),new ElementalMove(-3,-1),new ElementalMove(1,-2),new ElementalMove(1,1)};
        return new Move(m);
    }
}
