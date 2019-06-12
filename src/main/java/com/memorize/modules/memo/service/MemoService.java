package com.memorize.modules.memo.service;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.memorize.modules.memo.entity.Memo;
import com.memorize.modules.memo.repository.MemoRepository;

@Service
public class MemoService {

	@Autowired
	private MemoRepository memoRepository;

	public ResponseEntity<String> save(Memo memo) {
		memo.setCreationDate(Calendar.getInstance().getTime());
		memoRepository.save(memo);

		return new ResponseEntity<String>(HttpStatus.OK);
	}
}
