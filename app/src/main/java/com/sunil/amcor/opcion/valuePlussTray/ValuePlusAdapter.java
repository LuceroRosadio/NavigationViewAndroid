package com.sunil.amcor.opcion.valuePlussTray;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.sunil.amcor.R;
import com.sunil.amcor.opcion.valuePlussTray.detalle.DetalleMainActivity;
import com.sunil.amcor.opcion.valuePlussTray.model.Pedido;

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
        final Pedido pedido = pedidos.get(position);
        holder.nroPedido.setText(pedido.getNumeroPedido());
        holder.cliente.setText(pedido.getCliente());
        holder.producto.setText(pedido.getProducto());
        holder.cantidad.setText(pedido.getCantidad());
        holder.unidad.setText(pedido.getUnidadMedida());
        holder.ubicacion.setText(pedido.getUbicacion());

        holder.codigo.setText(pedido.getCodigoProducto());
        holder.version.setText(pedido.getVersion());
        holder.precioUnitario.setText(pedido.getPrecioUnitario());
        holder.precioTotal.setText(pedido.getPrecioTotal());
        holder.cantidadDias.setText(pedido.getCantidadDias());
        holder.motivo.setText(pedido.getEstadoMotivo());


        Log.d(TAG,"holder: "+pedido.toString());


        holder.archivo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    holder.codigo.setVisibility(View.VISIBLE);
                    holder.version.setVisibility(View.VISIBLE);
                    holder.precioUnitario.setVisibility(View.VISIBLE);
                    holder.precioTotal.setVisibility(View.VISIBLE);
                    holder.cantidadDias.setVisibility(View.VISIBLE);
                    holder.motivo.setVisibility(View.VISIBLE);

                    holder.codigoTextView.setVisibility(View.VISIBLE);
                    holder.versionTextView.setVisibility(View.VISIBLE);
                    holder.precioUnitarioTextView.setVisibility(View.VISIBLE);
                    holder.precioTotalTextView.setVisibility(View.VISIBLE);
                    holder.cantidadDiasTextView.setVisibility(View.VISIBLE);
                    holder.motivoTextView.setVisibility(View.VISIBLE);
                } else {
                    holder.codigo.setVisibility(View.GONE);
                    holder.version.setVisibility(View.GONE);
                    holder.precioUnitario.setVisibility(View.GONE);
                    holder.precioTotal.setVisibility(View.GONE);
                    holder.cantidadDias.setVisibility(View.GONE);
                    holder.motivo.setVisibility(View.GONE);

                    holder.codigoTextView.setVisibility(View.GONE);
                    holder.versionTextView.setVisibility(View.GONE);
                    holder.precioUnitarioTextView.setVisibility(View.GONE);
                    holder.precioTotalTextView.setVisibility(View.GONE);
                    holder.cantidadDiasTextView.setVisibility(View.GONE);
                    holder.motivoTextView.setVisibility(View.GONE);
                }
            }
        });

        holder.verDetalle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, DetalleMainActivity.class);
                intent.putExtra("pedido", pedido);
                activity.startActivity(intent);
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
        TextView unidad;
        TextView ubicacion;
        TextView codigo;
        TextView version;
        TextView precioUnitario;
        TextView precioTotal;
        TextView cantidadDias;
        TextView motivo;

        TextView codigoTextView;
        TextView versionTextView;
        TextView precioUnitarioTextView;
        TextView precioTotalTextView;
        TextView cantidadDiasTextView;
        TextView motivoTextView;

        CheckBox archivo;
        CheckBox verDetalle;

        public ValuePlusHolder(View itemView) {
            super(itemView);
            cardView = (CardView)itemView.findViewById(R.id.orderCardview);
            nroPedido = (TextView)itemView.findViewById(R.id.campo1);
            cliente = (TextView)itemView.findViewById(R.id.campo2);
            producto = (TextView)itemView.findViewById(R.id.campo3);
            cantidad = (TextView)itemView.findViewById(R.id.campo4);
            unidad = (TextView)itemView.findViewById(R.id.campo5);
            ubicacion = (TextView)itemView.findViewById(R.id.campo6);

            codigo = (TextView)itemView.findViewById(R.id.archivo1);
            version = (TextView)itemView.findViewById(R.id.archivo2);
            precioUnitario = (TextView)itemView.findViewById(R.id.archivo3);
            precioTotal = (TextView)itemView.findViewById(R.id.archivo4);
            cantidadDias = (TextView)itemView.findViewById(R.id.archivo5);
            motivo = (TextView)itemView.findViewById(R.id.archivo6);

            codigoTextView = (TextView)itemView.findViewById(R.id.tv_1);
            versionTextView = (TextView)itemView.findViewById(R.id.tv_2);
            precioUnitarioTextView = (TextView)itemView.findViewById(R.id.tv_3);
            precioTotalTextView = (TextView)itemView.findViewById(R.id.tv_4);
            cantidadDiasTextView = (TextView)itemView.findViewById(R.id.tv_5);
            motivoTextView = (TextView)itemView.findViewById(R.id.tv_6);

            archivo = (CheckBox) itemView.findViewById(R.id.checkOpcion);

            codigo.setVisibility(View.GONE);
            version.setVisibility(View.GONE);
            precioUnitario.setVisibility(View.GONE);
            precioTotal.setVisibility(View.GONE);
            cantidadDias.setVisibility(View.GONE);
            motivo.setVisibility(View.GONE);

            verDetalle = (CheckBox)itemView.findViewById(R.id.checkDetalle);

            codigoTextView.setVisibility(View.GONE);
            versionTextView.setVisibility(View.GONE);
            precioUnitarioTextView.setVisibility(View.GONE);
            precioTotalTextView.setVisibility(View.GONE);
            cantidadDiasTextView.setVisibility(View.GONE);
            motivoTextView.setVisibility(View.GONE);
        }
    }

}

