package com.sunil.amcor.opcion.valuePlussTray.detalle;

import android.app.ProgressDialog;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sunil.amcor.R;
import com.sunil.amcor.opcion.valuePlussTray.detalle.fragment.BitacoraTabFragment;
import com.sunil.amcor.opcion.valuePlussTray.detalle.fragment.DetalleTabFragment;
import com.sunil.amcor.opcion.valuePlussTray.detalle.fragment.UbicacionTabFragment;
import com.sunil.amcor.opcion.valuePlussTray.model.Pedido;
import com.sunil.amcor.util.Constant;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DetalleMainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private static final String TAG = "DetalleMain";
    private PedidoResponse pedidos = new PedidoResponse();
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_main);

        Pedido pedido = getIntent().getExtras().getParcelable("pedido");

        //setTitle("Detalle Pedido");
        progressDialog = new ProgressDialog(DetalleMainActivity.this,
                R.style.AppTheme_Dark_Dialog);
        progressDialog.setMessage("Cargando...");
        progressDialog.setCancelable(false);
        progressDialog.show();
        loadJsonDetalle(pedido);
    }

    private void loadJsonDetalle(Pedido pedido) {
        Log.d(TAG, "loadJsonDetalle");
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new DetalleInterceptor(this))
        //http://node142428-env-1313427.jelasticlw.com.br/RS_Consulta-1.0-SNAPSHOT/consulta/pedido/10
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .build();

        RestDetalle restDetalle = retrofit.create(RestDetalle.class);
        Call<ObResponse> call = restDetalle.getDetalle(pedido.getNumeroPedido());

        call.enqueue(new Callback<ObResponse>() {
            @Override
            public void onResponse(Call<ObResponse> call, Response<ObResponse> response) {
                Log.d(TAG, response.code() +"");
                switch (response.code()) {
                    case 200:

                        ObResponse data = response.body();
                        Log.d(TAG, data.toString());
                        //pedidos = data.getPedidoResponse();
                        //DetalleAdapter detalleAdapter = new DetalleAdapter(pedidos, getActivity());
                        //recyclerViewDetalle.setAdapter(detalleAdapter);
                        goTab(data);
                        break;
                    default:
                        progressDialog.dismiss();
                        break;
                }
            }

            @Override
            public void onFailure(Call<ObResponse> call, Throwable t) {

            }
        });
    }

    private void goTab(ObResponse data) {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        //setupViewPager(viewPager);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        Bundle bundle =  new Bundle();
        bundle.putParcelable("data", data);
        Log.d(TAG, "data: "+bundle);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        DetalleTabFragment detalleTabFragment = new DetalleTabFragment();
        adapter.addFragment(detalleTabFragment, "DETALLE");
        detalleTabFragment.setArguments(bundle);

        Log.d(TAG, "holaaa ");

        UbicacionTabFragment ubicacionTabFragment = new UbicacionTabFragment();
        adapter.addFragment(ubicacionTabFragment, "UBICACIÓN");
        ubicacionTabFragment.setArguments(bundle);

        BitacoraTabFragment bitacoraTabFragment = new BitacoraTabFragment();
        adapter.addFragment(bitacoraTabFragment, "BITÁCORA DE PEDIDO");
        bitacoraTabFragment.setArguments(bundle);

        viewPager.setAdapter(adapter);
        progressDialog.dismiss();

    }

    @Override
    public void setTitle(CharSequence title) {
        getSupportActionBar().setTitle(title);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

}
