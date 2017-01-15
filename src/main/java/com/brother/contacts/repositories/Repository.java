package com.brother.contacts.repositories;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

@Entity
public class Repository<E> {
    private final EntityManager em = Persistence.createEntityManagerFactory("EntityClass").createEntityManager();
    public Repository<E> (){
	
    }

}
