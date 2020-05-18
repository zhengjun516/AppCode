package com.appcode.tab;

import android.content.Context;
import android.view.View;

import com.appcode.R;
import com.appcode.base.BaseViewHolder2;
import com.appcode.base.BaseViewHolderDelegate;
import com.appcode.model.Category;

public class CategoryViewHolderDelegate extends BaseViewHolderDelegate<Category> {

	public CategoryViewHolderDelegate(Context context) {
		super(context);
	}

	@Override
	public int getItemViewLayoutId() {
		return R.layout.viewholder_category;
	}

	@Override
	public View getItemView() {
		return null;
	}

	@Override
	public boolean isForViewType(Category item, int position) {
		return true;
	}

	@Override
	public void bindViewHolder(BaseViewHolder2 holder, Category category, int position) {
		holder.setText(R.id.mTitle,category.title);
	}
}
