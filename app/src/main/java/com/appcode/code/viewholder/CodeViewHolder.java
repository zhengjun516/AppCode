package com.appcode.code.viewholder;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.appcode.R;
import com.appcode.base.BaseViewHolder;
import com.appcode.code.model.Code;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CodeViewHolder extends BaseViewHolder<Code> {

	@BindView(R.id.mTitle)
	protected TextView mTitle;

	@BindView(R.id.mPluginName)
	protected TextView mPluginName;

	@BindView(R.id.mDownLoad)
	protected TextView mDownLoad;

	@BindView(R.id.mProgressBar)
	protected ProgressBar mProgressBar;

	public CodeViewHolder(ViewGroup parent) {
		super(LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_code, null));
		ButterKnife.bind(this,itemView);
	}


	@Override
	public void bindViewHolder(Code blog) {
		super.bindViewHolder(blog);
		mTitle.setText(blog.title);
		//Glide.with(mContext).load(blog.url).into(mBookImage);
	}
}
