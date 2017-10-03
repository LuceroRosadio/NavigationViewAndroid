package com.amcor;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.amcor.data.Modulo;
import com.amcor.data.OpcionModulo;
import com.amcor.data.UserResponse;
import com.amcor.fragment.OrderRequestFragment;
import com.amcor.fragment.QueryTrackingFragment;
import com.amcor.opcion.createOrder.ContainerFragment;
import com.amcor.opcion.valuePlussTray.ValuePlusTrayFragment;
import com.amcor.util.Constant;
import com.amcor.util.SharedPrefManager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements RecyclerAdapter.ItemClickChild{

    private static final String TAG = "HomeActivity";
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.nav_view)
    NavigationView navView;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    //String names[] = Constant.name;
    //String subNames[] = Constant.subName;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.frame)
    FrameLayout frame;

    TitleFragment fragment;
    //OrderRequestFragment fragment;

    public List<Modulo> moduloList = new ArrayList<>();
    @BindView(R.id.nav_usuario)
    TextView usuario;

    UserResponse data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (!SharedPrefManager.getInstance(this).isLoggedIn()) {
            finish();
            startActivity(new Intent(this, LoginActivity.class));
            return;
        }
        data = SharedPrefManager.getInstance(this).getUserResponse();
        Log.d(TAG,"entre aca");
        //data = getIntent().getExtras().getParcelable("data");
        Log.d(TAG, "data:" +data);
        Log.d(TAG, "usuario: " +data.getUsuario());
        ButterKnife.bind(this);
        usuario.setText(data.getUsuario().getNombresUsuario());
        moduloList = data.getUsuario().getModuloList();

        setToolbar();

        //setSupportActionBar(toolbar);
        final ActionBar actionar = getSupportActionBar();
        actionar.setDisplayHomeAsUpEnabled(true);
        actionar.setHomeAsUpIndicator(R.drawable.ic_menu);

        List<TitleMenu> list = getModuloMenu(moduloList);
        RecyclerAdapter adapter = new RecyclerAdapter(this, list, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(adapter);

        setFragment();
    }

    private void setFragment() {
        fragment = new TitleFragment();
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
                transaction.replace(R.id.frame, fragment)
                //.addToBackStack(null)
                .commit();

        manager.executePendingTransactions();

    }


    private List<TitleMenu> getModuloMenu(List<Modulo> moduloList) {
        List<TitleMenu> moduloMenus = new ArrayList<>();
        for (Modulo modulo: moduloList
                ) {
            TitleMenu moduloMenu = new TitleMenu(modulo.getNombreModulo(),modulo.getOpcionModuloList());
            moduloMenus.add(moduloMenu);
        }
        return moduloMenus;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        Log.d(TAG,"option"+id);
        Log.d(TAG,"r"+R.id.action_cerrar);
        if (id == android.R.id.home) {
            drawerLayout.openDrawer(GravityCompat.START);
            return true;
        }else {
            Log.d(TAG,"optioentrn"+id);
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(R.string.message_confirm_logout);
            builder.setPositiveButton(R.string.salir, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    finish();
                    SharedPrefManager.getInstance(getApplicationContext()).logout();

                }});
            builder.setNegativeButton(R.string.cancelar, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });
            AlertDialog dialog = builder.create();
            dialog.show();

        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onChildClick(int position, OpcionModulo option) {
        Log.d(TAG, "position" +position);
        drawerLayout.closeDrawers();
        Bundle bundle=new Bundle();
        bundle.putString("codOpcion",option.getCodOpcion());
        Constant.codOpcion=option.getCodOpcion();
        Constant.codPerfil=data.getUsuario().getCodPerfil();
        Constant.codUsuario=data.getUsuario().getCodUsuario();
        bundle.putParcelable("data", data);
        switch (option.getEstadoOpcion()) {

            case "orderRequest":
                OrderRequestFragment orderRequestFragment = new OrderRequestFragment();
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frame, orderRequestFragment, "orderRequestFragment")
                        .addToBackStack("orderRequestFragment")
                        .commit();
                setTitle(option.getNombreOpcion());
                break;
            case "queryTracking":
                QueryTrackingFragment queryTrackingFragment = new QueryTrackingFragment();
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frame, queryTrackingFragment, "querTrackingFragment")
                        .addToBackStack("querTrackingFragment")
                        .commit();
                setTitle(option.getNombreOpcion());
                break;
            case "commercialTray":

                ValuePlusTrayFragment valuePlusTrayFragment = new ValuePlusTrayFragment();
                valuePlusTrayFragment.setArguments(bundle);
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frame, valuePlusTrayFragment, "valuePlusTrayFragment")
                        .addToBackStack("valuePlusTrayFragment")
                        .commit();
                setTitle(option.getNombreOpcion());
                /*FragmentTransaction fragmentTransaction2 = getFragmentManager().beginTransaction();
                fragmentTransaction2.replace(R.id.frame, valuePlusTrayFragment, "valuePlusTrayFragment").commit();*/
                break;
            case "historicaQuery":

                ValuePlusTrayFragment historicaQuery = new ValuePlusTrayFragment();

                historicaQuery.setArguments(bundle);
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frame, historicaQuery, "valuePlusTrayFragment")
                        .addToBackStack("valuePlusTrayFragment")
                        .commit();
                setTitle(option.getNombreOpcion());
                break;
        }

    }

    private void setToolbar() {
        // Añadir la Toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    @Override
    public void setTitle(CharSequence title) {
        getSupportActionBar().setTitle(title);
    }

    @Override
    public void onBackPressed() {

        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            Log.d(TAG, "onBackPressed1: "+getFragmentManager().getBackStackEntryCount() );
            getSupportFragmentManager().popBackStack();
        } else {
            Log.d(TAG, "onBackPressed2: "+getFragmentManager().getBackStackEntryCount() );
            //super.onBackPressed();
            System.exit(0);
        }
    }


}
