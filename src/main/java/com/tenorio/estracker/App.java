package com.tenorio.estracker;

import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.swing.*;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.tenorio.estracker.controller.ESTController;
import com.tenorio.estracker.model.ESTModel;
import com.tenorio.estracker.view.ESTView;



/**
 * Hello world!
 *
 */
public class App 
{
	private static void createAndShowGUI() throws JsonSyntaxException, JsonIOException, FileNotFoundException
	{
//		Gson gson = new Gson();
//		ESTModel testModel = gson.fromJson(new FileReader("./info/VegaConstruction.json"), ESTModel.class);
//		System.out.println(testModel);
		//Create and set up the window.
        ESTModel 		estModel 		= new ESTModel();
        ESTView 		estView 		= new ESTView(estModel);
        @SuppressWarnings("unused")
		ESTController 	estController 	= new ESTController(estView, estModel);
        
        estView.setVisible(true);
        
	}
	
    public static void main( String[] args )
    {
        System.out.println( "Swing Testing" );
        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        SwingUtilities.invokeLater(
        		new Runnable() {
        			public void run() 
        			{
		                //Turn off metal's use of bold fonts
				        UIManager.put("swing.boldMetal", Boolean.FALSE);
				        try {
							createAndShowGUI();
						} catch (JsonSyntaxException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (JsonIOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
        			}
        		});
    }
}
