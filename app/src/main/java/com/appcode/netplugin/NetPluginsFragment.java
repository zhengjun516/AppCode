package com.appcode.netplugin;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.appcode.AppCodeService;
import com.appcode.db.DataManager;
import com.appcode.DefaultOnItemClickListener;
import com.appcode.Post;
import com.appcode.R;
import com.appcode.base.BaseFragment;
import com.appcode.db.PluginManager;
import com.appcode.download.ProgressListener;
import com.qihoo360.replugin.RePlugin;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NetPluginsFragment extends BaseFragment {

	private AppCodeService appCodeService;
	private List<Post> posts;

	@BindView(R.id.mPluginsRecyclerView)
	protected RecyclerView mPluginsRecyclerView;

	private PluginPostAdapter mAdapter;
	private LinearLayoutManager mLayoutManager;
	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		posts = DataManager.getPosts();

		/*Retrofit retrofit = new Retrofit.Builder()
				.baseUrl("https://api.github.com/")
		.addConverterFactory(GsonConverterFactory.create())
				.build();

		appCodeService = retrofit.create(AppCodeService.class);
		appCodeService.listRepos().enqueue(new Callback<List<Post>>() {
			@Override
			public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {

			}

			@Override
			public void onFailure(Call<List<Post>> call, Throwable t) {

			}
		});*/
		//PluginManager.getInstance().downLoadPlugin(post);

	}

	@Nullable
	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_custom_ui,container,false);
		ButterKnife.bind(this,view);
		return view;
	}

	@Override
	public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
	}

	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		mLayoutManager = new LinearLayoutManager(getActivity());
		mLayoutManager.setOrientation(RecyclerView.VERTICAL);
		mPluginsRecyclerView.setLayoutManager(mLayoutManager);
		mPluginsRecyclerView.addItemDecoration(new RecycleViewDivider(getActivity(), LinearLayoutManager.VERTICAL, R.drawable.plugin_post_recycler_view_divider));

		mAdapter = new PluginPostAdapter(getActivity(),posts);
		mAdapter.setOnItemClickListener(new DefaultOnItemClickListener(){
			@Override
			public void onItemClick(PluginPostAdapter.ViewHolder viewHolder, int position) {
				Post post = posts.get(position);
				if(RePlugin.isPluginInstalled(post.getPluginName())){
					RePlugin.startActivity(getActivity(), RePlugin.createIntent(post.getPluginName(), post.getMainClass()));
				}else{
					if(viewHolder.status == PluginPostAdapter.ViewHolder.LOADING || viewHolder.status == PluginPostAdapter.ViewHolder.INIT){
						downloadPlugin(post,viewHolder);
					}
				}
			}
		});

		mPluginsRecyclerView.setAdapter(mAdapter);
	}

	private void downloadPlugin(Post post,final PluginPostAdapter.ViewHolder viewHolder) {
		PluginManager.getInstance().downLoadPlugin(post, new ProgressListener() {
			@Override
			public void onProgress(long currentBytes, long contentLength) {
				viewHolder.mProgressBar.setMax((int)contentLength);
				viewHolder.mProgressBar.setProgress((int)currentBytes);
			}

			@Override
			public void onComplete(boolean done) {
				if(done){
					viewHolder.mDownLoad.setText("启动");
					viewHolder.status = PluginPostAdapter.ViewHolder.LOADED;
				}
			}
		});
	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();
	}

}
