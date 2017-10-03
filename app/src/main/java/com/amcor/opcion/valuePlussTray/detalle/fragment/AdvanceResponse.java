package com.amcor.opcion.valuePlussTray.detalle.fragment;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Lucero on 27/09/2017.
 */

public class AdvanceResponse implements Parcelable {

    @SerializedName("mensajeAccion")
    private String mensajeAccion;

    public AdvanceResponse() {
    }

    public AdvanceResponse(String mensajeAccion) {
        this.mensajeAccion = mensajeAccion;
    }

    protected AdvanceResponse(Parcel in) {
        mensajeAccion = in.readString();
    }

    public static final Creator<AdvanceResponse> CREATOR = new Creator<AdvanceResponse>() {
        @Override
        public AdvanceResponse createFromParcel(Parcel in) {
            return new AdvanceResponse(in);
        }

        @Override
        public AdvanceResponse[] newArray(int size) {
            return new AdvanceResponse[size];
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
