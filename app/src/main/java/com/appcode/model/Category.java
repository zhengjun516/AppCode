package com.appcode.model;

import java.util.List;

public class Category<T> {
	public static final int CATEGORY_JAVA = 1;
	public static final int CATEGORY_ANDROID = 2;
	public static final int CATEGORY_KOTLIN = 3;
	public static final int CATEGORY_FLUTTER = 4;
	public static final int CATEGORY_DATABASE = 5;
	public static final int CATEGORY_LINUX = 6;
	public static final int CATEGORY_GIT = 7;

	public int id;
	public String title;
	public String imgUrl;
	public String tag;
	public String category;
	public int type;

	public List<T> subCategories;

	public Category(int id, String title,String category, String imgUrl, int type) {
		this.id = id;
		this.title = title;
		this.imgUrl = imgUrl;
		this.type = type;
		this.category = category;
	}
}
