package com.sunil.amcor.opcion.valuePlussTray.api;

import com.sunil.amcor.opcion.valuePlussTray.model.OrderRequestResponse;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by Lucero on 23/08/2017.
 */

public interface RestPedido {

    @GET("RS_Consulta/consulta/pedido")
    Call<OrderRequestResponse> getOrder(@QueryMap Map<String, String> datos);
    //@Path("pedidos") String cliente
}
