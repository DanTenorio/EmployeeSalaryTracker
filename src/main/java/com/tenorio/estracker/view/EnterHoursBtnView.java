package com.tenorio.estracker.view;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;

import com.tenorio.estracker.model.EnterHoursBtnModel;

public class EnterHoursBtnView extends JPanel
{

    /**
     * 
     */
    private static final long serialVersionUID = -4522496965487515947L;
    
    private JButton enterHrsBtn;
    private EnterHoursBtnModel enterHrsBtnM;

    public EnterHoursBtnView(EnterHoursBtnModel enterHrsBtnM) {
        this.setEnterHrsBtnM(enterHrsBtnM);
        Border blackline = BorderFactory.createLineBorder(Color.black);
        setBorder(blackline);
        setLayout(new GridBagLayout());
        enterHrsBtn = new JButton("Enter Hours");
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(enterHrsBtn, gbc);
    }
    
    public void addEnterHoursListener(ActionListener ehl)
    {
        enterHrsBtn.addActionListener(ehl);
    }

    public EnterHoursBtnModel getEnterHrsBtnM()
    {
        return enterHrsBtnM;
    }

    public void setEnterHrsBtnM(EnterHoursBtnModel enterHrsBtnM)
    {
        this.enterHrsBtnM = enterHrsBtnM;
    }
}
