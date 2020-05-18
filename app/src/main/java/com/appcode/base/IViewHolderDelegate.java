package com.appcode.base;


import android.view.View;
import android.view.ViewGroup;

/**
 * Created by zhy on 16/6/22.
 */
public interface IViewHolderDelegate<T,E> {

    int  getItemViewLayoutId();
    View getItemView();
    boolean isForViewType(T item, int position);
    E createViewHolder(ViewGroup parent);
    void bindViewHolder(BaseViewHolder2 holder, T t, int position);

}
