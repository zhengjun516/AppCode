package com.appcode.download;

import android.content.Context;
import android.util.Log;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.CacheControl;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;


public class DownLoadManager {
    public  final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    public  final MediaType MEDIA_TYPE_MARKDOWN = MediaType.parse("text/x-markdown; charset=utf-8");

    private static Context mContext;


    private static OkHttpClient.Builder builder;
    static {
        builder = new OkHttpClient.Builder();
        builder.connectTimeout(10000, TimeUnit.MILLISECONDS);
        builder.readTimeout(10000,TimeUnit.MILLISECONDS);
        builder.writeTimeout(10000,TimeUnit.MILLISECONDS);
        builder.addNetworkInterceptor(new HttpLoggingInterceptor());
    }
    private static OkHttpClient okHttpClient = builder.build();

    private static DownLoadManager instance;

    private DownLoadManager(){
    }

    public static void init(Context context){
        mContext = context;
    }

    public static Context getContext(){
        return mContext;
    }

    public static DownLoadManager getInstance(){
        if(instance == null){
           synchronized (DownLoadManager.class){
               instance = new DownLoadManager();
           }
        }
        return instance;
    }

    public void downloadFile(String url, final ProgressListener processListener, Callback callback){

        OkHttpClient client = okHttpClient.newBuilder().addNetworkInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Response response = chain.proceed(chain.request());
                return response.newBuilder().body(new ProgressResponseBody(response.body(),processListener)).build();
            }
        }).build();

        Request request  = new Request.Builder().url(url).build();
        client.newCall(request).enqueue(callback);
    }

    /**
     *
     * @param url
     * @param processListener
     * @return
     */
    public Response synDownloadFile(String url, final ProgressListener processListener){
        try {
            OkHttpClient client = okHttpClient.newBuilder().addNetworkInterceptor(new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Response response = chain.proceed(chain.request());
                    return response.newBuilder().body(new ProgressResponseBody(response.body(),processListener)).build();
                }
            }).build();

            Request request  = new Request.Builder().url(url).build();
           return client.newCall(request).execute();
        }catch (Exception e){

        }
        return null;
    }


    public  void postFile(String url, final ProgressListener processListener, Callback callback, File...files){

        MultipartBody.Builder builder = new MultipartBody.Builder();
        builder.setType(MultipartBody.FORM);
        builder.addFormDataPart("filename",files[0].getName());
        builder.addFormDataPart("position","0");
        builder.addFormDataPart("file",files[0].getName(), RequestBody.create(MediaType.parse("application/octet-stream"),files[0]));

        MultipartBody multipartBody = builder.build();

        Request request  = new Request.Builder().url(url).post(new ProgressRequestBody(multipartBody,processListener)).build();
        okHttpClient.newCall(request).enqueue(callback);
    }



    public  String doGet(String url){
        Request request  = new Request.Builder().url(url).build();
        try {
            Response response = okHttpClient.newCall(request).execute();
            if (response!=null){
                return response.body().string();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    public  void doGet(String url,Callback callback){
        Request request  = new Request.Builder().url(url).build();
        okHttpClient.newCall(request).enqueue(callback);
    }

    public  String doPost(String url,String userName,String password){

        FormBody.Builder formBodyBuilder = new FormBody.Builder();
        formBodyBuilder.add("username",userName);
        formBodyBuilder.add("password",password);

        Request request  = new Request.Builder().url(url).post(formBodyBuilder.build()).build();
        try {
            Response response = okHttpClient.newCall(request).execute();
            if (response!=null){
                return response.body().string();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    public  void doPost(String url,String userName,String password,Callback callback){
        MultipartBody.Builder builder = new MultipartBody.Builder();
        builder.setType(MultipartBody.FORM);
        builder.addFormDataPart("username",userName);
        builder.addFormDataPart("password",password);

        Request request  = new Request.Builder().url(url).post(builder.build()).build();
        okHttpClient.newCall(request).enqueue(callback);
    }


    public  void crach(){
        CacheControl.Builder builder = new CacheControl.Builder();
        //不使用缓存，全部走网络
        builder.noCache();
        //不使用缓存，也不存储缓存
        builder.noStore();
        //只使用缓存
        builder.onlyIfCached();
        //禁止转码
        builder.noTransform();
        //指示客户机可以接收生存期不大于指定时间的响应。
        builder.maxAge(10, TimeUnit.MILLISECONDS);
        //指示客户机可以接收超出超时期间的响应消息
        builder.maxStale(10, TimeUnit.SECONDS);
        //指示客户机可以接收响应时间小于当前时间加上指定时间的响应。
        builder.minFresh(10, TimeUnit.SECONDS);
        //cacheControl
        CacheControl cache = builder.build();


        MultipartBody.Builder multipartBodyBuilder = new MultipartBody.Builder();
        multipartBodyBuilder.addFormDataPart("username","password");
        RequestBody requestBody = multipartBodyBuilder.build();
        Request request = new Request.Builder().post(requestBody).cacheControl(cache).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()){

                }
            }
        });
    }


    public class HttpLogger implements HttpLoggingInterceptor.Logger {
        @Override
        public void log(String message) {
            Log.d("HttpLogInfo", message);
        }
    }

}
