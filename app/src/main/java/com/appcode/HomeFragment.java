package com.appcode;

import android.app.ProgressDialog;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.qihoo360.replugin.RePlugin;

public class HomeFragment extends BaseFragment {

	private static final int REQUEST_CODE_DEMO1 = 0x011;
	private static final int RESULT_CODE_DEMO1 = 0x012;

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Nullable
	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_home,container,false);
	}

	@Override
	public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);

		getView().findViewById(R.id.btn_start_demo1).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// 刻意以“包名”来打开
				RePlugin.startActivity(getActivity(), RePlugin.createIntent("com.qihoo360.replugin.sample.demo1", "com.qihoo360.replugin.sample.demo1.MainActivity"));
			}
		});

		getView().findViewById(R.id.btn_start_plugin_for_result).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// 刻意以“Alias（别名）”来打开
				Intent intent = new Intent();
				intent.setComponent(new ComponentName("demo1", "com.qihoo360.replugin.sample.demo1.activity.for_result.ForResultActivity"));
				RePlugin.startActivityForResult(getActivity(), intent, REQUEST_CODE_DEMO1, null);
			}
		});

		getView().findViewById(R.id.btn_load_fragment_from_demo1).setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				//startActivity(new Intent(getActivity(), PluginFragmentActivity.class));
			}
		});

		getView().findViewById(R.id.btn_start_demo3).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// 若没有安装，则直接提示“错误”
				// TODO 将来把回调串联上
				if (RePlugin.isPluginInstalled("demo3")) {
					RePlugin.startActivity(getActivity(), RePlugin.createIntent("demo3", "com.qihoo360.replugin.sample.demo3.MainActivity"));
				} else {
					Toast.makeText(getActivity(), "You must install demo3 first!", Toast.LENGTH_SHORT).show();
				}
			}
		});

		getView().findViewById(R.id.btn_start_demo4).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// 示例：直接通过宿主打开WebView插件中的Activity
				// FIXME: 后续可以将webview MainActivity URL 改为动态传入
				// 若没有安装，则直接提示“错误”
				if (RePlugin.isPluginInstalled("webview")) {
					RePlugin.startActivity(getActivity(), RePlugin.createIntent("webview", "com.qihoo360.replugin.sample.webview.MainActivity"));
				} else {
					Toast.makeText(getActivity(), "You must install webview first!", Toast.LENGTH_SHORT).show();
				}
			}
		});

		getView().findViewById(R.id.btn_start_demo5).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// 若没有安装，则直接提示“错误”
				// TODO 将来把回调串联上
				if (RePlugin.isPluginInstalled("plugin1")) {
					RePlugin.startActivity(getActivity(), RePlugin.createIntent("plugin1", "com.appcode.plugin.MainActivity"));
				} else {
					Toast.makeText(getActivity(), "You must install app-debug first!", Toast.LENGTH_SHORT).show();
				}
			}
		});


		getView().findViewById(R.id.btn_install_apk_from_assets).setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				final ProgressDialog pd = ProgressDialog.show(getActivity(), "Installing...", "Please wait...", true, true);
				// FIXME: 仅用于安装流程演示 2017/7/24
				new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
					@Override
					public void run() {
						//simulateInstallExternalPlugin();
						pd.dismiss();
					}
				}, 1000);
			}
		});
	}

	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);

	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();
	}
}
