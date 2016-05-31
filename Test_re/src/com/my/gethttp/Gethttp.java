package com.my.gethttp;
import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.util.EntityUtils;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;


public class Gethttp{
	Handler responseDataHandler;
	String tittle;
	public Gethttp(Handler responseDataHandler, String tittle) {
		super();
		this.responseDataHandler = responseDataHandler;
		this.tittle = tittle;
	}
		
	public  void startnet() throws ClientProtocolException, IOException {

		HttpGet htget = new HttpGet(
				"http://api.jisuapi.com/news/get?channel="+tittle+"&num=40&appkey=f629d622be49f5b6");
		// http://api.jisuapi.com/news/get?channel=头条&num=10&appkey=f629d622be49f5b6
		// 4.创建执行请求的HttpClient对象，并设置基本的参数(超时时间)
		HttpClient client = new DefaultHttpClient();
		// 设置请求参数
		// 请求超时时间
		client.getParams().setIntParameter(
				HttpConnectionParams.CONNECTION_TIMEOUT, 5000);
		// 5.执行请求,并得到响应结果
		HttpResponse response = client.execute(htget);
		if (response != null
				&& response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {

			// 从响应结果中获取响应数据(被封装成HttpEntity对象)
			HttpEntity entity = response.getEntity();

			// 将Entity对象，转换成字节数组
			byte[] resultData = EntityUtils.toByteArray(entity);

			// 封装响应结果
			Bundle bundle = new Bundle();
			bundle.putByteArray("result", resultData);
			Message msg = new Message();
			msg.setData(bundle);
			// 发送“响应结果”至主线程
			responseDataHandler.sendMessage(msg);
		}
	}
	
}
