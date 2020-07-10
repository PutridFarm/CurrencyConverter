package com.fdmgroup.CurrencyConverterProject;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class CurrencyXMLParser {
	private DocumentBuilderFactory dbf;
	private DocumentBuilder db;
	private Document parseDoc;
	
	public CurrencyXMLParser()
	{
		dbf = DocumentBuilderFactory.newInstance();	
		dbf.setNamespaceAware(true);
	}
	
	public ArrayList<Currency> parseDailyCurrency(String filename) throws ErrorParsingXMLException
	{
		ArrayList<Currency> currList = new ArrayList<Currency>();
		
		try {
			db = dbf.newDocumentBuilder();
			parseDoc = db.parse(new File(filename));
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		//System.out.println(parseDoc.getElementById("Cube").getAttribute("time"));
		NodeList list = parseDoc.getElementsByTagName("Cube");
		if(list.getLength() !=0)
		{
			//Parse time Cube
			Node root = list.item(1);
			NamedNodeMap rootAttributes = root.getAttributes();
			String cubeDate = rootAttributes.item(0).getNodeValue();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

			try {
				Date date = dateFormat.parse(cubeDate);
				//Parse each currency and exchange rate
				for(int i=2;i<list.getLength();i++)
				{
					Node n = list.item(i);
					NamedNodeMap attributes = n.getAttributes();
					String currName = attributes.item(0).getNodeValue();
					String currExRate = attributes.item(1).getNodeValue();
					//currList.add(new Currency(currName,Double.parseDouble(currExRate),date));
					System.out.println("currency: " + currName + ":  rate: " + currExRate);
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		else
		{
			throw new ErrorParsingXMLException("There was an error parsing the XML file. Please ensure the file is in the correct format according to the European Central Bank guidelines.");
		}
			
			
		return currList;
	}
	
	public HashMap<String,ArrayList<Currency>> parseCurrencyHistory(String filename) throws ErrorParsingXMLException
	{
		HashMap<String, ArrayList<Currency>> currList = new HashMap<String,ArrayList<Currency>>();
		
		try {
			db = dbf.newDocumentBuilder();
			parseDoc = db.parse(new File(filename));
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		//System.out.println(parseDoc.getElementById("Cube").getAttribute("time"));
		NodeList list = parseDoc.getElementsByTagName("Cube");
		NodeList nodeList = list.item(0).getChildNodes();
		if(list.getLength() !=0)
		{
			//Parse time Cube
			Node root = nodeList.item(1).getNextSibling();
			NamedNodeMap rootAttributes = root.getAttributes();
			String cubeDate = rootAttributes.item(0).getNodeValue();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			System.out.println("cube date: " + cubeDate);
			
			try {
				Date date = dateFormat.parse(cubeDate);	
				//Parse each currency and exchange rate

				for(int i=1;i<list.getLength();i++)
				{
					Node n = nodeList.item(i);
					NamedNodeMap attributes = n.getAttributes();
					String currName = attributes.item(0).getNodeValue();
					String currExRate = attributes.item(1).getNodeValue();
					//currList.add(new Currency(currName,Double.parseDouble(currExRate),date));
					System.out.println("currency: " + currName + ":  rate: " + currExRate);
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			//Parse time Cube
			root = list.item(2);
			rootAttributes = root.getAttributes();
			cubeDate = rootAttributes.item(0).getNodeValue();
			dateFormat = new SimpleDateFormat("yyyy-MM-dd");

			try {
				Date date = dateFormat.parse(cubeDate);	
				//Parse each currency and exchange rate
				for(int i=2;i<list.getLength();i++)
				{
					Node n = list.item(i);
					NamedNodeMap attributes = n.getAttributes();
					String currName = attributes.item(0).getNodeValue();
					String currExRate = attributes.item(1).getNodeValue();
					//currList.add(new Currency(currName,Double.parseDouble(currExRate),date));
					System.out.println("currency: " + currName + ":  rate: " + currExRate);
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		else
		{
			throw new ErrorParsingXMLException("There was an error parsing the XML file. Please ensure the file is in the correct format according to the European Central Bank guidelines.");
		}
			
			
		return currList;
	}
}
