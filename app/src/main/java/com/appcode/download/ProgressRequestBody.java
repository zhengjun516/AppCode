package com.appcode.download;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.Buffer;
import okio.BufferedSink;
import okio.ForwardingSink;
import okio.Okio;
import okio.Sink;


public class ProgressRequestBody extends RequestBody {
    public static final int UPDATE = 0x01;

    private RequestBody requestBody;
    private ProgressListener mListener;
    private BufferedSink bufferedSink;
    private ProgressHandler mProgressHandler;

    public ProgressRequestBody(RequestBody body, ProgressListener listener) {
        requestBody = body;
        mListener = listener;
        if (mProgressHandler==null){
            mProgressHandler = new ProgressHandler();
        }
    }

    @Override
    public MediaType contentType() {
        return requestBody.contentType();
    }

    @Override
    public long contentLength() throws IOException {
        return requestBody.contentLength();
    }

    @Override
    public void writeTo(BufferedSink sink) throws IOException {

        if (bufferedSink==null){
            bufferedSink = Okio.buffer(interceptSink(sink));
        }
        requestBody.writeTo(bufferedSink);
        bufferedSink.flush();
    }

    /**
     * 拦截上传流的进度，并把上传进度上报给上层
     * @param sink
     * @return
     */
    private Sink interceptSink(BufferedSink sink) {

        return new ForwardingSink(sink) {
            long bytesWritten = 0L;
            long contentLength = 0L;
            @Override
            public void write(Buffer source, long byteCount) throws IOException {
                super.write(source, byteCount);
                if (contentLength==0){
                    contentLength = contentLength();
                }
                bytesWritten += byteCount;
                Message msg = Message.obtain();
                msg.what = UPDATE;
                msg.obj =  new ProgressModel(bytesWritten,contentLength,bytesWritten==contentLength);
                mProgressHandler.sendMessage(msg);
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
                    if (mListener!=null) {
                        mListener.onProgress(progressModel.getCurrentBytes(), progressModel.getContentLength());
                        mListener.onComplete(progressModel.isDone());
                    }
                    break;

            }
        }
    }


}
