package com.memorize.modules.memo.service;

import java.util.Calendar;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.memorize.modules.memo.entity.Memo;
import com.memorize.modules.memo.repository.MemoRepository;

@Service
public class MemoService {

	@Autowired
	private MemoRepository memoRepository;

	public ResponseEntity<String> save(Memo memo) {
		Memo oldMemo = memoRepository.find(memo.getId());

		if (Objects.isNull(oldMemo)) {
			memo.setCreationDate(Calendar.getInstance().getTime());
			memoRepository.save(memo);
		} else {
			memo.setUpdateDate(Calendar.getInstance().getTime());
			memo.setCreationDate(oldMemo.getCreationDate());
			memoRepository.update(memo);
		}

		return new ResponseEntity<String>(String.valueOf(memo.getId()), HttpStatus.OK);
	}

	public ResponseEntity<String> load(long memoId) {
		Memo memo = memoRepository.find(memoId);
		String jsonMemo = new Gson().toJson(memo);

		return new ResponseEntity<String>(jsonMemo, HttpStatus.OK);
	}
}
