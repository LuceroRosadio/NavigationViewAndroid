package com.sunil.navigationviewandroid.opcion.valuePlussTray.detalle;

import android.app.Activity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sunil.navigationviewandroid.R;

import java.util.List;

import retrofit2.Call;

/**
 * Created by Lucero on 14/09/2017.
 */

public class DetalleAdapter extends RecyclerView.Adapter<DetalleAdapter.DetalleHolder> {

    private List<PedidoResponse> pedidos;
    private Activity activity;

    public DetalleAdapter(List<PedidoResponse> pedidos, Activity activity) {
        this.pedidos = pedidos;
        this.activity = activity;
    }

    @Override
    public DetalleHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_detalle_tab, parent,false);
        return new DetalleHolder(view);
    }

    @Override
    public void onBindViewHolder(DetalleHolder holder, int position) {
        PedidoResponse pedido = pedidos.get(position);
        holder.numPedido.setText(pedido.getNumeroPedido());
        holder.producto.setText(pedido.getProducto());
        holder.unidad.setText(pedido.getUnidadMedida());
        holder.ubicacion.setText(pedido.getUbicacion());
        holder.fechaRegistro.setText(pedido.getFechaRegistro());
        holder.total.setText(pedido.getTotal());
        holder.cantidad.setText(pedido.getCantidad());
        holder.fechaSolicitada.setText(pedido.getFechaSolicitada());
    }

    @Override
    public int getItemCount() {
        return pedidos.size();
    }

    public class DetalleHolder extends RecyclerView.ViewHolder {
        //CardView cardView;
        TextView numPedido;
        TextView producto;
        TextView unidad;
        TextView ubicacion;
        TextView fechaRegistro;
        TextView total;
        TextView cantidad;
        TextView fechaSolicitada;

        public DetalleHolder(View itemView) {
            super(itemView);
            //cardView = (CardView)itemView.findViewById(R.id.detalleCardview);
            numPedido = (TextView)itemView.findViewById(R.id.tv_pedido);
            producto = (TextView)itemView.findViewById(R.id.tv_producto);
            unidad = (TextView)itemView.findViewById(R.id.tv_unidad);
            ubicacion = (TextView)itemView.findViewById(R.id.tv_ubicacion);
            fechaRegistro = (TextView)itemView.findViewById(R.id.tv_fecha_registro);
            total = (TextView)itemView.findViewById(R.id.tv_total);
            cantidad = (TextView)itemView.findViewById(R.id.tv_cantidad);
            fechaSolicitada = (TextView)itemView.findViewById(R.id.tv_fecha_solicitada);
        }
    }
}
