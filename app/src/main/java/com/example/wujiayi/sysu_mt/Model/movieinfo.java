package com.example.wujiayi.sysu_mt.Model;

/**
 * Created by Wujiayi on 2017/6/25.
 */

public class movieinfo {
    private int src;
    private String name;
    private String type;
    private String score;

    public movieinfo(int _src, String _name, String _type, String _score) {
        this.src = _src;
        this.name = _name;
        this.type = _type;
        this.score = _score;
    }

    public void setSrc(int _src) {
        this.src = _src;
    }
    public int getSrc() {
        return src;
    }
    public void setName(String _name) {
        this.name = _name;
    }
    public String getName() {
        return name;
    }
    public void setType(String _type) {
        this.type = _type;
    }
    public String getType() {
        return type;
    }
    public void setScore(String _score) {
        this.score = _score;
    }
    public String getScore() {
        return score;
    }
}
