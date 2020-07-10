<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Currency Converter</title>
<link rel="stylesheet" type="text/css" href="stylesheet.css" />
</head>
<body>
	<h1> Welcome to the Currency Converter
	</h1>
	<div id="content">
		<p>Choose the types of currencies you wish to convert and the amount.</p>
	</div>
	
	<form id="form1" method="post" action=convert>
		From: 
		<select name="type">
			<c:forEach var="currency" items="${currency_types }">				
				<option value=${currency }>${currency }</option>
			</c:forEach>
		</select>
			<input type="text" size="10" name="fromCurrency" id="fromCurrency"/>
		<br/>
		To: 
		<select name="type">
			<c:forEach var="currency" items="${currency_types }">
				<option value=${currency }>${currency }</option>
			</c:forEach>
		</select>
		<input type="text" size="10" name="toCurrency" id="toCurrency" value='${total}'/>
		<br/>
		<Button id="convert_button" class="button" onclick="" onmouseover="mouseOverButton(this);" onmouseout="mouseOutButton(this);">Convert</Button>
	</form>
	<form id="form1" method="post" action="history">		
		<Button id="history_button" class="button" onclick="" onmouseover="mouseOverButton(this);" onmouseout="mouseOutButton(this);">History</Button>
	</form>
</body>
</html>