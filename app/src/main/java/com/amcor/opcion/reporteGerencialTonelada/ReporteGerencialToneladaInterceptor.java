package com.amcor.opcion.reporteGerencialTonelada;

import android.content.Context;
import android.util.Log;

import com.amcor.R;

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
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * Created by Lucero on 23/08/2017.
 */

public class ReporteGerencialToneladaInterceptor implements Interceptor {
    Context context;
    ReporteGerencialToneladaInterceptor(Context context){
        this.context=context;
    }
    @Override
    public Response intercept(Chain chain) throws IOException {

        final String TAG = "RGTInterceptor!";

        Response response = null;
        InputStream is = context.getResources().openRawResource(R.raw.reporte_pedido);
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

        response = new Response.Builder()
                .message(jsonString)
                .request(chain.request())
                .code(200)
                .protocol(Protocol.HTTP_1_0)
                .body(ResponseBody.create(MediaType.parse("application/json"), jsonString.getBytes()))
                .addHeader("content-type", "application/json")
                .build();

        //Log.d(TAG, "response: "+response.toString());

        return response;
    }

}
