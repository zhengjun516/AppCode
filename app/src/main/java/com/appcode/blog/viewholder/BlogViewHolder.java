package com.appcode.blog.viewholder;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.appcode.R;
import com.appcode.base.BaseViewHolder;
import com.appcode.blog.model.Blog;
import com.appcode.book.model.Book;
import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BlogViewHolder extends BaseViewHolder<Blog> {

	@BindView(R.id.mTitle)
	protected TextView mTitle;

	public BlogViewHolder(ViewGroup parent) {
		super(LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_blog, null));
		ButterKnife.bind(this,itemView);
	}


	@Override
	public void bindViewHolder(Blog blog) {
		super.bindViewHolder(blog);
		mTitle.setText(blog.title);
	}
}
