package com.appcode.net;

import okhttp3.OkHttpClient;

public class OkhttpProxy {

	private OkHttpClient okHttpClient;

	private static OkhttpProxy instance;

	private OkhttpProxy(){
		okHttpClient = new OkHttpClient();
	}

	public static OkhttpProxy getInstance(){
		if(instance == null){
			synchronized (OkhttpProxy.class){
				if(instance == null){
					instance = new OkhttpProxy();
				}
			}

		}
		return instance;
	}
}
