package com.appcode.netplugin;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;


import com.appcode.OnItemClickListener;
import com.appcode.Post;
import com.appcode.R;
import com.qihoo360.replugin.RePlugin;

import java.util.List;

public class PluginPostAdapter extends RecyclerView.Adapter {
	private LayoutInflater mInflater;
	private List<Post> posts;

	private OnItemClickListener onItemClickListener;

	public PluginPostAdapter(Context context,List<Post> posts){
		this.mInflater=LayoutInflater.from(context);
		this.posts = posts;

	}
	@Override
	public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		final View view=mInflater.inflate(R.layout.plugin_post_adapter_item,parent,false);
		ViewHolder viewHolder=new ViewHolder(view);
		return viewHolder;
	}

	@Override
	public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder viewHolder, final int position) {
		viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				onItemClickListener.onItemClick((ViewHolder) viewHolder,position);
			}
		});
		viewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View v) {
				onItemClickListener.onItemLongClick((ViewHolder)viewHolder,position);
				return false;
			}
		});

		if(viewHolder instanceof ViewHolder){
			ViewHolder holder = (ViewHolder) viewHolder;
			final Post post = posts.get(position);
			holder.mTitle.setText(post.getPluginName());
			holder.mPluginName.setText(post.getPluginFullName());
			if(RePlugin.isPluginInstalled(post.getPluginName())){
				holder.mDownLoad.setText("开启");
				holder.mProgressBar.setMax(100);
				holder.mProgressBar.setProgress(100);
			}else{
				holder.mDownLoad.setText("下载");
				holder.mProgressBar.setMax(100);
				holder.mProgressBar.setProgress(0);
			}
			holder.mUninstall.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					boolean isSuccess = RePlugin.uninstall(post.getPluginName());
					if(isSuccess){
						notifyItemChanged(position);
					}
				}
			});
		}
	}

	public void setOnItemClickListener(OnItemClickListener onItemClickListener){
		this.onItemClickListener = onItemClickListener;
	}



	@Override
	public int getItemCount() {
		return posts.size();
	}
	public static class ViewHolder extends RecyclerView.ViewHolder {

		public static final int INIT = 0;
		public static final int LOADING = 1;
		public static final int LOADED = 2;

		public int status = INIT;

		public TextView mTitle;
		public TextView mPluginName;
		public TextView mAuthor;
		public TextView mDownLoad;
		public TextView mUninstall;
		public ProgressBar mProgressBar;

		public ViewHolder(View view){
			super(view);
			mTitle = view.findViewById(R.id.mTitle);
			mPluginName = view.findViewById(R.id.mPluginName);
			mAuthor = view.findViewById(R.id.mAuthor);
			mDownLoad = view.findViewById(R.id.mDownLoad);
			mUninstall  = view.findViewById(R.id.mUninstall);
			mProgressBar= view.findViewById(R.id.mProgressBar);
		}
	}
}
