package com.sunil.amcor;

import android.util.Log;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by Lucero on 10/08/2017.
 */

public class LoginInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        String requestUser = "test";
        String requestPassword = "test";


        Request request = chain.request().newBuilder()
                .put(RequestBody.create(MediaType.parse("user"), requestUser))
                .put(RequestBody.create(MediaType.parse("password"),requestPassword))
                .build();

        this.sleep();
        Log.d("NetworkSlowdown", "Network slowdown done. Proceeding chain");
        
        return chain.proceed(request);

        /*
        * .code(200)
                .message(responseString)
                .request(chain.request())
                .protocol(Protocol.HTTP_1_0)
                .body(ResponseBody.create(MediaType.parse("application/json"), responseString.getBytes()))
                .addHeader("content-type", "application/json")
                .build();
        * */
    }

    private void sleep() {
        try {
            Log.d("NetworkSlowdown", "Sleeping for 2 seconds");
            Thread.sleep(2 * 1000);
        } catch (InterruptedException e) {
            Log.e("NetworkSlowdown", "Interrupted", e);
        }
    }

    private String bodyToString(final Request request) {
        try {
            final Request copy = request.newBuilder().build();
            final okio.Buffer buffer = new okio.Buffer();

            if (copy.body() != null) {
                copy.body().writeTo(buffer);
                return buffer.readUtf8();
            }

            return "";
        } catch (final IOException e) {
            return "bodyToString error.";
        }}
}
