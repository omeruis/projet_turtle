/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet_ihmv2.core;

/**
 * informations stockages dans l'historique de l'application
 * @author Baptiste
 */
public class ActionInfo {
    private Action action; //nom de l'action
    private String arg; //argument passe a l'action
    private String prec; //etat precedent necessaire au UNDO
    
    
    //constructeur
    public ActionInfo(Action action,String arg, String prec){
        this.action=action;
        this.arg=arg;
        this.prec=prec;
    }
    
    //getteurs

    public Action getAction() {
        return action;
    }
        
    public String getArg(){
        return this.arg;
    }

    public String getPrec() {
        return prec;
    }
    
}
