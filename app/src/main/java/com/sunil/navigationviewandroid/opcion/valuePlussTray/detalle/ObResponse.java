package com.sunil.navigationviewandroid.opcion.valuePlussTray.detalle;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Lucero on 15/09/2017.
 */

public class ObResponse implements Parcelable{
    @SerializedName("pedido")
    private List<PedidoResponse> pedidoResponseList;

    public ObResponse() {
    }

    public ObResponse(List<PedidoResponse> pedidoResponseList) {
        this.pedidoResponseList = pedidoResponseList;
    }

    protected ObResponse(Parcel in) {
        pedidoResponseList = in.createTypedArrayList(PedidoResponse.CREATOR);
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

    @Override
    public String toString() {
        return "ObResponse{" +
                "pedidoResponseList=" + pedidoResponseList +
                '}';
    }

    public List<PedidoResponse> getPedidoResponseList() {
        return pedidoResponseList;
    }

    public void setPedidoResponseList(List<PedidoResponse> pedidoResponseList) {
        this.pedidoResponseList = pedidoResponseList;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(pedidoResponseList);
    }
}
