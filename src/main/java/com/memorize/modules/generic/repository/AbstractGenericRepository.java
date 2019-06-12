package com.memorize.modules.generic.repository;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public abstract class AbstractGenericRepository<E extends Serializable, I> implements GenericRepository<E, I> {

	@PersistenceContext
	protected EntityManager manager;
	private final Class<E> classType;

	public AbstractGenericRepository(Class<E> classType) {
		this.classType = classType;
	}

	public void save(E entity) {
		manager.persist(entity);
	}

	public void update(E entity) {
		manager.merge(entity);
	}

	public E find(I id) {
		return manager.find(classType, id);
	}

	public List<E> findAll() {
		TypedQuery<E> query = manager.createQuery("select e from :pE e", classType);
		query.setParameter("pE", classType);

		return query.getResultList();
	}
}
