package com.brother.contacts.servlets;

import java.sql.SQLException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.brother.contacts.entities.Address;
import com.brother.contacts.entities.Contact;
import com.brother.contacts.repositories.AddressRepository;
import com.brother.contacts.repositories.ContactRepository;

@WebListener
public class Setup implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {

		try {

			AddressRepository addressRepository = new AddressRepository();
			addressRepository.init();

			Address address0 = new Address("150 West Tasman Dr.", "Fremont", "CA", "08857");
			addressRepository.create(address0);
			Address address1 = new Address("10001 Starr street", "Fremont", "CA", "94539");
			addressRepository.create(address1);
			Address address2 = new Address("800 West Tasman Dr.", "San Jose", "CA", "95587");
			addressRepository.create(address2);

			ContactRepository contactRepository = new ContactRepository();
			contactRepository.init();

			Contact contact1 = new Contact("James Bond", address0.getId());
			contactRepository.create(contact1);
			Contact contact2 = new Contact("Christofer", address1.getId());
			contactRepository.create(contact2);
			Contact contact3 = new Contact("Gandov King", address2.getId());
			contactRepository.create(contact3);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
