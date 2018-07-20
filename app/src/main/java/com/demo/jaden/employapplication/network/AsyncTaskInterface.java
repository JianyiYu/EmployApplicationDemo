package com.demo.jaden.employapplication.network;

import okhttp3.Request;
import okhttp3.RequestBody;

public interface AsyncTaskInterface {

    Request createPostRequest();

    Request.Builder createHead();

    RequestBody createBody();
}
