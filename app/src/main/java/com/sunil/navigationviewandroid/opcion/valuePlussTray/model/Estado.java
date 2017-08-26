package com.sunil.navigationviewandroid.opcion.valuePlussTray.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Lucero on 11/08/2017.
 */

public class Estado implements Parcelable{

    @SerializedName("estado")
    private int estado;
    @SerializedName("color")
    private String color;
    @SerializedName("descripcion")
    private String descripcion;

    public Estado() {
    }

    public Estado(int estado, String color, String descripcion) {
        this.estado = estado;
        this.color = color;
        this.descripcion = descripcion;
    }

    protected Estado(Parcel in) {
        estado = in.readInt();
        color = in.readString();
        descripcion = in.readString();
    }

    public static final Creator<Estado> CREATOR = new Creator<Estado>() {
        @Override
        public Estado createFromParcel(Parcel in) {
            return new Estado(in);
        }

        @Override
        public Estado[] newArray(int size) {
            return new Estado[size];
        }
    };

    @Override
    public String toString() {
        return "Estado{" +
                "estado=" + estado +
                ", color='" + color + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(estado);
        dest.writeString(color);
        dest.writeString(descripcion);
    }


}
