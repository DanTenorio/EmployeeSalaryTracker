package com.tenorio.estracker.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.tenorio.estracker.model.ReportBtnModel;
import com.tenorio.estracker.view.ReportBtnView;

public class ReportBtnController
{
    private ReportBtnModel  reportBtnM;
    private ReportBtnView   reportBtnV;
    public ReportBtnController(ReportBtnModel reportBtnM, ReportBtnView reportBtnV)
    {
        this.setReportBtnM(reportBtnM);
        this.setReportBtnV(reportBtnV);
        
        reportBtnV.addGetReportListener(new getReportListener());
    }
    public ReportBtnModel getReportBtnM()
    {
        return reportBtnM;
    }
    public void setReportBtnM(ReportBtnModel reportBtnM)
    {
        this.reportBtnM = reportBtnM;
    }
    public ReportBtnView getReportBtnV()
    {
        return reportBtnV;
    }
    public void setReportBtnV(ReportBtnView reportBtnV)
    {
        this.reportBtnV = reportBtnV;
    }
    
    public class getReportListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            // TODO: Create A dialog to show report
            
            
        }
        
    }

}
