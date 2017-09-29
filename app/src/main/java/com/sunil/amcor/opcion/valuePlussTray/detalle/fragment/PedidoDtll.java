package com.sunil.amcor.opcion.valuePlussTray.detalle.fragment;

/**
 * Created by Lucero on 28/09/2017.
 */

public class PedidoDtll {

    private String codigoPerfil;
    private String codigoUsuario;
    private String numPedido;

    public PedidoDtll() {
    }

    public PedidoDtll(String codigoPerfil, String codigoUsuario, String numPedido) {
        this.codigoPerfil = codigoPerfil;
        this.codigoUsuario = codigoUsuario;
        this.numPedido = numPedido;
    }

    @Override
    public String
    toString() {
        return "PedidoDtll{" +
                "codigoPerfil='" + codigoPerfil + '\'' +
                ", codigoUsuario='" + codigoUsuario + '\'' +
                ", numPedido='" + numPedido + '\'' +
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

    public String getNumPedido() {
        return numPedido;
    }

    public void setNumPedido(String numPedido) {
        this.numPedido = numPedido;
    }
}
