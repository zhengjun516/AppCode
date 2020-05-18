package com.appcode.base;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseAdapter<T,E extends BaseViewHolder> extends RecyclerView.Adapter<E> {
	protected Context mContext;
	protected List<T> mDatas;
	protected OnItemClickListener mOnItemClickListener;
	protected LayoutInflater layoutInflater;

	public BaseAdapter(Context context){
		this(context,null);
	}

	public BaseAdapter(Context context, List<T> datas) {
		this.mContext = context;
		layoutInflater = LayoutInflater.from(mContext);
		if(datas == null){
			datas = new ArrayList<>();
		}
		this.mDatas = datas;
	}

	@NonNull
	@Override
	public  abstract E onCreateViewHolder(@NonNull ViewGroup viewGroup, int index);

	@Override
	public abstract void onBindViewHolder(@NonNull E viewHolder, int index);

	@Override
	public int getItemCount() {
		return mDatas.size();
	}

	@Override
	public int getItemViewType(int position) {
		return position;
	}

	public T getItem(int index){
		if(index < 0 || index >getItemCount()){
			return null;
		}
		return mDatas.get(index);
	}

	public List<T> getDatas() {
		return mDatas;
	}

	public void setDatas(List<T> datas){
		mDatas.clear();
		mDatas.addAll(datas);
		notifyDataSetChanged();
	}

	public T remove(int position){
       if(position < 0 || position >= getItemCount()){
            return null;
	   }
	   T t = mDatas.remove(position);
       notifyDataSetChanged();
	   return t;
	}

	public void clear(){
		mDatas.clear();
		notifyDataSetChanged();
	}

	public void addDatas(List<T> datas){
		mDatas.addAll(datas);
		notifyDataSetChanged();
	}

	public interface OnItemClickListener {
		void onItemClick(View view, RecyclerView.ViewHolder holder, int position);

		boolean onItemLongClick(View view, RecyclerView.ViewHolder holder, int position);
	}

	public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
		this.mOnItemClickListener = onItemClickListener;
	}
}
