package com.amcor.opcion.valuePlussTray.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Lucero on 11/08/2017.
 */

public class Pedido implements Parcelable{

    @SerializedName("archivo")
    private Archivo archivo;
    @SerializedName("cantidad")
    private String cantidad;
    @SerializedName("fechaSol")
    private String fechaSol;
    @SerializedName("numeroPedido")
    private String numeroPedido;
    @SerializedName("precioTotal")
    private String precioTotal;
    @SerializedName("producto")
    private String producto;
    @SerializedName("unidadMedida")
    private String unidadMedida;
    @SerializedName("version")
    private String version;
    @SerializedName("color")
    private String color;
    @SerializedName("estado")
    private int estado;
    @SerializedName("ubicacion")
    private String ubicacion;
    @SerializedName("cliente")
    private String cliente;
    @SerializedName("cantDias")
    private String cantidadDias;
    @SerializedName("precioUnitario")
    private String precioUnitario;
    @SerializedName("descEstado")
    private String estadoMotivo;
    @SerializedName("codProducto")
    private String codigoProducto;

    public Pedido() {
    }

    public Pedido(Archivo archivo, String cantidad, String fechaSol, String numeroPedido,
                  String precioTotal, String producto, String unidadMedida, String version,
                  String color, int estado, String ubicacion, String cliente, String cantidadDias,
                  String precioUnitario, String estadoMotivo, String codigoProducto) {
        this.archivo = archivo;
        this.cantidad = cantidad;
        this.fechaSol = fechaSol;
        this.numeroPedido = numeroPedido;
        this.precioTotal = precioTotal;
        this.producto = producto;
        this.unidadMedida = unidadMedida;
        this.version = version;
        this.color = color;
        this.estado = estado;
        this.ubicacion = ubicacion;
        this.cliente = cliente;
        this.cantidadDias = cantidadDias;
        this.precioUnitario = precioUnitario;
        this.estadoMotivo = estadoMotivo;
        this.codigoProducto = codigoProducto;
    }

    protected Pedido(Parcel in) {
        archivo = in.readParcelable(Archivo.class.getClassLoader());
        cantidad = in.readString();
        fechaSol = in.readString();
        numeroPedido = in.readString();
        precioTotal = in.readString();
        producto = in.readString();
        unidadMedida = in.readString();
        version = in.readString();
        color = in.readString();
        estado = in.readInt();
        ubicacion = in.readString();
        cliente = in.readString();
        cantidadDias = in.readString();
        precioUnitario = in.readString();
        estadoMotivo = in.readString();
        codigoProducto = in.readString();
    }

    public static final Creator<Pedido> CREATOR = new Creator<Pedido>() {
        @Override
        public Pedido createFromParcel(Parcel in) {
            return new Pedido(in);
        }

        @Override
        public Pedido[] newArray(int size) {
            return new Pedido[size];
        }
    };

    @Override
    public String toString() {
        return "Pedido{" +
                "archivo=" + archivo +
                ", cantidad='" + cantidad + '\'' +
                ", fechaSol='" + fechaSol + '\'' +
                ", numeroPedido='" + numeroPedido + '\'' +
                ", precioTotal='" + precioTotal + '\'' +
                ", producto='" + producto + '\'' +
                ", unidadMedida='" + unidadMedida + '\'' +
                ", version='" + version + '\'' +
                ", color='" + color + '\'' +
                ", estado=" + estado +
                ", ubicacion='" + ubicacion + '\'' +
                ", cliente='" + cliente + '\'' +
                ", cantidadDias='" + cantidadDias + '\'' +
                ", precioUnitario='" + precioUnitario + '\'' +
                ", estadoMotivo='" + estadoMotivo + '\'' +
                ", codigoProducto='" + codigoProducto + '\'' +
                '}';
    }

    public Archivo getArchivo() {
        return archivo;
    }

    public void setArchivo(Archivo archivo) {
        this.archivo = archivo;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getFechaSol() {
        return fechaSol;
    }

    public void setFechaSol(String fechaSol) {
        this.fechaSol = fechaSol;
    }

    public String getNumeroPedido() {
        return numeroPedido;
    }

    public void setNumeroPedido(String numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    public String getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(String precioTotal) {
        this.precioTotal = precioTotal;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getCantidadDias() {
        return cantidadDias;
    }

    public void setCantidadDias(String cantidadDias) {
        this.cantidadDias = cantidadDias;
    }

    public String getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(String precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public String getEstadoMotivo() {
        return estadoMotivo;
    }

    public void setEstadoMotivo(String estadoMotivo) {
        this.estadoMotivo = estadoMotivo;
    }

    public String getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(archivo, flags);
        dest.writeString(cantidad);
        dest.writeString(fechaSol);
        dest.writeString(numeroPedido);
        dest.writeString(precioTotal);
        dest.writeString(producto);
        dest.writeString(unidadMedida);
        dest.writeString(version);
        dest.writeString(color);
        dest.writeInt(estado);
        dest.writeString(ubicacion);
        dest.writeString(cliente);
        dest.writeString(cantidadDias);
        dest.writeString(precioUnitario);
        dest.writeString(estadoMotivo);
        dest.writeString(codigoProducto);
    }


}
