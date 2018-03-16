/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet_ihmv2.core;

import java.awt.Color;

/**
 * liste des couleurs disponibles
 * @author Baptiste
 */
public enum ColorAble {
    BLACK(Color.BLACK),
    BLUE(Color.BLUE),
    CYAN(Color.CYAN),
    MAGENTA(Color.MAGENTA),
    RED(Color.RED),
    YELLOW(Color.YELLOW),
    PINK(Color.PINK),
    GRAY(Color.GRAY),
    GREEN(Color.GREEN);
    
    //constructeur
    ColorAble(Color c){
        this.color=c;
    }
    
    private Color color;
    
    public Color getColor(){
        return this.color;
    }
    
    //change la couleur actuel a la couleur suivante (quand on n'a pas besoin d'une couleur precise)
    public ColorAble nextColor(){
        int ind=-1;
        for(int i=0;i<ColorAble.values().length-1;i++){
            if(ColorAble.values()[i].toString().equals(this.toString())){
                ind=i+1;
            }
        }
        if(ind==-1){
            ind=0;
        }
        return ColorAble.values()[ind];
    }
}
