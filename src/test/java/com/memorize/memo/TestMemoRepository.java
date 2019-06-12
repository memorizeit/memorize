package com.memorize.memo;

import java.util.Calendar;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.memorize.modules.memo.entity.Memo;
import com.memorize.modules.memo.repository.MemoRepository;

public class TestMemoRepository {

	@Autowired
	private MemoRepository memoRepository;

	@Test
	public void creationMemo() {
		Memo memo = new Memo();

		memo.setTitle("Título Qualquer");
		memo.setContent("Conteúdo do primeiro memo");
		memo.setCreationDate(Calendar.getInstance().getTime());

		memoRepository.save(memo);

	}
}
