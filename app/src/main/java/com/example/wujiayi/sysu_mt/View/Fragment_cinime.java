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
import com.example.wujiayi.sysu_mt.Model.CinfoAdapter;
import com.example.wujiayi.sysu_mt.Model.CinemaData;
import com.example.wujiayi.sysu_mt.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

/**
 * Created by wujiayi on 17/5/23.
 */
public class Fragment_cinime extends ListFragment

{

    private List<CinemaData> acinemaList;
    private CinfoAdapter adapter;
    private int flag = 0;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle
        savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item2, null);
        if(flag == 0) {
            try {
                getCinemaList(this.getContext());
                flag = 1;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return view;
    }

    public void getCinemaList(final Context context) throws Exception {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    URL url = new URL(User.getInstance().IP + "cinemalist");
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
                        String name = jsonobj.getString("name"), address = jsonobj.getString("address"),
                                city = jsonobj.getString("city"), moviename = jsonobj.getString("moviename");
                        CinemaData cinemaData = new CinemaData(name, address, city, moviename);
                        acinemaList.add(cinemaData);
                        Log.e("sbwujiayi", name+address+city+moviename);
                    }
                    adapter = new CinfoAdapter(context, acinemaList);
                    setListAdapter(adapter);
                } catch (Exception e) {
                    Log.e("sbwujiayi","是真的有毒");
                    e.printStackTrace();
                }
            }
        }).start();
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        Bundle bundle = new Bundle();
        bundle.putString("name", adapter.getName(position));
        bundle.putString("location", adapter.getLocation(position));
        Intent intent = new Intent(getActivity(), CinemaActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);

    }

}
