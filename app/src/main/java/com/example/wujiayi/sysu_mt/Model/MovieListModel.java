package com.example.wujiayi.sysu_mt.Model;

import android.app.Activity;
import android.widget.Toast;

import com.example.wujiayi.sysu_mt.Controller.User;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Wujiayi on 2017/6/29.
 */

public class MovieListModel {
    public MovieListModel movieList;
    public Activity activity;

    public void getMovieList() {
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(3, TimeUnit.SECONDS)       //设置连接超时
                .readTimeout(3, TimeUnit.SECONDS)          //设置读超时
                .writeTimeout(3,TimeUnit.SECONDS)          //设置写超时
                .retryOnConnectionFailure(true)             //是否自动重连
                .build();                                   //构建OkHttpClient对象

        Retrofit retrofit= new Retrofit.Builder()
                .baseUrl(User.getInstance().IP)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        RetrofitInterface service = retrofit.create(RetrofitInterface.class);

        Call<MovieList> movieListCall = service.getMovieList();

        movieListCall.enqueue(new Callback<MovieList>() {
            @Override
            public void onResponse(Call<MovieList> call, Response<MovieList> response) {
                Toast.makeText(activity,response.body().getFirst().getName(),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<MovieList> call, Throwable t) {
                Toast.makeText(activity,"出错了傻逼.",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
