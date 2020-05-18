package com.appcode.blog;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.ViewGroup;

import com.appcode.base.BaseAdapter;
import com.appcode.base.BaseViewHolder;
import com.appcode.blog.model.Blog;
import com.appcode.blog.viewholder.BlogViewHolder;

import java.util.List;

public class BlogAdapter extends BaseAdapter<Blog, BaseViewHolder> {

	public BlogAdapter(Context mContext) {
		this(mContext,null);
	}

	public BlogAdapter(Context context, List<Blog> datas) {
		super(context, datas);
		//mViewHolderDelegateManager.addDelegate(new BookViewHolderDelegate(mContext));
	}

	@NonNull
	@Override
	public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int index) {
		return new BlogViewHolder(viewGroup);
	}

	@Override
	public void onBindViewHolder(@NonNull BaseViewHolder viewHolder, int index) {
		viewHolder.bindViewHolder(getItem(index));
	}
}
