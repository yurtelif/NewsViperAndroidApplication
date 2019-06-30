package com.yrtelf.newsviper.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.yrtelf.newsviper.model.News;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import static android.content.Context.MODE_PRIVATE;
import static com.yrtelf.newsviper.util.AppKeys.SHARED_PREF_NEWS;

public class NewsSharedPreferences {

    private static NewsSharedPreferences instance;
    private SharedPreferences.Editor editor ;
    private SharedPreferences sharedPreferences;
    private Gson gson = new Gson();

    public synchronized static NewsSharedPreferences getInstance() {
        if (instance == null) {
            instance = new NewsSharedPreferences();
        }
        return instance;
    }

    public NewsSharedPreferences() {
    }

    public void init(Context context){
        sharedPreferences = context.getSharedPreferences(SHARED_PREF_NEWS, MODE_PRIVATE);
    }

    public void setNews(ArrayList<News> newsArrayList){
        String json = gson.toJson(newsArrayList);
        editor = sharedPreferences.edit();
        editor.putString(SHARED_PREF_NEWS,json);
        editor.apply();
    }

    public ArrayList<News> getNews(){
        String json = sharedPreferences.getString(SHARED_PREF_NEWS, null);
        if (TextUtils.isEmpty(json)) {
            return null;
        }
        Type type = new TypeToken<List<News>>() {}.getType();
        ArrayList<News> arrayList = gson.fromJson(json, type);
        return arrayList;
    }


    /*
    public void setExchangeRates(ArrayList<ExchangeRateResource> exchangeRates){
        String json = gson.toJson(exchangeRates);
        SharedPrefDb.putString(KEY_EXCHANGE_RATES,json);
    }
     */

}
