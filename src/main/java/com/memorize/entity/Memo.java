package com.memorize.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Memo implements Serializable {

	private static final long serialVersionUID = 1L;
	private long id;
	private String title;
	private String content;
	private Author author;
	private List<String> tags;
	private int backgroundColor;
	private boolean nightMode;
	private int fontSize;
	private Date creationDate;
	private Date updateDate;
	private String visibility;
}