package com.sunil.amcor.opcion.createOrder;

import android.app.Activity;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.sunil.amcor.R;
import com.sunil.amcor.opcion.createOrder.model.Producto;

import java.util.List;

/**
 * Created by Lucero on 07/09/2017.
 */

public class CreateOrderAdapter extends RecyclerView.Adapter<CreateOrderAdapter.CreateOrderHolder> {

    private List<Producto> productos;
    private Activity activity;

    private String TAG= "adapterCreateOrder";

    public CreateOrderAdapter(List<Producto> productos,  Activity activity) {
        this.productos = productos;
        this.activity = activity;
    }


    @Override
    public CreateOrderHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_product, parent,false);
        return new CreateOrderHolder(view);
    }

    @Override
    public void onBindViewHolder(final CreateOrderHolder holder, int position) {
        final Producto producto = productos.get(position);

        String encodedDataString = "";
        encodedDataString = producto.getBase64().toString();
        byte[] imageAsBytes = Base64.decode(encodedDataString.getBytes(), 0);
        holder.base64.setImageBitmap(BitmapFactory.decodeByteArray(imageAsBytes, 0, imageAsBytes.length));
        //base64.setImageBitmap(BitmapFactory.decodeByteArray(imageAsBytes, 0, imageAsBytes.length));
        //producto.getBase64().toString();

        holder.sku.setText(producto.getSku());
        holder.marca.setText(producto.getMarcaProducto());
        holder.unidad.setText(producto.getUnidadMedida());
        holder.version.setText(producto.getVersionProducto());
        holder.codigo.setText(producto.getCodProducto());

        holder.agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onclick ");
                //holder.cardView.setVisibility(View.GONE);
                Bundle bundle = new Bundle();
                //bundle.putString("producto", producto.toString());
                bundle.putParcelable("producto", producto);
                AddCartFragment addCartfragmentNew = new AddCartFragment();
                addCartfragmentNew.setArguments(bundle);
                Log.d(TAG, "bundle: "+bundle);
                addCartfragmentNew.actualizar();

            }
        });

    }

    @Override
    public int getItemCount() {

        return productos.size();
    }

    public class CreateOrderHolder extends RecyclerView.ViewHolder{
        CardView cardView;
        String base64String;
        ImageView base64;
        ImageButton agregar;
        TextView sku;
        TextView marca;
        TextView unidad;
        TextView version;
        TextView codigo;

        public CreateOrderHolder(View itemView) {
            super(itemView);
            cardView = (CardView)itemView.findViewById(R.id.productCardview);
            base64 = (ImageView)itemView.findViewById(R.id.iv_base64);
            agregar = (ImageButton)itemView.findViewById(R.id.ib_producto);
            sku = (TextView)itemView.findViewById(R.id.tv_sku);
            marca = (TextView)itemView.findViewById(R.id.tv_marca);
            unidad = (TextView)itemView.findViewById(R.id.tv_unidad);
            version = (TextView)itemView.findViewById(R.id.tv_version);
            codigo = (TextView)itemView.findViewById(R.id.tv_codigo);

        }
    }
}
