package com.example.wujiayi.sysu_mt.View;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.wujiayi.sysu_mt.R;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Liudx on 2017/6/29.
 */

public class MovieDetailsActivity extends Activity {

    private String url = "http://192.168.237.1:3000/image/";
    private Bitmap bitmap;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_detail);

        Bundle bundle = getIntent().getExtras();
        TextView name = (TextView) findViewById(R.id.movieDetailName);
        TextView score = (TextView) findViewById(R.id.movieDetailScore);
        TextView type = (TextView) findViewById(R.id.movieDetailType);
        TextView date = (TextView) findViewById(R.id.movieDetailDate);
        TextView intro = (TextView) findViewById(R.id.movieIntroduction);
        TextView actor = (TextView) findViewById(R.id.movieActor);
        imageView  = findViewById(R.id.movieDetailImage);

        name.setText(bundle.getString("name"));
        score.setText("评分：" + bundle.getString("score") + "分");
        type.setText(bundle.getString("type"));
        date.setText(bundle.getString("date"));
        intro.setText(bundle.getString("intro"));
        actor.setText(bundle.getString("actor"));
        getImage((bundle.getString("src")));



    }
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 1) {
                imageView.setImageBitmap(bitmap);
            }
        }
    };



    public void getImage(final String picName) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    bitmap = null;
                    URL pic_url = new URL(url + picName + ".png");
                    HttpURLConnection connection = (HttpURLConnection) pic_url.openConnection();
                    connection.setDoInput(true);
                    if (connection.getResponseCode() == 200) {
                        InputStream is = connection.getInputStream();
                        bitmap = BitmapFactory.decodeStream(is);
                        is.close();
                        connection.disconnect();
                    }
                    Message msg = new Message();
                    msg.what = 1;
                    handler.sendMessage(msg);

                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
