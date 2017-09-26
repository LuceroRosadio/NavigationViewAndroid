package com.sunil.amcor.data;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Lucero on 09/08/2017.
 */

public class Modulo implements Parcelable{

    @SerializedName("codModulo")
    private String codModulo;
    @SerializedName("nombreModulo")
    private String nombreModulo;
    @SerializedName("opciones")
    private List<OpcionModulo> opcionModuloList;

    public Modulo() {
    }

    public Modulo(String codModulo, String nombreModulo, List<OpcionModulo> opcionModuloList) {
        this.codModulo = codModulo;
        this.nombreModulo = nombreModulo;
        this.opcionModuloList = opcionModuloList;
    }

    protected Modulo(Parcel in) {
        codModulo = in.readString();
        nombreModulo = in.readString();
        opcionModuloList = in.createTypedArrayList(OpcionModulo.CREATOR);
    }

    public static final Creator<Modulo> CREATOR = new Creator<Modulo>() {
        @Override
        public Modulo createFromParcel(Parcel in) {
            return new Modulo(in);
        }

        @Override
        public Modulo[] newArray(int size) {
            return new Modulo[size];
        }
    };

    @Override
    public String toString() {
        return "Modulo{" +
                "codModulo='" + codModulo + '\'' +
                ", nombreModulo='" + nombreModulo + '\'' +
                ", opcionModuloList=" + opcionModuloList +
                '}';
    }

    public String getCodModulo() {
        return codModulo;
    }

    public void setCodModulo(String codModulo) {
        this.codModulo = codModulo;
    }

    public String getNombreModulo() {
        return nombreModulo;
    }

    public void setNombreModulo(String nombreModulo) {
        this.nombreModulo = nombreModulo;
    }

    public List<OpcionModulo> getOpcionModuloList() {
        return opcionModuloList;
    }

    public void setOpcionModuloList(List<OpcionModulo> opcionModuloList) {
        this.opcionModuloList = opcionModuloList;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(codModulo);
        dest.writeString(nombreModulo);
        dest.writeTypedList(opcionModuloList);
    }
}
