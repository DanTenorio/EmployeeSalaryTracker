package com.tenorio.estracker.view;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;

import com.tenorio.estracker.model.ReportBtnModel;

public class ReportBtnView extends JPanel
{

    /**
     * 
     */
    private static final long serialVersionUID = 5759645690542417640L;
    
    JButton getReportBtn;
    ReportBtnModel reportBtnM;
    
    public ReportBtnView(ReportBtnModel reportBtnM)
    {
        Border blackline = BorderFactory.createLineBorder(Color.black);
        setBorder(blackline);
        setLayout(new GridBagLayout());
        this.reportBtnM = reportBtnM;
        getReportBtn = new JButton("Get Report");
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(getReportBtn, gbc);
    }
    
    public void addGetReportListener(ActionListener grl)
    {
        getReportBtn.addActionListener(grl);
    }
}
