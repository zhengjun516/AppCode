package com.appcode.code;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.appcode.R;
import com.appcode.base.BaseFragment;
import com.appcode.db.CodeManager;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CodeCategoryFragment extends BaseFragment {

	@BindView(R.id.mTabLayout)
	protected TabLayout mTabLayout;
	@BindView(R.id.mViewpager)
	protected ViewPager mViewpager;

	protected CodeFragmentAdapter mCodeFragmentAdapter;

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

	}

	@Nullable
	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_code_category,container,false);
		ButterKnife.bind(this,rootView);
		return rootView;
	}


	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		mCodeFragmentAdapter = new CodeFragmentAdapter(getChildFragmentManager());

		mCodeFragmentAdapter.addFragment("UI",CodeFragment.newInstance(CodeManager.CATEGORY_UI));
		mCodeFragmentAdapter.addFragment("SQLite",CodeFragment.newInstance(CodeManager.CATEGORY_SQLITE));
		mCodeFragmentAdapter.addFragment("网络",CodeFragment.newInstance(CodeManager.CATEGORY_NET));
		//mCodeFragmentAdapter.addFragment("Kotlin",new CodeFragment());

		mTabLayout.setupWithViewPager(mViewpager);
		mViewpager.setAdapter(mCodeFragmentAdapter);

	}
}
