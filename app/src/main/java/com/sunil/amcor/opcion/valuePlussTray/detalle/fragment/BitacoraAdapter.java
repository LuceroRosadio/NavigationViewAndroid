package com.sunil.amcor.opcion.valuePlussTray.detalle.fragment;

import android.app.Activity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sunil.amcor.R;
import com.sunil.amcor.opcion.valuePlussTray.detalle.Bitacora;

import java.util.List;

/**
 * Created by Lucero on 20/09/2017.
 */

public class BitacoraAdapter extends RecyclerView.Adapter<BitacoraAdapter.BitacoraHolder> {

    //private PedidoResponse pedido;
    private List<Bitacora> bitacoras;
    private Activity activity;
    private String TAG= "BitacoraAdapter";

    public BitacoraAdapter(List<Bitacora> bitacoras, Activity activity) {
        this.bitacoras = bitacoras;
        this.activity = activity;
    }

    @Override
    public BitacoraAdapter.BitacoraHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_bitacora, parent,false);
        return new BitacoraAdapter.BitacoraHolder(view);
    }

    @Override
    public void onBindViewHolder(BitacoraAdapter.BitacoraHolder holder, int position) {
        /*holder.nro.setText(pedido.get);
        pedido.get(position)*/
        /*final Pedido pedido = pedidos.get(position);
        holder.nroPedido.setText(pedido.getNumeroPedido());*/

        final Bitacora bitacora = bitacoras.get(position);
        //holder.origen.setText(bitacora.get);

        Log.d(TAG, "bitacora: "+bitacora);
        //Log.d(TAG, "pedido: "+pedido.getBitacoras());
        Log.d(TAG, "bitacoras: "+bitacoras.toString());
        holder.nro.setText(""+(position+1));
        Log.d(TAG, "position: "+position);
        holder.origen.setText(bitacora.getOrigen());
        holder.destino.setText(bitacora.getDestino());
        holder.evento.setText(bitacora.getEvento());
        holder.fechaHora.setText(bitacora.getFecha());
        holder.usuario.setText(bitacora.getUsuario());
    }

    @Override
    public int getItemCount() {
        return bitacoras.size();
    }

    public class BitacoraHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        TextView nro;
        TextView origen;
        TextView destino;
        TextView evento;
        TextView fechaHora;
        TextView usuario;

        public BitacoraHolder(View itemView) {
            super(itemView);
            cardView = (CardView)itemView.findViewById(R.id.bitacoraCardview);
            nro = (TextView)itemView.findViewById(R.id.tv_nro);
            origen = (TextView)itemView.findViewById(R.id.tv_origen);
            destino = (TextView)itemView.findViewById(R.id.tv_destino);
            evento = (TextView)itemView.findViewById(R.id.tv_evento);
            fechaHora = (TextView)itemView.findViewById(R.id.tv_fecha_hora);
            usuario = (TextView)itemView.findViewById(R.id.tv_usuario);
        }
    }
}
