package com.tenorio.estracker;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Hashtable;

import com.google.gson.Gson;


import com.tenorio.estracker.model.CompanyModel;
import com.tenorio.estracker.model.ESTModel;
import com.tenorio.estracker.model.Employee;

public class TestingGround {
	ESTModel testModel;
	
	
	public static void main(String[] args)
	{
		Hashtable<Integer, Integer[]> htable = new Hashtable<>();
		Integer[] intArray1 = new Integer[10];
		intArray1[0] = 1;
		intArray1[1] = 2;
		htable.put(1, intArray1);
		
		Integer[] intArray1C = htable.get(Integer.valueOf(1));
		intArray1C[0] = 3;
		for(int i = 0; i < 10; i++)
		{
		    System.out.println("Array 1: " + intArray1[i]);
		    System.out.println("Array 1 Copy: " + intArray1C[i]);
		}
	
	}
	
	private static void write(String json, String location) throws IOException
	{
		Writer fileWriter = new FileWriter(location, false);
		fileWriter.write(json);
		fileWriter.close();
	}
	
	@SuppressWarnings("resource")
	private static String read(String location) throws IOException
	{
		FileReader fr = new FileReader(location);
		
		String json = "";
		int i;
		while((i = fr.read()) != -1)
		{
			json+=(char) i;
		}

		return json;
	}
}
