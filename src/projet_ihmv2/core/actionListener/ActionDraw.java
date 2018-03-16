/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet_ihmv2.core.actionListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import projet_ihmv2.core.Action;

/**
 * mode novice : active et desactive la trace
 * @author Baptiste
 */
public class ActionDraw implements ActionListener {
    private JRadioButton r;
    
    public ActionDraw(JRadioButton r){
        this.r=r;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(r.isSelected()){
            Action.DRAW.action("on");
        }
        else{
            Action.DRAW.action("off");
        }
    }
}
