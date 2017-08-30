package com.sunil.navigationviewandroid.opcion.valuePlussTray;

import android.util.Log;

import com.google.gson.Gson;
import com.sunil.navigationviewandroid.UserLogin;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * Created by Lucero on 23/08/2017.
 */

public class ValuePlusInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {

        final String TAG = "ValuePlusIntercetor!";

        Response response = null;
        Log.d(TAG, "response: ");

        String responseString = "{\n" +
                "            \"pedidos\": [\n" +
                "                {\n" +
                "                    \"archivo\": {\n" +
                "                        \"base64\": \"12334234\",\n" +
                "                        \"contentType\": \"appliction/pdf\",\n" +
                "                        \"nombreArchivo\": \"asdas.jpe\"\n" +
                "                    },\n" +
                "                    \"cantidad\": \"1\",\n" +
                "                    \"fechaSol\": \"10/01/2017\",\n" +
                "                    \"numeroPedido\": \"3\",\n" +
                "                    \"precioTotal\": \"2.9\",\n" +
                "                    \"producto\": \"marca 1\",\n" +
                "                    \"unidadMedida\": \"KG\",\n" +
                "                    \"version\": \"v01\",\n" +
                "                    \"color\":\"#F78181\",\n" +
                "                    \"estado\":1,\n" +
                "                    \"ubicacion\":\"VALUE PLUS\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"archivo\": {\n" +
                "                        \"base64\": \"12334234\",\n" +
                "                        \"contentType\": \"application/pdf\",\n" +
                "                        \"nombreArchivo\": \"asdas.jpe\"\n" +
                "                    },\n" +
                "                    \"cantidad\": \"10\",\n" +
                "                    \"cliente\": \"LUIS \",\n" +
                "                    \"fechaSol\": \"10/01/2017\",\n" +
                "                    \"numeroPedido\": \"8\",\n" +
                "                    \"precioTotal\": \"14.5\",\n" +
                "                    \"producto\": \"marca 1\",\n" +
                "                    \"unidadMedida\": \"KG\",\n" +
                "                    \"version\": \"v01\",\n" +
                "                    \"color\":\"blue\",\n" +
                "                    \"estado\" : 2\n" +
                "                }\n" +
                "            ]\n" +
                "            ,\"estados\": [\n" +
                "                {\n" +
                "                     \"estado\":1,\n" +
                "                    \"color\" : \"#ade\",\n" +
                "                    \"descripcion\": \"Estado 1\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"estado\":2,\n" +
                "                    \"color\" : \"#eee\",\n" +
                "                    \"descripcion\": \"Estado 2\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"estado\":3,\n" +
                "                    \"color\" : \"#fff\",\n" +
                "                    \"descripcion\": \"Estado 3\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"estado\":4,\n" +
                "                    \"color\" : \"#eee\",\n" +
                "                    \"descripcion\": \"Estado 4\"\n" +
                "                }\n" +
                "            ]\n" +
                "        }";

        response = new Response.Builder()
                .message(responseString)
                .request(chain.request())
                .code(200)
                .protocol(Protocol.HTTP_1_0)
                .body(ResponseBody.create(MediaType.parse("application/json"), responseString.getBytes()))
                .addHeader("content-type", "application/json")
                .build();

        //Log.d(TAG, "response: "+response.toString());

        return response;
    }

}
