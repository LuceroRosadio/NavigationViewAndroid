package com.sunil.navigationviewandroid.opcion.createOrder.api;

import com.sunil.navigationviewandroid.opcion.createOrder.model.CreateOrderResponse;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Lucero on 07/09/2017.
 */

public interface RestProducto {

    @GET("producto")
    Call<CreateOrderResponse> getProducto();
}
