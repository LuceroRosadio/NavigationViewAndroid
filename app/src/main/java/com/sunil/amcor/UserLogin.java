package com.sunil.amcor;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Lucero on 09/08/2017.
 */

public class UserLogin {
    @SerializedName("codUsuario")
    private String username;
    @SerializedName("contraseña")
    private String password;

    public UserLogin() {
    }

    public UserLogin(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserLogin{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
