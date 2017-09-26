package com.sunil.amcor.data;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Lucero on 09/08/2017.
 */

public class Cliente implements Parcelable{

    @SerializedName("codCliente")
    private String codCliente;
    @SerializedName("correo")
    private String correo;
    @SerializedName("nombreCliente")
    private String nombreCliente;

    public Cliente() {
    }

    public Cliente(String codCliente, String correo, String nombreCliente) {
        this.codCliente = codCliente;
        this.correo = correo;
        this.nombreCliente = nombreCliente;
    }

    protected Cliente(Parcel in) {
        codCliente = in.readString();
        correo = in.readString();
        nombreCliente = in.readString();
    }

    public static final Creator<Cliente> CREATOR = new Creator<Cliente>() {
        @Override
        public Cliente createFromParcel(Parcel in) {
            return new Cliente(in);
        }

        @Override
        public Cliente[] newArray(int size) {
            return new Cliente[size];
        }
    };

    @Override
    public String toString() {
        return "Cliente{" +
                "codCliente='" + codCliente + '\'' +
                ", correo='" + correo + '\'' +
                ", nombreCliente='" + nombreCliente + '\'' +
                '}';
    }

    public String getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(String codCliente) {
        this.codCliente = codCliente;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(codCliente);
        dest.writeString(correo);
        dest.writeString(nombreCliente);
    }
}
