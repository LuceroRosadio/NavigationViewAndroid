package com.amcor.fragment;


import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.amcor.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class OrderRequestFragment extends Fragment {


    /*public OrderRequestFragment() {
        // Required empty public constructor
    }*/


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_order_request, container, false);
    }

}
