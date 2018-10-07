package com.example.administrator.festivalmessage.Bean;

/**
 * Created by Administrator on 2016/6/24 0024.
 */
public class Msg {
    private int id;
    private int festivalid;
    private String message;


    public Msg(int id, int festivalid, String message) {
        this.id = id;
        this.festivalid = festivalid;
        this.message = message;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFestivalid(int festivalid) {
        this.festivalid = festivalid;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getId() {
        return id;
    }

    public int getFestivalid() {
        return festivalid;
    }

    public String getMessage() {
        return message;
    }
}
