package com.example.administrator.listviewdemo.Utils;

/**
 * Created by Administrator on 2016/6/25 0025.
 */
public class ItemBean
{
    private int imgId;
    private String des;

    public ItemBean(int imgId, String des)
    {
        this.imgId = imgId;
        this.des = des;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public int getImgId() {
        return imgId;
    }

    public String getDes() {
        return des;
    }
}
