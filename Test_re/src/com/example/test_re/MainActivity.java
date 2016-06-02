package com.example.test_re;

import in.srain.cube.views.ptr.PtrClassicFrameLayout;
import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler;
import in.srain.cube.views.ptr.header.RentalsSunHeaderView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.aphidmobile.flip.FlipViewController;
import com.my.adapter.Filp_adapter;
import com.my.adapter.ListNews_adapter;
import com.my.bean.ListBean;

import com.my.fragment.fragment_toutiao;
import com.my.gethttp.Dohandler;
import com.my.gethttp.Gethttp;

import com.viewpagerindicator.TabPageIndicator;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends FragmentActivity {
	Context context;
	private Button btn, go_flip;
	private ListView listv;
	Handler responseDataHandler = new Handler();
	String httpurl;
	List<ListBean> listBean ;
	ListNews_adapter adapter;
	private FlipViewController flipView;
	private PtrClassicFrameLayout ptr;
	List<ListView> listViews;
	Gethttp Getnet;
	Dohandler dohandler;
	ViewPager pager;
	int tag;
	fragment_toutiao ff;
	private static final String[] CONTENT = new String[] 
              { "头条", "体育", "军事","科技", "教育" };
	/**
	 * FragmentManager
	 * 
	 */
	FragmentManager fm;
	List<Fragment> list_frags;
   Map<String,View>map_view;
   View view;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		view=LayoutInflater.from(this).inflate(R.layout.activity_main, null);
		setContentView(view);
		map_view=new HashMap<String, View>();
		pager = (ViewPager) findViewById(R.id.pager);
		list_frags = new ArrayList<Fragment>();
		innitrtr();	
		btn = (Button) findViewById(R.id.btn);
		btn.setVisibility(View.INVISIBLE);
		go_flip = (Button) findViewById(R.id.btn_flip);
		
		
		fragment_toutiao fragment01 = new fragment_toutiao(MainActivity.this,
				responseDataHandler, listBean, adapter, Getnet, dohandler,
				CONTENT[0]);
		fragment_toutiao fragment02 = new fragment_toutiao(MainActivity.this,
				responseDataHandler, listBean, adapter, Getnet, dohandler,
				CONTENT[1]);
		fragment_toutiao fragment03 = new fragment_toutiao(MainActivity.this,
				responseDataHandler, listBean, adapter, Getnet, dohandler,
				CONTENT[2]);
		fragment_toutiao fragment04 = new fragment_toutiao(MainActivity.this,
				responseDataHandler, listBean, adapter, Getnet, dohandler,
				CONTENT[3]);
		fragment_toutiao fragment05 = new fragment_toutiao(MainActivity.this,
				responseDataHandler, listBean, adapter, Getnet, dohandler,
				CONTENT[4]);
		
		list_frags.add(fragment01);
		list_frags.add(fragment02);
		list_frags.add(fragment03);
		list_frags.add(fragment04);
		list_frags.add(fragment05);
		// go_flip.setVisibility(View.INVISIBLE);
		/*
		 * flipView设置
		 */
		flipView = new FlipViewController(this);
		flipView.setAnimationBitmapFormat(Bitmap.Config.RGB_565);
		flipView = new FlipViewController(this, FlipViewController.HORIZONTAL);

		go_flip.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				
//				fragment_toutiao ff=(fragment_toutiao) list_frags.get(0);
//				ff.getListBean();		
				if(ff!=null){
				GotoFlip();
				}
			}
		});

		responseDataHandler = new Handler() {
			@Override
			public void dispatchMessage(Message msg) {
				// 获取子线程中所传递的响应结果
				byte[] str = msg.getData().getByteArray("result");
				String rootresult = new String(str);
				dohandler = new Dohandler(MainActivity.this, listBean,
						rootresult, adapter, listv);
			}
		};
	}

	protected void GotoFlip() {
		
		flipView.setAdapter(new Filp_adapter(MainActivity.this, ff.getListBean(), MainActivity.this,map_view));
		flipView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				String url = ff.getListBean().get(arg2).getUrl();
				String tittle = ff.getListBean().get(arg2).getTitle();
				String pic = ff.getListBean().get(arg2).getPic();
				List<String> str = new ArrayList<String>();
				str.add(url);
				str.add(tittle);
				str.add(pic);
	
				Intent intent = new Intent(MainActivity.this,
						WebViewsActivity.class);
				intent.putExtra("url", url);
				intent.putExtra("tittle", tittle);
				intent.putExtra("pic", pic);
				startActivity(intent);

			}
		});
		map_view.put("c_view",view);
		setContentView(flipView);
	}

	@Override
	protected void onResume() {
		super.onResume();
		flipView.onResume();
	}

	@Override
	protected void onPause() {
		super.onPause();
		flipView.onPause();
	}
	private void innitrtr() {

		GoogleMusicAdapter myMusicadapter = new GoogleMusicAdapter(
				getSupportFragmentManager(), list_frags);

		pager.setAdapter(myMusicadapter);
		TabPageIndicator indicator = (TabPageIndicator) findViewById(R.id.indicator);
		indicator.setViewPager(pager);

	}

	class GoogleMusicAdapter extends FragmentPagerAdapter {
		List<Fragment> list_frags;
		FragmentManager fm;

		public GoogleMusicAdapter(FragmentManager fm, List<Fragment> list_frags) {
			super(fm);
			this.list_frags = list_frags;
			this.fm = fm;
		}

		@Override
		public Fragment getItem(int position) {
			
			
			   if(position==CONTENT.length||position==0){
				   ff=(fragment_toutiao) list_frags.get(position);
			   }else{
				   ff=(fragment_toutiao) list_frags.get(position-1);
			   }
			return list_frags.get(position);
		}

		@Override
		public CharSequence getPageTitle(int position) {
			
			return CONTENT[position % CONTENT.length].toUpperCase();
		}

		@Override
		public int getCount() {
			return CONTENT.length;
		}
	}

	public List<ListBean> getListBean() {
		return listBean;
	}

	public void setListBean(List<ListBean> listBean) {
		this.listBean = listBean;
	}
	
}
