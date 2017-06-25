package com.example.wujiayi.sysu_mt;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;




/**
 * Created by wujiayi on 17/5/23.
 */
public class Fragment_movie extends Fragment

{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle
            savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item1, null);

        return view;
    }

}

