package com.example.wujiayi.sysu_mt.Model;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.ImageView;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


/**
 * Created by Wujiayi on 2017/6/30.
 */

public class GetImage {
    public static String url = "http://192.168.237.1:3000/image/a.png";
    public Bitmap temp;


    private Handler mHandler = new Handler(){
        public void handleMessage(android.os.Message msg) {
            super.handleMessage(msg);
            temp = (Bitmap) msg.obj;
        };
    };


    public void showImageByThead(){
        new Thread(){
            public void run() {
                Bitmap bitmap = getBitmapFromUrl();
                Message message = Message.obtain();
                message.obj = bitmap;
                mHandler.sendMessage(message);
            };
        }.start();
    }

    public Bitmap getBitmapFromUrl(){
        Bitmap bitmap;
        InputStream is = null;
        try {
            URL mUrl= new URL(url);
            HttpURLConnection connection = (HttpURLConnection) mUrl.openConnection();
            is = new BufferedInputStream(connection.getInputStream());
            bitmap=BitmapFactory.decodeStream(is);
            connection.disconnect();
            return bitmap;
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            try {
                assert is != null;
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }


}
