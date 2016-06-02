package com.my.gethttp;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.example.test_re.MainActivity;
import com.example.test_re.WebViewsActivity;
import com.my.adapter.ListNews_adapter;
import com.my.bean.ListBean;

public class Dohandler {
	Context context;
	List<ListBean> listBean;
	String rootresult;
	ListNews_adapter adapter;
	ListView listv;
		
	public Dohandler(Context context, List<ListBean> listBean,
			String rootresult, ListNews_adapter adapter,
			ListView listv) {
		super();
		this.context = context;
		this.listBean = listBean;
		this.rootresult = rootresult;
		this.adapter = adapter;
		this.listv = listv;
		Getdata();
		Getadapter(this.getListBean());
	}
	public List<ListBean> Getdata(){		
		try {
			JSONObject resultObj = new JSONObject(rootresult);
			String message = resultObj.getString("result");
			JSONObject newmsg = new JSONObject(message);
			String listnews = newmsg.getString("list");		
			JSONArray newsdetaList = new JSONArray(listnews);
			listBean = new ArrayList<ListBean>();
			int length = newsdetaList.length();
			for (int i = 0; i < length; i++) {
				ListBean lb = new ListBean();
				JSONObject JSONimg = newsdetaList.getJSONObject(i);
				lb.setPic(JSONimg.getString("pic"));
				lb.setSrc(JSONimg.getString("src"));
				lb.setTime(JSONimg.getString("time"));
				lb.setUrl(JSONimg.getString("url"));
				lb.setTitle(JSONimg.getString("title"));
				lb .setData(JSONimg.getString("content"));
				listBean.add(lb);
			}
		} catch (JSONException e) {

			e.printStackTrace();
		}	
		return listBean;		
	}
	public void Getadapter(final List<ListBean> listBean) {
		 adapter=new ListNews_adapter(context, listBean);
		listv.setAdapter(adapter);
		listv.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				String url = listBean.get(arg2).getUrl();
				Intent intent = new Intent(context,
						WebViewsActivity.class);
				intent.putExtra("url", url);
				context.startActivity(intent);
			}
		});
	}

	public ListNews_adapter getAdapter() {
		return adapter;
	}

	public void setAdapter(ListNews_adapter adapter) {
		this.adapter = adapter;
	}
	public List<ListBean> getListBean() {
		return listBean;
	}
	public void setListBean(List<ListBean> listBean) {
		this.listBean = listBean;
	}
	public String getRootresult() {
		return rootresult;
	}
	public void setRootresult(String rootresult) {
		this.rootresult = rootresult;
	}
	public ListView getListv() {
		return listv;
	}
	public void setListv(ListView listv) {
		this.listv = listv;
	}
	
}
