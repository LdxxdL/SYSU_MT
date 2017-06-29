package com.example.wujiayi.sysu_mt.Model;

/**
 * Created by Liudx on 2017/6/28.
 */

public class CinimeInfo {

    private String name;
    private String location;

    public CinimeInfo(String _name, String _location) {
        this.name = _name;
        this.location = _location;
    }

    public void setName(String _name) {
        this.name = _name;
    }
    public String getName() {
        return this.name;
    }
    public void setLocation(String _location) {
        this.location = _location;
    }
    public String getLocation() {
        return this.location;
    }

}
