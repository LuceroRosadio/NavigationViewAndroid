package com.amcor.data;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Lucero on 09/08/2017.
 */

public class UserResponse implements Parcelable{

    @SerializedName("usuario")
    private Usuario usuario;
    @SerializedName("token")
    private String token;

    public UserResponse() {
    }

    public UserResponse(Usuario usuario, String token) {
        this.usuario = usuario;
        this.token = token;
    }


    protected UserResponse(Parcel in) {
        usuario = in.readParcelable(Usuario.class.getClassLoader());
        token = in.readString();
    }

    public static final Creator<UserResponse> CREATOR = new Creator<UserResponse>() {
        @Override
        public UserResponse createFromParcel(Parcel in) {
            return new UserResponse(in);
        }

        @Override
        public UserResponse[] newArray(int size) {
            return new UserResponse[size];
        }
    };

    @Override
    public String toString() {
        return "UserResponse{" +
                "usuario=" + usuario +
                ", token='" + token + '\'' +
                '}';
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(usuario, flags);
        dest.writeString(token);
    }
}
