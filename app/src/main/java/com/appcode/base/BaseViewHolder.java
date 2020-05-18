package com.appcode.base;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

public abstract class BaseViewHolder<E> extends RecyclerView.ViewHolder {

    protected Context mContext;
    protected E data;
    protected int position;

    public BaseViewHolder(View itemView) {
        super(itemView);
        mContext = itemView.getContext();
    }

    public BaseViewHolder(ViewGroup parent, int layoutId) {
        super(LayoutInflater.from(parent.getContext()).inflate(layoutId, parent, false));
        mContext = parent.getContext();
    }

    public void bindViewHolder(E entity){
        data = entity;

    }
    public void bindViewHolder(E entity,int position){
        data = entity;
        position = position;
    }

}
