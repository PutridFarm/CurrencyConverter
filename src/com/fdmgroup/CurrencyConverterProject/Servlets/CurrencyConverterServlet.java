package com.fdmgroup.CurrencyConverterProject.Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fdmgroup.CurrencyConverterProject.CurrencyManager;

/**
 * Servlet implementation class CurrencyConverterServlet
 * This servlet is responsible for handling the pre processing of data on the home page.
 */
public class CurrencyConverterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private CurrencyManager currManager;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CurrencyConverterServlet() {
        super();
        currManager = CurrencyManager.getInstance();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("currency_types", currManager.getCurrencyList());
		request.getRequestDispatcher("/home").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
