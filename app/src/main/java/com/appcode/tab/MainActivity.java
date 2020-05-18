package com.appcode.tab;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.appcode.R;
import com.appcode.base.BaseFragmentPagerAdapter;
import com.appcode.blog.BlogFragment;
import com.appcode.book.BookFragment;
import com.appcode.code.CodeCategoryFragment;
import com.appcode.netplugin.NetPluginsFragment;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

	@BindView(R.id.mViewpager)
	protected ViewPager mViewPager;
	@BindView(R.id.mTabLayout)
	protected TabLayout mTabLayout;


	private BaseFragmentPagerAdapter mFragmentPagerAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ButterKnife.bind(this);

		initTab();

	}

	private void initTab() {
		mFragmentPagerAdapter =new TabFragmentAdapter(getSupportFragmentManager(),null);
		mFragmentPagerAdapter.addFragment("首页",new HomeFragment());
		mFragmentPagerAdapter.addFragment("博客",new BlogFragment());
		mFragmentPagerAdapter.addFragment("代码",new CodeCategoryFragment());
		mFragmentPagerAdapter.addFragment("书籍",new BookFragment());
		mFragmentPagerAdapter.addFragment("我的",new NetPluginsFragment());
		mViewPager.setAdapter(mFragmentPagerAdapter);
		mTabLayout.setupWithViewPager(mViewPager);
		mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
			@Override
			public void onTabSelected(TabLayout.Tab tab) {

			}

			@Override
			public void onTabUnselected(TabLayout.Tab tab) {

			}

			@Override
			public void onTabReselected(TabLayout.Tab tab) {

			}
		});
	}


}
