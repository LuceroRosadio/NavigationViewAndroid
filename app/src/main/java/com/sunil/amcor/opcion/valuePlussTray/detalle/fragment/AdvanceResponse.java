package com.sunil.amcor.opcion.valuePlussTray.detalle.fragment;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Lucero on 27/09/2017.
 */

public class DetalleResponse implements Parcelable {

    @SerializedName("mensajeAccion")
    private String mensajeAccion;

    public DetalleResponse() {
    }

    public DetalleResponse(String mensajeAccion) {
        this.mensajeAccion = mensajeAccion;
    }

    protected DetalleResponse(Parcel in) {
        mensajeAccion = in.readString();
    }

    public static final Creator<DetalleResponse> CREATOR = new Creator<DetalleResponse>() {
        @Override
        public DetalleResponse createFromParcel(Parcel in) {
            return new DetalleResponse(in);
        }

        @Override
        public DetalleResponse[] newArray(int size) {
            return new DetalleResponse[size];
        }
    };

    @Override
    public String toString() {
        return "DetalleResponse{" +
                "mensajeAccion='" + mensajeAccion + '\'' +
                '}';
    }

    public String getMensajeAccion() {
        return mensajeAccion;
    }

    public void setMensajeAccion(String mensajeAccion) {
        this.mensajeAccion = mensajeAccion;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mensajeAccion);
    }
}
