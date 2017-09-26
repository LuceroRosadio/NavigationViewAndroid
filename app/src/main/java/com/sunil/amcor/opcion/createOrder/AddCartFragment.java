package com.sunil.amcor.opcion.createOrder;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sunil.amcor.R;
import com.sunil.amcor.opcion.createOrder.api.RestProducto;
import com.sunil.amcor.opcion.createOrder.model.CreateOrderResponse;
import com.sunil.amcor.opcion.createOrder.model.Producto;

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
public class AddCartFragment extends Fragment {

    private EditText producto;
    private ImageButton buscarProducto;
    private EditText descripcion;
    private EditText unidad;
    private EditText cantidad;
    private EditText fecha;
    private Button adjuntarArchivo;
    private EditText archivo;

    private RecyclerView recyclerViewCreateOrder;
    private List<Producto> productos = new ArrayList<>();

    private static final String TAG = "AddCart";

    public AddCartFragment() {
        // Required empty public constructor

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_cart, container, false);

        producto = (EditText)view.findViewById(R.id.edt_producto);
        buscarProducto = (ImageButton)view.findViewById(R.id.ib_buscar);
        descripcion = (EditText)view.findViewById(R.id.edt_descripcion);
        unidad = (EditText)view.findViewById(R.id.edt_unidad);
        cantidad = (EditText)view.findViewById(R.id.edt_cantidad);
        fecha = (EditText)view.findViewById(R.id.edt_fecha);
        adjuntarArchivo = (Button)view.findViewById(R.id.btn_archivo);
        archivo = (EditText)view.findViewById(R.id.edt_archivo);
        recyclerViewCreateOrder = (RecyclerView)view.findViewById(R.id.productRecyclerview);

        producto.setEnabled(false);
        descripcion.setEnabled(false);
        unidad.setEnabled(false);
        cantidad.setEnabled(false);
        fecha.setEnabled(false);
        archivo.setEnabled(false);

        seleccionarProducto(view, 0);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerViewCreateOrder.setLayoutManager(linearLayoutManager);

        buscarProducto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadJsonProductos();
                recyclerViewCreateOrder.setVisibility(View.VISIBLE);
            }
        });

        adjuntarArchivo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Uri uri = Uri.fromFile(new File(Environment.getExternalStorageDirectory()
                        .getAbsolutePath() + "/CALC/REPORTS/", pdfname));*/
            }
        });

        return view;
    }

    private void loadJsonProductos() {
        Log.d(TAG, "loadJsonProductos");

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new CreateOrderInterceptor())
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://amcore/api/order/addCart/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .build();

        RestProducto restProducto = retrofit.create(RestProducto.class);
        Call<CreateOrderResponse> call = restProducto.getProducto();

        call.enqueue(new Callback<CreateOrderResponse>() {
            @Override
            public void onResponse(Call<CreateOrderResponse> call, Response<CreateOrderResponse> response) {
                Log.d(TAG, response.code() +"");
                switch (response.code()) {
                    case 200:
                        CreateOrderResponse data = response.body();
                        Log.d(TAG, data.toString());
                        productos = data.getProductoList();
                        CreateOrderAdapter createOrderAdapter = new CreateOrderAdapter(productos, getActivity());
                        recyclerViewCreateOrder.setAdapter(createOrderAdapter);
                        Log.d(TAG, "createorderadapter" +createOrderAdapter.toString());
                        break;
                    case 401:
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onFailure(Call<CreateOrderResponse> call, Throwable t) {

            }
        });
    }

    public void setFragment(AddCartFragment addCartFragment) {
        //addCartFragment = new AddCartFragment();
        FragmentManager manager = addCartFragment.getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.frameAddCart, addCartFragment).commit();
        manager.executePendingTransactions();
    }

    public void actualizar () {
        //Log.d(TAG, "actualizar "+bundle);
        //bundle = getArguments();
        //bundle.getInt("adapterPosition", 0);
        Bundle bundle = getArguments();
        //String producto = bundle.getString("producto", "");
        Producto producto = bundle.getParcelable("producto");
        //Log.d(TAG, "bundle: "+bundle);
        Log.d(TAG, "producto: "+producto);
        Log.d(TAG, "marca: "+producto.getMarcaProducto());
        Log.d(TAG, "descripcion: "+producto.getDescripcionProducto());
        Log.d(TAG, "unidad: "+producto.getUnidadMedida());

        //llenarProducto(producto);

    }

    private void llenarProducto(Producto p) {
        /*String marca = p.getMarcaProducto();
        String descripcion = p.getDescripcionProducto();
        String unidad = p.getUnidadMedida();
        lalala(marca, descripcion, unidad);*/

        seleccionarProducto(getView() , 1);
        //recyclerViewCreateOrder.setVisibility(View.GONE);
        //producto.setText("productolalala");
    }

    private void lalala(String a, String b, String c) {
        //seleccionarProducto(getView() ,1);

    }

    private void seleccionarProducto(View view, int i) {
        view.setVisibility(View.VISIBLE);
        recyclerViewCreateOrder.setVisibility(View.GONE);
        producto.setText("productolalala");

        /*if (i!=0) {
            producto.setText("producto1");
        };*/

    }

}
