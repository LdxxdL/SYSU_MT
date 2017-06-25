package com.example.wujiayi.sysu_mt;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by Wujiayi on 2017/6/25.
 */

public class minfoAdapter extends BaseAdapter{

    private List<movieinfo> mData;//定义数据。
    private LayoutInflater mInflater;//定义Inflater,加载我们自定义的布局。

    public minfoAdapter(LayoutInflater inflater, List<movieinfo> data) {
        mData = data;
        mInflater = inflater;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View minfoView = mInflater.inflate(R.layout.movie_view, null);
        movieinfo movieInfo = mData.get(i);
        return null;
    }
}

