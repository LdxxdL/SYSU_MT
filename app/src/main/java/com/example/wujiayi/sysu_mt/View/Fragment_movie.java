package com.example.wujiayi.sysu_mt.View;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.wujiayi.sysu_mt.Controller.User;
import com.example.wujiayi.sysu_mt.Model.MovieData;
import com.example.wujiayi.sysu_mt.Model.minfoAdapter;
import com.example.wujiayi.sysu_mt.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;


/**
 * Created by wujiayi on 17/5/23.
 */
public class Fragment_movie extends ListFragment

{
    private int listener = 0;
    private int flag = 0;
    public minfoAdapter adapter;
    public ArrayList<MovieData> amovieList = new ArrayList<>();

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle
            savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item1, null);
        if (flag == 0) {
            try {
                getMovieList(this.getContext());
                flag = 1;
                setListener();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return view;
    }

    private void setListener() {
        listener = 1;
    }
    public int getListener() {
        return listener;
    }

    public void getMovieList(final Context context) throws Exception {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Log.e("sbwujiayi", "!!!!!!!!!!!!!!!!");
                    URL url = new URL(User.getInstance().IP + "movielist");
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    InputStream is = connection.getInputStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(is));
                    String line, json = "";
                    while ((line = reader.readLine()) != null)
                        json += line;
                    is.close();
                    connection.disconnect();

                    JSONArray jsonarray = new JSONArray(json);Log.e("sbwujiayi",json);
                    for (int i = 0; i < jsonarray.length(); i++) {
                        JSONObject jsonobj = jsonarray.getJSONObject(i);
                        String name = jsonobj.getString("name"), src = jsonobj.getString("src"),
                                type = jsonobj.getString("type"), date = jsonobj.getString("date"),
                                score = jsonobj.getString("score"), intro = jsonobj.getString("intro"),
                                actor = jsonobj.getString("actor");
                        MovieData movieData = new MovieData(src, name, type, score, date, intro, actor);
                        amovieList.add(movieData);
                    }
                    adapter = new minfoAdapter(context, amovieList);
                    setListAdapter(adapter);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        Intent intent = new Intent(getActivity(), MovieActivity.class);
        startActivity(intent);

    }
}