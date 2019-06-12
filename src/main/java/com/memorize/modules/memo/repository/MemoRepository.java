package com.memorize.modules.memo.repository;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.memorize.modules.generic.repository.AbstractGenericRepository;
import com.memorize.modules.memo.entity.Memo;

@Repository
@Transactional
public class MemoRepository extends AbstractGenericRepository<Memo, Long> {

	private MemoRepository(Class<Memo> classType) {
		super(classType);
	}

	public MemoRepository() {
		this(Memo.class);
	}

	public List<Memo> findMemosByAuthor(String author) {
		TypedQuery<Memo> query = super.manager.createQuery("select m from Memo m where m.author = :pAuthor",
				Memo.class);
		query.setParameter("pAuthor", author);

		return query.getResultList();
	}
}
