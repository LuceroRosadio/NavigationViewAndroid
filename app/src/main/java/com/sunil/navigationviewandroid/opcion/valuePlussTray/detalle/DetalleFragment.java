package com.sunil.navigationviewandroid.opcion.valuePlussTray.detalle;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sunil.navigationviewandroid.R;
import com.sunil.navigationviewandroid.opcion.valuePlussTray.detalle.fragment.BitacoraTabFragment;
import com.sunil.navigationviewandroid.opcion.valuePlussTray.detalle.fragment.DetalleTabFragment;
import com.sunil.navigationviewandroid.opcion.valuePlussTray.detalle.fragment.UbicacionTabFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetalleFragment extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public DetalleFragment(FragmentManager fm, int NumOfTabs) {
        // Required empty public constructor
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                DetalleTabFragment detalleTabFragment = new DetalleTabFragment();
                return detalleTabFragment;
            case 1:
                UbicacionTabFragment ubicacionTabFragment = new UbicacionTabFragment();
                return ubicacionTabFragment;
            case 2:
                BitacoraTabFragment bitacoraTabFragment = new BitacoraTabFragment();
                return bitacoraTabFragment;

        }
        return null;
    }
}
