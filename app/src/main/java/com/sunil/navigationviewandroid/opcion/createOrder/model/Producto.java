package com.sunil.navigationviewandroid.opcion.createOrder.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Lucero on 07/09/2017.
 */

public class Producto implements Parcelable {

    @SerializedName("codProducto")
    private String codProducto;
    @SerializedName("marcaProducto")
    private String marcaProducto;
    @SerializedName("descripcionProducto")
    private String descripcionProducto;
    @SerializedName("versionProducto")
    private String versionProducto;
    @SerializedName("sku")
    private String sku;
    @SerializedName("unidadMedida")
    private String unidadMedida;
    @SerializedName("base64")
    private String base64;

    public Producto() {
    }

    public Producto(String codProducto, String marcaProducto, String descripcionProducto,
                    String versionProducto, String sku, String unidadMedida, String base64) {
        this.codProducto = codProducto;
        this.marcaProducto = marcaProducto;
        this.descripcionProducto = descripcionProducto;
        this.versionProducto = versionProducto;
        this.sku = sku;
        this.unidadMedida = unidadMedida;
        this.base64 = base64;
    }

    protected Producto(Parcel in) {
        codProducto = in.readString();
        marcaProducto = in.readString();
        descripcionProducto = in.readString();
        versionProducto = in.readString();
        sku = in.readString();
        unidadMedida = in.readString();
        base64 = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(codProducto);
        dest.writeString(marcaProducto);
        dest.writeString(descripcionProducto);
        dest.writeString(versionProducto);
        dest.writeString(sku);
        dest.writeString(unidadMedida);
        dest.writeString(base64);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Producto> CREATOR = new Creator<Producto>() {
        @Override
        public Producto createFromParcel(Parcel in) {
            return new Producto(in);
        }

        @Override
        public Producto[] newArray(int size) {
            return new Producto[size];
        }
    };

    @Override
    public String toString() {
        return "Producto{" +
                "codProducto='" + codProducto + '\'' +
                ", marcaProducto='" + marcaProducto + '\'' +
                ", descripcionProducto='" + descripcionProducto + '\'' +
                ", versionProducto='" + versionProducto + '\'' +
                ", sku='" + sku + '\'' +
                ", unidadMedida='" + unidadMedida + '\'' +
                ", base64='" + base64 + '\'' +
                '}';
    }

    public String getCodProducto() {
        return codProducto;
    }

    public void setCodProducto(String codProducto) {
        this.codProducto = codProducto;
    }

    public String getMarcaProducto() {
        return marcaProducto;
    }

    public void setMarcaProducto(String marcaProducto) {
        this.marcaProducto = marcaProducto;
    }

    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }

    public String getVersionProducto() {
        return versionProducto;
    }

    public void setVersionProducto(String versionProducto) {
        this.versionProducto = versionProducto;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public String getBase64() {
        return base64;
    }

    public void setBase64(String base64) {
        this.base64 = base64;
    }
}
