package com.demo.jaden.employapplication.network.callback;

import com.demo.jaden.employapplication.network.HttpInfo;

import java.io.IOException;

/**
 * 异步请求回调接口
 * @author zhousf
 * 该接口已过时，请使用com.okhttplib.callback.Callback
 */
@Deprecated
public interface CallbackOk  extends BaseCallback{
    /**
     * 该回调方法已切换到UI线程
     */
    void onResponse(HttpInfo info) throws IOException;
}
