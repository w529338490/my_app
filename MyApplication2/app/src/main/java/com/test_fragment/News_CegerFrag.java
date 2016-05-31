package com.test_fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.com.adapter.listviewadaper;
import com.com.utils.Com_http;
import com.example.administrator.myapplication.R;

/**
 * Created by Administrator on 2016/5/30.
 */
public class News_CegerFrag extends Fragment{

    Context context;
    ListView list_iem;
    com.com.adapter.listviewadaper listviewadaper;
    Com_http con_http;
    String tittle;

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_news_categer, null);
        list_iem = (ListView) view.findViewById(R.id.list_items);
        lodingIamg();

        return view;
    }
    private void lodingIamg() {
        con_http= new Com_http(context,list_iem,listviewadaper,tittle);
    }

    public void setContext(Context context) {
        this.context = context;
    }
}
