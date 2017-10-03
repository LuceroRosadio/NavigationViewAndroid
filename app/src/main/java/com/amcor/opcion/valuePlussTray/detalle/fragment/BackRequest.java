package com.amcor.opcion.valuePlussTray.detalle.fragment;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Lucero on 28/09/2017.
 */

public class BackRequest {
    @SerializedName("codPerfil")
    private String codigoPerfil;
    @SerializedName("codUsuario")
    private String codigoUsuario;
    @SerializedName("numeroPedido")
    private String numeroPedido;
    @SerializedName("observacion")
    private String observacion;

    public BackRequest() {
    }

    @Override
    public String toString() {
        return "BackRequest{" +
                "codigoPerfil='" + codigoPerfil + '\'' +
                ", codigoUsuario='" + codigoUsuario + '\'' +
                ", numeroPedido='" + numeroPedido + '\'' +
                ", observacion='" + observacion + '\'' +
                '}';
    }

    public String getCodigoPerfil() {
        return codigoPerfil;
    }

    public void setCodigoPerfil(String codigoPerfil) {
        this.codigoPerfil = codigoPerfil;
    }

    public String getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(String codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public String getNumeroPedido() {
        return numeroPedido;
    }

    public void setNumeroPedido(String numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
}
