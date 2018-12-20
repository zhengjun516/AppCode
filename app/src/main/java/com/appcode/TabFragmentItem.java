package com.appcode;

import android.support.v4.app.Fragment;

public class TabFragmentItem {
	private String title;
	private Fragment fragment;

	public TabFragmentItem(String title, Fragment fragment) {
		this.title = title;
		this.fragment = fragment;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Fragment getFragment() {
		return fragment;
	}

	public void setFragment(Fragment fragment) {
		this.fragment = fragment;
	}
}
