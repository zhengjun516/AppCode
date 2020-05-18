package com.appcode.db;

import com.appcode.model.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryManager {

	public static List<Category> getCategories(){
		List<Category> categories = new ArrayList<>();
		categories.add(new Category(1,"java","java","",Category.CATEGORY_JAVA));

		categories.add(new Category(3,"Android","android","",Category.CATEGORY_ANDROID));

		categories.add(new Category(4,"kotlin","kotlin","",Category.CATEGORY_KOTLIN));

		categories.add(new Category(7,"flutter","kotlin","",Category.CATEGORY_FLUTTER));
		categories.add(new Category(8,"数据库","database","",Category.CATEGORY_DATABASE));

		categories.add(new Category(10,"linux","linux","",Category.CATEGORY_LINUX));

		categories.add(new Category(11,"git","git","",Category.CATEGORY_GIT));

		categories.add(new Category(3,"第三方框架","android","",Category.CATEGORY_ANDROID));
		return categories;
	}
}
