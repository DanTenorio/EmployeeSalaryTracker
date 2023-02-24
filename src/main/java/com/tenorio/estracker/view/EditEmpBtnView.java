package com.tenorio.estracker.view;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;

import com.tenorio.estracker.model.EditEmpBtnModel;

public class EditEmpBtnView extends JPanel
{

    /**
     * 
     */
    private static final long serialVersionUID = 4994706947659306669L;
    EditEmpBtnModel editEmpBtnM;
    JButton editEmpBtn;
    private JFrame parentFrame;
    public EditEmpBtnView(EditEmpBtnModel editEmpBtnM, JFrame parent)
    {
        Border blackline = BorderFactory.createLineBorder(Color.black);
        setBorder(blackline);
        setLayout(new GridBagLayout());
        this.editEmpBtnM = editEmpBtnM;
        this.setParentFrame(parent);
        editEmpBtn = new JButton("Edit Employee");
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(editEmpBtn, gbc);
    }
    
    public void addEditEmployeeListener(ActionListener eel)
    {
        editEmpBtn.addActionListener(eel);
    }

    public JFrame getParentFrame()
    {
        return parentFrame;
    }

    public void setParentFrame(JFrame parentFrame)
    {
        this.parentFrame = parentFrame;
    }
}
