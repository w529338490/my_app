package com.enity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/5/27.
 */
public class ListBean {
    /**
     * title : 中国开闸放水27天解救越南旱灾
     * time : 2016-03-16 07:23
     * src : 中国网
     * category : mil
     * pic : http://api.jisuapi.com/news/upload/20160316/105123_31442.jpg
     */
    private String title;
    private String time;
    private String src;
    private String category;
    private String pic;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }
}
