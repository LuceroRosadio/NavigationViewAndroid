package com.sunil.amcor;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * Created by Lucero on 09/08/2017.
 */

public class AdvanceInterceptor implements Interceptor {
    Context context;
    public AdvanceInterceptor(Context context){
        this.context=context;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Response response = null;
        final String TAG = "AdvanceIntercetor!";
        InputStream is = context.getResources().openRawResource(R.raw.advance);
        Writer writer = new StringWriter();
        char[] buffer = new char[1024];
        try {
            Thread.sleep(2000l);
            Reader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            int n;
            while ((n = reader.read(buffer)) != -1) {
                writer.write(buffer, 0, n);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            is.close();
        }
        Log.d(TAG, "response: ");

        String jsonString = writer.toString();



        response = new Response.Builder()
                .code(200)
                .message(jsonString)
                .request(chain.request())
                .protocol(Protocol.HTTP_1_0)
                .body(ResponseBody.create(MediaType.parse("application/json"), jsonString.getBytes()))
                .addHeader("content-type", "application/json")
                .build();
        //this.sleep();

        return response;
    }
    private void sleep() {
        try {
            Log.d("NetworkSlowdown", "Sleeping for 3 seconds");
            Thread.sleep(2 * 1000);
        } catch (InterruptedException e) {
            Log.e("NetworkSlowdown", "Interrupted", e);
        }
    }


}
