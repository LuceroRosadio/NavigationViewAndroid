package com.amcor.data;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by johel on 24/10/2017.
 */

public class EjecutivoComercial implements Parcelable {
    @SerializedName("codEjecutivo")
    private String codEjecutivo;
    @SerializedName("nombreEjecutivo")
    private String nombreEjecutivo;
    public EjecutivoComercial(String nombreEjecutivo){
        this.nombreEjecutivo=nombreEjecutivo;
    }
    protected EjecutivoComercial(Parcel in) {
        nombreEjecutivo = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(codEjecutivo);
        dest.writeString(nombreEjecutivo);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<EjecutivoComercial> CREATOR = new Creator<EjecutivoComercial>() {
        @Override
        public EjecutivoComercial createFromParcel(Parcel in) {
            return new EjecutivoComercial(in);
        }

        @Override
        public EjecutivoComercial[] newArray(int size) {
            return new EjecutivoComercial[size];
        }
    };

    public String getCodEjecutivo() {
        return codEjecutivo;
    }

    public void setCodEjecutivo(String codEjecutivo) {
        this.codEjecutivo = codEjecutivo;
    }

    public String getNombreEjecutivo() {
        return nombreEjecutivo;
    }

    public void setNombreEjecutivo(String nombreEjecutivo) {
        this.nombreEjecutivo = nombreEjecutivo;
    }

    @Override
    public String toString() {
        return nombreEjecutivo;
    }
}
