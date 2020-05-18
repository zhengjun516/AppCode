package com.appcode.blog;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.appcode.R;
import com.appcode.base.BaseFragment;
import com.appcode.db.BlogManager;
import com.appcode.db.CategoryManager;
import com.appcode.tab.CategoryAdapter;
import com.appcode.tab.DividerItemDecoration;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BlogFragment extends BaseFragment {

	@BindView(R.id.mCategoryRecyclerView)
	protected RecyclerView mCategoryRecyclerView;

	private BlogAdapter mCategoryAdapter;

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
		mCategoryAdapter = new BlogAdapter(getContext(), BlogManager.getBlogs());

		mCategoryRecyclerView.setAdapter(mCategoryAdapter);
		mCategoryRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
		mCategoryRecyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL_LIST));
	}
}
