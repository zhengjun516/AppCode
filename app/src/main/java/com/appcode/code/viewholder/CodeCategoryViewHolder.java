package com.appcode.code.viewholder;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.widget.TextView;

import com.appcode.R;
import com.appcode.base.BaseViewHolder;
import com.appcode.code.CodeAdapter;
import com.appcode.code.model.CodeCategory;
import com.appcode.tab.DividerItemDecoration;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CodeCategoryViewHolder extends BaseViewHolder<CodeCategory> {

	protected CodeAdapter mBookAdapter;

	@BindView(R.id.mTitle)
	protected TextView mTitle;

	@BindView(R.id.mBooksRecyclerView)
	protected RecyclerView mBooksRecyclerView;

	public CodeCategoryViewHolder(ViewGroup parent) {
		super(parent, R.layout.viewholder_code_category);

		ButterKnife.bind(this,itemView);
		mBookAdapter = new CodeAdapter(mContext);
		mBooksRecyclerView.setAdapter(mBookAdapter);
		mBooksRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
		//mBooksRecyclerView.addItemDecoration(new DividerItemDecoration(mContext, DividerItemDecoration.VERTICAL_LIST));
	}

	@Override
	public void bindViewHolder(CodeCategory blogCategory) {
		super.bindViewHolder(blogCategory);
		mTitle.setText(blogCategory.title);
		mBookAdapter.setDatas(blogCategory.blogs);
	}
}
