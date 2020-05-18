package com.appcode.tab;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


import com.appcode.base.BaseFragmentPagerAdapter;

import java.util.List;

public class TabFragmentAdapter extends BaseFragmentPagerAdapter {

	public TabFragmentAdapter(FragmentManager fm, List<TabFragmentItem> tabFragmentItemList) {
		super(fm,tabFragmentItemList);
	}



	@Override
	public CharSequence getPageTitle(int position) {
		return mFragmentItems.get(position).getTitle();
	}
}
