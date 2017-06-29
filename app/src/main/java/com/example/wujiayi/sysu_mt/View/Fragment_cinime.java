package com.example.wujiayi.sysu_mt.View;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wujiayi.sysu_mt.Model.CinfoAdapter;
import com.example.wujiayi.sysu_mt.Model.CinimeInfo;
import com.example.wujiayi.sysu_mt.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wujiayi on 17/5/23.
 */
public class Fragment_cinime extends ListFragment

    {

        private List<CinimeInfo> cinimeData;
        private CinfoAdapter adapter;

        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            cinimeData = new ArrayList<>();

            for (int i = 0; i < 10; i++) {
                CinimeInfo cinime = new CinimeInfo("123","123");
                cinimeData.add(cinime);
            }

            adapter = new CinfoAdapter(this.getContext(), cinimeData);

        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle
        savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item2, null);

            this.setListAdapter(adapter);

        return view;
    }

    }
