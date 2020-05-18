package com.appcode.base;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class BaseViewHolderDelegate<T> implements IViewHolderDelegate<T, BaseViewHolder2> {

	protected Context mContext;
	protected LayoutInflater mLayoutInflater;

	public BaseViewHolderDelegate(Context context) {
		this.mContext = context;
		mLayoutInflater = LayoutInflater.from(mContext);
	}

	@Override
	public BaseViewHolder2 createViewHolder(ViewGroup parent) {
		if (getItemViewLayoutId()  >  0){
			return createViewHolder(parent,getItemViewLayoutId());
		}else if(getItemView() != null){
			return createViewHolder(parent,getItemView());
		}else{
			throw new RuntimeException("getItemViewLayoutId must > 0 or getItemView not null");
		}
	}

	public final BaseViewHolder2 createViewHolder(ViewGroup parent, int layoutId) {
		View itemView = mLayoutInflater.inflate(layoutId, parent, false);
		BaseViewHolder2 holder = new BaseViewHolder2(mContext, itemView);
		return holder;
	}

	public final BaseViewHolder2 createViewHolder(ViewGroup parent, View itemView) {
		BaseViewHolder2 holder = new BaseViewHolder2(mContext, itemView);
		return holder;
	}
}
