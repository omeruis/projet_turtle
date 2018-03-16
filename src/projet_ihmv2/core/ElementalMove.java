/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet_ihmv2.core;

/**
 * Mouvements elementaires composants les mouvements plus complexes
 * @author Baptiste
 */
public class ElementalMove {
    private int x;
    private int y;
    public static ElementalMove UP = new ElementalMove(0,-1);
    public static ElementalMove DOWN = new ElementalMove(0,1);
    public static ElementalMove RIGHT = new ElementalMove(1,0);
    public static ElementalMove LEFT = new ElementalMove(-1,0);
    public static ElementalMove UP_RIGHT = new ElementalMove(1,-1);
    public static ElementalMove UP_LEFT = new ElementalMove(-1,-1);
    public static ElementalMove DOWN_RIGHT = new ElementalMove(1,1);
    public static ElementalMove DOWN_LEFT = new ElementalMove(-1,1);
    
    
    public ElementalMove(int x,int y){
        this.x=x;
        this.y=y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    
    
    
    
}
