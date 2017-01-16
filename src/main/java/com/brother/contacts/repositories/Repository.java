package com.brother.contacts.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;


public class Repository<E> {

    private final EntityManager em = Persistence.createEntityManagerFactory("training").createEntityManager();
    private final Class<E> entityClass;
    
    // a constructor for runtime type class issue = > <E>.class in find() method.
    public Repository(Class<E> entityClass) {
	super();
	this.entityClass = entityClass;
    }

    public E find(long id) {
	return em.find(entityClass, id);
    }
    
    public List<E> findAll(){
	return em.createQuery("from " + entityClass.getSimpleName(), entityClass).getResultList();
	
    }

    public E save(E entity) {
	em.getTransaction().begin();
	entity = em.merge(entity);
	em.getTransaction().commit();
	return entity;
    }

    public void delete(E entity) {
	em.remove(entity);
    }

}
