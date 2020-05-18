package com.appcode.book.viewholder;

import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.appcode.R;
import com.appcode.base.BaseViewHolder;
import com.appcode.book.BookAdapter;
import com.appcode.book.model.BookCategory;
import com.appcode.tab.DividerItemDecoration;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BookCategoryViewHolder extends BaseViewHolder<BookCategory> {

	protected BookAdapter mBookAdapter;

	@BindView(R.id.mTitle)
	protected TextView mTitle;

	@BindView(R.id.mBooksRecyclerView)
	protected RecyclerView mBooksRecyclerView;

	public BookCategoryViewHolder(ViewGroup parent) {
		super(parent, R.layout.viewholder_book_category);

		ButterKnife.bind(this,itemView);
		mBookAdapter = new BookAdapter(mContext);
		mBooksRecyclerView.setAdapter(mBookAdapter);
		mBooksRecyclerView.setLayoutManager(new GridLayoutManager(mContext,2));
		mBooksRecyclerView.addItemDecoration(new DividerItemDecoration(mContext, DividerItemDecoration.VERTICAL_LIST));
	}

	@Override
	public void bindViewHolder(BookCategory bookCategory) {
		super.bindViewHolder(bookCategory);
		mTitle.setText(bookCategory.title);
		mBookAdapter.setDatas(bookCategory.books);
	}
}
