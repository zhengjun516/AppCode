package com.appcode.book.viewholder;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.appcode.R;
import com.appcode.base.BaseViewHolder;
import com.appcode.book.model.Book;
import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BookViewHolder extends BaseViewHolder<Book> {

	@BindView(R.id.mTitle)
	protected TextView mTitle;
	@BindView(R.id.mBookImage)
	protected ImageView mBookImage;

	public BookViewHolder(ViewGroup parent) {
		super(LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_book, null));
		ButterKnife.bind(this,itemView);
	}


	@Override
	public void bindViewHolder(Book book) {
		super.bindViewHolder(book);
		mTitle.setText(book.title);
		Glide.with(mContext).load(book.imgUrl).into(mBookImage);
	}
}
