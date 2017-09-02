package com.sunil.navigationviewandroid.opcion.valuePlussTray;

import android.app.Activity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TextView;

import com.sunil.navigationviewandroid.R;
import com.sunil.navigationviewandroid.opcion.valuePlussTray.model.Pedido;

import java.util.List;

/**
 * Created by Lucero on 23/08/2017.
 */

public class ValuePlusAdapter extends RecyclerView.Adapter<ValuePlusAdapter.ValuePlusHolder> {

    private List<Pedido> pedidos;
    //private int resource;
    private Activity activity;

    private String TAG= "adapterValuePlus";

    public ValuePlusAdapter(List<Pedido> pedidos,  Activity activity) {
        this.pedidos = pedidos;
        this.activity = activity;
    }

    @Override
    public ValuePlusHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d(TAG,"onCreateViewHolderValue");
        View view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_order, parent,false);
        return new ValuePlusHolder(view);
    }

    @Override
    public void onBindViewHolder(final ValuePlusHolder holder, int position) {
        Log.d(TAG,"onBindViewHolderValue");
        Pedido pedido = pedidos.get(position);
        holder.nroPedido.setText(pedido.getNumeroPedido());
        holder.cliente.setText(pedido.getCliente());
        holder.producto.setText(pedido.getProducto());
        holder.cantidad.setText(pedido.getCantidad());
        holder.precioTotal.setText(pedido.getPrecioTotal());
        holder.base64.setText(pedido.getArchivo().getBase64());
        holder.contentType.setText(pedido.getArchivo().getContentType());
        holder.nombreArchivo.setText(pedido.getArchivo().getNombreArchivo());

        Log.d(TAG,"holder: "+pedido.toString());



        holder.archivo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"base64");

                holder.base64.setVisibility(View.VISIBLE);
                holder.contentType.setVisibility(View.VISIBLE);
                holder.nombreArchivo.setVisibility(View.VISIBLE);
            }
        });
    }

    @Override
    public int getItemCount() {

        return pedidos.size();
    }

    public class ValuePlusHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        TextView nroPedido;
        TextView cliente;
        TextView producto;
        TextView cantidad;
        TextView precioTotal;
        TextView base64;
        TextView contentType;
        TextView nombreArchivo;
        CheckBox archivo;

        public ValuePlusHolder(View itemView) {
            super(itemView);
            cardView = (CardView)itemView.findViewById(R.id.orderCardview);
            nroPedido = (TextView)itemView.findViewById(R.id.campo1);
            cliente = (TextView)itemView.findViewById(R.id.campo2);
            producto = (TextView)itemView.findViewById(R.id.campo3);
            cantidad = (TextView)itemView.findViewById(R.id.campo4);
            precioTotal = (TextView)itemView.findViewById(R.id.campo5);
            base64 = (TextView)itemView.findViewById(R.id.archivo1);
            contentType = (TextView)itemView.findViewById(R.id.archivo2);
            nombreArchivo = (TextView)itemView.findViewById(R.id.archivo3);
            archivo = (CheckBox) itemView.findViewById(R.id.checkOpcion);

            base64.setVisibility(View.GONE);
            contentType.setVisibility(View.GONE);
            nombreArchivo.setVisibility(View.GONE);
        }
    }

}
