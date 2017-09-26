package com.sunil.amcor;

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
 * Created by Lucero on 09/08/2017.
 */

public class FakeInterceptor implements Interceptor {
//aca dentro de chain
    @Override
    public Response intercept(Chain chain) throws IOException {
        //chain.request().body() //aca esta la info que le enviaste desde aki
        //cuando tu llamas recien al api es decir a ese metodo  este interceptor lo captura
        //es en este objeto donde tienes el request

        Response response = null;

        String responseString = "{\n" +
                "  \"usuario\": {\n" +
                "    \"cliente\": {\n" +
                "      \"codCliente\": \"1\",\n" +
                "      \"correo\": \"luis.huapaya1389@gmail.com\",\n" +
                "      \"nombreCliente\": \"LUIS  HUAPAYA\"\n" +
                "    },\n" +
                "    \"codUsuario\": \"LHUAPAYA\",\n" +
                "    \"codPerfil\": \"1320\",\n" +
                "    \"modulos\": [\n" +
                "      {\n" +
                "        \"codModulo\": \"APRPED\",\n" +
                "        \"nombreModulo\": \"Aprobaci\\u00f3n Pedido\",\n" +
                "        \"opciones\": [\n" +
                "          {\n" +
                "            \"codOpcion\": \"SPR\",\n" +
                "            \"codPerfil\": \"CL\",\n" +
                "            \"estadoOpcion\": \"orderRequest\",\n" +
                "            \"nombreOpcion\": \"Solicitar Pedido Repetido\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"codOpcion\": \"CTP\",\n" +
                "            \"codPerfil\": \"CL\",\n" +
                "            \"estadoOpcion\": \"queryTracking\",\n" +
                "            \"nombreOpcion\": \"Consultar Tracking de Pedido\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"codOpcion\": \"BV\",\n" +
                "            \"codPerfil\": \"VP\",\n" +
                "            \"estadoOpcion\": \"valuePlussTray\",\n" +
                "            \"nombreOpcion\": \"Bandeja Value Plus\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"codOpcion\": \"MMP\",\n" +
                "            \"codPerfil\": \"VP\",\n" +
                "            \"estadoOpcion\": \"matrixMaintenance\",\n" +
                "            \"nombreOpcion\": \"Mantenimiento Matriz Precio\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"codOpcion\": \"BC\",\n" +
                "            \"codPerfil\": \"GC\",\n" +
                "            \"estadoOpcion\": \"commercialTray\",\n" +
                "            \"nombreOpcion\": \"Bandeja Comercial\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"codOpcion\": \"RPR\",\n" +
                "            \"codPerfil\": \"EC\",\n" +
                "            \"estadoOpcion\": \"createOrder\",\n" +
                "            \"nombreOpcion\": \"Registrar Pedidos Repetidos\"\n" +
                "          }\n" +
                "        ]\n" +
                "      },\n" +
                "      {\n" +
                "        \"codModulo\": \"SEGPROD\",\n" +
                "        \"nombreModulo\": \"Seguimiento Producto\",\n" +
                "        \"opciones\": [\n" +
                "          {\n" +
                "            \"codOpcion\": \"CHP\",\n" +
                "            \"codPerfil\": \"CL\",\n" +
                "            \"estadoOpcion\": \"historicaQuery\",\n" +
                "            \"nombreOpcion\": \"Consultar Historico de Pedido\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"codOpcion\": \"CPR\",\n" +
                "            \"codPerfil\": \"EC\",\n" +
                "            \"estadoOpcion\": \"queryOrder\",\n" +
                "            \"nombreOpcion\": \"Consultar Pedidos Repetidos\"\n" +
                "          }\n" +
                "        ]\n" +
                "      }\n" +
                "    ],\n" +
                "    \"nombresUsuario\": \"Luis Huapaya\",\n" +
                "    \"productos\": [\n" +
                "      {\n" +
                "        \"codProducto\": \"1\",\n" +
                "        \"nombreProducto\": \"PRODUCTO 1\",\n" +
                "        \"unidad\": \"KG\",\n" +
                "        \"version\": \"v01\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"codProducto\": \"2\",\n" +
                "        \"nombreProducto\": \"producto 2\",\n" +
                "        \"unidad\": \"kg\",\n" +
                "        \"version\": \"v02\"\n" +
                "      }\n" +
                "    ]\n" +
                "  },\n" +
                "  \"token\": \"12345543\"\n" +
                "}";
        Gson gson = new Gson();
        UserLogin userLogin=gson.fromJson(bodyToString(chain.request()),UserLogin.class);

        Log.i("lu",userLogin.toString());
        int code;
        if("test".equals(userLogin.getUsername()) && "test".equals(userLogin.getPassword())){
            code=200;
        }
        else{
            code=401;
        }

        response = new Response.Builder()
                .code(code)
                .message(responseString)
                .request(chain.request())
                .protocol(Protocol.HTTP_1_0)
                .body(ResponseBody.create(MediaType.parse("application/json"), responseString.getBytes()))
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
