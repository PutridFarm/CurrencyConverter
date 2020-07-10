package com.fdmgroup.CurrencyConverterProject;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Before;
import org.junit.Test;

public class TestCurrencyDBStorage {

	private CurrencyDBStorage dbStorage;
	private Currency curr;
	
	@Before
	public void init()
	{
		dbStorage = new CurrencyDBStorage();
		String dateToParse = "2014-6-10";
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date;
		try {
			date = dateFormat.parse(dateToParse);
			curr = new Currency("USD",1.54,date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testCreate() {
		assertTrue(dbStorage.create(curr));
	}
	
	@Test
	public void testDelete()
	{
		
	}
	
	@Test
	public void testUpdate()
	{
		
	}
	
	@Test
	public void testRead()
	{
		String dateToParse = "2014-01-10";
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date;
		try {
			date = dateFormat.parse(dateToParse);
			Currency newCurr = new Currency("ZZZ",1.04, date);
			dbStorage.create(newCurr);
			Currency readObject = dbStorage.read("ZZZ");
			assertEquals(newCurr.getCurrencyName(), readObject.getCurrencyName());
			assertEquals(newCurr.getExchangeRate(), readObject.getExchangeRate(),0.0);
			assertEquals(newCurr.getCurrentDate(), readObject.getCurrentDate());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
