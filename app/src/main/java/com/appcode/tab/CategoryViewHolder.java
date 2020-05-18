package com.appcode.tab;

import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.widget.TextView;
import com.appcode.R;
import com.appcode.base.BaseViewHolder;
import com.appcode.model.Category;

import java.util.ArrayList;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CategoryViewHolder extends BaseViewHolder<Category> {


	@BindView(R.id.mTitle)
	protected TextView mTitle;

	@BindView(R.id.mItemView)
	protected CardView mItemView;

	public CategoryViewHolder(ViewGroup parent) {
		super(parent, R.layout.viewholder_category);
		ButterKnife.bind(this,itemView);

	}

	@Override
	public void bindViewHolder(Category entity, int position) {
		super.bindViewHolder(entity, position);
		mTitle.setText(entity.title);
	}

}
