package com.sunil.navigationviewandroid.opcion.createOrder;

import android.util.Log;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Protocol;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * Created by Lucero on 07/09/2017.
 */

public class CreateOrderInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {

        final String TAG = "CreateOrderInterceptor";

        Response response = null;
        Log.d(TAG, "response: ");

        String responseString = "{\"productos\":[{\n" +
                "          \"codProducto\":\"1\",\n" +
                "           \"marcaProducto\":\"producto1\",\n" +
                "          \"descripcionProducto\":\"descripcion1\",\n" +
                "          \"versionProducto\":\"v01\",\n" +
                "          \"sku\":1234,\n" +
                "          \"unidadMedida\":\"KG\",\n" +
                "          \"base64\":\"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\"\n" +
                "      },\n" +
                "          {\n" +
                "              \"codProducto\":\"2\",\n" +
                "              \"descripcionProducto\":\"descripcion2\",\n" +
                "              \"marcaProducto\":\"producto2\",\n" +
                "              \"versionProducto\":\"v02\",\n" +
                "              \"sku\":1234,\n" +
                "              \"unidadMedida\":\"KG\",\n" +
                "              \"base64\":\"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\"\n" +
                "          },\n" +
                "          {\n" +
                "              \"codProducto\":\"1236\",\n" +
                "              \"descripcionProducto\":\"descripcion3\",\n" +
                "              \"marcaProducto\":\"producto3\",\n" +
                "              \"versionProducto\":\"v01\",\n" +
                "              \"sku\":1234,\n" +
                "              \"unidadMedida\":\"KG\",\n" +
                "              \"base64\":\"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\"\n" +
                "          },\n" +
                "          {\n" +
                "              \"codProducto\":\"1237\",\n" +
                "              \"descripcionProducto\":\"descripcion4\",\n" +
                "              \"marcaProducto\":\"producto4\",\n" +
                "              \"versionProducto\":\"v01\",\n" +
                "              \"sku\":1234,\n" +
                "              \"unidadMedida\":\"KG\",\n" +
                "              \"base64\":\"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\"\n" +
                "          },\n" +
                "          {\n" +
                "              \"codProducto\":\"12379\",\n" +
                "              \"descripcionProducto\":\"descripcion5\",\n" +
                "              \"marcaProducto\":\"producto5\",\n" +
                "              \"versionProducto\":\"v01\",\n" +
                "              \"sku\":1234,\n" +
                "              \"unidadMedida\":\"KG\",\n" +
                "              \"base64\":\"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\"\n" +
                "          },\n" +
                "          {\n" +
                "              \"codProducto\":\"12371\",\n" +
                "              \"descripcionProducto\":\"descripcion6\",\n" +
                "              \"marcaProducto\":\"producto5\",\n" +
                "              \"versionProducto\":\"v01\",\n" +
                "              \"sku\":1234,\n" +
                "              \"unidadMedida\":\"KG\",\n" +
                "              \"base64\":\"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\"\n" +
                "          }]}";

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
}