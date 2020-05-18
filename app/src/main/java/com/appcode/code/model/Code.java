package com.appcode.code.model;

import java.util.List;

public class Code {
	public int id;
	public String title;
	public String codeUrl;
	public String apkUrl;
	public String category;
	public String tag;
	public List<String> imageUrls;

	public Code(int id, String title, String codeUrl) {
		this.id = id;
		this.title = title;
		this.codeUrl = codeUrl;
	}
}
