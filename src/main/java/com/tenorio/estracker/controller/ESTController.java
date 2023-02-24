package com.tenorio.estracker.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.tenorio.estracker.model.ESTModel;
import com.tenorio.estracker.view.ESTView;

public class ESTController
{
	ESTView estView;
	ESTModel estModel;
	public ESTController(ESTView estView, ESTModel estModel)
	{
		this.estView = estView;
		this.estModel = estModel;
	}
	class getReportListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e)
        {
            // TODO Auto-generated method stub
            
        }
	    
	}
	
	class editEmployeeListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e)
        {
            // TODO Auto-generated method stub
            
        }
	    
	}
	
	class enterWagesListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e)
        {
            // TODO Auto-generated method stub
            
        }
	    
	}
	
}
