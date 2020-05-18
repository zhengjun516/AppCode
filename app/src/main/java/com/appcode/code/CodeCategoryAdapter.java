package com.appcode.code;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.ViewGroup;

import com.appcode.base.BaseAdapter;
import com.appcode.base.BaseViewHolder;
import com.appcode.code.model.CodeCategory;
import com.appcode.code.viewholder.CodeCategoryViewHolder;

import java.util.List;

public class CodeCategoryAdapter extends BaseAdapter<CodeCategory,BaseViewHolder> {

	public CodeCategoryAdapter(Context context, List datas) {
		super(context, datas);
	}

	@NonNull
	@Override
	public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int index) {
		return new CodeCategoryViewHolder(viewGroup);
	}

	@Override
	public void onBindViewHolder(@NonNull BaseViewHolder viewHolder, int index) {
		viewHolder.bindViewHolder(getItem(index));
	}
}
