package com.tenorio.estracker.gbc;

import java.awt.GridBagConstraints;

public class GridBagHelper
{
    private GridBagHelper() {}
    public static GridBagConstraints getTableConstraints()
    {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        return gbc;
    }
    
    public static GridBagConstraints getGetReportConstraints()
    {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.CENTER;
//        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 0;
        return gbc;
    }
    public static GridBagConstraints getEditEmpConstraints()
    {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.CENTER;
//        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 0;
        return gbc;
    }
    public static GridBagConstraints getEnterHoursConstraints()
    {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.CENTER;
//        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 0 ;
        return gbc;
    }
    public static GridBagConstraints getAddEmpConstraints()
    {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 3;
        gbc.anchor = GridBagConstraints.CENTER;
//        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 0 ;
        return gbc;
    }
}
