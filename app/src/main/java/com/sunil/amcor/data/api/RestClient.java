package com.sunil.amcor.data.api;

import com.sunil.amcor.UserLogin;
import com.sunil.amcor.data.UserResponse;
import com.sunil.amcor.opcion.valuePlussTray.detalle.fragment.AdvanceResponse;
import com.sunil.amcor.opcion.valuePlussTray.detalle.fragment.AdvanceRequest;
import com.sunil.amcor.opcion.valuePlussTray.detalle.fragment.BackRequest;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by Lucero on 09/08/2017.
 */

public interface RestClient {
    @POST("RS_User/login/user/movil")
    Call<UserResponse> authenticate(@Body UserLogin userLogin);

    @POST("RS_Pedido/solicitud/mantenimiento")
    Call<AdvanceResponse> advance(@Body AdvanceRequest advanceRequest);

    @POST("RS_Pedido/solicitud/mantenimiento")
    Call<AdvanceResponse> back(@Body BackRequest backRequest);
}
