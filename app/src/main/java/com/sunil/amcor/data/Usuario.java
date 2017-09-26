package com.sunil.amcor.data;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Lucero on 09/08/2017.
 */

public class Usuario implements Parcelable{

    @SerializedName("cliente")
    private Cliente cliente;
    @SerializedName("codUsuario")
    private String codUsuario;
    @SerializedName("modulos")
    private List<Modulo> moduloList;
    @SerializedName("nombresUsuario")
    private String nombresUsuario;
    @SerializedName("codPerfil")
    private String codPerfil;

    public Usuario() {
    }

    public Usuario(Cliente cliente, String codUsuario, List<Modulo> moduloList, String nombresUsuario, String codPerfil) {
        this.cliente = cliente;
        this.codUsuario = codUsuario;
        this.moduloList = moduloList;
        this.nombresUsuario = nombresUsuario;
        this.codPerfil = codPerfil;
    }

    public Usuario(Parcel in) {
        cliente = in.readParcelable(Cliente.class.getClassLoader());
        codUsuario = in.readString();
        moduloList = in.createTypedArrayList(Modulo.CREATOR);
        nombresUsuario = in.readString();
        codPerfil = in.readString();
    }

    public static final Creator<Usuario> CREATOR = new Creator<Usuario>() {
        @Override
        public Usuario createFromParcel(Parcel in) {
            return new Usuario(in);
        }

        @Override
        public Usuario[] newArray(int size) {
            return new Usuario[size];
        }
    };

    @Override
    public String toString() {
        return "Usuario{" +
                "cliente=" + cliente +
                ", codUsuario='" + codUsuario + '\'' +
                ", moduloList=" + moduloList +
                ", nombresUsuario='" + nombresUsuario + '\'' +
                ", codPerfil='" + codPerfil + '\'' +
                '}';
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(String codUsuario) {
        this.codUsuario = codUsuario;
    }

    public List<Modulo> getModuloList() {
        return moduloList;
    }

    public void setModuloList(List<Modulo> moduloList) {
        this.moduloList = moduloList;
    }

    public String getNombresUsuario() {
        return nombresUsuario;
    }

    public void setNombresUsuario(String nombresUsuario) {
        this.nombresUsuario = nombresUsuario;
    }

    public String getCodPerfil() {
        return codPerfil;
    }

    public void setCodPerfil(String codPerfil) {
        this.codPerfil = codPerfil;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(cliente, flags);
        dest.writeString(codUsuario);
        dest.writeTypedList(moduloList);
        dest.writeString(nombresUsuario);
        dest.writeString(codPerfil);
    }
}
