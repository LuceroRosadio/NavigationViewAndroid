package com.amcor.opcion.valuePlussTray.detalle;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Lucero on 14/09/2017.
 */

public interface RestDetalle {

    @GET("RS_Consulta/consulta/pedido/{numPedido}")
    Call<ObResponse> getDetalle(@Path("numPedido") String numPedido);
}
