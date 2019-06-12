package com.memorize.modules.generic.repository;

import java.io.Serializable;
import java.util.List;

public interface GenericRepository<E extends Serializable, I> {

	void save(E entity);

	E find(I id);

	void update(E entity);

	List<E> findAll();
}
