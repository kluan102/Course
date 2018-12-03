package com.user;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public RegistrationServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Customer customer = new Customer();
		customer.setEmail(request.getParameter("email"));
		customer.setPhoneNumber(request.getParameter("phoneNumber"));
		customer.setFirstName(request.getParameter("firstName"));
		customer.setLastName(request.getParameter("lastName"));
		customer.setPassword(request.getParameter("password"));
		customer.setInitialDeposit(request.getParameter("initialDeposit"));
		
		Address address= new Address();
		address.setStreet(request.getParameter("street"));
		address.setCity(request.getParameter("city"));
		address.setState(request.getParameter("state"));
		address.setZipCode(request.getParameter("zipcode"));
		customer.setAddress(address);
		
		
		Bank bank= new Bank();
		bank.readFromFile();
		bank.addCustomer(customer);
		
		bank.saveToFile();
		
		HttpSession session=request.getSession(true);
		session.setAttribute("customer", customer);
		session.setAttribute("bank",bank);
		RequestDispatcher rs = request.getRequestDispatcher("main.jsp");
		rs.forward(request,response);
	}	
				
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
