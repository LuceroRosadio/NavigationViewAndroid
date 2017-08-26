package com.sunil.navigationviewandroid;

import com.sunil.navigationviewandroid.data.OpcionModulo;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

/**
 * Created by sunil on 12/23/16.
 */

public class TitleMenu extends ExpandableGroup<OpcionModulo> {

    //private String imageUrl;

    public TitleMenu(String title, List<OpcionModulo> items) {
        super(title, items);
        //this.imageUrl = imageUrl;
    }

    /*public String getImageUrl() {
        return imageUrl;
    }*/

}

