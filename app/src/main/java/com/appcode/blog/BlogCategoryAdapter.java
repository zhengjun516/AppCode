package com.appcode.blog;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.ViewGroup;


import com.appcode.base.BaseAdapter;
import com.appcode.base.BaseViewHolder;
import com.appcode.blog.model.BlogCategory;
import com.appcode.blog.viewholder.BlogCategoryViewHolder;

import java.util.List;

public class BlogCategoryAdapter extends BaseAdapter<BlogCategory,BaseViewHolder> {

	public BlogCategoryAdapter(Context context, List datas) {
		super(context, datas);
	}

	@NonNull
	@Override
	public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int index) {
		return new BlogCategoryViewHolder(viewGroup);
	}

	@Override
	public void onBindViewHolder(@NonNull BaseViewHolder viewHolder, int index) {
		viewHolder.bindViewHolder(getItem(index));
	}
}
