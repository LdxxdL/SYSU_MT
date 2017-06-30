package com.example.wujiayi.sysu_mt.Controller;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.wujiayi.sysu_mt.Model.MovieData;
import com.example.wujiayi.sysu_mt.R;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;


/**
 * Created by Wujiayi on 2017/6/25.
 */

public class minfoAdapter extends BaseAdapter{

    public ArrayList<MovieData> movieData;//定义数据。
    private Context context;//定义Inflater,加载我们自定义的布局。
    private Bitmap bitmap;
    private View movieView;
    private int flag = 0;
    private String url = "http://192.168.237.1:3000/image/";
    private ViewHolder viewHolder;

    public minfoAdapter(Context _context, ArrayList<MovieData> _data) {
        this.movieData = _data;
        this.context = _context;
    }

    @Override
    public int getCount() {
        if (movieData == null) {
            return 0;
        }
        return movieData.size();
    }

    @Override
    public Object getItem(int i) {
        if (movieData == null) {
            return 0;
        }
        return movieData.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if (view == null) {
            movieView = LayoutInflater.from(context).inflate(R.layout.movie_view, null);
            viewHolder = new ViewHolder();
            viewHolder.MovieImage = (ImageView) movieView.findViewById(R.id.movieImage);
            viewHolder.MovieName = (TextView) movieView.findViewById(R.id.movieName);
            viewHolder.MovieType = (TextView) movieView.findViewById(R.id.movieType);
            viewHolder.MovieScore = (TextView) movieView.findViewById(R.id.movieScore);
            movieView.setTag(viewHolder);
        } else {
            movieView = view;
            viewHolder = (ViewHolder) movieView.getTag();
        }

        viewHolder.MovieName.setText(movieData.get(i).name);
        viewHolder.MovieType.setText(movieData.get(i).type);
        viewHolder.MovieScore.setText(movieData.get(i).score + "分");
        getImage(movieData.get(i).src);
        return movieView;
    }

    public Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {Log.e("sbwujiayi", "getImageOk");
            if (msg.what == 1) {
                viewHolder.MovieImage.setImageBitmap(bitmap);
                msg.what = 0;
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

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private class ViewHolder {
        public ImageView MovieImage;
        public TextView MovieName;
        public TextView MovieType;
        public TextView MovieScore;
    }


}

