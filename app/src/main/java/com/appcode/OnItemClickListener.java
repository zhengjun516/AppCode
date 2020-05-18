package com.appcode;


import com.appcode.netplugin.PluginPostAdapter;

public interface OnItemClickListener {
	void onItemClick(PluginPostAdapter.ViewHolder viewHolder, int position);
	void onItemLongClick(PluginPostAdapter.ViewHolder viewHolder, int position);
}
