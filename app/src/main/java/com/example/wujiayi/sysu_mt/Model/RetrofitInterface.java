package com.example.wujiayi.sysu_mt.Model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Wujiayi on 2017/6/28.
 */

public interface RetrofitInterface {
    @GET("/movielist")
    Call<List<MovieData>> getMovieList();

    @GET("/movielist/{path}")
    Call<MovieData> getMovie(@Path("path") String path);

    @GET("/cinemalist/{path}")
    Call<CinemaData> getCinema(@Path("path") String path);
}
