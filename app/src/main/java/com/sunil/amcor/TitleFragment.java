package com.sunil.amcor;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.support.v4.app.Fragment;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by sunil on 12/24/16.
 */

public class TitleFragment extends Fragment {

    View rootView;

    @BindView(R.id.title_name)
    TextView titleName;

    @BindView(R.id.main_content)
    LinearLayout mainContent;
    private String TAG = this.getClass().getName();

    @BindView(R.id.carouselView)
    CarouselView carouselView;
    int[] sampleImages = {R.drawable.banner1, R.drawable.banner2, R.drawable.banner3, R.drawable.banner4, R.drawable.banner5};
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_title, container, false);
        ButterKnife.bind(this, rootView);
        carouselView.setPageCount(sampleImages.length);

        carouselView.setImageListener(imageListener);
        return rootView;
    }

    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(sampleImages[position]);
        }
    };

    public void showToolBar(/*String tittle,*/ boolean upButton, View view) {
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        //((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(tittle);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }

    /*public void setTitle(String title) {
        titleName.setText(title);
        if (title.equalsIgnoreCase("google")){
            mainContent.setBackgroundColor(getResources().getColor(R.color.red_icon_color));
        } else if (title.equalsIgnoreCase("Motorola")){
            mainContent.setBackgroundColor(getResources().getColor(R.color.green_icon_color));
        } else if (title.equalsIgnoreCase("Samsung")){
            mainContent.setBackgroundColor(getResources().getColor(R.color.yellow_icon_color));
        } else if (title.equalsIgnoreCase("Lenevo")){
            mainContent.setBackgroundColor(getResources().getColor(R.color.blue_icon_color));
        }

    }*/
}
