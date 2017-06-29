package com.example.wujiayi.sysu_mt.Model;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.wujiayi.sysu_mt.R;

import java.util.List;

/**
 * Created by Wujiayi on 2017/6/25.
 */

public class minfoAdapter extends BaseAdapter{

    private List<MovieData> movieData;//定义数据。
    private Context context;//定义Inflater,加载我们自定义的布局。

    public minfoAdapter(Context _context, List<MovieData> _data) {
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
        View movieView;
        ViewHolder viewHolder;

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

        int j = movieData.get(i).getSrc();

        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), movieData.get(i).getSrc());

        viewHolder.MovieImage.setImageBitmap(bitmap);
        viewHolder.MovieName.setText(movieData.get(i).getName());
        viewHolder.MovieType.setText(movieData.get(i).getType());
        viewHolder.MovieScore.setText(movieData.get(i).getScore());

        return movieView;
    }

    private class ViewHolder {
        public ImageView MovieImage;
        public TextView MovieName;
        public TextView MovieType;
        public TextView MovieScore;
    }


}

