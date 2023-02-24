package com.tenorio.estracker.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;

import com.tenorio.estracker.view.MenuBarView;

public class MenuBarController {
	private MenuBarView menuBarView;
	private JFileChooser fc = new JFileChooser();
	public MenuBarController(MenuBarView menuBarView){
		this.menuBarView = menuBarView;
		menuBarView.addNewListener(new newFileListener());
		menuBarView.addOpenListener(new openFileListener());
		menuBarView.addSaveListener(new saveFileListener());
	}
	
	class newFileListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e)
		{
			// TODO Auto-generated method stub
			
		}
		
	}
	
	class openFileListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand() == "Open")
			{
				fc.showOpenDialog(menuBarView);					
			}
			
		}
	}
	
	class saveFileListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e)
		{
			// TODO Auto-generated method stub
			
		}
		
	}
	


}
