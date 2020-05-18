package com.appcode.tab;



import androidx.fragment.app.FragmentManager;

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
