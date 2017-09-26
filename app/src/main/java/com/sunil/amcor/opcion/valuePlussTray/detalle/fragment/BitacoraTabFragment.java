package com.sunil.amcor.opcion.valuePlussTray.detalle.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sunil.amcor.R;
import com.sunil.amcor.opcion.valuePlussTray.detalle.ObResponse;
import com.sunil.amcor.opcion.valuePlussTray.detalle.PedidoResponse;
import com.sunil.amcor.opcion.valuePlussTray.detalle.Bitacora;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class BitacoraTabFragment extends Fragment {
    private static final String TAG = "BitacoraTabFragment";
    private PedidoResponse pedidos = new PedidoResponse();
    private List<Bitacora> bitacoras = new ArrayList<>();
    private RecyclerView recyclerViewBitacora;

    public BitacoraTabFragment() {
        // Required empty public constructor
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
        View view = inflater.inflate(R.layout.fragment_bitacora_tab, container, false);

        recyclerViewBitacora = (RecyclerView)view.findViewById(R.id.bitacoraRecyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerViewBitacora.setLayoutManager(linearLayoutManager);

        bitacoras = pedidos.getBitacoras();

        BitacoraAdapter bitacoraAdapter = new BitacoraAdapter(bitacoras, getActivity());
        recyclerViewBitacora.setAdapter(bitacoraAdapter);

        return view;
    }


}
