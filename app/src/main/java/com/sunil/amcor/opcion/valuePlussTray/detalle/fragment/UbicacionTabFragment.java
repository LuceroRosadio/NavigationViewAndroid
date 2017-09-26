package com.sunil.amcor.opcion.valuePlussTray.detalle.fragment;


import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.sunil.amcor.R;
import com.sunil.amcor.opcion.valuePlussTray.detalle.ObResponse;
import com.sunil.amcor.opcion.valuePlussTray.detalle.PedidoResponse;

/**
 * A simple {@link Fragment} subclass.
 */
public class UbicacionTabFragment extends Fragment {
    private static final String TAG = "UbicacionTabFragment";

    private PedidoResponse pedidos = new PedidoResponse();

    ImageView ubicacion;

    public UbicacionTabFragment() {
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
        View view = inflater.inflate(R.layout.fragment_ubicacion_tab, container, false);

        ubicacion = (ImageView)view.findViewById(R.id.img_ubicacion);

        String encodedDataString = pedidos.getImagenUbicacion();
        Log.d(TAG, "imagnUbic: "+pedidos.getImagenUbicacion());
        Log.d(TAG, "encodedDataString: "+encodedDataString);
        byte[] imageAsBytes = Base64.decode(encodedDataString.getBytes(), 0);
        ubicacion.setImageBitmap(BitmapFactory.decodeByteArray(imageAsBytes, 0, imageAsBytes.length));

        return  view;
    }

}
