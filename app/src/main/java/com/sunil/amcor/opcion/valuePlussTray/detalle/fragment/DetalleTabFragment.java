package com.sunil.amcor.opcion.valuePlussTray.detalle.fragment;


import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sunil.amcor.AdvanceInterceptor;
import com.sunil.amcor.R;
import com.sunil.amcor.data.api.RestClient;
import com.sunil.amcor.opcion.valuePlussTray.detalle.DetalleAdapter;
import com.sunil.amcor.opcion.valuePlussTray.detalle.ObResponse;
import com.sunil.amcor.opcion.valuePlussTray.detalle.PedidoDetalle;
import com.sunil.amcor.opcion.valuePlussTray.detalle.PedidoResponse;
import com.sunil.amcor.util.Constant;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetalleTabFragment extends Fragment {

    private static final String TAG = "DetalleTabFragment";

    private RecyclerView recyclerViewDetallePedido;
    private CoordinatorLayout coordinatorLayout;
    private PedidoResponse pedidos = new PedidoResponse();
    private List<PedidoDetalle> pedidoDetalles = new ArrayList<>();

    private AdvanceRequest advanceRequest = new AdvanceRequest();

    TextView numPedido;
    TextView producto;
    TextView unidad;
    TextView ubicacion;
    TextView fechaRegistro;
    TextView total;
    CardView cardView;
    TextView cantidad;
    TextView fechaSolicitada;
    ImageView base64;
    Button viewFile;
    Button avanzar;

    public DetalleTabFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Bundle bundle = getArguments();
        Log.d(TAG, "bundle: "+bundle);
        ObResponse data = bundle.getParcelable("data");
        Log.d(TAG, "data: "+data);
        pedidos = data.getPedidoResponse();
        Log.d(TAG, "pedidos: "+pedidos);

        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_detalle_tab, container, false);
        pedidoDetalles = pedidos.getPedidosDetalle();
        Log.d(TAG, "pedidoDetalles: "+pedidoDetalles);

        recyclerViewDetallePedido = (RecyclerView)view.findViewById(R.id.detallePedidoRecyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerViewDetallePedido.setLayoutManager(linearLayoutManager);

        DetalleAdapter detalleAdapter = new DetalleAdapter(pedidoDetalles, getActivity());
        recyclerViewDetallePedido.setAdapter(detalleAdapter);

        numPedido = (TextView)view.findViewById(R.id.tv_pedido);
        producto = (TextView)view.findViewById(R.id.tv_producto);
        unidad = (TextView)view.findViewById(R.id.tv_unidad);
        ubicacion = (TextView)view.findViewById(R.id.tv_ubicacion);
        fechaRegistro = (TextView)view.findViewById(R.id.tv_fecha_registro);
        total = (TextView)view.findViewById(R.id.tv_total);
        cardView = (CardView)view.findViewById(R.id.detalleCardview);
        base64= (ImageView)view.findViewById(R.id.img_detalle);
        coordinatorLayout = (CoordinatorLayout)view.findViewById(R.id.tab_detalle_coordinator);
        viewFile = (Button)view.findViewById(R.id.btn_orden_compra);
        if(Constant.HISTORICA_QUERY.equals(Constant.codOpcion))
        viewFile.setVisibility(View.GONE);
        avanzar = (Button)view.findViewById(R.id.btn_avanzar);

        Log.d(TAG, "numPedido: "+pedidos.getNumeroPedido());
        Log.d(TAG, "producto: "+pedidos.getProducto());
        Log.d(TAG, "unidad: "+pedidos.getUnidadMedida());
        Log.d(TAG, "ubicacion: "+pedidos.getUbicacion());
        Log.d(TAG, "fechaRegistro: "+pedidos.getFechaRegistro());
        Log.d(TAG, "total: "+pedidos.getTotal());
        Log.d(TAG, "base64: "+base64);
        numPedido.setText(pedidos.getNumeroPedido());
        producto.setText(pedidos.getProducto());
        unidad.setText(pedidos.getUnidadMedida());
        ubicacion.setText(pedidos.getUbicacion());
        fechaRegistro.setText(pedidos.getFechaRegistro());
        total.setText(pedidos.getTotal());
        final String encodedDataString = pedidos.getImagenProducto().toString();
        byte[] imageAsBytes = Base64.decode(encodedDataString.getBytes(), 0);
        base64.setImageBitmap(BitmapFactory.decodeByteArray(imageAsBytes, 0, imageAsBytes.length));

        final Context context=getContext();
        viewFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onclickbase64: ");
                FileOutputStream fos = null;
                try {
                    if (encodedDataString != null) {

                        Log.d("Detalle","contentType"+pedidos.getImagenAdjunta().getContentType());
                        Constant.imagenAdjunta=pedidos.getImagenAdjunta();
                        File file=new File(context.getExternalFilesDir(null),"orden");
                        fos = new FileOutputStream(file);
                        byte[] decodedString = Base64.decode(pedidos.getImagenAdjunta().getBase64(),Base64.DEFAULT);
                        fos.flush();
                        fos.write(decodedString);
                        fos.close();
                        Intent intent =new Intent(Intent.ACTION_VIEW);
                        Uri targetUri = Uri.fromFile(file);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                        intent.setDataAndType(targetUri,pedidos.getImagenAdjunta().getContentType());
                        startActivity(intent);
                        Log.d(TAG, "targetUri: "+targetUri.getPath());
                        Log.d(TAG, "onclickbase65: ");

                    }
                } catch (Exception e) {
                    Log.d(TAG, "exception: "+e.getMessage());

                } finally {
                    if (fos != null) {
                        fos = null;
                    }
                }
            }
        });

        avanzar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                advancePedido(v);
            }
        });

        return view;
    }

    public void advancePedido(final View v) {
        Log.d(TAG, "advancePedido");

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(R.string.message_confirm);
        builder.setPositiveButton(R.string.avanzar, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                final ProgressDialog progressDialog = new ProgressDialog(v.getContext(),
                        R.style.AppTheme_Dark_Dialog);
                progressDialog.setMessage("Cargando...");
                progressDialog.setIndeterminate(true);
                progressDialog.setCancelable(false);
                progressDialog.show();
                Gson gson = new GsonBuilder()
                        .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                        .create();

                OkHttpClient client = new OkHttpClient.Builder()
                        .addInterceptor(new AdvanceInterceptor(getContext()))
                        .build();

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(Constant.BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create(gson))
                        .client(client)
                        .build();

                RestClient restClient = retrofit.create(RestClient.class);
                advanceRequest.setCodigoPerfil(Constant.codPerfil);
                advanceRequest.setCodigoUsuario(Constant.codUsuario);
                advanceRequest.setNumeroPedido(pedidos.getNumeroPedido());
                Call<AdvanceResponse> call = restClient.advance(advanceRequest);
                call.enqueue(new Callback<AdvanceResponse>() {
                    @Override
                    public void onResponse(Call<AdvanceResponse> call, Response<AdvanceResponse> response) {
                        Log.d(TAG, response.code() +"");
                        switch (response.code()) {
                            case 200:
                                progressDialog.dismiss();
                                AdvanceResponse data = response.body();
                                Toast.makeText(getActivity(),data.getMensajeAccion(),Toast.LENGTH_LONG).show();

                                final Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        getActivity().finish();
                                        //Do something after 100ms
                                    }
                                }, 1000);
                                break;
                            case 401:
                                progressDialog.dismiss();
                                break;
                            default:
                                progressDialog.dismiss();
                                break;
                        }
                    }

                    @Override
                    public void onFailure(Call<AdvanceResponse> call, Throwable t) {

                    }
                });

                // User clicked OK button
            }
        });
        builder.setNegativeButton(R.string.cancelar, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User cancelled the dialog
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();

    }


}
