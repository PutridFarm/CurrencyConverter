package com.fdmgroup.CurrencyConverterProject;

import java.util.Date;

public class Currency implements DTO{

	private String currencyName;
	private double exchangeRate;
	private Date currentDate;
	
	public Currency()
	{
		super();
	}
	
	public Currency(String currName, double exRate, Date date)
	{
		this.currencyName = currName;
		this.exchangeRate = exRate;
		this.currentDate = date;
	}
	
	public String getCurrencyName()
	{
		return currencyName;
	}

	public double getExchangeRate()
	{
		return exchangeRate;
	}
	
	public Date getCurrentDate()
	{
		return currentDate;
	}
	
	public void setCurrencyName(String value)
	{
		this.currencyName = value;
	}
	
	public void setExchangeRate(double value)
	{
		this.exchangeRate = value;
	}
	
	public void setCurrentDate(Date value)
	{
		this.currentDate = value;
	}
}
