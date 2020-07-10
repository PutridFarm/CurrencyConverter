package com.fdmgroup.CurrencyConverterProject;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestCurrencyManager {

	private String filename;
	private static CurrencyManager currManager;
	
	@Before
	public void init()
	{
		filename="eurofxref-daily.xml";
		currManager = CurrencyManager.getInstance();
	}
	
	@Test
	public void testReadDailyXML() {
		assertTrue(currManager.readDailyXML(filename));
	}
	
	@Test
	public void testReadDailyXML_Fails() {
		assertFalse(currManager.readDailyXML("filedoesnotexist.txt"));
	}


}
