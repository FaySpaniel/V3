package com.example.cinema2;

import com.google.gson.Gson;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskInfo implements IColor {
    public int id ;
    public String nameTask = "";
    public String predmet = "";
    public String endDate = "";
    public String color = "";
    public String note = "";
    public Boolean done = false;

    public static TaskInfo load(String json) {
        return new Gson().fromJson(json, TaskInfo.class);
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
        this.color = color;
    }
}
