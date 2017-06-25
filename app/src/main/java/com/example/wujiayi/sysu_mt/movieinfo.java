package com.example.wujiayi.sysu_mt;

/**
 * Created by Wujiayi on 2017/6/25.
 */

public class movieinfo {
    private String src;
    private String name;
    private String system;
    private String type;
    private String intro;
    private String release;
    private String date;

    public movieinfo(String _src, String _name, String _system, String _type, String _intro,
                     String _release, String _date) {
        src = _src;
        name = _name;
        system = _system;
        type = _type;
        intro = _intro;
        release = _release;
        date = _date;
    }

    public void setSrc(String _src) {
        src = _src;
    }

    public String getSrc() {
        return src;
    }
    public void setName(String _name) {
        name = _name;
    }

    public String getName() {
        return name;
    }

    public void setSystem(String _system) {
        system = _system;
    }

    public String getSystem() {
        return system;
    }

    public void setType(String _type) {
        type = _type;
    }

    public String getType() {
        return type;
    }

    public void setIntro(String _intro) {
        intro = _intro;
    }

    public String getIntro() {
        return intro;
    }

    public void setRelease(String _release) {
        release = _release;
    }

    public String get() {
        return release;
    }

    public void setDate(String _date) {
        date = _date;
    }

    public String getDate() {
        return date;
    }
}
