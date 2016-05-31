package com.my.api;

import java.util.Map;

import com.my.bean.ListBean;
import com.my.bean.NewsBean;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.QueryMap;
import rx.Subscriber;

public interface NewsApi {
	
	@GET("/news/get")
	Call<NewsBean> GetNews(@QueryMap () Map<String ,String> map);
	@GET("/news/get")
	Subscriber<NewsBean>GetNews2(@QueryMap () Map<String ,String> map);

}
