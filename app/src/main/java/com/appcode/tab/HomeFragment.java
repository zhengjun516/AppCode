package com.appcode.tab;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.appcode.R;
import com.appcode.base.BaseFragment;
import com.appcode.db.CategoryManager;
import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeFragment extends BaseFragment {

	@BindView(R.id.mCategoryRecyclerView)
	protected RecyclerView mCategoryRecyclerView;

	private CategoryAdapter mCategoryAdapter;

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Nullable
	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_home,container,false);
		ButterKnife.bind(this,rootView);
		return rootView;
	}


	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		mCategoryAdapter = new CategoryAdapter(getContext(), CategoryManager.getCategories());
		mCategoryRecyclerView.setAdapter(mCategoryAdapter);
		//mCategoryRecyclerView.setLayoutManager(new GridLayoutManager(getContext(),4));
		mCategoryRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL));
		mCategoryRecyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL_LIST));
	}
}
