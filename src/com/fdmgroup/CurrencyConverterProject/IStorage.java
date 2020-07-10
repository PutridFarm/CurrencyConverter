package com.fdmgroup.CurrencyConverterProject;

public interface IStorage {
	public DTO read(String recordName);
	public boolean create(Currency record);
	public boolean createHistory(Currency record);
	public int update(Currency oldRecord, Currency newRecord);
	public int delete(Currency record);
}

