package com.example.administrator.festivalmessage.Bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/6/21 0021.
 */
public class FestivalLab
{
    private static FestivalLab mInstance;
    private List<Festival> festivals = new ArrayList<Festival>();
    private List<Msg> messagelist = new ArrayList<Msg>();

    private FestivalLab()
    {
        festivals.add(new Festival(1, "儿童节"));
        festivals.add(new Festival(1, "父亲节"));
        festivals.add(new Festival(1, "母亲节"));
        festivals.add(new Festival(1, "劳动节"));
        festivals.add(new Festival(1, "建军节"));
        festivals.add(new Festival(1, "春节"));
        festivals.add(new Festival(1, "端午节"));

        messagelist.add(new Msg(1, 1, "儿童节快乐"));
        messagelist.add(new Msg(2, 1, "父亲节快乐"));
        messagelist.add(new Msg(3, 1, "母亲节快乐"));
        messagelist.add(new Msg(4, 1, "劳动节快乐"));
        messagelist.add(new Msg(5, 1, "建军节快乐"));
        messagelist.add(new Msg(6, 1, "春节快乐"));
        messagelist.add(new Msg(7, 1, "端午节快乐"));
    }

    public List<Msg> getMsgByFestivalid(int msgid)
    {
        ArrayList<Msg> theList = new ArrayList<Msg>();
        for(Msg msg: messagelist)
        {
            if(msg.getFestivalid() == msgid)
            {
                theList.add(msg);
            }
        }

        return theList;
    }

    public Msg getMsgByMsgid(int id)
    {
        for(Msg msg: messagelist)
        {
            if(msg.getId() == id)
            {
                return msg;
            }
        }

        return null;
    }

    public List<Festival> getFestivals()
    {
        return new ArrayList<Festival>(festivals);
    }

    public Festival getFestivalByid(int fesid)
    {
        for(Festival festival: festivals)
        {
            if(festivals.get(fesid) == festival)
            {
                return festival;
            }
        }
        return null;
    }

    public static FestivalLab getInstance()
    {
        if(mInstance == null)
        {
            synchronized(FestivalLab.class)
            {
                if(mInstance == null)
                {
                    mInstance = new FestivalLab();
                }
            }
        }
        return mInstance;
    }
}
