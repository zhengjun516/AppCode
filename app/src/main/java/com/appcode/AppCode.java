package com.appcode;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;

import com.qihoo360.replugin.RePlugin;
import com.qihoo360.replugin.RePluginConfig;

public class AppCode extends Application {
	@Override
	protected void attachBaseContext(Context base) {
		super.attachBaseContext(base);
		RePluginConfig rePluginConfig = new RePluginConfig();
		rePluginConfig.setVerifySign(!BuildConfig.DEBUG);
		RePlugin.App.attachBaseContext(this,rePluginConfig);
	}

	@Override
	public void onCreate() {
		super.onCreate();
		RePlugin.App.onCreate();
	}

	@Override
	public void onTrimMemory(int level) {
		super.onTrimMemory(level);
		RePlugin.App.onTrimMemory(level);
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		RePlugin.App.onConfigurationChanged(newConfig);
	}
}
