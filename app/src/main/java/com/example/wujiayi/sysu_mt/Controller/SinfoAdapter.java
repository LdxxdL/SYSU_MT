package com.example.wujiayi.sysu_mt.Controller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.wujiayi.sysu_mt.Model.SessionData;
import com.example.wujiayi.sysu_mt.R;

import java.util.List;

/**
 * Created by Liudx on 2017/6/30.
 */

public class SinfoAdapter extends BaseAdapter {

    private List<SessionData> sessionDatas;
    private Context context;

    public SinfoAdapter(Context _context, List<SessionData> _sessionDatas) {
        context = _context;
        sessionDatas = _sessionDatas;
    }

    @Override
    public int getCount() {
        if (sessionDatas == null)
            return 0;
        return sessionDatas.size();
    }

    @Override
    public Object getItem(int i) {
        if (sessionDatas == null)
            return 0;
        return sessionDatas.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        View sessionView;
        ViewHolder viewHolder;

        if (view == null) {
            sessionView = LayoutInflater.from(context).inflate(R.layout.item_seesion, null);
            viewHolder = new ViewHolder();
            viewHolder.SessionTime = (TextView) sessionView.findViewById(R.id.SessionTime);
            viewHolder.SessionRoom = (TextView) sessionView.findViewById(R.id.SessionRoom);
            viewHolder.SessionPrice = (TextView) sessionView.findViewById(R.id.SessionPrice);
            sessionView.setTag(viewHolder);
        } else {
            sessionView = view;
            viewHolder = (ViewHolder) sessionView.getTag();
        }

        viewHolder.SessionTime.setText(sessionDatas.get(i).time);
        viewHolder.SessionRoom.setText(sessionDatas.get(i).room);
        viewHolder.SessionPrice.setText(sessionDatas.get(i).price);

        return sessionView;
    }

    private class ViewHolder {
        public TextView SessionTime;
        public TextView SessionRoom;
        public TextView SessionPrice;
    }
}
