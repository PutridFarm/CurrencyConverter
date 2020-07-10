package com.fdmgroup.CurrencyConverterProject;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestConverter {

	private Converter converter;
	private String fromCurr;
	private String toCurr;
	
	@Before
	public void init()
	{
		fromCurr="CAD";
		toCurr="USD";
	}
	
	@Test
	public void testTotal_CAD_To_USD() {
		fromCurr="CAD";
		toCurr="USD";
		converter = new Converter(fromCurr,toCurr);
		assertEquals(0.92,converter.calculateTotal(1.00),0.01);
	}
	
	@Test 
	public void testTotal_CAD_To_EUR()
	{
		toCurr="EUR";
		converter = new Converter(fromCurr,toCurr);
		assertEquals(0.68,converter.calculateTotal(1.00),0.01);
	}
	
	@Test 
	public void testTotal_EUR_To_CAD()
	{
		fromCurr="EUR";
		toCurr="CAD";
		converter = new Converter(fromCurr,toCurr);
		assertEquals(1.48,converter.calculateTotal(1.00),0.01);
	}

}
