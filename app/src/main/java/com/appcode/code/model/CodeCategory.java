package com.appcode.code.model;

import java.util.List;

public class CodeCategory {
	public int id;
	public String title;
	public List<Code> blogs;

	public CodeCategory(int id, String title) {
		this.id = id;
		this.title = title;
	}
}
