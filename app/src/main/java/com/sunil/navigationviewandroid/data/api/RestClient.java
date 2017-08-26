package com.sunil.navigationviewandroid.data.api;

import com.sunil.navigationviewandroid.UserLogin;
import com.sunil.navigationviewandroid.data.UserResponse;

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
