package com.amcor.opcion.valuePlussTray.api;

import com.amcor.opcion.reporteGerencialTonelada.model.ReportePedidoResponse;
import com.amcor.opcion.reporteGerencialVenta.model.ReporteClienteResponse;
import com.amcor.opcion.valuePlussTray.model.OrderRequestResponse;

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

    @GET("reportePedido")
    Call<ReportePedidoResponse> reportePedido(@QueryMap Map<String, String> datos);

    @GET("reporteCliente")
    Call<ReporteClienteResponse> reporteCliente(@QueryMap Map<String, String> datos);
}
