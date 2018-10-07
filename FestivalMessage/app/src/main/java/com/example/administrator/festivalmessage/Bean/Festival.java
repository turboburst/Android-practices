package com.example.administrator.festivalmessage.Bean;

import java.util.Date;

/**
 * Created by Administrator on 2016/6/21 0021.
 */
public class Festival
{
    private int festivalID;
    private String festivalName;
    private String festivalDES;
    private Date festivalDate;

    public Festival(int id, String name)
    {
        this.festivalID = id;
        this.festivalName = name;
    }

    public int getFestivalID() {
        return festivalID;
    }

    public String getFestivalName() {
        return festivalName;
    }

    public void setFestivalID(int festivalID) {
        this.festivalID = festivalID;
    }

    public void setFestivalName(String festivalName) {
        this.festivalName = festivalName;
    }
}
