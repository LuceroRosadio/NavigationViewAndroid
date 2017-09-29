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
    AdvanceInterceptor(Context context){
        this.context=context;
    }
//aca dentro de chain
    @Override
    public Response intercept(Chain chain) throws IOException {
        //chain.request().body() //aca esta la info que le enviaste desde aki
        //cuando tu llamas recien al api es decir a ese metodo  este interceptor lo captura
        //es en este objeto donde tienes el request

        Response response = null;
        final String TAG = "LoginIntercetor!";
        InputStream is = context.getResources().openRawResource(R.raw.login);
        Writer writer = new StringWriter();
        char[] buffer = new char[1024];
        try {
            Reader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            int n;
            while ((n = reader.read(buffer)) != -1) {
                writer.write(buffer, 0, n);
            }
        } finally {
            is.close();
        }
        Log.d(TAG, "response: ");

        String jsonString = writer.toString();
        Gson gson = new Gson();
        UserLogin userLogin=gson.fromJson(bodyToString(chain.request()),UserLogin.class);


        Log.i("Parametros",bodyToString(chain.request()));
        int code;
        if("test".equals(userLogin.getUsername()) && "test".equals(userLogin.getPassword())){
            code=200;
        }
        else{
            code=401;
        }

        response = new Response.Builder()
                .code(code)
                .message(jsonString)
                .request(chain.request())
                .protocol(Protocol.HTTP_1_0)
                .body(ResponseBody.create(MediaType.parse("application/json"), jsonString.getBytes()))
                .addHeader("content-type", "application/json")
                .build();

        this.sleep();
        Log.d("NetworkSlowdown", "Network slowdown done. Proceeding chain");

        return response;
    }

    private void sleep() {
        try {
            Log.d("NetworkSlowdown", "Sleeping for 3 seconds");
            Thread.sleep(1 * 1000);
        } catch (InterruptedException e) {
            Log.e("NetworkSlowdown", "Interrupted", e);
        }
    }

    //este metodo no se que hace :p
    //el request que le envias  , especificamente los datos que le envias lo convierte en un string con formato json
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
