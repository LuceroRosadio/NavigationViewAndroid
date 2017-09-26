package com.sunil.amcor.data.api;

import com.sunil.amcor.UserLogin;
import com.sunil.amcor.data.UserResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by Lucero on 09/08/2017.
 */

public interface RestClient {

    @POST("authenticate")
    Call<UserResponse> authenticate(@Body UserLogin userLogin);
}
