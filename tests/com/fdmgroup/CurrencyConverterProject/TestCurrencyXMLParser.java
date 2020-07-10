package com.fdmgroup.CurrencyConverterProject;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

public class TestCurrencyXMLParser {

	CurrencyXMLParser currParser;
	
	@Before
	public void init()
	{
		currParser = new CurrencyXMLParser();
	}
	
	@Test
	public void testParseDailyCurrency() {
		try {
			ArrayList<Currency> list = currParser.parseDailyCurrency("testFile.xml");
			assertFalse(list.isEmpty());
			assertEquals("USD", list.get(0).getCurrencyName());
			assertEquals(1.3547, list.get(0).getExchangeRate(),0.0);
		} catch (ErrorParsingXMLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testParseCurrencyHistory()
	{
		try {
			HashMap<String,ArrayList<Currency>> list = currParser.parseCurrencyHistory("eurofxref-hist-90d.xml");
//			assertFalse(list.isEmpty());
//			assertEquals("USD", list.get(0).getCurrencyName());
//			assertEquals(1.3547, list.get(0).getExchangeRate(),0.0);
		} catch (ErrorParsingXMLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
