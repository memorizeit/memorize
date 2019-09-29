package com.memorize.modules.memo.repository;

import java.util.Date;
import java.util.List;

import javax.persistence.Query;
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
		TypedQuery<Memo> query = super.manager.createQuery("select m from Memo m where m.author = :pAuthor and m.deleted = 0 order by m.title",
				Memo.class);
		query.setParameter("pAuthor", author);

		return query.getResultList();
	}

	public List<Memo> findMemosByTitle(String title) {
		TypedQuery<Memo> query = super.manager.createQuery("select m from Memo m where m.title like :pTitle and m.deleted = 0 order by m.title",
				Memo.class);
		query.setParameter("pTitle", "%"+title+"%");

		return query.getResultList();
	}

	public List<Memo> findMemosByContent(String content) {
		TypedQuery<Memo> query = super.manager.createQuery("select m from Memo m where m.content like :pContent and m.deleted = 0 order by m.title",
				Memo.class);
		query.setParameter("pContent", "%"+content+"%");

		return query.getResultList();
	}

	public List<Memo> findMemosByLast() {
		TypedQuery<Memo> query = super.manager.createQuery("select m from Memo m where m.deleted = 0 order by m.updateDate, m.creationDate desc",
				Memo.class);

		return query.getResultList();
	}

	public List<Memo> findMemosBetweenDates(Date date1, Date date2) {
		System.out.println(date1 + " " + date2);
		String queryString = "select m from Memo m where m.deleted = 0 and m.creationDate between :pFirstDate and :pSecondDate order by m.updateDate, m.creationDate desc";
		TypedQuery<Memo> query = super.manager.createQuery(queryString,	Memo.class);
		query.setParameter("pFirstDate", date1);
		query.setParameter("pSecondDate", date2);

		return query.getResultList();
	}

	public List<Memo> findAll() {
		TypedQuery<Memo> query = super.manager.createQuery("select m from Memo m where m.deleted = 0", Memo.class);

		return query.getResultList();
	}

	public long delete(long memoId) {
		Query query = super.manager.createQuery("update Memo set deleted = 1 where id = :pId");
		query.setParameter("pId", memoId);

		return query.executeUpdate();

	}
}
