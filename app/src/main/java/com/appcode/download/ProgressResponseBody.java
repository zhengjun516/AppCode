package com.appcode.download;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.ForwardingSource;
import okio.Okio;
import okio.Source;


public class ProgressResponseBody extends ResponseBody {

    public static final int UPDATE = 0x01;
    
    private ResponseBody responseBody;
    private ProgressListener mProgressListener;
    private BufferedSource bufferedSource;
    private Handler progressHandler;
    
    public ProgressResponseBody(ResponseBody body, ProgressListener listener) {
        responseBody = body;
        mProgressListener = listener;
        if (progressHandler==null){
            progressHandler = new ProgressHandler();
        }
    }

    @Override
    public MediaType contentType() {
        return responseBody.contentType();
    }

    @Override
    public long contentLength() {
        return responseBody.contentLength();
    }

    @Override
    public BufferedSource source() {
        if (bufferedSource==null){
            bufferedSource = Okio.buffer(interceptSource(responseBody.source()));
        }
        return bufferedSource;
    }

    /**
     * 拦截流的读取，并把读取进度上报给上层
     * @param source
     * @return
     */
    private Source interceptSource(Source source) {
        return  new ForwardingSource(source) {
            long totalBytesRead = 0L;
            @Override
            public long read(Buffer sink, long byteCount) throws IOException {
                long bytesRead = super.read(sink, byteCount);

                totalBytesRead +=bytesRead!=-1?bytesRead:0;
                Message msg = Message.obtain();
                msg.what = UPDATE;
                msg.obj =  new ProgressModel(totalBytesRead,contentLength(),totalBytesRead==contentLength());
                progressHandler.sendMessage(msg);
                return bytesRead;
            }
        };
    }

    class ProgressHandler extends Handler {

        public ProgressHandler() {
            super(Looper.getMainLooper());
        }

        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case UPDATE:
                    ProgressModel progressModel = (ProgressModel) msg.obj;
                    if (mProgressListener!=null) {
                        mProgressListener.onProgress(progressModel.getCurrentBytes(), progressModel.getContentLength());
                        mProgressListener.onComplete(progressModel.isDone());
                    }
                    break;
            }
        }
    }
}
