package com.memorize.modules.memo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.memorize.modules.memo.entity.Memo;
import com.memorize.modules.memo.service.MemoService;

@Controller
@RequestMapping("/memo/")
public class MemoController {

	@Autowired
	private MemoService memoService;

	@PostMapping("new")
	public ResponseEntity<String> save(Memo memo) {
		try {
			return memoService.save(memo);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
}
