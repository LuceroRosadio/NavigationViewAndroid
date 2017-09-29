package com.sunil.amcor.opcion.valuePlussTray.detalle.fragment;

import android.util.Log;

import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * Created by Lucero on 28/09/2017.
 */

public class PedidoDetalleInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {

        final String TAG = "PedidoDetalleInterceptor!";

        Response response = null;

        String responseString = "{\n" +
                "  \"mensajeAccion\": \"El pedido 19, fue enviado a la bandeja de Cliente.\"\n" +
                "}";

        Gson gson = new Gson();
        PedidoDtll pedidoDtll=gson.fromJson(bodyToString(chain.request()),PedidoDtll.class);

        response = new Response.Builder()
                .message(responseString)
                .request(chain.request())
                .code(200)
                .protocol(Protocol.HTTP_1_0)
                .body(ResponseBody.create(MediaType.parse("application/json"), responseString.getBytes()))
                .addHeader("content-type", "application/json")
                .build();

        return response;
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
