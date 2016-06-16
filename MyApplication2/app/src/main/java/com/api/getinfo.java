package com.api;

import com.enity.beaninfo;
import com.enity.beaninfo_a;
import com.squareup.okhttp.ResponseBody;

import java.util.Map;

import retrofit.Call;
import retrofit.Response;
import retrofit.http.GET;
import retrofit.http.Header;
import retrofit.http.Path;
import retrofit.http.Query;
import retrofit.http.QueryMap;
import retrofit.http.Url;
import rx.Observable;

/**
 * Created by Administrator on 2016/5/25.
 */
public interface getinfo {

    @GET("/news/get")
    Call<beaninfo_a> getinfo(@QueryMap Map<String, String> filters);

    @GET("/news/get")
    Observable<beaninfo_a> getimg(@QueryMap Map<String, String> filters);


}
