package com.amcor.opcion.reporteGerencialTonelada;


import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;

import com.amcor.R;
import com.amcor.data.EjecutivoComercial;
import com.amcor.data.UserResponse;
import com.amcor.opcion.reporteGerencialTonelada.model.ReportePedido;
import com.amcor.opcion.reporteGerencialTonelada.model.ReportePedidoResponse;
import com.amcor.opcion.reporteGerencialVenta.ReporteGerencialVentaInterceptor;
import com.amcor.opcion.reporteGerencialVenta.model.ReporteCliente;
import com.amcor.opcion.reporteGerencialVenta.model.ReporteClienteResponse;
import com.amcor.opcion.valuePlussTray.api.RestPedido;
import com.amcor.opcion.valuePlussTray.model.Pedido;
import com.amcor.util.Constant;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 */
public class ReporteGerencialToneladaFragment extends Fragment implements DatePickerDialog.OnDateSetListener{

    private static final String TAG = "RGTFragment";

    private RecyclerView recyclerViewValuePlus;
    PieChart pieChart;
    private List<Pedido> pedidos = new ArrayList<>();
    private ImageButton fchInicio;
    private ImageButton fchFin;
    private EditText edTextFchInicio;
    private EditText edTextFchFin;
    private ImageButton btnGenRGV;
    UserResponse userData;
    String codOpcion;
    public ReporteGerencialToneladaFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.d(TAG, "ReporteGerencialToneladaFragment");
        Bundle bundle = getArguments();
        Log.d(TAG, "bundle: "+bundle);
        userData = bundle.getParcelable("data");
        codOpcion=bundle.getString("codOpcion");
        View view = inflater.inflate(R.layout.fragment_reporte_gerencial_tonelada, container, false);
        pieChart = (PieChart) view.findViewById(R.id.piechartPedido);
        fchInicio = (ImageButton)  view.findViewById(R.id.fchInicio);
        fchFin = (ImageButton) view.findViewById(R.id.fchFin);
        edTextFchInicio = (EditText)  view.findViewById(R.id.fechaInicio);
        edTextFchInicio.setEnabled(false);
        edTextFchFin = (EditText) view.findViewById(R.id.fechaFin);
        edTextFchFin.setEnabled(false);
        btnGenRGV = (ImageButton) view.findViewById(R.id.btnGenRGV);
        btnGenRGV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadJsonPedidos();
            }
        });
        fchInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar now = Calendar.getInstance();
                DatePickerDialog dpd = DatePickerDialog.newInstance(
                        ReporteGerencialToneladaFragment.this,
                        now.get(Calendar.YEAR),
                        now.get(Calendar.MONTH),
                        now.get(Calendar.DAY_OF_MONTH)
                );
                dpd.show(getActivity().getFragmentManager(), "FechaInicio");
            }
        });

        fchFin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar now = Calendar.getInstance();
                DatePickerDialog dpd = DatePickerDialog.newInstance(
                        ReporteGerencialToneladaFragment.this,
                        now.get(Calendar.YEAR),
                        now.get(Calendar.MONTH),
                        now.get(Calendar.DAY_OF_MONTH)
                );
                dpd.show(getActivity().getFragmentManager(), "FechaFin");

            }
        });
        pieChart.setUsePercentValues(true);
        pieChart.setNoDataText("No hay información disponible");
        pieChart.setDescription(null);
        //loadJsonPedidos();
        return view;

    }

    private void loadJsonPedidos() {
        Log.d(TAG, "loadJsonPedidos");
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new ReporteGerencialToneladaInterceptor(getContext()))
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .build();

        Map<String, String> data = new HashMap<>();
        if(edTextFchInicio.getText()!=null)
            data.put("fechaInicio", edTextFchInicio.getText().toString());
        if(edTextFchFin.getText()!=null)
            data.put("fechaFin",  edTextFchFin.getText().toString());
        RestPedido restPedido = retrofit.create(RestPedido.class);
        Call<ReportePedidoResponse> call = restPedido.reportePedido(data);

        Log.d(TAG, "userDAta"+userData);
        Log.d(TAG, "data:"+data);
        final ProgressDialog progressDialog = new ProgressDialog(getContext(),
                R.style.AppTheme_Dark_Dialog);
        progressDialog.setMessage("Cargando...");
        progressDialog.setCancelable(false);
        progressDialog.show();
        call.enqueue(new Callback<ReportePedidoResponse>() {
            @Override
            public void onResponse(Call<ReportePedidoResponse> call, Response<ReportePedidoResponse> response) {
                Log.d(TAG, response.code() +"");
                switch (response.code()) {
                    case 200:
                        progressDialog.dismiss();
                        ReportePedidoResponse data = response.body();
                        Log.d(TAG, data.toString());
                        List<ReportePedido>  reportePedidoList= data.getReportePedidoList();
                        loadPieChart(reportePedidoList);
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
            public void onFailure(Call<ReportePedidoResponse> call, Throwable t) {

            }
        });
    }
    private void loadPieChart(List<ReportePedido> reportePedidoList){
        ArrayList<Entry> yvalues = new ArrayList<Entry>();
        ArrayList<String> xVals = new ArrayList<String>();
        int i=0;
        for (ReportePedido reportePedido : reportePedidoList) {
            yvalues.add(new Entry(reportePedido.getToneladas().floatValue(),i++));
            xVals.add(reportePedido.getClaseEstructurada());
        }
        PieDataSet dataSet = new PieDataSet(yvalues, "Clase Estructurada");
        dataSet.setValueTextSize(12f);
        PieData data = new PieData(xVals, dataSet);
        data.setValueFormatter(new PercentFormatter());
        dataSet.setColors(ColorTemplate.VORDIPLOM_COLORS);
        data.setValueTextSize(13f);
        data.setValueTextColor(Color.DKGRAY);
        pieChart.setData(data);
        pieChart.setDescription(null);
        pieChart.setDrawHoleEnabled(true);
        pieChart.setTransparentCircleRadius(25f);
        pieChart.setHoleRadius(25f);
        pieChart.animateXY(1400, 1400);

    }
    @Override
    public void onResume() {
        Log.i(TAG,"RECARGANDO");
        //loadJsonPedidos();
        super.onResume();

        // reload your list items if changed and adapter.notifydatastatechange();
    }


    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
        Log.i(TAG,view.getTag());
        if("FechaInicio".equals(view.getTag())){
            edTextFchInicio.setText(dayOfMonth+"/"+(monthOfYear+1)+"/"+year);
        }else{
            edTextFchFin.setText(dayOfMonth+"/"+(monthOfYear+1)+"/"+year);
        }
    }
}
