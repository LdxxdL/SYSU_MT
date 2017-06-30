package com.example.wujiayi.sysu_mt.View;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.wujiayi.sysu_mt.Model.GetImage;
import com.example.wujiayi.sysu_mt.R;

/**
 * Created by Liudx on 2017/6/29.
 */

public class MovieActivity extends Activity {

    private GetImage Image;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_detail);

        Image = new GetImage();
        imageView = findViewById(R.id.movieDetailImage);
        Image.showImageByThead();


        imageView.setImageBitmap(Image.temp);

    }

}
