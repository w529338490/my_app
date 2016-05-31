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

import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler;
import in.srain.cube.views.ptr.header.MaterialHeader;
import in.srain.cube.views.ptr.header.StoreHouseHeader;

/**
 * Created by Administrator on 2016/5/30.
 */
public class News_CegerFrag extends Fragment{

    Context context;
    ListView list_iem;
    com.com.adapter.listviewadaper listviewadaper;
    Com_http con_http;
    String tittle;
    private PtrFrameLayout ptr;
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

        ptr = (PtrFrameLayout)view.findViewById(R.id.ptr);

        lodingIamg();
        initPtr();
        return view;
    }


    private void lodingIamg() {
        con_http= new Com_http(context,list_iem,listviewadaper,tittle);
    }

    public void setContext(Context context) {
        this.context = context;
    }
    private void initPtr() {

// header
        final MaterialHeader header = new MaterialHeader(context);
        int[] colors = getResources().getIntArray(R.array.google_colors);

        header.setColorSchemeColors(colors);
        header.setLayoutParams(new PtrFrameLayout.LayoutParams(-1, -2));
        header.setPadding(0, DisplayUtil.dip2px(context, 15), 0, DisplayUtil.dip2px(context, 10));
        header.setPtrFrameLayout(ptr);

        // material header是否为覆盖式
        ptr.setPinContent(true);
        ptr.setHeaderView(header);
        ptr.addPtrUIHandler(header);
        ptr.postDelayed(new Runnable()
        {
            @Override
            public void run()
            {


                ptr.autoRefresh(true);
            }
        }, 150);

        ptr.setPtrHandler(new PtrHandler()
        {

            @Override
            public void onRefreshBegin(PtrFrameLayout frame)
            {
                frame.postDelayed(new Runnable()
                {
                    @Override
                    public void run()
                    {


                        ptr.refreshComplete();
                    }
                }, 1800);
            }

            @Override
            public boolean checkCanDoRefresh(PtrFrameLayout frame, View content, View header)
            {
                return PtrDefaultHandler.checkContentCanBePulledDown(frame, content, header);
            }
        });
    }

}
