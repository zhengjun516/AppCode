package com.appcode.download;

public interface ProgressListener {
    void onProgress(long currentBytes, long contentLength);
    void onComplete(boolean done);
}
