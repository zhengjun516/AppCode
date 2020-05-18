package com.appcode.book.model;

public class Book {
	public int id;
	public String title;
	public String imgUrl;
	public String category;
	public String tag;

	public Book(int id, String title, String imgUrl) {
		this.id = id;
		this.title = title;
		this.imgUrl = imgUrl;
	}

	public Book(int id, String title, String imgUrl, String tag) {
		this.id = id;
		this.title = title;
		this.imgUrl = imgUrl;
		this.tag = tag;
	}
}
