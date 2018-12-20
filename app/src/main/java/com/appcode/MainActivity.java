package com.appcode;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

	private List<TabFragmentItem> mFragmentList;

	@BindView(R.id.mViewpager)
	protected ViewPager mViewPager;
	@BindView(R.id.mTabLayout)
	protected TabLayout mTabLayout;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ButterKnife.bind(this);

		mFragmentList = new ArrayList<>();
		mFragmentList.add(new TabFragmentItem("首页",new HomeFragment()));
		mFragmentList.add(new TabFragmentItem("用户",new UserFragment()));
		mViewPager.setAdapter(new TabFragmentAdapter(getSupportFragmentManager(),getBaseContext(),mFragmentList));
		mTabLayout.setupWithViewPager(mViewPager);//此方法就是让tablayout和ViewPager联动

	}
}
