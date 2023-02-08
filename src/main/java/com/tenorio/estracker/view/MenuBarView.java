package com.tenorio.estracker.view;

import javax.swing.*;

public class MenuBarView extends JMenuBar{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8444910908574435199L;
	JMenuBar menuBar;
	protected MenuBarView()
	{
			JMenu file = new JMenu("File");
			add(file);
			
			JMenuItem newFile = new JMenuItem("New");
			file.add(newFile);
			
			JMenuItem openFile = new JMenuItem("Open");
			file.add(openFile);
			
			JMenuItem saveFile = new JMenuItem("Save");
			file.add(saveFile);
	}
}
