package com.sunil.amcor.opcion.valuePlussTray.detalle.fragment;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Lucero on 28/09/2017.
 */

public class AdvanceRequest {
    @SerializedName("codPerfil")
    private String codigoPerfil;
    @SerializedName("codUsuario")
    private String codigoUsuario;
    @SerializedName("numeroPedido")
    private String numeroPedido;

    public AdvanceRequest() {
    }

    public AdvanceRequest(String codigoPerfil, String codigoUsuario, String numeroPedido) {
        this.codigoPerfil = codigoPerfil;
        this.codigoUsuario = codigoUsuario;
        this.numeroPedido = numeroPedido;
    }

    @Override
    public String
    toString() {
        return "PedidoDtll{" +
                "codigoPerfil='" + codigoPerfil + '\'' +
                ", codigoUsuario='" + codigoUsuario + '\'' +
                ", numeroPedido='" + numeroPedido + '\'' +
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
}
