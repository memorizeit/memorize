package com.memorize.modules.memo.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.memorize.modules.memo.entity.Memo;
import com.memorize.modules.memo.service.MemoService;

@Controller
@RequestMapping("/memos/")
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

	@RequestMapping(value = "{memoId}", produces={"application/json; charset=UTF-8"}, method = RequestMethod.GET)
	public ResponseEntity<String> load(@PathVariable long memoId) {
		try {
			return memoService.load(memoId);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "search/byAuthor{?author}", produces={"application/json; charset=UTF-8"}, method = RequestMethod.GET)
	public ResponseEntity<String> loadByAuthor(@RequestParam String author) {
		try {
			return memoService.loadByAuthor(author);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "search/byTitle{?title}", produces={"application/json; charset=UTF-8"}, method = RequestMethod.GET)
	public ResponseEntity<String> loadByTitle(@RequestParam String title) {
		try {
			return memoService.loadByTitle(title);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "search/byContent{?content}", produces={"application/json; charset=UTF-8"}, method = RequestMethod.GET)
	public ResponseEntity<String> loadByContent(@RequestParam String content) {
		try {
			return memoService.loadByContent(content);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "search/byLast", produces={"application/json; charset=UTF-8"}, method = RequestMethod.GET)
	public ResponseEntity<String> loadByLast() {
		try {
			return memoService.loadByLast();
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "search/betweenDates", params = {"date1", "date2"}, produces={"application/json; charset=UTF-8"}, method = RequestMethod.GET)
	public ResponseEntity<String> loadBetweenDates(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date date1,
			@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date date2) {
		try {
			return memoService.loadBetweenDates(date1, date2);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(produces={"application/json; charset=UTF-8"}, method = RequestMethod.GET)
	public ResponseEntity<String> loadAll() {
		try {
			return memoService.loadAll();
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "{memoId}", produces = {"application/json; charset=UTF-8"}, method = RequestMethod.DELETE)
	public ResponseEntity<String> delete(@PathVariable long memoId) {
		try {
			return memoService.delete(memoId);
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
