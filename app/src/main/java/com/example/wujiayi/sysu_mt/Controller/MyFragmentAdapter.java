package com.example.wujiayi.sysu_mt.Controller;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wujiayi on 17/5/23.
 */
public class MyFragmentAdapter extends FragmentPagerAdapter

    {

        List<Fragment> list;
        private FragmentManager fm;


        public MyFragmentAdapter(FragmentManager fm,List<Fragment> list) {
        super(fm);
        this.fm = fm;
        this.list=list;
    }//写构造方法，方便赋值调用

        @Override
        public Fragment getItem(int arg0) {
        return list.get(arg0);
    }
    //根据Item的位置返回对应位置的Fragment，绑定item和Fragment

        @Override
        public int getCount() {
        return list.size();
    }//设置Item的数量
        public void setFragments(ArrayList list) {
            if(this.list != null){
                FragmentTransaction ft = fm.beginTransaction();
                for(Fragment f:this.list){
                    ft.remove(f);
                }
                ft.commit();
                ft=null;
                fm.executePendingTransactions();
            }
            this.list = list;
            notifyDataSetChanged();
        }
//
//        @Override
//        public int getItemPosition(Object object) {
//            return POSITION_NONE;
//        }
    }


