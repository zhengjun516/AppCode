package com.appcode.base;

import android.support.v4.util.SparseArrayCompat;


/**
 * Created by zhy on 16/6/22.
 */
public class ViewHolderDelegateManager<T> {
	SparseArrayCompat<IViewHolderDelegate<T, BaseViewHolder2>> delegates = new SparseArrayCompat();

	public int getItemViewDelegateCount() {
		return delegates.size();
	}

	public ViewHolderDelegateManager<T> addDelegate(IViewHolderDelegate<T, BaseViewHolder2> delegate) {
		int viewType = delegates.size();
		if (delegate != null) {
			delegates.put(viewType, delegate);
			viewType++;
		}
		return this;
	}

	public ViewHolderDelegateManager<T> addDelegate(int viewType, IViewHolderDelegate<T, BaseViewHolder2> delegate) {
		if (delegates.get(viewType) != null) {
			throw new IllegalArgumentException(
					"An ItemViewDelegate is already registered for the viewType = "
							+ viewType
							+ ". Already registered ItemViewDelegate is "
							+ delegates.get(viewType));
		}
		delegates.put(viewType, delegate);
		return this;
	}

	public ViewHolderDelegateManager<T> removeDelegate(IViewHolderDelegate<T, BaseViewHolder2> delegate) {
		if (delegate == null) {
			throw new NullPointerException("ItemViewDelegate is null");
		}
		int indexToRemove = delegates.indexOfValue(delegate);

		if (indexToRemove >= 0) {
			delegates.removeAt(indexToRemove);
		}
		return this;
	}

	public ViewHolderDelegateManager<T> removeDelegate(int itemType) {
		int indexToRemove = delegates.indexOfKey(itemType);

		if (indexToRemove >= 0) {
			delegates.removeAt(indexToRemove);
		}
		return this;
	}

	public int getItemViewType(T item, int position) {
		int delegatesCount = delegates.size();
		for (int i = delegatesCount - 1; i >= 0; i--) {
			IViewHolderDelegate<T, BaseViewHolder2> delegate = delegates.valueAt(i);
			if (delegate.isForViewType(item, position)) {
				return delegates.keyAt(i);
			}
		}
		throw new IllegalArgumentException(
				"No ItemViewDelegate added that matches position=" + position + " in data source");
	}

	public void bindViewHolder(BaseViewHolder2 holder, T item, int position) {
		int delegatesCount = delegates.size();
		for (int i = 0; i < delegatesCount; i++) {
			IViewHolderDelegate<T, BaseViewHolder2> delegate = delegates.valueAt(i);

			if (delegate.isForViewType(item, position)) {
				delegate.bindViewHolder(holder, item, position);
				return;
			}
		}
		throw new IllegalArgumentException(
				"No ItemViewDelegateManager added that matches position=" + position + " in data source");
	}


	public IViewHolderDelegate getItemViewDelegate(int viewType) {
		return delegates.get(viewType);
	}

	/*public int getItemViewLayoutId(int viewType) {
		return getItemViewDelegate(viewType).getItemViewLayoutId();
	}*/

	/*public int getItemViewType(IViewHolderDelegate itemViewDelegate) {
		return delegates.indexOfValue(itemViewDelegate);
	}*/
}