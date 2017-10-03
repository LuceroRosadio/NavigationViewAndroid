package com.amcor.opcion.createOrder;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;

import com.amcor.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CreateOrderFragment extends Fragment implements OnItemSelectedListener {

    private TextInputEditText solicitud;
    private TextInputEditText fecha;
    private Spinner cliente;
    private Spinner accion;
    private FloatingActionButton addCart;

    Context context;

    private static final String TAG = "CreateOrder";

    public CreateOrderFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view  = inflater.inflate(R.layout.fragment_create_order, container, false);

        solicitud = (TextInputEditText)view.findViewById(R.id.edt_solicitud);
        fecha = (TextInputEditText)view.findViewById(R.id.edt_fecha);
        cliente = (Spinner)view.findViewById(R.id.spinner_cliente);
        accion = (Spinner)view.findViewById(R.id.spinner_accion);
        addCart = (FloatingActionButton)view.findViewById(R.id.fabCart);

        solicitud.setEnabled(false);
        fecha.setEnabled(false);

        cliente.setOnItemSelectedListener(this);
        List<String> clienteList = new ArrayList<String>();
        clienteList.add("Cliente 1");
        clienteList.add("Cliente 2");
        clienteList.add("Cliente 3");
        ArrayAdapter<String> clienteAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_dropdown_item, clienteList);
        clienteAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        cliente.setAdapter(clienteAdapter);

        accion.setOnItemSelectedListener(this);
        List<String> accionList = new ArrayList<String>();
        accionList.add("");
        accionList.add("Avanzar");
        ArrayAdapter<String> accionAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_dropdown_item, accionList);
        accionAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        accion.setAdapter(accionAdapter);

        //setFragment();

        addCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Intent intent = new Intent(getActivity(), AddCartFragment.class);
                startActivity(intent);*/
                Log.d(TAG, "click");
                AddCartFragment addCartfragment = new AddCartFragment();
                FragmentManager cartManager = getFragmentManager();
                FragmentTransaction transaction = cartManager.beginTransaction();
                transaction.replace(R.id.frameContainer, addCartfragment)
                        //.addToBackStack(null)
                        .commit();
            }
        });

        return view;
    }

    public void setFragment() {
        CreateOrderFragment createOrderFragment = new CreateOrderFragment();
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.frameCreateOrder, createOrderFragment).commit();
        //manager.executePendingTransactions();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String item = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
