package com.example.wujiayi.sysu_mt.Model;

import java.util.List;

/**
 * Created by Wujiayi on 2017/6/28.
 */

public class MovieList {
    public List<MovieData> movieList;

    public MovieData getFirst() {
        return movieList.get(0);
    }
}
