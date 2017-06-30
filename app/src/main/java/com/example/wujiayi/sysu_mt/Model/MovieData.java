package com.example.wujiayi.sysu_mt.Model;

/**
 * Created by Wujiayi on 2017/6/25.
 */

public class MovieData {
    private String name;
    private String type;
    private String score;

    public MovieData(String _name, String _type, String _score) {
        this.name = _name;
        this.type = _type;
        this.score = _score;
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
