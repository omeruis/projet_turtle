/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet_ihmv2.core.actionListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import projet_ihmv2.core.Action;
import projet_ihmv2.core.ColorAble;

/**
 * mode expert : applique les actions ecrites pas l'utilisateur
 * @author Baptiste
 */
public class ActionApply implements ActionListener {
    private JTextArea zoneSaisi; //zone contenant les actions a effectuer
    
    public ActionApply(JTextArea zoneSaisi){
        this.zoneSaisi=zoneSaisi;
    }
    
    public boolean isInteger(String s){
        try{
            Integer.parseInt(s);
        }
        catch(NumberFormatException e){
            return false;
        }
        return true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        //recupere les actions sous forme de liste
        String[] lines = this.zoneSaisi.getText().split("\\n");
        
        Action.INIT.action("");
        this.zoneSaisi.setText("");
        int nbInstruct = lines.length;
        //tests de syntaxe des commandes
        for(String instruct : lines){
            if(instruct.contains("(")&&instruct.contains(")")){
                String[] actionInfo = instruct.split("\\("); //isole le nom de l'action
                String[] actionArg = actionInfo[1].split("\\)"); //isole l'argument de l'action
                if(actionArg.length==1){
                    String arg = actionArg[0];
                    switch(actionInfo[0]){
                        case "GO" :
                            if(isInteger(arg)){
                                Action.GO.action(arg);
                            }
                            break;
                        case "TURN" :
                            if(isInteger(arg)){
                                Action.TURN.action(arg);
                            }
                            break;
                        case "COLOR" :
                            for(ColorAble c : ColorAble.values()){
                                    if(c.name().equals(arg)){
                                        Action.COLOR.action(arg);
                                    }
                                }
                            break;
                        case "DRAW" :
                            if(actionArg[0].equals("on")){
                                Action.DRAW.action("on");
                            }
                            else{
                                if(actionArg[0].equals("off")){
                                    Action.DRAW.action("off");
                                }
                            }
                            break;
                        default :
                            //Si le nom de l'action est inconnu on laisse le choix de la marche a suivre a l'utilisateur
                            int res = JOptionPane.showConfirmDialog(null, "L'action "+instruct+" n'a pas était reconnue.\n "
                                                                            + "Voulais vous continuer ? (cette instruction sera ignorée)\n"
                                                                            + "Annuler effacera completement le dessin.");
                            if(res==JOptionPane.NO_OPTION){
                                return ;
                            }
                            else{
                                if(res==JOptionPane.CANCEL_OPTION){
                                    Action.INIT.action("");
                                    return ;
                                }
                            }
                            break;
                    }
                }
            }
            else{
                //si la syntaxe est incorrecte et que le champ est non vide on laisse le choix de la marche a suivre a l'utilisateur
                if(!instruct.equals("")){
                    int syntaxe = JOptionPane.showConfirmDialog(null, instruct+" n'a pas la bonne syntaxe.\n"
                                                                        + "les instructions sont de la forme ACTION(arg)"
                                                                        + "Voulais vous continuer ? (cette instruction sera ignorée)\n"
                                                                        + "Annuler effacera completement le dessin.");
                    if(syntaxe==JOptionPane.NO_OPTION){
                        return ;
                    }
                    else{
                        if(syntaxe==JOptionPane.CANCEL_OPTION){
                            Action.INIT.action("");
                                    return ;
                        }
                    }
                }
                
            }
        }
    }
    
}
