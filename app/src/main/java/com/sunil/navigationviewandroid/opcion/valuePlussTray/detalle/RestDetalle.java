package com.sunil.navigationviewandroid.opcion.valuePlussTray.detalle;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Lucero on 14/09/2017.
 */

public interface RestDetalle {

    @GET("detalle")
    Call<ObResponse> getDetalle();
}
