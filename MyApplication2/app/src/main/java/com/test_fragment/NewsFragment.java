package com.test_fragment;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.api.getinfo;
import com.enity.beaninfo;

import com.enity.beaninfo_a;
import com.example.administrator.myapplication.R;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;

import retrofit.Response;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;
import retrofit.http.Url;
import rx.internal.schedulers.NewThreadWorker;

import static retrofit.GsonConverterFactory.*;

/**
 * Created by Administrator on 2016/5/25.
 */
public class NewsFragment  extends Fragment{

    private TextView tv;
    private ImageView img;
    URL myFileURL;
    String s_url;
    private  Bitmap bitmap;
    private Handler han;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_news,null);
        tv= (TextView) view.findViewById(R.id.tv_textjson);
        img= (ImageView) view.findViewById(R.id.img);
        han=new Handler() {
            @Override
            public void close() {

            }

            @Override
            public void flush() {

            }

            @Override
            public void publish(LogRecord record) {

            }
        };
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    getretrofi();
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
        });

       if(bitmap!=null){
           img.setImageBitmap(this.getbimap());
       }else {
           new Thread(){
               @Override
               public void run() {
                   try {
                    setbimap();

                   } catch (MalformedURLException e) {
                       e.printStackTrace();
                   }
               }
           }.start();
       }


        return view;


    }

    public void  getretrofi() throws MalformedURLException {
     Retrofit retrofit = new retrofit.Retrofit.Builder()
                .baseUrl("http://api.jisuapi.com")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        getinfo ginfo=retrofit.create(getinfo.class);
        Map<String, String> filters = new HashMap<String, String>();
        filters.put("channel","头条");
        filters.put("num","1");
        filters.put("appkey","f629d622be49f5b6");

        Call<beaninfo_a> call=ginfo.getinfo(filters);

       call.enqueue(new Callback<beaninfo_a>() {


           @Override
           public void onResponse(Response<beaninfo_a> response, Retrofit retrofit) {
               beaninfo_a b=response.body();
               beaninfo_a.ResultBean.ListBean lb=b.getResult().getList().get(0);

               NewsFragment.this.seturl(lb.getPic());

               tv.setText( s_url);

           }
           @Override
           public void onFailure(Throwable t) {
         System.out.print("============================"+t.getMessage()+"=====================");
           }

       });


    }

    private   void setbimap() throws MalformedURLException {
        myFileURL = new URL(this.geturl());

        HttpURLConnection conn = null;
        if (myFileURL!=null) {
            try {

              //  Toast.makeText(NewsFragment.this.getActivity(),"KKKKK",Toast.LENGTH_LONG).show();
                conn = (HttpURLConnection) myFileURL.openConnection();
                //设置超时时间为6000毫秒，conn.setConnectionTiem(0);表示没有时间限制
                conn.setConnectTimeout(6000);
                //连接设置获得数据流
                conn.setDoInput(true);
                //不使用缓存
                conn.setUseCaches(false);
                //这句可有可无，没有影响
                //conn.connect();
                //得到数据流
                InputStream is = conn.getInputStream();
                //解析得到图片
                 bitmap = BitmapFactory.decodeStream(is);
                //关闭数据流
                this.setbimap(bitmap);
                System.out.print("YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY"+this.getbimap());


                is.close();

            } catch (IOException e) {
                e.printStackTrace();
            }


        }else {
            System.out.print("EEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE");
         //   Toast.makeText(NewsFragment.this.getActivity(),"EEEEE",Toast.LENGTH_LONG).show();
        }

    }

    public void setbimap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public Bitmap getbimap() {
        return bitmap;
    }
    public void seturl(String url) {
        this.s_url = url;
    }

    public String geturl() {
        return s_url;
    }
}
