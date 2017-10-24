package com.amcor.opcion.reporteGerencialTonelada.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by johel on 24/10/2017.
 */

public class ReportePedido  implements Parcelable{
    @SerializedName("claseEstructura")
    private String claseEstructurada;
    @SerializedName("toneladas")
    private Double toneladas;
    @SerializedName("total")
    private Double total;

    protected ReportePedido(Parcel in) {
        claseEstructurada = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(claseEstructurada);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ReportePedido> CREATOR = new Creator<ReportePedido>() {
        @Override
        public ReportePedido createFromParcel(Parcel in) {
            return new ReportePedido(in);
        }

        @Override
        public ReportePedido[] newArray(int size) {
            return new ReportePedido[size];
        }
    };

    @Override
    public String toString() {
        return "ReportePedido{" +
                "claseEstructurada='" + claseEstructurada + '\'' +
                ", toneladas=" + toneladas +
                ", total=" + total +
                '}';
    }

    public String getClaseEstructurada() {
        return claseEstructurada;
    }

    public void setClaseEstructurada(String claseEstructurada) {
        this.claseEstructurada = claseEstructurada;
    }

    public Double getToneladas() {
        return toneladas;
    }

    public void setToneladas(Double toneladas) {
        this.toneladas = toneladas;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
