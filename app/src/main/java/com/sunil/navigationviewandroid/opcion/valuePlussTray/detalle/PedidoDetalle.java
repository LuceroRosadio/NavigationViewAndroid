package com.sunil.navigationviewandroid.opcion.valuePlussTray.detalle;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Lucero on 14/09/2017.
 */

public class PedidoDetalle implements Parcelable {

    @SerializedName("cantidadPedido")
    private String cantidadPedido;
    @SerializedName("fechaSolicitada")
    private String fechaSolicitada;
    @SerializedName("idPedidoDetalle")
    private String idPedidoDetalle;

    public PedidoDetalle() {
    }

    public PedidoDetalle(String cantidadPedido, String fechaSolicitada, String idPedidoDetalle) {
        this.cantidadPedido = cantidadPedido;
        this.fechaSolicitada = fechaSolicitada;
        this.idPedidoDetalle = idPedidoDetalle;
    }

    protected PedidoDetalle(Parcel in) {
        cantidadPedido = in.readString();
        fechaSolicitada = in.readString();
        idPedidoDetalle = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(cantidadPedido);
        dest.writeString(fechaSolicitada);
        dest.writeString(idPedidoDetalle);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<PedidoDetalle> CREATOR = new Creator<PedidoDetalle>() {
        @Override
        public PedidoDetalle createFromParcel(Parcel in) {
            return new PedidoDetalle(in);
        }

        @Override
        public PedidoDetalle[] newArray(int size) {
            return new PedidoDetalle[size];
        }
    };

    @Override
    public String toString() {
        return "PedidoDetalle{" +
                "cantidadPedido='" + cantidadPedido + '\'' +
                ", fechaSolicitada='" + fechaSolicitada + '\'' +
                ", idPedidoDetalle='" + idPedidoDetalle + '\'' +
                '}';
    }

    public String getCantidadPedido() {
        return cantidadPedido;
    }

    public void setCantidadPedido(String cantidadPedido) {
        this.cantidadPedido = cantidadPedido;
    }

    public String getFechaSolicitada() {
        return fechaSolicitada;
    }

    public void setFechaSolicitada(String fechaSolicitada) {
        this.fechaSolicitada = fechaSolicitada;
    }

    public String getIdPedidoDetalle() {
        return idPedidoDetalle;
    }

    public void setIdPedidoDetalle(String idPedidoDetalle) {
        this.idPedidoDetalle = idPedidoDetalle;
    }
}
