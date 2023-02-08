package com.tenorio.estracker;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import com.google.gson.Gson;

import com.tenorio.estracker.model.Company;
import com.tenorio.estracker.model.ESTModel;
import com.tenorio.estracker.model.Employee;

public class TestingGround {
	ESTModel testModel;
	
	
	public static void main(String[] args)
	{
		Gson gson = new Gson();
		
		ESTModel createTestModel = new ESTModel("Vega Constructions");
		Company company = createTestModel.getCompany();
		Employee e1 = new Employee("Fran", 20);
		company.addEmployee(e1);
		String json = gson.toJson(createTestModel);
		String fileLocation = "./info/VegaConstruction.json";
		
		try {
			write(json, fileLocation);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			String json2 = read(fileLocation);
			System.out.println(json2 + "\n That was json2");
		} catch(IOException e)
		{
			e.printStackTrace();
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
