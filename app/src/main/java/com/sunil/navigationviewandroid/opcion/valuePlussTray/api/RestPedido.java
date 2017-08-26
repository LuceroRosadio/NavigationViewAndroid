package com.sunil.navigationviewandroid.opcion.valuePlussTray.api;

import com.sunil.navigationviewandroid.opcion.valuePlussTray.model.OrderRequestResponse;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Lucero on 23/08/2017.
 */

public interface RestPedido {

    @GET("pedido")
    Call<OrderRequestResponse> getOrder();
    //@Path("pedidos") String cliente
}
