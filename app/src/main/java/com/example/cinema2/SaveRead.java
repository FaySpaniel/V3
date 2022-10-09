package com.example.cinema2;

import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class SaveRead {
    private static final int DEFAULT_INT = 0;
    private static final String DEFAULT_STRING = "";
    private static final float DEFAULT_FLOAT = -1f;
    private static final boolean DEFAULT_BOOLEAN = false;
    private static final long DEFAULT_LONG = 0;
    private static SharedPreferences sharedPreferences;
    private static SaveRead prefsUtil;

    private SaveRead(@NonNull Context mContext) {
        if (sharedPreferences == null) {
            sharedPreferences = mContext.getApplicationContext().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        }
    }

    public static SaveRead with(@NonNull Context context) {
        if (prefsUtil == null) {
            prefsUtil = new SaveRead(context);
        }
        return prefsUtil;
    }

    public static SaveRead with(@NonNull Fragment fragment) {
        if (prefsUtil == null) {
            prefsUtil = new SaveRead(fragment.requireContext());
        }
        return prefsUtil;
    }

    public boolean hasKey(String key) {
        return sharedPreferences.contains(key);
    }

    public void removeKey(String key) {
        sharedPreferences.edit().remove(key).apply();
    }

    public void write(String name, int number) {
        sharedPreferences.edit().putInt(name, number).apply();
    }

    public void write(String name, String str) {
        sharedPreferences.edit().putString(name, str).apply();
    }

    public void write(String name, float number) {
        sharedPreferences.edit().putFloat(name, number).apply();
    }

    public void write(String name, long number) {
        sharedPreferences.edit().putLong(name, number).apply();
    }

    public void write(String name, boolean bool) {
        sharedPreferences.edit().putBoolean(name, bool).apply();
    }

    public int readInt(String name) {
        return sharedPreferences.getInt(name, DEFAULT_INT);
    }

    public String readString(String name) {
        return sharedPreferences.getString(name, DEFAULT_STRING);
    }

    public float readFloat(String name) {
        return sharedPreferences.getFloat(name, DEFAULT_FLOAT);
    }

    public boolean readBoolean(String name) {
        return sharedPreferences.getBoolean(name, DEFAULT_BOOLEAN);
    }

    public long readLong(String name) {
        return sharedPreferences.getLong(name, DEFAULT_LONG);
    }

    public void clearPrefs() {
        sharedPreferences.edit().clear().apply();
    }
    public void saveJson(String name, JsonObject jo) {
        saveJson(name,jo.toString());
    }
    public void saveJson(String name, String jo) {
        sharedPreferences.edit().putString(name, jo.toString()).apply();
    }
    public JsonObject readJson(String name) {
        return JsonParser.parseString(sharedPreferences.getString(name, DEFAULT_STRING)).getAsJsonObject();
    }
}

