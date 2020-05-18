package com.appcode.code;


import androidx.fragment.app.FragmentManager;

import com.appcode.base.BaseFragmentPagerAdapter;

public class CodeFragmentAdapter extends BaseFragmentPagerAdapter {

	public CodeFragmentAdapter(FragmentManager fm) {
		super(fm);
	}

	@Override
	public CharSequence getPageTitle(int position) {
		return mFragmentItems.get(position).getTitle();
	}

}
