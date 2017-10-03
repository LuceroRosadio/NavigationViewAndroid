package com.amcor.opcion.createOrder.api;

import com.amcor.opcion.createOrder.model.CreateOrderResponse;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Lucero on 07/09/2017.
 */

public interface RestProducto {

    @GET("producto")
    Call<CreateOrderResponse> getProducto();
}
