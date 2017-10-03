package com.amcor.data;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Lucero on 09/08/2017.
 */

public class OpcionModulo implements Parcelable{

    @SerializedName("codOpcion")
    private String codOpcion;
    @SerializedName("codPerfil")
    private String codPerfil;
    @SerializedName("estadoOpcion")
    private String estadoOpcion;
    @SerializedName("nombreOpcion")
    private String nombreOpcion;

    public OpcionModulo() {
    }

    public OpcionModulo(String codOpcion, String codPerfil, String estadoOpcion, String nombreOpcion) {
        this.codOpcion = codOpcion;
        this.codPerfil = codPerfil;
        this.estadoOpcion = estadoOpcion;
        this.nombreOpcion = nombreOpcion;
    }

    protected OpcionModulo(Parcel in) {
        codOpcion = in.readString();
        codPerfil = in.readString();
        estadoOpcion = in.readString();
        nombreOpcion = in.readString();
    }

    public static final Creator<OpcionModulo> CREATOR = new Creator<OpcionModulo>() {
        @Override
        public OpcionModulo createFromParcel(Parcel in) {
            return new OpcionModulo(in);
        }

        @Override
        public OpcionModulo[] newArray(int size) {
            return new OpcionModulo[size];
        }
    };

    @Override
    public String toString() {
        return "OpcionModulo{" +
                "codOpcion='" + codOpcion + '\'' +
                ", codPerfil='" + codPerfil + '\'' +
                ", estadoOpcion='" + estadoOpcion + '\'' +
                ", nombreOpcion='" + nombreOpcion + '\'' +
                '}';
    }

    public String getCodOpcion() {
        return codOpcion;
    }

    public void setCodOpcion(String codOpcion) {
        this.codOpcion = codOpcion;
    }

    public String getCodPerfil() {
        return codPerfil;
    }

    public void setCodPerfil(String codPerfil) {
        this.codPerfil = codPerfil;
    }

    public String getEstadoOpcion() {
        return estadoOpcion;
    }

    public void setEstadoOpcion(String estadoOpcion) {
        this.estadoOpcion = estadoOpcion;
    }

    public String getNombreOpcion() {
        return nombreOpcion;
    }

    public void setNombreOpcion(String nombreOpcion) {
        this.nombreOpcion = nombreOpcion;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(codOpcion);
        dest.writeString(codPerfil);
        dest.writeString(estadoOpcion);
        dest.writeString(nombreOpcion);
    }
}
