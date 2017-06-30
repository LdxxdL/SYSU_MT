package com.example.wujiayi.sysu_mt.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.wujiayi.sysu_mt.Model.MovieData;
import com.example.wujiayi.sysu_mt.Model.minfoAdapter;
import com.example.wujiayi.sysu_mt.R;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by wujiayi on 17/5/23.
 */
public class Fragment_movie extends ListFragment

{

    private List<MovieData> MovieData;
    private minfoAdapter adapter;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MovieData = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            MovieData movie = new MovieData("123","123","123");
            MovieData.add(movie);
        }

        adapter = new minfoAdapter(this.getContext(), MovieData);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle
            savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item1, null);

        this.setListAdapter(adapter);

        return view;
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        Intent intent = new Intent(getActivity(), MovieActivity.class);
        startActivity(intent);

    }
}

