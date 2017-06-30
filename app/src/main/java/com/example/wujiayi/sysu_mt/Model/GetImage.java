package com.example.wujiayi.sysu_mt.Model;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Message;
import android.view.View;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import static android.R.attr.handle;

/**
 * Created by Wujiayi on 2017/6/30.
 */

public class GetImage {
  public String url;

//    public void getImage() {
//            //新建线程加载图片信息，发送到消息队列中
//            new Thread(new Runnable() {
//
//                @Override
//                public void run() {
//                    // TODO Auto-generated method stub
//                    Bitmap bmp = getURLimage(url);
//                    Message msg = new Message();
//                    msg.what = 0;
//                    msg.obj = bmp;
//                    System.out.println("000");
//                //    handle.sendMess0 k00age(msg);
//                }
//            }).start();
//        }
//}

    //加载图片
    public Bitmap getURLimage() {
        Bitmap bmp = null;
        try {
            URL myurl = new URL(url);
            // 获得连接
            HttpURLConnection conn = (HttpURLConnection) myurl.openConnection();
            conn.setConnectTimeout(6000);//设置超时
            conn.setDoInput(true);
            conn.setUseCaches(false);//不缓存
            conn.connect();
            InputStream is = conn.getInputStream();//获得图片的数据流
            bmp = BitmapFactory.decodeStream(is);
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bmp;
    }
}
