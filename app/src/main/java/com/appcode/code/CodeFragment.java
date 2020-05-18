package com.appcode.code;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.appcode.R;
import com.appcode.base.BaseFragment;
import com.appcode.db.CodeManager;
import com.appcode.tab.DividerItemDecoration;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CodeFragment extends BaseFragment {

	//@BindView(R.id.mCodeRecyclerView)
	//protected RecyclerView mCodeRecyclerView;

	private CodeAdapter mCodeAdapter;

	private int categoryId;

	public static CodeFragment newInstance(int categoryId){
		CodeFragment codeFragment = new CodeFragment();
		Bundle params = new Bundle();
		params.putInt("categoryId",categoryId);
		codeFragment.setArguments(params);
		return codeFragment;
	}

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		categoryId = getArguments().getInt("categoryId",1);
	}

	@Nullable
	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_code,container,false);
		ButterKnife.bind(this,rootView);
		return rootView;
	}

	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		mCodeAdapter = new CodeAdapter(getContext(), CodeManager.getCodeByCategory(categoryId));

		//mCodeRecyclerView.setAdapter(mCodeAdapter);
		//mCodeRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
		//mCodeRecyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL_LIST));
	}
}
