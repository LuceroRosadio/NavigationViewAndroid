package com.sunil.navigationviewandroid.opcion.valuePlussTray.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Lucero on 11/08/2017.
 */

public class Archivo implements Parcelable{

    @SerializedName("base64")
    private String base64;
    @SerializedName("contentType")
    private String contentType;
    @SerializedName("nombreArchivo")
    private String nombreArchivo;

    public Archivo() {
    }

    public Archivo(String base64, String contentType, String nombreArchivo) {
        this.base64 = base64;
        this.contentType = contentType;
        this.nombreArchivo = nombreArchivo;
    }

    protected Archivo(Parcel in) {
        base64 = in.readString();
        contentType = in.readString();
        nombreArchivo = in.readString();
    }

    public static final Creator<Archivo> CREATOR = new Creator<Archivo>() {
        @Override
        public Archivo createFromParcel(Parcel in) {
            return new Archivo(in);
        }

        @Override
        public Archivo[] newArray(int size) {
            return new Archivo[size];
        }
    };

    @Override
    public String toString() {
        return "Archivo{" +
                "base64='" + base64 + '\'' +
                ", contentType='" + contentType + '\'' +
                ", nombreArchivo='" + nombreArchivo + '\'' +
                '}';
    }

    public String getBase64() {
        return base64;
    }

    public void setBase64(String base64) {
        this.base64 = base64;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(base64);
        dest.writeString(contentType);
        dest.writeString(nombreArchivo);
    }
}
