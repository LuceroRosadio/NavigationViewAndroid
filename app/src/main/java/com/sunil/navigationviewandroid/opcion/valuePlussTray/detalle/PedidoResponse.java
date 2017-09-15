package com.sunil.navigationviewandroid.opcion.valuePlussTray.detalle;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Lucero on 14/09/2017.
 */

public class PedidoResponse implements Parcelable{

    @SerializedName("numeroPedido")
    private String numeroPedido;
    @SerializedName("numeroSolicitud")
    private String numeroSolicitud;
    @SerializedName("cliente")
    private String cliente;
    @SerializedName("codCliente")
    private String codCliente;
    @SerializedName("producto")
    private String producto;
    @SerializedName("fechaSolicitada")
    private String fechaSolicitada;
    @SerializedName("pedidosDetalle")
    private List<PedidoDetalle> pedidosDetalle;
    @SerializedName("cantidad")
    private String cantidad;
    @SerializedName("unidadMedida")
    private String unidadMedida;
    @SerializedName("ubicacion")
    private String ubicacion;
    @SerializedName("fechaRegistro")
    private String fechaRegistro;
    @SerializedName("precioUnitario")
    private String precioUnitario;
    @SerializedName("total")
    private String total;
    @SerializedName("imagenProducto")
    private String imagenProducto;
    @SerializedName("imagenAdjunta")
    private ImagenAdjunta imagenAdjunta;
    @SerializedName("imagenUbicacion")
    private String imagenUbicacion;
    @SerializedName("bitacoras")
    private List<Bitacora> bitacoras;

    public PedidoResponse() {
    }

    public PedidoResponse(String numeroPedido, String numeroSolicitud, String cliente,
                          String codCliente, String producto, String fechaSolicitada,
                          List<PedidoDetalle> pedidosDetalle, String cantidad, String unidadMedida,
                          String ubicacion, String fechaRegistro, String precioUnitario, String total,
                          String imagenProducto, ImagenAdjunta imagenAdjunta, String imagenUbicacion,
                          List<Bitacora> bitacoras) {
        this.numeroPedido = numeroPedido;
        this.numeroSolicitud = numeroSolicitud;
        this.cliente = cliente;
        this.codCliente = codCliente;
        this.producto = producto;
        this.fechaSolicitada = fechaSolicitada;
        this.pedidosDetalle = pedidosDetalle;
        this.cantidad = cantidad;
        this.unidadMedida = unidadMedida;
        this.ubicacion = ubicacion;
        this.fechaRegistro = fechaRegistro;
        this.precioUnitario = precioUnitario;
        this.total = total;
        this.imagenProducto = imagenProducto;
        this.imagenAdjunta = imagenAdjunta;
        this.imagenUbicacion = imagenUbicacion;
        this.bitacoras = bitacoras;
    }

    protected PedidoResponse(Parcel in) {
        numeroPedido = in.readString();
        numeroSolicitud = in.readString();
        cliente = in.readString();
        codCliente = in.readString();
        producto = in.readString();
        fechaSolicitada = in.readString();
        pedidosDetalle = in.createTypedArrayList(PedidoDetalle.CREATOR);
        cantidad = in.readString();
        unidadMedida = in.readString();
        ubicacion = in.readString();
        fechaRegistro = in.readString();
        precioUnitario = in.readString();
        total = in.readString();
        imagenProducto = in.readString();
        imagenAdjunta = in.readParcelable(ImagenAdjunta.class.getClassLoader());
        imagenUbicacion = in.readString();
        bitacoras = in.createTypedArrayList(Bitacora.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(numeroPedido);
        dest.writeString(numeroSolicitud);
        dest.writeString(cliente);
        dest.writeString(codCliente);
        dest.writeString(producto);
        dest.writeString(fechaSolicitada);
        dest.writeTypedList(pedidosDetalle);
        dest.writeString(cantidad);
        dest.writeString(unidadMedida);
        dest.writeString(ubicacion);
        dest.writeString(fechaRegistro);
        dest.writeString(precioUnitario);
        dest.writeString(total);
        dest.writeString(imagenProducto);
        dest.writeParcelable(imagenAdjunta, flags);
        dest.writeString(imagenUbicacion);
        dest.writeTypedList(bitacoras);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<PedidoResponse> CREATOR = new Creator<PedidoResponse>() {
        @Override
        public PedidoResponse createFromParcel(Parcel in) {
            return new PedidoResponse(in);
        }

        @Override
        public PedidoResponse[] newArray(int size) {
            return new PedidoResponse[size];
        }
    };

    @Override
    public String toString() {
        return "PedidoResponse{" +
                "numeroPedido='" + numeroPedido + '\'' +
                ", numeroSolicitud='" + numeroSolicitud + '\'' +
                ", cliente='" + cliente + '\'' +
                ", codCliente='" + codCliente + '\'' +
                ", producto='" + producto + '\'' +
                ", fechaSolicitada='" + fechaSolicitada + '\'' +
                ", pedidosDetalle=" + pedidosDetalle +
                ", cantidad='" + cantidad + '\'' +
                ", unidadMedida='" + unidadMedida + '\'' +
                ", ubicacion='" + ubicacion + '\'' +
                ", fechaRegistro='" + fechaRegistro + '\'' +
                ", precioUnitario='" + precioUnitario + '\'' +
                ", total='" + total + '\'' +
                ", imagenProducto='" + imagenProducto + '\'' +
                ", imagenAdjunta=" + imagenAdjunta +
                ", imagenUbicacion='" + imagenUbicacion + '\'' +
                ", bitacoras=" + bitacoras +
                '}';
    }

    public String getNumeroPedido() {
        return numeroPedido;
    }

    public void setNumeroPedido(String numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    public String getNumeroSolicitud() {
        return numeroSolicitud;
    }

    public void setNumeroSolicitud(String numeroSolicitud) {
        this.numeroSolicitud = numeroSolicitud;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(String codCliente) {
        this.codCliente = codCliente;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getFechaSolicitada() {
        return fechaSolicitada;
    }

    public void setFechaSolicitada(String fechaSolicitada) {
        this.fechaSolicitada = fechaSolicitada;
    }

    public List<PedidoDetalle> getPedidosDetalle() {
        return pedidosDetalle;
    }

    public void setPedidosDetalle(List<PedidoDetalle> pedidosDetalle) {
        this.pedidosDetalle = pedidosDetalle;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(String precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getImagenProducto() {
        return imagenProducto;
    }

    public void setImagenProducto(String imagenProducto) {
        this.imagenProducto = imagenProducto;
    }

    public ImagenAdjunta getImagenAdjunta() {
        return imagenAdjunta;
    }

    public void setImagenAdjunta(ImagenAdjunta imagenAdjunta) {
        this.imagenAdjunta = imagenAdjunta;
    }

    public String getImagenUbicacion() {
        return imagenUbicacion;
    }

    public void setImagenUbicacion(String imagenUbicacion) {
        this.imagenUbicacion = imagenUbicacion;
    }

    public List<Bitacora> getBitacoras() {
        return bitacoras;
    }

    public void setBitacoras(List<Bitacora> bitacoras) {
        this.bitacoras = bitacoras;
    }
}
