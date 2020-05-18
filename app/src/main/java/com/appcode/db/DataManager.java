package com.appcode.db;

import com.appcode.Post;

import java.util.ArrayList;
import java.util.List;

public class DataManager {

	public static List<Post> getPosts(){

		List<Post> posts = new ArrayList<>();

		Post post = new Post();
		post.setPluginName("demo1");
		post.setPluginFullName("demo1.apk");
		post.setMainClass("com.qihoo360.replugin.sample.demo1.MainActivity");
		post.setPluginUrl("http://www.51shipin.com.cn:8080/download/plugin/demo1");
		posts.add(post);


		post = new Post();
		post.setPluginName("pluginTouchEvent");
		post.setPluginFullName("pluginTouchEvent.apk");
		post.setMainClass("com.appcode.touchevent.MainActivity");
		post.setPluginUrl("http://www.51shipin.com.cn:8080/download/plugin/pluginTouchEvent");
		posts.add(post);

		post = new Post();
		post.setPluginName("pluginDesignPatterns");
		post.setPluginFullName("pluginDesignPatterns.apk");
		post.setMainClass("com.appcode.plugin.designpatterns.MainActivity");
		post.setPluginUrl("http://www.51shipin.com.cn:8080/download/plugin/pluginDesignPatterns");
		posts.add(post);



		post = new Post();
		post.setPluginName("demo3");
		post.setPluginFullName("demo3.apk");
		post.setMainClass("com.qihoo360.replugin.sample.demo3.MainActivity");
		post.setPluginUrl("http://www.51shipin.com.cn:8080/download/plugin/demo3");
		posts.add(post);

		post = new Post();
		post.setPluginName("pluginLogin");
		post.setPluginFullName("pluginLogin.apk");
		post.setMainClass("com.appcode.plugin.login.MainActivity");
		post.setPluginUrl("http://www.51shipin.com.cn:8080/download/plugin/pluginLogin");
		posts.add(post);

		post = new Post();
		post.setPluginName("pluginMap2D");
		post.setPluginFullName("pluginMap2D.apk");
		post.setMainClass("com.appcode.map2d.MainActivity");
		post.setPluginUrl("http://www.51shipin.com.cn:8080/download/plugin/pluginMap2D");
		posts.add(post);

		post = new Post();
		post.setPluginName("pluginMap3D");
		post.setPluginFullName("pluginMap3D.apk");
		post.setMainClass("com.appcode.map3d.MainActivity");
		post.setPluginUrl("http://www.51shipin.com.cn:8080/download/plugin/pluginMap3D");
		posts.add(post);

		post = new Post();
		post.setPluginName("pluginRxJava");
		post.setPluginFullName("pluginRxJava.apk");
		post.setMainClass("com.appcode.plugin.rxjava.MainActivity");
		post.setPluginUrl("http://www.51shipin.com.cn:8080/download/plugin/pluginRxJava");
		posts.add(post);

		post = new Post();
		post.setPluginName("pluginMvp");
		post.setPluginFullName("pluginMvp.apk");
		post.setMainClass("com.appcode.plugin.mvp.MainActivity");
		post.setPluginUrl("http://www.51shipin.com.cn:8080/download/plugin/pluginMvp");
		posts.add(post);

		post = new Post();
		post.setPluginName("pluginMvvM");
		post.setPluginFullName("pluginMvvM.apk");
		post.setMainClass("com.appcode.mvvm.viewmodel.ViewModelActivity");
		post.setPluginUrl("http://www.51shipin.com.cn:8080/download/plugin/pluginMvvM");
		posts.add(post);

		post = new Post();
		post.setPluginName("pluginDagger2");
		post.setPluginFullName("pluginDagger2.apk");
		post.setMainClass("com.appcode.plugin.dagger2.MainActivity");
		post.setPluginUrl("http://www.51shipin.com.cn:8080/download/plugin/pluginDagger2");
		posts.add(post);

		post = new Post();
		post.setPluginName("pluginOkhttp");
		post.setPluginFullName("pluginOkhttp.apk");
		post.setMainClass("com.appcode.plugin.okhttp.MainActivity");
		post.setPluginUrl("http://www.51shipin.com.cn:8080/download/plugin/pluginOkhttp");
		posts.add(post);

		post = new Post();
		post.setPluginName("pluginDianDian");
		post.setPluginFullName("pluginDianDian.apk");
		post.setMainClass("com.diandian.mobi.StartActivity");
		post.setPluginUrl("http://www.51shipin.com.cn:8080/download/plugin/pluginDianDian");
		posts.add(post);


		post = new Post();
		post.setPluginName("pluginIJKPlayer");
		post.setPluginFullName("pluginIJKPlayer.apk");
		post.setMainClass("tv.danmaku.ijk.media.example.activities.SampleMediaActivity");
		post.setPluginUrl("http://www.51shipin.com.cn:8080/download/plugin/pluginIJKPlayer");
		posts.add(post);


		post = new Post();
		post.setPluginName("pluginArtPlayer");
		post.setPluginFullName("pluginArtPlayer.apk");
		post.setMainClass("org.salient.artvideoplayer.activity.MainActivity");
		post.setPluginUrl("http://www.51shipin.com.cn:8080/download/plugin/pluginArtPlayer");
		posts.add(post);


		return posts;
	}
}
