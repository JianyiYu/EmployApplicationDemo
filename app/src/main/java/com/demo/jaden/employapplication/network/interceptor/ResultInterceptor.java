package com.demo.jaden.employapplication.network.interceptor;

import com.demo.jaden.employapplication.network.HttpInfo;

/**
 * 请求结果拦截器
 * @author zhousf
 */
public interface ResultInterceptor {

    HttpInfo intercept(HttpInfo info) throws Exception;

}
