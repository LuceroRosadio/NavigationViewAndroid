package com.amcor.opcion.valuePlussTray.detalle;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Lucero on 15/09/2017.
 */

public class ObResponse implements Parcelable{
    @SerializedName("pedido")
    private PedidoResponse pedidoResponse;

    public ObResponse(){

    }
    public ObResponse(PedidoResponse pedidoResponse) {
        this.pedidoResponse = pedidoResponse;
    }

    protected ObResponse(Parcel in) {
        pedidoResponse = in.readParcelable(PedidoResponse.class.getClassLoader());
    }

    public static final Creator<ObResponse> CREATOR = new Creator<ObResponse>() {
        @Override
        public ObResponse createFromParcel(Parcel in) {
            return new ObResponse(in);
        }

        @Override
        public ObResponse[] newArray(int size) {
            return new ObResponse[size];
        }
    };

    public PedidoResponse getPedidoResponse() {
        return pedidoResponse;
    }

    public void setPedidoResponse(PedidoResponse pedidoResponse) {
        this.pedidoResponse = pedidoResponse;
    }

    @Override
    public String toString() {
        return "ObResponse{" +
                "pedidoResponse=" + pedidoResponse +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(pedidoResponse, flags);
    }
}
