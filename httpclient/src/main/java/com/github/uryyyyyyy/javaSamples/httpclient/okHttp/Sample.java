package com.github.uryyyyyyy.javaSamples.httpclient.okHttp;


import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Sample {
    public static void main(String args[]) {

        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(2, TimeUnit.SECONDS)
                .build();  //(1)
        Request request = new Request.Builder()
                .url("http://example.com").build(); //(2)

        Call call = client.newCall(request); //(3)
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                throw new RuntimeException(e);
            }

            @Override
            public void onResponse(Response response) throws IOException { // ----(4)
                if(!response.isSuccessful()) {
                    // エラーが返ってきた時の処理
                    System.out.println(response.body());
                }
                System.out.println("response:" + response.body().string()); //-----(5)
                response.body().close();
            }
        });
    }
}