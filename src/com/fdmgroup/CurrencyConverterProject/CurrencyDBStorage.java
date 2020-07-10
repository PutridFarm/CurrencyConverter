package com.fdmgroup.CurrencyConverterProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class CurrencyDBStorage implements IStorage{

	private Connection dbConn;

	public CurrencyDBStorage()
	{
		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			dbConn = DriverManager.getConnection("jdbc:oracle:thin:username/password@oracle.fdmgroup.com:1521:xe", "michaelyoung", "Oracle101");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public boolean create(Currency record) {
		
		String query="INSERT INTO currency (currency_name,exchange_rate,currency_date) VALUES (?,?,?)";
		try {
			PreparedStatement statement = dbConn.prepareStatement(query);
			statement.setString(1, record.getCurrencyName());
			statement.setDouble(2, record.getExchangeRate());
			
			java.util.Date javaDate = record.getCurrentDate();
			java.sql.Date d = new java.sql.Date(javaDate.getTime());
			statement.setDate(3, d);
			if(statement.executeUpdate()==1)
				return true;
			else
				return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Currency read(String currencyName) {
		java.sql.Date date;
		String query="SELECT currency_name, exchange_rate, currency_date FROM currency WHERE currency_name=?";
		try {
			PreparedStatement statement = dbConn.prepareStatement(query);
			
			statement.setString(1, currencyName);
			ResultSet rs = statement.executeQuery();
			while(rs.next())
			{
				String currName = rs.getString(1);
				double exchange_rate = rs.getDouble(2);
				date = rs.getDate(3);
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				try {
					java.util.Date newDate = dateFormat.parse(date.toString());
					return new Currency(currName,exchange_rate,newDate);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public boolean createHistory(Currency record) {
		
		String query="INSERT INTO currency_history (currency_name,exchange_rate,currency_date) VALUES (?,?,?)";
		try {
			PreparedStatement statement = dbConn.prepareStatement(query);
			statement.setString(1, record.getCurrencyName());
			statement.setDouble(2, record.getExchangeRate());
			
			java.util.Date javaDate = record.getCurrentDate();
			java.sql.Date d = new java.sql.Date(javaDate.getTime());
			statement.setDate(3, d);
			if(statement.executeUpdate()==1)
				return true;
			else
				return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public ArrayList<Currency> readHistory(String date)
	{
		ArrayList<Currency> currencyList = new ArrayList<Currency>();
		String query ="SELECT currency_name, exchange_rate, currency_date FROM currency_history WHERE currency_date=?";
		java.sql.Date currDate;
		try{
			PreparedStatement statement = dbConn.prepareStatement(query);
			
			statement.setString(1,date);
			ResultSet rs = statement.executeQuery();
			while(rs.next())
			{
				String currName = rs.getString(1);
				double exchange_rate = rs.getDouble(2);
				currDate = rs.getDate(3);
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				try{
					java.util.Date newDate = dateFormat.parse(currDate.toString());
					currencyList.add(new Currency(currName,exchange_rate,newDate));
				}
				catch (ParseException e){
					e.printStackTrace();
				}
				 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return currencyList;
	}
	
	@Override
	public int update(Currency oldRecord, Currency newRecord) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Currency record) {
		// TODO Auto-generated method stub
		return 0;
	}

}
