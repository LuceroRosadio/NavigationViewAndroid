package com.amcor.opcion.valuePlussTray.detalle;

import android.app.Activity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.amcor.R;

import java.util.List;

/**
 * Created by Lucero on 14/09/2017.
 */

public class DetalleAdapter extends RecyclerView.Adapter<DetalleAdapter.DetalleHolder> {

    //private PedidoResponse pedido;
    private List<PedidoDetalle> pedidoDetalles;
    private Activity activity;

    public DetalleAdapter(List<PedidoDetalle> pedidoDetalles, Activity activity) {
        this.pedidoDetalles = pedidoDetalles;
        this.activity = activity;
    }

    @Override
    public DetalleHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_detalle, parent,false);
        return new DetalleHolder(view);
    }

    @Override
    public void onBindViewHolder(DetalleHolder holder, int position) {
        /*holder.numPedido.setText(pedido.getNumeroPedido());
        holder.producto.setText(pedido.getProducto());
        holder.unidad.setText(pedido.getUnidadMedida());
        holder.ubicacion.setText(pedido.getUbicacion());
        holder.fechaRegistro.setText(pedido.getFechaRegistro());
        holder.total.setText(pedido.getTotal());
        String encodedDataString = pedido.getImagenProducto().toString();
        Log.d("adapter", "encodedDataString");
        byte[] imageAsBytes = Base64.decode(encodedDataString.getBytes(), 0);
        holder.base64.setImageBitmap(BitmapFactory.decodeByteArray(imageAsBytes, 0, imageAsBytes.length));*/

        PedidoDetalle pedidoDetalle = pedidoDetalles.get(position);
        holder.cantidad.setText(pedidoDetalle.getCantidadPedido());
        holder.fechaSolicitada.setText(pedidoDetalle.getFechaSolicitada());
    }

    @Override
    public int getItemCount() {
        return pedidoDetalles.size();
    }

    public class DetalleHolder extends RecyclerView.ViewHolder {
        /*TextView numPedido;
        TextView producto;
        TextView unidad;
        TextView ubicacion;
        TextView fechaRegistro;
        TextView total;*/
        CardView cardView;
        TextView cantidad;
        TextView fechaSolicitada;
        //ImageView base64;

        public DetalleHolder(View itemView) {
            super(itemView);
            /*numPedido = (TextView)itemView.findViewById(R.id.tv_pedido);
            producto = (TextView)itemView.findViewById(R.id.tv_producto);
            unidad = (TextView)itemView.findViewById(R.id.tv_unidad);
            ubicacion = (TextView)itemView.findViewById(R.id.tv_ubicacion);
            fechaRegistro = (TextView)itemView.findViewById(R.id.tv_fecha_registro);
            total = (TextView)itemView.findViewById(R.id.tv_total);
            cardView = (CardView)itemView.findViewById(R.id.detalleCardview);
            base64= (ImageView)itemView.findViewById(R.id.img_detalle);*/
            cantidad = (TextView)itemView.findViewById(R.id.tv_cantidad_detalle);
            fechaSolicitada = (TextView)itemView.findViewById(R.id.tv_fecha_detalle);
        }
    }
}
