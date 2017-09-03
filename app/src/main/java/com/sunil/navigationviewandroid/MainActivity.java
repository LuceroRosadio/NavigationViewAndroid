package com.sunil.navigationviewandroid;

import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.sunil.navigationviewandroid.data.Modulo;
import com.sunil.navigationviewandroid.data.OpcionModulo;
import com.sunil.navigationviewandroid.data.UserResponse;
import com.sunil.navigationviewandroid.fragment.OrderRequestFragment;
import com.sunil.navigationviewandroid.fragment.QueryTrackingFragment;
import com.sunil.navigationviewandroid.opcion.valuePlussTray.ValuePlusTrayFragment;

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

    TextView usuario;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        UserResponse data = getIntent().getExtras().getParcelable("data");
        Log.d(TAG, "data:" +data);
        Log.d(TAG, "usuario: " +data.getUsuario());
        ButterKnife.bind(this);

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

        //fragment = new TitleFragment();
        /*getSupportFragmentManager().beginTransaction()
                .replace(R.id.frame, fragment, "TitleFragment")
                //.add(R.id.frame, fragment)
                .commit();*/
        //FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        //fragmentTransaction.replace(R.id.frame, fragment, "TitleFragment").commit();
    }

    /*private List<TitleMenu> getList() {
        List<TitleMenu> list = new ArrayList<>();
        for (int i = 0; i < names.length; i++) {
            List<SubTitle> subTitles = new ArrayList<>();
            for (int j = 0; j < subNames.length; j++) {
                SubTitle subTitle = new SubTitle(subNames[j]);
                subTitles.add(subTitle);
            }
            TitleMenu model = new TitleMenu(names[i], subTitles, null);
            list.add(model);
        }
        return list;
    }*/

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
        if (id == android.R.id.home) {
            drawerLayout.openDrawer(GravityCompat.START);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onChildClick(int position, OpcionModulo option) {
        Log.d(TAG, "position" +position);
        //Log.d(TAG, "opcion" +opcion);
        //String name = subNames[position];
        drawerLayout.closeDrawers();
        //fragment.setTitle(name);
        /*QueryTrackingFragment queryTrackingFragment = new QueryTrackingFragment();
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame, queryTrackingFragment)
                .commit();*/

        switch (option.getEstadoOpcion()) {
            case "orderRequest":
                OrderRequestFragment orderRequestFragment = new OrderRequestFragment();
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frame, orderRequestFragment, "orderRequestFragment")
                        .addToBackStack("orderRequestFragment")
                        .commit();
                setTitle(option.getNombreOpcion());
                /*FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frame, orderRequestFragment, "orderRequestFragment")
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                        .commit();*/
                break;
            case "queryTracking":
                QueryTrackingFragment queryTrackingFragment = new QueryTrackingFragment();
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frame, queryTrackingFragment, "querTrackingFragment")
                        .addToBackStack("querTrackingFragment")
                        .commit();
                setTitle(option.getNombreOpcion());
                /*FragmentTransaction fragmentTransaction1 = getFragmentManager().beginTransaction();
                fragmentTransaction1.replace(R.id.frame, queryTrackingFragment, "querTrackingFragment").commit();*/
                break;
            case "valuePlussTray":
                ValuePlusTrayFragment valuePlusTrayFragment = new ValuePlusTrayFragment();
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frame, valuePlusTrayFragment, "valuePlusTrayFragment")
                        .addToBackStack("valuePlusTrayFragment")
                        .commit();
                setTitle(option.getNombreOpcion());
                /*FragmentTransaction fragmentTransaction2 = getFragmentManager().beginTransaction();
                fragmentTransaction2.replace(R.id.frame, valuePlusTrayFragment, "valuePlusTrayFragment").commit();*/
                break;
        }

    }

    private void setToolbar() {
        // Añadir la Toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
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

    /*boolean doubleBackPressed = false;
    public void onBackPressed(){
        Log.d(TAG, "onBackPressed" );
        //finish();
        //System.exit(0);
        if (doubleBackPressed) {
            super.onBackPressed();
        } else {
            doubleBackPressed = true;
            final FrameLayout frameLayout = (FrameLayout)findViewById(R.id.frame);

            Snackbar.make(frameLayout, "Presione de nuevo para salir.", Snackbar.LENGTH_SHORT).show();
            new android.os.Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    doubleBackPressed = false;
                }
            }, 2000);
        }
        /*getSupportFragmentManager().addOnBackStackChangedListener(
                new FragmentManager.OnBackStackChangedListener() {
                    public void onBackStackChanged() {
                        Log.d(TAG, "sali" );
                        // Update your UI here.

                        //Toast.makeText(getApplicationContext(), "BotonBack", Toast.LENGTH_SHORT).show();
                    }
                });
    }*/
}
