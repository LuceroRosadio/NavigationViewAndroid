package com.amcor.opcion.createOrder.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Lucero on 07/09/2017.
 */

public class CreateOrderResponse implements Parcelable {

    @SerializedName("productos")
    private List<Producto> productoList;

    public CreateOrderResponse() {
    }

    public CreateOrderResponse(List<Producto> productoList) {
        this.productoList = productoList;
    }

    protected CreateOrderResponse(Parcel in) {
        productoList = in.createTypedArrayList(Producto.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(productoList);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<CreateOrderResponse> CREATOR = new Creator<CreateOrderResponse>() {
        @Override
        public CreateOrderResponse createFromParcel(Parcel in) {
            return new CreateOrderResponse(in);
        }

        @Override
        public CreateOrderResponse[] newArray(int size) {
            return new CreateOrderResponse[size];
        }
    };

    @Override
    public String toString() {
        return "CreateOrderResponse{" +
                "productoList=" + productoList +
                '}';
    }

    public List<Producto> getProductoList() {
        return productoList;
    }

    public void setProductoList(List<Producto> productoList) {
        this.productoList = productoList;
    }
}
