package com.appcode.base;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.appcode.tab.TabFragmentItem;

import java.util.ArrayList;
import java.util.List;

public class BaseFragmentPagerAdapter extends FragmentStatePagerAdapter {

    protected List<TabFragmentItem> mFragmentItems;

    public BaseFragmentPagerAdapter(FragmentManager fm, List<TabFragmentItem> fragments) {
        super(fm);
        if (fragments != null) {
            this.mFragmentItems = fragments;
        } else {
            this.mFragmentItems = new ArrayList<TabFragmentItem>();
        }
    }

    public BaseFragmentPagerAdapter(FragmentManager fm) {
        this(fm,null);
    }

    @Override
    public Fragment getItem(int position) {
        if (mFragmentItems != null) {
            return mFragmentItems.get(position).getFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        if (mFragmentItems != null) {
            return mFragmentItems.size();
        }
        return 0;
    }

    public Object addFragment(String title, Fragment fragment) {
        if (mFragmentItems == null) {
            mFragmentItems = new ArrayList<TabFragmentItem>();
        }
        mFragmentItems.add(new TabFragmentItem(title,fragment));
        return fragment;
    }
}
