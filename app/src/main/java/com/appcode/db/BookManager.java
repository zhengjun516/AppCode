package com.appcode.db;

import com.appcode.book.model.Book;
import com.appcode.book.model.BookCategory;

import java.util.ArrayList;
import java.util.List;

public class BookManager {

	public static List<BookCategory>  getBooks(){
		List<BookCategory> bookCategories = new ArrayList<>();


		BookCategory  bookCategory = new BookCategory(1,"编程必备","");
		List<Book> books = new ArrayList<>();
		books.add(new Book(3,"Head First Design(设计模式)","https://img3.doubanio.com/view/subject/l/public/s2686916.jpg"));
		books.add(new Book(4,"大话设计模式","https://img1.doubanio.com/view/ark_article_cover/retina/public/32943798.jpg?v=0"));
		books.add(new Book(4,"算法","https://img3.doubanio.com/view/subject/l/public/s28322244.jpg"));
		books.add(new Book(4,"算法导论","https://img3.doubanio.com/view/subject/l/public/s25648004.jpg"));
		books.add(new Book(4,"重构","https://img3.doubanio.com/view/subject/l/public/s28259431.jpg"));
		books.add(new Book(4,"图解 HTTP","https://img3.doubanio.com/view/subject/l/public/s27283822.jpg"));
		books.add(new Book(4,"Git权威指南","https://img3.doubanio.com/view/subject/l/public/s6523000.jpg"));
		bookCategory.books = books;
		bookCategories.add(bookCategory);

		bookCategory = new BookCategory(1,"Linux系列","");
		books = new ArrayList<>();
		books.add(new Book(1,"鸟哥的Linux私房菜","https://img1.doubanio.com/view/subject/l/public/s4399937.jpg"));
		books.add(new Book(2,"Linux命令行大全","https://img3.doubanio.com/view/subject/l/public/s27318531.jpg"));
		books.add(new Book(2,"深入理解LINUX内核","https://img3.doubanio.com/view/subject/l/public/s27314344.jpg"));
		books.add(new Book(2,"Linux/UNIX系统编程手册","https://img3.doubanio.com/view/subject/l/public/s27199116.jpg"));
		bookCategory.books = books;
		bookCategories.add(bookCategory);

		bookCategory = new BookCategory(1,"c/c++系列","");
		books = new ArrayList<>();
		books.add(new Book(2,"C Primer Plus","https://img1.doubanio.com/view/subject/l/public/s29438897.jpg"));
		books.add(new Book(2,"C++ Primer","https://img3.doubanio.com/view/subject/l/public/s27023182.jpg"));
		books.add(new Book(2,"C++ Primer Plus","https://img3.doubanio.com/view/subject/l/public/s10307483.jpg"));
		bookCategory.books = books;
		bookCategories.add(bookCategory);

		bookCategory = new BookCategory(1,"java系列","");
		books = new ArrayList<>();
		books.add(new Book(1,"Head First Java","https://img3.doubanio.com/view/subject/l/public/s2171906.jpg","基础"));
		books.add(new Book(1,"Effective java","https://img3.doubanio.com/view/subject/l/public/s2171906.jpg","基础"));
		books.add(new Book(1,"Java核心技术（卷1）:基础知识","https://img3.doubanio.com/view/subject/l/public/s27123141.jpg","基础"));
		books.add(new Book(2,"Java核心技术（卷2）：高级特性","https://img3.doubanio.com/view/subject/l/public/s28038862.jpg","基础"));
		books.add(new Book(2,"数据结构与算法分析：Java 语言描述","https://img3.doubanio.com/view/subject/l/public/s28318872.jpg","基础"));
		books.add(new Book(2,"Java编程思想","https://img3.doubanio.com/view/subject/l/public/s27243455.jpg","基础"));
		books.add(new Book(2,"Java并发编程的艺术","https://img3.doubanio.com/view/ark_article_cover/retina/public/11771712.jpg?v=0","进阶"));
		books.add(new Book(2,"Java多线程编程核心技术","https://img3.doubanio.com/view/ark_article_cover/retina/public/10197774.jpg?v=0","进阶"));
		books.add(new Book(2,"Netty权威指南","https://img3.doubanio.com/view/subject/l/public/s28055322.jpg","进阶"));
		books.add(new Book(2,"深入理解Java虚拟机：JVM高级特性与最佳实践","https://img3.doubanio.com/view/ark_article_cover/retina/public/15233695.jpg?v=0","进阶"));
		books.add(new Book(2,"Java虚拟机规范","https://img3.doubanio.com/view/subject/l/public/s28102962.jpg","进阶"));
		bookCategory.books  = books;
		bookCategories.add(bookCategory);

		bookCategory = new BookCategory(1,"python系列","");
		books = new ArrayList<>();
		books.add(new Book(1,"Python基础教程","https://img3.doubanio.com/view/subject/l/public/s4387251.jpg","基础"));
		books.add(new Book(1,"笨办法学 Python3","https://img3.doubanio.com/view/subject/l/public/s29782950.jpg","基础"));
		books.add(new Book(1,"Head First Python","https://img3.doubanio.com/view/subject/l/public/s27262723.jpg","基础"));
		books.add(new Book(1,"流畅的Python","https://img3.doubanio.com/view/subject/l/public/s29434304.jpg","进阶"));
		books.add(new Book(1,"Python Cookbook","https://img3.doubanio.com/view/subject/l/public/s4357883.jpg","进阶"));
		books.add(new Book(1,"Python编程实战","https://img3.doubanio.com/view/subject/l/public/s27397566.jpg","进阶"));
		books.add(new Book(1,"Python 标准库","https://img3.doubanio.com/view/subject/l/public/s10245980.jpg","进阶"));
		bookCategory.books = books;
		bookCategories.add(bookCategory);

		bookCategory = new BookCategory(1,"PHP系列","");
		books = new ArrayList<>();
		books.add(new Book(1,"高性能MySQL",""));
		bookCategory.books = books;
		bookCategories.add(bookCategory);


		bookCategory = new BookCategory(1,"前端系列","");
		books = new ArrayList<>();
		books.add(new Book(1,"JavaScript权威指南","https://img3.doubanio.com/view/subject/l/public/s9056065.jpg"));
		books.add(new Book(1,"JavaScript高级程序设计","https://img3.doubanio.com/view/subject/l/public/s8958650.jpg"));
		books.add(new Book(1,"JavaScript DOM编程艺术","https://img3.doubanio.com/view/subject/l/public/s4677623.jpg"));
		books.add(new Book(1,"JavaScript设计模式与开发实践","https://img3.doubanio.com/view/subject/l/public/s4677623.jpg"));
		books.add(new Book(1,"Web 性能权威指南","https://img1.doubanio.com/view/subject/l/public/s27249387.jpg"));
		bookCategory.books = books;
		bookCategories.add(bookCategory);

		bookCategory = new BookCategory(1,"机器学习系列","");
		books = new ArrayList<>();
		books.add(new Book(1,"机器学习","https://img1.doubanio.com/view/subject/l/public/s28735609.jpg"));
		books.add(new Book(1,"统计学习方法","https://img3.doubanio.com/view/subject/l/public/s9108113.jpg"));
		books.add(new Book(1,"集体智慧编程","https://img3.doubanio.com/view/subject/l/public/s3350961.jpg"));
		books.add(new Book(1,"Pattern Recognition and Machine Learning","https://img1.doubanio.com/view/subject/l/public/s4254558.jpg"));
		books.add(new Book(1,"Machine Learning","https://img1.doubanio.com/view/subject/l/public/s24486538.jpg"));
		books.add(new Book(1,"The Elements of Statistical Learning","https://img3.doubanio.com/view/subject/l/public/s7004243.jpg"));
		books.add(new Book(1,"机器学习","https://img1.doubanio.com/view/subject/l/public/s28735609.jpg"));
		bookCategory.books = books;
		bookCategories.add(bookCategory);


		bookCategory = new BookCategory(1,"数据库系列","");
		books = new ArrayList<>();
		books.add(new Book(1,"MySQL必知必会","https://img3.doubanio.com/view/subject/l/public/s5968156.jpg"));
		books.add(new Book(1,"Redis设计与实现","https://img1.doubanio.com/view/subject/l/public/s27297117.jpg"));
		books.add(new Book(1,"Redis开发与运维","https://img3.doubanio.com/view/subject/l/public/s29335561.jpg"));
		books.add(new Book(1,"数据库查询优化器的艺术","https://img3.doubanio.com/view/subject/l/public/s27206472.jpg"));
		books.add(new Book(1,"高性能MySQL","https://img1.doubanio.com/view/subject/l/public/s27783358.jpg"));
		books.add(new Book(1,"MySQL排错指南","https://img3.doubanio.com/view/subject/l/public/s28294841.jpg"));
		books.add(new Book(1,"MySQL技术内幕","https://img1.doubanio.com/view/subject/l/public/s29731159.jpg"));
		books.add(new Book(1,"数据库索引设计与优化","https://img3.doubanio.com/view/subject/l/public/s28104652.jpg"));
		books.add(new Book(1,"深入理解MySQL核心技术","https://img1.doubanio.com/view/subject/l/public/s6073229.jpg"));
		books.add(new Book(1,"MySQL内核：InnoDB存储引擎","https://img3.doubanio.com/view/subject/l/public/s27266366.jpg"));
		bookCategory.books = books;
		bookCategories.add(bookCategory);


		/*bookCategory = new BookCategory(1,"Android系列","");
		books = new ArrayList<>();
		bookCategory.books = books;
		bookCategories.add(bookCategory);*/

		/*bookCategory = new BookCategory(1,"IOS系列","");
		books = new ArrayList<>();
		bookCategory.books = books;
		bookCategories.add(bookCategory);*/

		bookCategory = new BookCategory(1,"大数据系列","");
		books = new ArrayList<>();
		books.add(new Book(1,"Hadoop权威指南","https://img1.doubanio.com/view/subject/l/public/s4356809.jpg"));
		books.add(new Book(1,"Hive编程指南","https://img1.doubanio.com/view/subject/l/public/s28019858.jpg"));
		books.add(new Book(1,"HBase权威指南","https://img1.doubanio.com/view/subject/l/public/s10199109.jpg"));
		bookCategory.books = books;
		bookCategories.add(bookCategory);

		/*bookCategory = new BookCategory(1,"测试系列","");
		books = new ArrayList<>();
		bookCategory.books = books;
		bookCategories.add(bookCategory);*/



		return bookCategories;
	}
}
