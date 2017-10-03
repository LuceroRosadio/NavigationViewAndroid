package com.amcor.opcion.valuePlussTray.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Lucero on 11/08/2017.
 */

public class OrderRequestResponse implements Parcelable{

    @SerializedName("pedidos")
    private List<Pedido> pedidoList;
    @SerializedName("estados")
    private List<Estado> estadoList;

    public OrderRequestResponse() {
    }

    public OrderRequestResponse(List<Pedido> pedidoList, List<Estado> estadoList) {
        this.pedidoList = pedidoList;
        this.estadoList = estadoList;
    }

    protected OrderRequestResponse(Parcel in) {
        pedidoList = in.createTypedArrayList(Pedido.CREATOR);
        estadoList = in.createTypedArrayList(Estado.CREATOR);
    }

    public static final Creator<OrderRequestResponse> CREATOR = new Creator<OrderRequestResponse>() {
        @Override
        public OrderRequestResponse createFromParcel(Parcel in) {
            return new OrderRequestResponse(in);
        }

        @Override
        public OrderRequestResponse[] newArray(int size) {
            return new OrderRequestResponse[size];
        }
    };

    @Override
    public String toString() {
        return "OrderRequestResponse{" +
                "pedidoList=" + pedidoList +
                ", estadoList=" + estadoList +
                '}';
    }

    public List<Pedido> getPedidoList() {
        return pedidoList;
    }

    public void setPedidoList(List<Pedido> pedidoList) {
        this.pedidoList = pedidoList;
    }

    public List<Estado> getEstadoList() {
        return estadoList;
    }

    public void setEstadoList(List<Estado> estadoList) {
        this.estadoList = estadoList;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(pedidoList);
        dest.writeTypedList(estadoList);
    }


}
