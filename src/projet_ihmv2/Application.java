/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet_ihmv2;

import java.awt.Point;
import projet_ihmv2.core.Core;
import projet_ihmv2.core.Pattern;
import projet_ihmv2.ihm.Fenetre;

/**
 * Fait le lien entre l'interface et le noyau fonctionnel
 * @author Baptiste
 */
public class Application {
    private Core core = new Core();;
    private Fenetre fenetre;
    
    public Application(int size, int nbColonne, int nbLigne,Point positionInit,int mod){
        //Créé l'interface
        this.fenetre = new Fenetre(size,nbColonne,nbLigne,mod);   
        //Initialise le noyau fonctionnel
        core.init(fenetre,Pattern.pattern2(),positionInit);
    }
    
    
    public static void main(String[] arg){
        //Panneau de configuration qui lance l'application
        OptionPane options = new OptionPane();
    }
}
