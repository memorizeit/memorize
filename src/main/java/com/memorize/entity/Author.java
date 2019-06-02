package com.memorize.entity;

import java.io.Serializable;

public class Author implements Serializable {

	private static final long serialVersionUID = 1L;
	private long id;
	private String name;
	private int age;
	private String bio;
	private String url;
	private String username;
	private String email;
	private transient String password;

}
