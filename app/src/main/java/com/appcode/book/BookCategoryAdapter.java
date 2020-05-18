package com.appcode.book;

import android.content.Context;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.appcode.base.BaseAdapter;
import com.appcode.base.BaseViewHolder;
import com.appcode.book.model.BookCategory;
import com.appcode.book.viewholder.BookCategoryViewHolder;

import java.util.List;

public class BookCategoryAdapter extends BaseAdapter<BookCategory, BaseViewHolder> {

	public BookCategoryAdapter(Context context, List<BookCategory> datas) {
		super(context, datas);
		//mViewHolderDelegateManager.addDelegate(new BookCategoryViewHolderDelegate(mContext));
	}

	@NonNull
	@Override
	public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int index) {
		return new BookCategoryViewHolder(viewGroup);
	}

	@Override
	public void onBindViewHolder(@NonNull BaseViewHolder viewHolder, int index) {
		viewHolder.bindViewHolder(getItem(index));
	}
}
