package com.sunil.navigationviewandroid.opcion.valuePlussTray;


import android.app.Activity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
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
import com.sunil.navigationviewandroid.opcion.valuePlussTray.api.RestPedido;
import com.sunil.navigationviewandroid.opcion.valuePlussTray.model.OrderRequestResponse;
import com.sunil.navigationviewandroid.opcion.valuePlussTray.model.Pedido;

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
public class ValuePlusTrayFragment extends Fragment {

    private static final String TAG = "ValuePlusFragment";

    private RecyclerView recyclerViewValuePlus;
    private List<Pedido> pedidos = new ArrayList<>();

    public ValuePlusTrayFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.d(TAG, "entreValuePlussss");
        View view = inflater.inflate(R.layout.fragment_value_plus_tray, container, false);

        /*recyclerViewValuePlus = (RecyclerView)view.findViewById(R.id.tableRecyclerView);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);

        recyclerViewValuePlus.setLayoutManager(linearLayoutManager);*/
        //loadJsonPedidos();
        return view;

    }

    private void loadJsonPedidos() {
        Log.d(TAG, "loadJsonPedidos");
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new ValuePlusInterceptor())
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://amcore/api/order/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .build();

        RestPedido restPedido = retrofit.create(RestPedido.class);
        Call<OrderRequestResponse> call = restPedido.getOrder();

        call.enqueue(new Callback<OrderRequestResponse>() {
            @Override
            public void onResponse(Call<OrderRequestResponse> call, Response<OrderRequestResponse> response) {
                Log.d(TAG, response.code() +"");
                switch (response.code()) {
                    case 200:
                        OrderRequestResponse data = response.body();
                        Log.d(TAG, data.toString());
                        pedidos = data.getPedidoList();
                        ValuePlusAdapter valuePlusAdapter = new ValuePlusAdapter(pedidos, R.layout.cardview_order, getActivity());
                        recyclerViewValuePlus.setAdapter(valuePlusAdapter);
                        break;
                    case 401:
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onFailure(Call<OrderRequestResponse> call, Throwable t) {

            }
        });
    }

}
