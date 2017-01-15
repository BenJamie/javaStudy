package com.brother.contacts.repositories;

import com.brother.contacts.entities.Contact;

public class ContactRepository extends Repository<Contact> {

    public ContactRepository() {
	super(Contact.class);
    }

}
