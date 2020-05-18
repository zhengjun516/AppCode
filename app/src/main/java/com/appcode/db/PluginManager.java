package com.appcode.db;

import android.content.Context;
import android.util.Log;

import com.appcode.Post;
import com.appcode.download.DownLoadManager;
import com.appcode.download.ProgressListener;
import com.qihoo360.replugin.RePlugin;
import com.qihoo360.replugin.model.PluginInfo;
import com.qihoo360.replugin.utils.FileUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class PluginManager {

	private static final String TAG = "PluginManager";

	private static PluginManager instance;
	private DownLoadManager downLoadManager;

	private PluginManager(){
		downLoadManager = DownLoadManager.getInstance();
	}

	public static PluginManager getInstance(){
		if(instance == null){
			synchronized (PluginManager.class){
				instance = new PluginManager();
			}
		}
		return  instance;
	}

	public void downLoadPlugin(Post post){
		downLoadPlugin(post,null);
	}

	public void downLoadPlugin(final Post post,final ProgressListener progressListener){

		downLoadManager.downloadFile(post.getPluginUrl(), new ProgressListener() {
			@Override
			public void onProgress(long currentBytes, long contentLength) {
				if(progressListener != null){
					progressListener.onProgress(currentBytes,contentLength);
				}
			}
			@Override
			public void onComplete(boolean done) {
				if(progressListener != null){
					progressListener.onComplete(done);
				}
			}
		}, new Callback() {
			@Override
			public void onFailure(Call call, IOException e) {
				Log.d(TAG,e.getMessage());
			}

			@Override
			public void onResponse(Call call, Response response) throws IOException {
				String pluginFilePath = DownLoadManager.getContext().getFilesDir().getAbsolutePath()+File.separator+post.getPluginFullName();
				File pluginFile = new File(pluginFilePath);
				if(pluginFile.exists()){
					FileUtils.deleteQuietly(pluginFile);
				}

				InputStream inputStream = null;
				FileOutputStream outputStream = null;
				try {
					if(response.isSuccessful()){
						//将响应数据转化为输入流数据
						inputStream=response.body().byteStream();
						outputStream = (downLoadManager.getContext().openFileOutput(post.getPluginFullName(),Context.MODE_PRIVATE));

						byte[] buf = new byte[1024];
						int ch = -1;
						while ((ch = inputStream.read(buf)) != -1) {
							outputStream.write(buf, 0, ch);
						}
						//刷新文件流
						outputStream.flush();
						outputStream.close();
					}
				}catch (Exception e){
					e.printStackTrace();

				}finally {
					try {
						if(inputStream != null) {
							inputStream.close();
						}
					} catch (IOException e) {
					}
					try {
						if(outputStream != null) {
							outputStream.close();
						}
					} catch (IOException e) {
					}
				}
				PluginInfo pluginInfo = null;
				if (pluginFile.exists()) {
					pluginInfo = RePlugin.install(pluginFilePath);
				}
				if(pluginInfo != null){
					RePlugin.preload(pluginInfo);
				}
			}
		});
	}
}
