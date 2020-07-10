package com.fdmgroup.CurrencyConverterProject.Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fdmgroup.CurrencyConverterProject.Converter;

/**
 * Servlet implementation class ConvertCurrencyServlet
 */
public class ConvertCurrencyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Converter converter;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConvertCurrencyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fromCurr = "CAD";
		String toCurr = "CAD"; 
		double fromAmt = 0.0;
        converter = new Converter(fromCurr,toCurr);
        
        double totalAmount = converter.calculateTotal(fromAmt);
        request.setAttribute("total", totalAmount);
        request.getRequestDispatcher("/home").forward(request, response);
	}

}
