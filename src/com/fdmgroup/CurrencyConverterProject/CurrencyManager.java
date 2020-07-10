package com.fdmgroup.CurrencyConverterProject;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;
import java.util.Set;

public class CurrencyManager {
	
	private HashMap<String,IStorage> storageTypes;
	private IStorage storage;
	private static CurrencyManager currManager;
	private ArrayList<String> currencyList;
	private Set<String> historyDates;
	
	private CurrencyManager()
	{
		storageTypes = new HashMap<String,IStorage>();
		currencyList = new ArrayList<String>();
		initStorage();
	}
	
	public static CurrencyManager getInstance()
	{
		if(currManager==null)
		{
			currManager = new CurrencyManager();
		}
		return currManager;
	}
	
	private void initStorage()
	{
		storageTypes.put("RAM", new CurrencyRAMStorage());
		//storageTypes.put("DB", new CurrencyDBStorage());

		Properties p = getProperties("storage.properties");

		String  type = p.getProperty("Type");
		
		storage = storageTypes.get(type);
	}

	private Properties getProperties(String filename){

		Properties properties = null;
		FileInputStream fileIS = null;
		
			
		try {
			properties = new Properties();
			System.out.println("fileName" + filename);
			fileIS = new FileInputStream(filename);
			properties.load(fileIS);
			fileIS.close();
		}
		catch(IOException ioe) {
			properties = null;
			ioe.printStackTrace();
		}
		
		return properties;		
	}
	
	public IStorage getStorage()
	{
		return storage;
	}
	
	public ArrayList<String> getCurrencyList()
	{
		return currencyList;
	}
	
	public Currency readCurrency(String currencyName)
	{
		return (Currency) storage.read(currencyName);
	}
	
	public boolean readDailyXML(String filename)
	{
		CurrencyXMLParser parser = new CurrencyXMLParser();
		try {
			ArrayList<Currency> info = parser.parseDailyCurrency(filename);
			for(Currency curr: info)
			{
				if(!storage.create(curr))
					return false;
				currencyList.add(curr.getCurrencyName());
			}
			return true;
		} catch (ErrorParsingXMLException e) {
			return false;
		}
	}
	
	public boolean read90DayXML(String filename)
	{
		CurrencyXMLParser parser = new CurrencyXMLParser();
		try{
			HashMap<String,ArrayList<Currency>> history = parser.parseCurrencyHistory(filename);
			historyDates = history.keySet();
			for(String date:historyDates)
			{
				for(Currency curr:history.get(date))
				{
					if(!storage.createHistory(curr))
					return false;
				}
			}
		}catch (ErrorParsingXMLException e){
			return false;
		}
		return true;
	}
	
	public boolean addCurrency(Currency curr)
	{
		return false;
	}
}
