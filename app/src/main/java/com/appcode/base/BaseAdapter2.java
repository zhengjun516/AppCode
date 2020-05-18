package com.appcode.base;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhy on 16/4/9.
 */
public class BaseAdapter2<T> extends RecyclerView.Adapter<BaseViewHolder2> {
	protected Context mContext;
	protected List<T> mDatas;

	protected ViewHolderDelegateManager mViewHolderDelegateManager;
	protected OnItemClickListener mOnItemClickListener;

	public BaseAdapter2(Context mContext) {
		this(mContext,null);
	}

	public BaseAdapter2(Context context, List<T> datas) {
		mContext = context;
		if(datas == null){
			datas = new ArrayList<>();
		}
		mDatas = datas;
		mViewHolderDelegateManager = new ViewHolderDelegateManager();
	}

	@Override
	public int getItemViewType(int position) {
		if (!useItemViewDelegateManager()) {
			return super.getItemViewType(position);
		}
		return mViewHolderDelegateManager.getItemViewType(mDatas.get(position), position);
	}


	@Override
	public BaseViewHolder2 onCreateViewHolder(ViewGroup parent, int viewType) {

		BaseViewHolder2 baseViewHolder = createdViewHolder(parent,viewType);
		setListener(parent, baseViewHolder, viewType);
		return baseViewHolder;
	}



	@Override
	public void onBindViewHolder(BaseViewHolder2 holder, int position) {
		bindViewHolder(holder, mDatas.get(position));
	}

	public BaseViewHolder2 createdViewHolder(ViewGroup parent, int viewType) {
		BaseViewHolderDelegate itemViewDelegate =(BaseViewHolderDelegate) mViewHolderDelegateManager.getItemViewDelegate(viewType);
       return itemViewDelegate.createViewHolder(parent);
	}

	public void bindViewHolder(BaseViewHolder2 holder, T t) {
		mViewHolderDelegateManager.bindViewHolder(holder, t, holder.getAdapterPosition());
	}

	protected boolean isEnabled(int viewType) {
		return true;
	}


	protected void setListener(final ViewGroup parent, final BaseViewHolder2 viewHolder, int viewType) {
		if (!isEnabled(viewType)) {
			return;
		}
		viewHolder.getConvertView().setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if (mOnItemClickListener != null) {
					int position = viewHolder.getAdapterPosition();
					mOnItemClickListener.onItemClick(v, viewHolder, position);
				}
			}
		});

		viewHolder.getConvertView().setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View v) {
				if (mOnItemClickListener != null) {
					int position = viewHolder.getAdapterPosition();
					return mOnItemClickListener.onItemLongClick(v, viewHolder, position);
				}
				return false;
			}
		});
	}


	@Override
	public int getItemCount() {
		int itemCount = mDatas.size();
		return itemCount;
	}

	public void addDatas(List<T> datas){
		mDatas.addAll(datas);
		notifyDataSetChanged();
	}

	public void setDatas(List<T> datas){
		mDatas.clear();
		mDatas.addAll(datas);
		notifyDataSetChanged();
	}

	public void clear(){
		mDatas.clear();
		notifyDataSetChanged();
	}

	public List<T> getDatas() {
		return mDatas;
	}

	public BaseAdapter2 addItemViewDelegate(IViewHolderDelegate<T, BaseViewHolder2> itemViewDelegate) {
		mViewHolderDelegateManager.addDelegate(itemViewDelegate);
		return this;
	}

	public BaseAdapter2 addItemViewDelegate(int viewType, IViewHolderDelegate<T, BaseViewHolder2> itemViewDelegate) {
		mViewHolderDelegateManager.addDelegate(viewType, itemViewDelegate);
		return this;
	}

	protected boolean useItemViewDelegateManager() {
		return mViewHolderDelegateManager.getItemViewDelegateCount() > 0;
	}

	public interface OnItemClickListener {
		void onItemClick(View view, RecyclerView.ViewHolder holder, int position);

		boolean onItemLongClick(View view, RecyclerView.ViewHolder holder, int position);
	}

	public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
		this.mOnItemClickListener = onItemClickListener;
	}
}
