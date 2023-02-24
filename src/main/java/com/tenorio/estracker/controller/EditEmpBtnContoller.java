package com.tenorio.estracker.controller;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.tenorio.estracker.model.EditEmpBtnModel;
import com.tenorio.estracker.view.EditEmpBtnView;

public class EditEmpBtnContoller
{
    private EditEmpBtnModel editEmpBtnM;
    private EditEmpBtnView editEmpBtnV;
    public EditEmpBtnContoller(EditEmpBtnModel editEmpBtnM, EditEmpBtnView editEmpBtnV)
    {
        setEditEmpBtnM(editEmpBtnM);
        setEditEmpBtnV(editEmpBtnV);
        editEmpBtnV.addEditEmployeeListener(new EditEmployeeListener());
    }
    public EditEmpBtnModel getEditEmpBtnM()
    {
        return editEmpBtnM;
    }
    public void setEditEmpBtnM(EditEmpBtnModel editEmpBtnM)
    {
        this.editEmpBtnM = editEmpBtnM;
    }
    public EditEmpBtnView getEditEmpBtnV()
    {
        return editEmpBtnV;
    }
    public void setEditEmpBtnV(EditEmpBtnView editEmpBtnV)
    {
        this.editEmpBtnV = editEmpBtnV;
    }
    
    public class EditEmployeeListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            // TODO Get Selected Employee, Bring up a dialog, Dialog should have Labels and text fields for wage and name
            int selectedRow = editEmpBtnM.getEmpTableV().getEmployeeTable().getSelectedRow();
            System.out.println("Button Edit, row: " + selectedRow);
            if(selectedRow != -1)
            {
                showEditEmployeeDialog(selectedRow);
            } else 
            {
                JDialog noSelectedEmp = new JDialog();
                JLabel noEmpLabel = new JLabel("No Employee Selected");
                noSelectedEmp.add(noEmpLabel);
                noSelectedEmp.setSize(150,100);
                noSelectedEmp.setVisible(true);
                
            }

        }
        
    }
    
    public void showEditEmployeeDialog(int selectedRow)
    {
        JDialog editEmpDlg = new JDialog();
        editEmpDlg.setSize(250, 250);
        GridBagConstraints gbc = new GridBagConstraints();
        editEmpDlg.setLayout(new GridBagLayout());
        String empName = (String)editEmpBtnM.getEmpTableV().getEmployeeTable().getValueAt(selectedRow, 0);
        JLabel empNameLabel = new JLabel("Name");
        JTextField empNameField = new JTextField(empName, 15);
        JButton confirmButton = new JButton("Confirm");
        editEmpDlg.add(empNameLabel, gbc);
        gbc.gridx = 1;
        editEmpDlg.add(empNameField, gbc);
        gbc.gridy = 1;
        editEmpDlg.add(confirmButton,gbc);
        editEmpDlg.setVisible(true);
       
        
    }

}
