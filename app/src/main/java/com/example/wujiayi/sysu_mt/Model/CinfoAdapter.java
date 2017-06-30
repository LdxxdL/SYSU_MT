package com.example.wujiayi.sysu_mt.Model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.wujiayi.sysu_mt.R;

import java.util.List;

/**
 * Created by Liudx on 2017/6/28.
 */

public class CinfoAdapter extends BaseAdapter {

    private List<CinimeData> CinimeData;//定义数据。
    private Context context;

    public CinfoAdapter(Context _context, List<CinimeData> _data) {
        this.CinimeData = _data;
        this.context = _context;
    }

    @Override
    public int getCount() {
        if (CinimeData == null) {
            return 0;
        }
        return CinimeData.size();
    }

    @Override
    public Object getItem(int i) {
        if (CinimeData == null) {
            return 0;
        }
        return CinimeData.get(i);
    }

    public String getName(int i) {
        return CinimeData.get(i).getName();
    }

    public String getLocation(int i) {
        return CinimeData.get(i).getLocation();
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View cinimeView;
        ViewHolder viewHolder;

        if (view == null) {
            cinimeView = LayoutInflater.from(context).inflate(R.layout.item_cinime, null);
            viewHolder = new ViewHolder();
            viewHolder.cinimeName = (TextView) cinimeView.findViewById(R.id.CinimeName);
            viewHolder.cinimeLocation = (TextView) cinimeView.findViewById(R.id.CinimeLocation);
            cinimeView.setTag(viewHolder);
        } else {
            cinimeView = view;
            viewHolder = (ViewHolder) cinimeView.getTag();
        }

        viewHolder.cinimeName.setText(CinimeData.get(i).getName());
        viewHolder.cinimeLocation.setText(CinimeData.get(i).getLocation());

        return cinimeView;
    }

    private class ViewHolder {
        public TextView cinimeName;
        public TextView cinimeLocation;
    }

}
