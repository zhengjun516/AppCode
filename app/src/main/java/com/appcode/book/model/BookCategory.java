package com.appcode.book.model;

import java.util.List;

public class BookCategory {
	public int id;
	public String title;
	public String imgUrl;
	public String category;
	public String tag;

	public List<Book> books;

	public BookCategory(int id, String title, String imgUrl) {
		this.id = id;
		this.title = title;
		this.imgUrl = imgUrl;
	}
}
