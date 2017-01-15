package com.brother.contacts.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.brother.contacts.entities.Address;
import com.brother.contacts.entities.Contact;
import com.brother.contacts.repositories.AddressRepository;
import com.brother.contacts.repositories.ContactRepository;

@WebServlet("/contacts")
public class ContactServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private final AddressRepository addressRepository = new AddressRepository();
    private final ContactRepository contactRepository = new ContactRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	if (request.getParameter("show") != null) {
	    try {
		request.setAttribute("contacts", contactRepository.findAll());
	    } catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }
	    request.getRequestDispatcher("jsp/contactList.jsp").forward(request, response);
	} else if (request.getParameter("add") != null) {
	    request.getRequestDispatcher("jsp/addContact.jsp").forward(request, response);
	} else if (request.getParameter("edit") != null) {
	    request.getRequestDispatcher("jsp/editContact.jsp").forward(request, response);
	} else if (request.getParameter("id") != null) {
	    Long id = Long.parseLong(request.getParameter("id"));
	    try {
		Contact contact = contactRepository.find(id);
		Address address = addressRepository.find(contact.getAddressId());
		request.setAttribute("contact", contact);
		request.setAttribute("address", address);
		request.getRequestDispatcher("jsp/showContact.jsp").forward(request, response);
	    } catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }
	} else {
	    // TODO
	    super.doGet(request, response);
	}
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	try {

	    if (request.getParameter("add") != null) {
		
		// create new contact and address form form parameters, and persist
		Address address = new Address(request.getParameter("street"), request.getParameter("city"),
			request.getParameter("state"), request.getParameter("zip"));
		addressRepository.create(address);
		Contact contact = new Contact(request.getParameter("name"), address.getId());
		contactRepository.create(contact);
		response.sendRedirect("contacts?id=" + contact.getId());
	    } else if (request.getParameter("edit") != null) {
		Long id = Long.parseLong(request.getParameter("id"));
		Contact contact = contactRepository.find(id);
		Address address = addressRepository.find(contact.getAddressId());
		contact.setName(request.getParameter("name"));
		address.setStreet(request.getParameter("street"));
		address.setCity(request.getParameter("city"));
		address.setState(request.getParameter("state"));
		address.setZip(request.getParameter("zip"));
		contactRepository.update(contact);
		addressRepository.update(address);
		
		// redirect to contact view page
		response.sendRedirect("contacts?id=" + contact.getId());
	    }

	} catch (SQLException e) {
	    throw new ServletException();

	}

    }

}
