package com.com.utils;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.api.getinfo;
import com.com.adapter.listviewadaper;
import com.enity.beaninfo_a;
import com.example.administrator.myapplication.WebviewsActivity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2016/5/30.
 */
public class Com_http {
    Context context;
    String tittle;
    String s_url;
    ListView list_iem;
    listviewadaper listviewadaper;
    private List<beaninfo_a.ResultBean.ListBean> listdata;

    public Com_http(Context context, ListView list_iem, com.com.adapter.listviewadaper listviewadaper, String tittle) {
        this.context = context;
        this.list_iem = list_iem;
        this.listviewadaper = listviewadaper;
        this.tittle = tittle;
        lodingIamg();

    }
    public void lodingIamg() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.jisuapi.com")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        Map<String, String> filters = new HashMap<String, String>();
        filters.put("channel", tittle);
        filters.put("num", "40");
        filters.put("appkey", "f629d622be49f5b6");

        getinfo g = retrofit.create(getinfo.class);
        g.getimg(filters)
                .subscribeOn(Schedulers.io())
                .doOnNext(new Action1<beaninfo_a>() {
                    @Override
                    public void call(beaninfo_a beaninfo_a) {
                        s_url = beaninfo_a.getResult().getList().get(2).getPic();
                        listviewadaper = new listviewadaper(context, beaninfo_a.getResult().getList());

                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<beaninfo_a>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(context, e.toString(), Toast.LENGTH_LONG).show();

                    }
                    @Override
                    public void onNext(beaninfo_a beaninfo) {

                        DolistView( beaninfo);
                    }
                });
    }
    private void DolistView(final beaninfo_a beaninfo) {
        if (listviewadaper != null) {
            list_iem.setAdapter(listviewadaper);
            list_iem.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                  //  WebviewsActivity
                     String url= beaninfo.getResult().getList().get(position).getUrl();
                    Intent intent=new Intent(context,WebviewsActivity.class);
                    intent.putExtra("url",url);
                    context.startActivity(intent);
                }
            });
        } else {
            System.out.print("EROR" );
        }
    }

}
