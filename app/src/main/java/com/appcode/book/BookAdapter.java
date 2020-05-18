package com.appcode.book;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.ViewGroup;

import com.appcode.base.BaseAdapter;
import com.appcode.base.BaseViewHolder;
import com.appcode.book.model.Book;
import com.appcode.book.viewholder.BookViewHolder;

import java.util.List;

public class BookAdapter extends BaseAdapter<Book, BaseViewHolder> {

	public BookAdapter(Context mContext) {
		this(mContext,null);
	}

	public BookAdapter(Context context, List datas) {
		super(context, datas);
		//mViewHolderDelegateManager.addDelegate(new BookViewHolderDelegate(mContext));
	}

	@NonNull
	@Override
	public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int index) {
		return new BookViewHolder(viewGroup);
	}

	@Override
	public void onBindViewHolder(@NonNull BaseViewHolder viewHolder, int index) {
		viewHolder.bindViewHolder(getItem(index));
	}
}
