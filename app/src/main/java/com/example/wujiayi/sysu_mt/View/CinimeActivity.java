package com.example.wujiayi.sysu_mt.View;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.example.wujiayi.sysu_mt.Model.RecyclerAdapter;
import com.example.wujiayi.sysu_mt.Model.SessionData;
import com.example.wujiayi.sysu_mt.Model.SinfoAdapter;
import com.example.wujiayi.sysu_mt.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Liudx on 2017/6/30.
 */

public class CinimeActivity extends Activity {

    private RecyclerView recyclerView;
    private RecyclerAdapter recyclerAdapter;
    private List<Integer> Imageid;
    private List<String> ImageName;
    private ListView sessionView;
    private SessionData sessionData;
    private List<SessionData> sessionDatas;
    private SinfoAdapter sinfoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cinime_detail);

        Bundle bundle = getIntent().getExtras();
        TextView cinimeName = (TextView) findViewById(R.id.Menu);
        TextView cinimeLocation = (TextView) findViewById(R.id.cinimeDetailLocation);

        cinimeName.setText(bundle.getString("name"));
        cinimeLocation.setText(bundle.getString("location"));

        initDatas();
        recyclerView = (RecyclerView) findViewById(R.id.Recycler);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        recyclerAdapter = new RecyclerAdapter(CinimeActivity.this, Imageid);

        recyclerAdapter.setOnItemClickLitener(new RecyclerAdapter.OnItemClickLitener() {
            @Override
            public void onItemClick(View view, int position) {

                TextView textView = (TextView) findViewById(R.id.selectedMovie);
                textView.setText(ImageName.get(position));

            }
        });

        recyclerView.setAdapter(recyclerAdapter);

        sessionView = (ListView) findViewById(R.id.SessionList);
        sinfoAdapter = new SinfoAdapter(CinimeActivity.this, sessionDatas);
        sessionView.setAdapter(sinfoAdapter);

    }

    private void initDatas()
    {
        Imageid = new ArrayList<Integer>(Arrays.asList(R.drawable.a,
                R.drawable.b, R.drawable.c, R.drawable.d, R.drawable.e,
                R.drawable.f, R.drawable.g));

        ImageName = new ArrayList<String>(Arrays.asList("爱乐之城", "变形金刚5：最后的骑士",
                "刺客信条", "加勒比海盗5：死无对证", "金刚狼3：殊死一战","惊天魔盗团2", "银河护卫队2"));

        sessionDatas = new ArrayList<>();
        sessionData = new SessionData("10:25", "5号厅", "38");
        sessionDatas.add(sessionData);
        sessionData = new SessionData("12:15", "8号厅", "38");
        sessionDatas.add(sessionData);
        sessionData = new SessionData("13:55", "2号厅", "38");
        sessionDatas.add(sessionData);
        sessionData = new SessionData("15:55", "4号厅", "38");
        sessionDatas.add(sessionData);
        sessionData = new SessionData("17:35", "1号厅", "38");
        sessionDatas.add(sessionData);
        sessionData = new SessionData("19:30", "7号厅", "38");
        sessionDatas.add(sessionData);
        sessionData = new SessionData("21:30", "6号厅", "38");
        sessionDatas.add(sessionData);
        sessionData = new SessionData("22:55", "6号厅", "38");
        sessionDatas.add(sessionData);
    }

}
