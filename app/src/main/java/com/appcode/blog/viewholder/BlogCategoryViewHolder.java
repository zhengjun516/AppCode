package com.appcode.blog.viewholder;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.widget.TextView;

import com.appcode.R;
import com.appcode.base.BaseViewHolder;
import com.appcode.blog.BlogAdapter;
import com.appcode.blog.model.BlogCategory;
import com.appcode.book.BookAdapter;
import com.appcode.book.model.BookCategory;
import com.appcode.tab.DividerItemDecoration;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BlogCategoryViewHolder extends BaseViewHolder<BlogCategory> {

	protected BlogAdapter mBookAdapter;

	@BindView(R.id.mTitle)
	protected TextView mTitle;

	@BindView(R.id.mBooksRecyclerView)
	protected RecyclerView mBooksRecyclerView;

	public BlogCategoryViewHolder(ViewGroup parent) {
		super(parent, R.layout.viewholder_blog_category);

		ButterKnife.bind(this,itemView);
		mBookAdapter = new BlogAdapter(mContext);
		mBooksRecyclerView.setAdapter(mBookAdapter);
		mBooksRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
		mBooksRecyclerView.addItemDecoration(new DividerItemDecoration(mContext, DividerItemDecoration.VERTICAL_LIST));
	}

	@Override
	public void bindViewHolder(BlogCategory blogCategory) {
		super.bindViewHolder(blogCategory);
		mTitle.setText(blogCategory.title);
		mBookAdapter.setDatas(blogCategory.blogs);
	}
}
