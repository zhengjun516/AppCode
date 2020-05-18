package com.appcode.blog.model;

import java.util.List;

public class BlogCategory {
	public int id;
	public String title;
	public List<Blog> blogs;

	public BlogCategory(int id, String title) {
		this.id = id;
		this.title = title;
	}
}
