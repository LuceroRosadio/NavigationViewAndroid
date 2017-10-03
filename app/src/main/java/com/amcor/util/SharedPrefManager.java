package com.amcor.util;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;

import com.amcor.LoginActivity;
import com.amcor.data.UserResponse;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.gson.Gson;

/**
 * Created by johel on 2/10/2017.
 */

public class SharedPrefManager {

    private static final String SHARED_PREF_NAME = "amcorsharedpref";
    private static final String KEY_USER = "keyuser";
    private static final Gson gson=new Gson();
    private static SharedPrefManager mInstance;
    private static Context mCtx;

    private SharedPrefManager(Context context) {
        mCtx = context;
    }
    public static synchronized SharedPrefManager getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new SharedPrefManager(context);
        }
        return mInstance;
    }

    public void userLogin(UserResponse user) {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_USER, gson.toJson(user));
        editor.apply();
    }
    public boolean isLoggedIn() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        Log.d("shared", "boolean:"+(sharedPreferences.getString(KEY_USER, null) != null));
        return sharedPreferences.getString(KEY_USER, null) != null;
    }
    public UserResponse getUserResponse() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return  gson.fromJson(sharedPreferences.getString(KEY_USER,null),UserResponse.class);
    }

    public void logout() {
        FirebaseMessaging.getInstance().unsubscribeFromTopic(getUserResponse().getUsuario().getCodPerfil());
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
        mCtx.startActivity(new Intent(mCtx, LoginActivity.class));
    }
}
