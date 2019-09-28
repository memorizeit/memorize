package com.memorize.modules.memo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "{memoId}", produces={"application/json; charset=UTF-8"})
	public ResponseEntity<String> load(@PathVariable long memoId) {
		try {
			return memoService.load(memoId);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "all", produces={"application/json; charset=UTF-8"})
	public ResponseEntity<String> loadAll() {
		try {
			return memoService.loadAll();
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("v/new")
	public ModelAndView viewNewMemo() {
		return new ModelAndView("index");
	}

	@GetMapping("v/{memoId}")
	public ModelAndView viewMemo(@PathVariable long memoId) {
		return new ModelAndView("preview");
	}
}
