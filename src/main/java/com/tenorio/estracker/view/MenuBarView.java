package com.tenorio.estracker.view;

import java.awt.event.ActionListener;

import javax.swing.*;

public class MenuBarView extends JMenuBar{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8444910908574435199L;
	JMenuBar menuBar;
	JFileChooser fc;
	JMenu file;
	final JMenuItem newFile;
	final JMenuItem openFile;
	final JMenuItem saveFile;
	protected MenuBarView()
	{
			file = new JMenu("File");

			fc = new JFileChooser();
			newFile = new JMenuItem("New");

			file.add(newFile);
			
			openFile = new JMenuItem("Open");
			file.add(openFile);
			
			saveFile = new JMenuItem("Save");
			file.add(saveFile);
			
			add(file);
	}
	
	public void addNewListener(ActionListener nal)
	{
		newFile.addActionListener(nal);
	}
	
	public void addOpenListener(ActionListener oal)
	{
		openFile.addActionListener(oal);
	}
	
	public void addSaveListener(ActionListener sal)
	{
		saveFile.addActionListener(sal);
	}
	
	
}
