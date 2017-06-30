package com.example.wujiayi.sysu_mt.View;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.wujiayi.sysu_mt.Model.GetImage;
import com.example.wujiayi.sysu_mt.R;

/**
 * Created by Liudx on 2017/6/29.
 */

public class MovieDetailsActivity extends Activity {

    private GetImage Image;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_detail);

        Bundle bundle = getIntent().getExtras();
        TextView name = (TextView) findViewById(R.id.movieDetailName);
        TextView score = (TextView) findViewById(R.id.movieDetailScore);
        TextView type = (TextView) findViewById(R.id.movieDetailType);
        TextView date = (TextView) findViewById(R.id.movieDetailDate);
        TextView intro = (TextView) findViewById(R.id.movieIntroduction);
        TextView actor = (TextView) findViewById(R.id.movieActor);

        name.setText(bundle.getString("name"));
        score.setText("评分：" + bundle.getString("score") + "分");
        type.setText(bundle.getString("type"));
        date.setText(bundle.getString("date"));
        intro.setText(bundle.getString("intro"));
        actor.setText(bundle.getString("actor"));


//
//        Image = new GetImage();
//        imageView = findViewById(R.id.movieDetailImage);
//        Image.showImageByThead();
//        imageView.setImageBitmap(Image.temp);

    }

}
