package com.sunil.amcor.opcion.createOrder;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sunil.amcor.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ContainerFragment extends Fragment {


    public ContainerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_container, container, false);

        CreateOrderFragment createOrderFragment = new CreateOrderFragment();
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.frameContainer, createOrderFragment)
                //.addToBackStack(null)
                .commit();

        //manager.executePendingTransactions();

        return view;
    }

}
