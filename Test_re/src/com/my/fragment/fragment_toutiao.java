package com.my.fragment;

import in.srain.cube.views.ptr.PtrClassicFrameLayout;

import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler;
import in.srain.cube.views.ptr.header.RentalsSunHeaderView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.client.ClientProtocolException;

import com.aphidmobile.flip.FlipViewController;
import com.example.test_re.MainActivity;
import com.example.test_re.R;
import com.example.test_re.WebViewsActivity;
import com.my.adapter.Filp_adapter;
import com.my.adapter.ListNews_adapter;
import com.my.bean.ListBean;
import com.my.gethttp.Dohandler;
import com.my.gethttp.Gethttp;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class fragment_toutiao extends Fragment {
	Context context;
	MainActivity ac;
	Handler responseDataHandler;
	List<ListBean> listBean;
	ListNews_adapter adapter;
	Gethttp Getnet;
	Dohandler dohandler;
	String tittle;
	public ListView list_toutiao;

	private PtrFrameLayout ptr;

	
	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.frag_toutiao, null);
		list_toutiao = (ListView) view.findViewById(R.id.frag_list);	
		ptr = (PtrFrameLayout)view.findViewById(R.id.ptr);
		initview();
		initPtr();
		return view;
	}
	private void initPtr() {

				final RentalsSunHeaderView header = new RentalsSunHeaderView(context);
				header.setLayoutParams(new PtrFrameLayout.LayoutParams(-1, -2));
				header.setPadding(0, DisplayUtil.dip2px(context, 15), 0,
						DisplayUtil.dip2px(context, 10));
				header.setUp(ptr);

				ptr.setHeaderView(header);
				ptr.addPtrUIHandler(header);
				ptr.postDelayed(new Runnable() {
					@Override
					public void run() {
						
						ptr.autoRefresh(true);
					}
				}, 150);

				ptr.setPtrHandler(new PtrHandler() {

					@Override
					public void onRefreshBegin(PtrFrameLayout frame) {
						frame.postDelayed(new Runnable() {
							@Override
							public void run() {
								ptr.refreshComplete();
							}
						}, 1800);
					}

					@Override
					public boolean checkCanDoRefresh(PtrFrameLayout frame,
							View content, View header) {
						return PtrDefaultHandler.checkContentCanBePulledDown(frame,
								content, header);
					}
				});
			};
	public void initview() {
		
		dodata();
	}
	public void dodata() {
		Getdata getdata = new Getdata();
		getdata.setTittle(tittle);
		new Thread(getdata).start();
		do_handler();
	}
	public void do_handler() {
		responseDataHandler = new Handler() {
			@Override
			public void dispatchMessage(Message msg) {
				// 获取子线程中所传递的响应结果
				byte[] str = msg.getData().getByteArray("result");
				String rootresult = new String(str);
				dohandler = new Dohandler(context, listBean, rootresult, adapter, list_toutiao);			
				returnlistbean(dohandler);
			}
		};
	}

	public	class Getdata implements Runnable {
		private String tittle;

		@Override
		public void run() {
			Getnet = new Gethttp(responseDataHandler,tittle);
			try {
				Getnet.startnet();
			} catch (ClientProtocolException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		public String getTittle() {
			return tittle;
		}

		public void setTittle(String tittle) {
			this.tittle = tittle;
		}

	}
	public fragment_toutiao(Context context, Handler responseDataHandler,
			List<ListBean> listBean, ListNews_adapter adapter, Gethttp getnet,
			Dohandler dohandler, String tittle) {
		super();
		this.context = context;
		this.responseDataHandler = responseDataHandler;
		this.listBean = listBean;
		this.adapter = adapter;
		Getnet = getnet;
		this.dohandler = dohandler;
		this.tittle = tittle;
		
	}
	private List<ListBean>  returnlistbean(Dohandler Dohandlers) {
		
		this.setListBean(Dohandlers.getListBean());
		return listBean;
	}
	public Dohandler getDohandler() {
		return dohandler;
	}
	public void setDohandler(Dohandler dohandler) {
		this.dohandler = dohandler;
	}
	public List<ListBean> getListBean() {
		return listBean;
	}
	public void setListBean(List<ListBean> listBean) {
		this.listBean = listBean;
	}
	
}
