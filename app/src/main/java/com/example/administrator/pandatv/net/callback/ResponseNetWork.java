package com.example.administrator.pandatv.net.callback;


import java.io.IOException;

import okhttp3.Response;

public interface ResponseNetWork {
    void onResponse(Response response) throws IOException;
    void onFailure(String errorMsg);
}
