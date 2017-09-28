package com.sunil.amcor.opcion.valuePlussTray.detalle;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Lucero on 14/09/2017.
 */

public class Bitacora implements Parcelable{

    @SerializedName("origen")
    private String origen;
    @SerializedName("destino")
    private String destino;
    @SerializedName("evento")
    private String evento;
    @SerializedName("fecha")
    private String fecha;
    @SerializedName("usuario")
    private String usuario;

    public Bitacora() {
    }

    public Bitacora(String origen, String destino, String evento, String fecha, String usuario) {
        this.origen = origen;
        this.destino = destino;
        this.evento = evento;
        this.fecha = fecha;
        this.usuario = usuario;
    }

    protected Bitacora(Parcel in) {
        origen = in.readString();
        destino = in.readString();
        evento = in.readString();
        fecha = in.readString();
        usuario = in.readString();
    }

    public static final Creator<Bitacora> CREATOR = new Creator<Bitacora>() {
        @Override
        public Bitacora createFromParcel(Parcel in) {
            return new Bitacora(in);
        }

        @Override
        public Bitacora[] newArray(int size) {
            return new Bitacora[size];
        }
    };

    @Override
    public String toString() {
        return "Bitacora{" +
                "origen='" + origen + '\'' +
                ", destino='" + destino + '\'' +
                ", evento='" + evento + '\'' +
                ", fecha='" + fecha + '\'' +
                ", usuario='" + usuario + '\'' +
                '}';
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getEvento() {
        return evento;
    }

    public void setEvento(String evento) {
        this.evento = evento;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(origen);
        dest.writeString(destino);
        dest.writeString(evento);
        dest.writeString(fecha);
        dest.writeString(usuario);
    }
}
