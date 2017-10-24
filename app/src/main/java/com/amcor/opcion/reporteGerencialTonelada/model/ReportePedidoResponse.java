package com.amcor.opcion.reporteGerencialTonelada.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.amcor.opcion.valuePlussTray.model.Estado;
import com.amcor.opcion.valuePlussTray.model.Pedido;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Lucero on 11/08/2017.
 */

public class ReportePedidoResponse implements Parcelable{

    @SerializedName("reportePedido")
    private List<ReportePedido> reportePedidoList;
    public ReportePedidoResponse() {
    }

    protected ReportePedidoResponse(Parcel in) {
        reportePedidoList = in.createTypedArrayList(ReportePedido.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(reportePedidoList);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ReportePedidoResponse> CREATOR = new Creator<ReportePedidoResponse>() {
        @Override
        public ReportePedidoResponse createFromParcel(Parcel in) {
            return new ReportePedidoResponse(in);
        }

        @Override
        public ReportePedidoResponse[] newArray(int size) {
            return new ReportePedidoResponse[size];
        }
    };

    @Override
    public String toString() {
        return "ReportePedidoResponse{" +
                "reportePedidoList=" + reportePedidoList +
                '}';
    }

    public List<ReportePedido> getReportePedidoList() {
        return reportePedidoList;
    }

    public void setReportePedidoList(List<ReportePedido> reportePedidoList) {
        this.reportePedidoList = reportePedidoList;
    }
}
