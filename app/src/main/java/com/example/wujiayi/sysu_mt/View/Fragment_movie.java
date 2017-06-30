package com.example.wujiayi.sysu_mt.View;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.wujiayi.sysu_mt.Controller.User;
import com.example.wujiayi.sysu_mt.Model.MovieData;
import com.example.wujiayi.sysu_mt.Controller.minfoAdapter;
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
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return view;
    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 1) {
                setListAdapter(adapter);
            }
        }
    };

    public void getMovieList(final Context context) throws Exception {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    URL url = new URL(User.getInstance().IP + "movielist");
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    InputStream is = connection.getInputStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(is));
                    String line, json = "";
                    while ((line = reader.readLine()) != null)
                        json += line;
                    is.close();
                    connection.disconnect();

                    JSONArray jsonarray = new JSONArray(json);
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
                    Message msg = new Message();
                    msg.what = 1;
                    handler.sendMessage(msg);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);


        super.onListItemClick(l, v, position, id);

        Bundle bundle = new Bundle();
        bundle.putString("name", adapter.movieData.get(position).name);
        bundle.putString("type", adapter.movieData.get(position).type);
        bundle.putString("date", adapter.movieData.get(position).date);
        bundle.putString("score", adapter.movieData.get(position).score);
        bundle.putString("actor", adapter.movieData.get(position).actor);
        bundle.putString("intro", adapter.movieData.get(position).intro);
        bundle.putString("src", adapter.movieData.get(position).src);
        Intent intent = new Intent(getActivity(), MovieDetailsActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}