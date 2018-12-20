package com.appcode;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

public class TabFragmentAdapter extends FragmentPagerAdapter {

	private Context context;
	private List<TabFragmentItem> tabFragmentItemList;
	public TabFragmentAdapter(FragmentManager fm,Context context,List<TabFragmentItem> tabFragmentItemList) {
		super(fm);
		this.context = context;
		this.tabFragmentItemList = tabFragmentItemList;
	}

	@Override
	public Fragment getItem(int position) {
		return tabFragmentItemList.get(position).getFragment();
	}
	@Override
	public int getCount() {
		return tabFragmentItemList.size();
	}

	@Override
	public CharSequence getPageTitle(int position) {
		return tabFragmentItemList.get(position).getTitle();
	}
}
