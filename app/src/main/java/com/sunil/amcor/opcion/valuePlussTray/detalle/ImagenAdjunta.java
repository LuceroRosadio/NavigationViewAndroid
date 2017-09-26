package com.sunil.amcor.opcion.valuePlussTray.detalle;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Lucero on 14/09/2017.
 */

public class ImagenAdjunta implements Parcelable{

    @SerializedName("base64")
    private String base64;
    @SerializedName("contentType")
    private String contentType;

    public ImagenAdjunta() {
    }

    public ImagenAdjunta(String base64, String contentType) {
        this.base64 = base64;
        this.contentType = contentType;
    }

    protected ImagenAdjunta(Parcel in) {
        base64 = in.readString();
        contentType = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(base64);
        dest.writeString(contentType);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ImagenAdjunta> CREATOR = new Creator<ImagenAdjunta>() {
        @Override
        public ImagenAdjunta createFromParcel(Parcel in) {
            return new ImagenAdjunta(in);
        }

        @Override
        public ImagenAdjunta[] newArray(int size) {
            return new ImagenAdjunta[size];
        }
    };

    @Override
    public String toString() {
        return "ImagenAdjunta{" +
                "base64='" + base64 + '\'' +
                ", contentType='" + contentType + '\'' +
                '}';
    }

    public String getBase64() {
        return base64;
    }

    public void setBase64(String base64) {
        this.base64 = base64;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }
}
