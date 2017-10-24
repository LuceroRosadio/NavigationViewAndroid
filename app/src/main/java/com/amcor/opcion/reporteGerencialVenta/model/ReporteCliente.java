package com.amcor.opcion.reporteGerencialVenta.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by johel on 24/10/2017.
 */

public class ReporteCliente implements Parcelable{
    @SerializedName("ejecutivoComercial")
    private String ejecutivoComercial;
    @SerializedName("cliente")
    private String cliente;
    @SerializedName("total")
    private Double total;

    @Override
    public String toString() {
        return "ReporteCliente{" +
                "ejecutivoComercial='" + ejecutivoComercial + '\'' +
                ", cliente='" + cliente + '\'' +
                ", total=" + total +
                '}';
    }

    protected ReporteCliente(Parcel in) {
        ejecutivoComercial = in.readString();
        cliente = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(ejecutivoComercial);
        dest.writeString(cliente);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ReporteCliente> CREATOR = new Creator<ReporteCliente>() {
        @Override
        public ReporteCliente createFromParcel(Parcel in) {
            return new ReporteCliente(in);
        }

        @Override
        public ReporteCliente[] newArray(int size) {
            return new ReporteCliente[size];
        }
    };

    public String getEjecutivoComercial() {
        return ejecutivoComercial;
    }

    public void setEjecutivoComercial(String ejecutivoComercial) {
        this.ejecutivoComercial = ejecutivoComercial;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
