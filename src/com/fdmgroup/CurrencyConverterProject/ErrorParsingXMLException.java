package com.fdmgroup.CurrencyConverterProject;

@SuppressWarnings("serial")
public class ErrorParsingXMLException extends Exception{
	
	private String message;
	
	public ErrorParsingXMLException(String message)
	{
		this.message = message;
	}
	
	public String getMessage()
	{
		return message;
	}
}
