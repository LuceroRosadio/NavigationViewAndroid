package com.sunil.navigationviewandroid.opcion.valuePlussTray.detalle.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sunil.navigationviewandroid.R;
import com.sunil.navigationviewandroid.opcion.valuePlussTray.detalle.DetalleAdapter;
import com.sunil.navigationviewandroid.opcion.valuePlussTray.detalle.DetalleInterceptor;
import com.sunil.navigationviewandroid.opcion.valuePlussTray.detalle.ObResponse;
import com.sunil.navigationviewandroid.opcion.valuePlussTray.detalle.PedidoDetalle;
import com.sunil.navigationviewandroid.opcion.valuePlussTray.detalle.PedidoResponse;
import com.sunil.navigationviewandroid.opcion.valuePlussTray.detalle.RestDetalle;

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

    private RecyclerView recyclerViewDetalle;
    private List<PedidoResponse> pedidos = new ArrayList<>();


    public DetalleTabFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_detalle_tab, container, false);
        recyclerViewDetalle = (RecyclerView)view.findViewById(R.id.detalleRecyclerView);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerViewDetalle.setLayoutManager(linearLayoutManager);
        loadJsonDetalle();

        return view;
    }

    private void loadJsonDetalle() {
        Log.d(TAG, "loadJsonDetalle");
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new DetalleInterceptor())
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://amcore/api/order/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .build();

        RestDetalle restDetalle = retrofit.create(RestDetalle.class);
        Call<ObResponse> call = restDetalle.getDetalle();

        call.enqueue(new Callback<ObResponse>() {
            @Override
            public void onResponse(Call<ObResponse> call, Response<ObResponse> response) {
                Log.d(TAG, response.code() +"");
                switch (response.code()) {
                    case 200:
                        ObResponse data = response.body();
                        Log.d(TAG, data.toString());
                        pedidos = data.getPedidoResponseList();
                        DetalleAdapter detalleAdapter = new DetalleAdapter(pedidos, getActivity());
                        recyclerViewDetalle.setAdapter(detalleAdapter);
                        break;
                    case 401:
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onFailure(Call<ObResponse> call, Throwable t) {

            }
        });


    }

}
