package com.example.cinema2;

import com.google.gson.Gson;

public class ParaInfo implements IColor {
    public int id;
    public String predmet = "";
    public String cab = "";
    public String prepod = "";
    public String typels = "";
    public String color = "";
    public String starttime = "";
    public String endtime = "";

    public ParaInfo() {

    }

    public static ParaInfo load(String json) {
        return new Gson().fromJson(json, ParaInfo.class);
    }

    public String save() {
        return new Gson().toJson(this);
    }

    @Override
    public void setid(int id) {
        this.id=id;
    }

    @Override
    public void setcolor(String color) {
        this.color =color;
    }
}
