package com.brother.contacts.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.brother.contacts.repositories.AddressRepository;
import com.brother.contacts.repositories.ContactRepository;

@WebServlet("/getaddress")
public class Start extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private final AddressRepository addressRepository = new AddressRepository();
	private final ContactRepository contactRepository = new ContactRepository();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		doPost(request, response);
		try {
			request.setAttribute("addresses", addressRepository.findAll());
			request.setAttribute("contacts", contactRepository.findAll());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RequestDispatcher view = request.getRequestDispatcher("jsp/getAddress.jsp");
		view.forward(request, response);
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/*
		 * Address add1 = new Address();
		 * 
		 * String address = request.getParameter("address");
		 */
		/*
		 * String street = request.getParameter("street"); String city =
		 * request.getParameter("city"); String state =
		 * request.getParameter("state"); String zip =
		 * request.getParameter("zip");
		 */

		
		/*
		 * request.setAttribute("street", street); request.setAttribute("city",
		 * city); request.setAttribute("state", state);
		 * request.setAttribute("zip", zip);
		 */

		
	}

}
