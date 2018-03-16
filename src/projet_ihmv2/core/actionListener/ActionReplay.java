/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet_ihmv2.core.actionListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.SwingUtilities;
import projet_ihmv2.core.Action;
import projet_ihmv2.core.ActionInfo;
import projet_ihmv2.core.Core;

/**
 * tout les modes : rejoue le dessin
 * @author Baptiste
 */
public class ActionReplay implements ActionListener {
    private boolean running = false;
    private Core core;
    private ArrayList<ActionInfo> history;
    
    public ActionReplay(Core core){
        this.core=core;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        //thread rejouant le dessin
        Thread n = new Thread(){
            @Override
            public void run() {
                ActionReplay.this.setHistory();
                //bloque les boutons les plus problematiques
                ActionReplay.this.setEnableButton(false);
                Action.INIT.action("");
                //rejoue les actions de l'historique
                while(!(ActionReplay.this.history.isEmpty())){
                    ActionInfo a = ActionReplay.this.history.get(0);
                    try{
                        //si l'action est un GO
                        if(a.getAction().equals(Action.GO)){
                            Thread.sleep(500);
                        }
                    }
                    catch(InterruptedException excep){
                    }
                    SwingUtilities.invokeLater(new Runnable(){
                        @Override
                        public void run() {
                            a.getAction().action(a.getArg()); //dessin
                    }
                    });
                    history.remove(0);
                }
                //reactive les boutons
                ActionReplay.this.setEnableButton(true);
                ActionReplay.this.running=false;
            }

        };
        if(!this.running){
            n.start();
            this.running=true;
        }
    }
    
    //copie l'historique
    public ArrayList<ActionInfo> copy(ArrayList<ActionInfo> l){
        ArrayList<ActionInfo> res = new ArrayList<>();
        for(int i=0;i<l.size();i++){
        res.add(l.get(i));
        }
        return res;
    }
    
    //l'attribut history devient une copie de l'historique
    public void setHistory(){
        this.history=copy(core.getHistory());
    }
    
    public void setEnableButton(boolean b){
        this.core.getFrame().getButtonInit().setEnabled(b);
        this.core.getFrame().getButtonUndo().setEnabled(b);
        this.core.getFrame().getButtonReplay().setEnabled(b);
    }
    
}
