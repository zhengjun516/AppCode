package com.appcode.db;

import com.appcode.blog.model.Blog;
import com.appcode.blog.model.BlogCategory;
import com.appcode.model.Category;

import java.util.ArrayList;
import java.util.List;

public class BlogManager {


	public static List<Blog> getBlogs(){
		List<Blog> blogs = new ArrayList<>();
		blogs.add(new Blog(8,"数据库","database"));
		blogs.add(new Blog(9,"数据库","database"));
		blogs.add(new Blog(10,"linux","linux"));
		blogs.add(new Blog(11,"git","git"));

		return blogs;
	}

	public static List<BlogCategory> getBlogCategories(){
		List<BlogCategory>  blogCategories = new ArrayList<>();


		List<Blog> blogs = new ArrayList<>();
		BlogCategory blogCategory = new BlogCategory(1,"java");

		blogs.add(new Blog(1,"java基础","java"));
		blogs.add(new Blog(2,"java中级","java"));
		blogs.add(new Blog(3,"java高级","java"));
		blogCategory.blogs = blogs;
		blogCategories.add(blogCategory);

		blogCategory = new BlogCategory(2,"android");
		blogs = new ArrayList<>();
		blogs.add(new Blog(3,"Android基础","android"));
		blogs.add(new Blog(3,"Android中高级","android"));
		blogCategory.blogs = blogs;
		blogCategories.add(blogCategory);

		blogCategory = new BlogCategory(3,"kotlin");
		blogs = new ArrayList<>();
		blogs.add(new Blog(4,"kotlin基础","kotlin"));
		blogs.add(new Blog(5,"kotlin中级","kotlin"));
		blogs.add(new Blog(6,"kotlin高级","kotlin"));
		blogs.add(new Blog(7,"flutter","kotlin"));
		blogCategory.blogs = blogs;
		blogCategories.add(blogCategory);

		blogCategory = new BlogCategory(4,"database");
		blogs = new ArrayList<>();
		blogs.add(new Blog(8,"数据库","database"));
		blogs.add(new Blog(9,"数据库","database"));
		blogs.add(new Blog(10,"linux","linux"));
		blogs.add(new Blog(11,"git","git"));

		blogCategory = new BlogCategory(4,"第三方框架");
		blogs = new ArrayList<>();
		blogs.add(new Blog(3,"第三方框架","android"));
		blogCategory.blogs = blogs;
		blogCategories.add(blogCategory);
		return blogCategories;
	}
}
