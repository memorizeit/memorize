package com.memorize.modules.memo.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
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

	public ResponseEntity<String> loadByAuthor(String author) {
		List<Memo> memos = memoRepository.findMemosByAuthor(author);
		String jsonMemos = new Gson().toJson(memos);

		return new ResponseEntity<String>(jsonMemos, HttpStatus.OK);
	}

	public ResponseEntity<String> loadByTitle(String title) {
		List<Memo> memos = memoRepository.findMemosByTitle(title);
		String jsonMemos = new Gson().toJson(memos);

		return new ResponseEntity<String>(jsonMemos, HttpStatus.OK);
	}

	public ResponseEntity<String> loadByContent(String content) {
		List<Memo> memos = memoRepository.findMemosByContent(content);
		String jsonMemos = new Gson().toJson(memos);

		return new ResponseEntity<String>(jsonMemos, HttpStatus.OK);
	}

	public ResponseEntity<String> loadByLast() {
		List<Memo> memos = memoRepository.findMemosByLast();
		String jsonMemos = new Gson().toJson(memos);

		return new ResponseEntity<String>(jsonMemos, HttpStatus.OK);
	}

	public ResponseEntity<String> loadBetweenDates(Date date1, Date date2) {
		List<Memo> memos = memoRepository.findMemosBetweenDates(date1, date2);
		String jsonMemos = new Gson().toJson(memos);

		return new ResponseEntity<String>(jsonMemos, HttpStatus.OK);
	}

	public ResponseEntity<String> loadAll() {
		List<Memo> memos = memoRepository.findAll();
		String jsonMemos = new Gson().toJson(memos);

		return new ResponseEntity<String>(jsonMemos, HttpStatus.OK);
	}

	public ResponseEntity<String> delete(long memoId) {
		long id = memoRepository.delete(memoId);
		String jsonId = new Gson().toJson(id);

		return new ResponseEntity<String>(jsonId, HttpStatus.OK);
	}
}
