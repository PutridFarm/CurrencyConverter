package com.fdmgroup.CurrencyConverterProject;

public class Converter {

	private double fromExchangeRate;
	private double toExchangeRate;
	private CurrencyManager currManager;
	
	public Converter(String fromCurr, String toCurr)
	{
		currManager = CurrencyManager.getInstance();
		assignCurrencies(fromCurr,toCurr);
	}
	
	public double calculateTotal(double fromCurrAmt)
	{
		return (fromCurrAmt/fromExchangeRate)*toExchangeRate;
	}
	
	//Finish this
	private void assignCurrencies(String fromCurr, String toCurr)
	{
		if(fromCurr.equals("EUR"))
			fromExchangeRate = 1.00;
		else
		{
			fromExchangeRate = currManager.readCurrency(fromCurr).getExchangeRate();
		}
			
		
		if(toCurr.equals("EUR"))
			toExchangeRate = 1.00;
		else
			toExchangeRate = currManager.readCurrency(toCurr).getExchangeRate();
	}
}
