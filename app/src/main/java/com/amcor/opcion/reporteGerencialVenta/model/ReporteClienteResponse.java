package com.amcor.opcion.reporteGerencialVenta.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.amcor.opcion.valuePlussTray.model.Estado;
import com.amcor.opcion.valuePlussTray.model.Pedido;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Lucero on 11/08/2017.
 */

public class ReporteClienteResponse implements Parcelable{

    @SerializedName("reporteCliente")
    private List<ReporteCliente> reporteClienteList;
    public ReporteClienteResponse() {
    }

    protected ReporteClienteResponse(Parcel in) {
        reporteClienteList = in.createTypedArrayList(ReporteCliente.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(reporteClienteList);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ReporteClienteResponse> CREATOR = new Creator<ReporteClienteResponse>() {
        @Override
        public ReporteClienteResponse createFromParcel(Parcel in) {
            return new ReporteClienteResponse(in);
        }

        @Override
        public ReporteClienteResponse[] newArray(int size) {
            return new ReporteClienteResponse[size];
        }
    };

    @Override
    public String toString() {
        return "ReporteClienteResponse{" +
                "reporteClienteList=" + reporteClienteList +
                '}';
    }

    public List<ReporteCliente> getReporteClienteList() {
        return reporteClienteList;
    }

    public void setReporteClienteList(List<ReporteCliente> reporteClienteList) {
        this.reporteClienteList = reporteClienteList;
    }
}
