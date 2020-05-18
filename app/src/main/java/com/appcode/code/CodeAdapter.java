package com.appcode.code;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.ViewGroup;

import com.appcode.base.BaseAdapter;
import com.appcode.base.BaseViewHolder;
import com.appcode.code.model.Code;
import com.appcode.code.viewholder.CodeViewHolder;

import java.util.List;

public class CodeAdapter extends BaseAdapter<Code, BaseViewHolder> {

	public CodeAdapter(Context mContext) {
		this(mContext,null);
	}

	public CodeAdapter(Context context, List<Code> datas) {
		super(context, datas);
		//mViewHolderDelegateManager.addDelegate(new BookViewHolderDelegate(mContext));
	}

	@NonNull
	@Override
	public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int index) {
		return new CodeViewHolder(viewGroup);
	}

	@Override
	public void onBindViewHolder(@NonNull BaseViewHolder viewHolder, int index) {
		viewHolder.bindViewHolder(getItem(index));
	}
}
