package com.example.wujiayi.sysu_mt.Controller;

import android.location.Location;

/**
 * Created by Wujiayi on 2017/6/28.
 */

public class User {
    public String IP = "http://192.168.157.1:3000/client/";
    public String city;

    private User() {
        city = "广州";
    }

    private static volatile User instance;
    public static User getInstance() {
        if (instance == null) {
            //确保同一时间只有一个线程在执行同步
            synchronized(User.class) {
                if (instance == null) {
                    instance = new User();
                }
            }
        }
        return instance;
    }
}
