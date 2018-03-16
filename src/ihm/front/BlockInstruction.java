/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihm.front;

import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import ihm.core.ColorAble;
import ihm.core.actionListener.ActionColor;
import ihm.core.actionListener.ActionDraw;
import ihm.core.actionListener.ActionGo;
import ihm.core.actionListener.ActionTextFieldClean;
import ihm.core.actionListener.ActionTurn;
import ihm.front.ColorPanel;

/**
 * Mode Novice : JPanel contenant les options GO TURN COLOR et DRAW
 * @author Baptiste
 */
public class BlockInstruction extends JPanel {
    private Box instructGo = Box.createHorizontalBox();
    private Box instructTurn = Box.createHorizontalBox();
    private JPanel displayColor = new JPanel();
    private JScrollPane listColor = new JScrollPane(displayColor);
    private JRadioButton draw;
    
    private JTextField nbPas = new JTextField("nb pas");
    private JTextField nbTurn = new JTextField("nb fois");
    private JButton go = new JButton("GO");
    private JButton turn= new JButton("TURN");
    
    
    public BlockInstruction(){
        int h = this.getHeight();
        int w = this.getWidth();
        
        
        instructGo.add(Box.createHorizontalGlue());
        instructGo.add(nbPas);
            nbPas.addMouseListener(new ActionTextFieldClean(nbPas));
        instructGo.add(Box.createHorizontalGlue());
        instructGo.add(go);
        instructGo.add(Box.createHorizontalGlue());
        
        instructTurn.add(Box.createHorizontalGlue());
        instructTurn.add(nbTurn);
            nbTurn.addMouseListener(new ActionTextFieldClean(nbTurn));
        instructTurn.add(Box.createHorizontalGlue());
        instructTurn.add(turn);
        instructTurn.add(Box.createHorizontalGlue());
        
        displayColor.setLayout(new FlowLayout());
        listColor.setViewportView(displayColor);
        
        for(ColorAble c : ColorAble.values()){
            displayColor.add(createColorPanel(c));
        }
        
        this.draw = new JRadioButton("DRAW");
        this.draw.setSelected(true);
        
        this.add(instructGo);
        this.add(instructTurn);
        this.add(listColor);
        listColor.setPreferredSize(new Dimension(60,60));
        
        this.add(draw);
        
        this.setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
        
        
        
        this.go.addActionListener(new ActionGo(this.nbPas));
        this.turn.addActionListener(new ActionTurn(this.nbTurn));
        this.draw.addActionListener(new ActionDraw(this.draw));
    }

    public JRadioButton getDraw() {
        return draw;
    }
    
    
    public JPanel createColorPanel(ColorAble c){
        ColorPanel colorPanel = new ColorPanel(c);
        colorPanel.setPreferredSize(new Dimension(30,30));
        colorPanel.addMouseListener(new ActionColor(colorPanel));
        return colorPanel;
    }
}
