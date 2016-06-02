package com.testimageloader.activity;

import java.util.ArrayList;
import java.util.List;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.testimageloader.adapter.ListViewAdapter;
import com.testimageloader.cache.AsyncImageLoader;
import com.testimageloader.util.Images;

public class MainActivity extends Activity
{
	private ListView listView;

	// listview适配器
	private ListViewAdapter adapter;
	// 数据源
	private List<String> datas = new ArrayList<String>();
	private LinearLayout loading_llyt;

	// 是否为最后一行
	private boolean isLastRow = false;
	private int index = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// 设置加载中显示图片
		AsyncImageLoader.getInstance(this).setLoadingDrawable(R.drawable.empty_photo);
		// 设置加载失败显示图片
		AsyncImageLoader.getInstance(this).setLoadFailDrawable(R.drawable.ic_launcher);

		listView = (ListView) findViewById(R.id.listView);

		loading_llyt = (LinearLayout) LayoutInflater.from(this).inflate(R.layout.loading_view, null);

		// 初始化数据源
		for (int i = 0; i < 20; i++)
		{
			datas.add(Images.imageArray[i]);
		}
		adapter = new ListViewAdapter(this, datas, listView);
		listView.addFooterView(loading_llyt);
		listView.setAdapter(adapter);

		// 列表滚动事件
		listView.setOnScrollListener(new OnScrollListener()
		{

			@Override
			public void onScrollStateChanged(AbsListView view, int scrollState)
			{
				if (isLastRow && scrollState == OnScrollListener.SCROLL_STATE_IDLE)
				{
					if (index < 2)
					{
						// 模拟请求网络数据加载更多
						new Thread(new Runnable()
						{

							@Override
							public void run()
							{
								try
								{
									Thread.sleep(1000);
								} catch (InterruptedException e)
								{
									e.printStackTrace();
								}
								handler.sendEmptyMessage(1);
							}
						}).start();
					}
					isLastRow = false;
				}
			}

			@Override
			public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount)
			{
				if (firstVisibleItem + visibleItemCount == totalItemCount && totalItemCount > 0)
				{
					isLastRow = true;
				}
			}
		});
	}

	@SuppressLint("HandlerLeak")
	private Handler handler = new Handler()
	{

		@Override
		public void handleMessage(Message msg)
		{
			switch (msg.what)
			{

			// 滚动加载
			case 1:

				// 加载数据
				for (int i = 20; i < 40; i++)
				{
					datas.add(Images.imageArray[i]);
				}
				adapter.refreshDatas(datas);
				index++;
				if (index == 2)
				{
					listView.removeFooterView(loading_llyt);
				}

				break;

			default:
				break;
			}
		}
	};

	@Override
	protected void onPause()
	{
		super.onPause();
		// 将内存中的操作记录同步到日志文件中
		AsyncImageLoader.getInstance(this).fluchCache();
	}

	@Override
	protected void onDestroy()
	{
		super.onDestroy();
		// 退出时结束所有加载任务
		AsyncImageLoader.getInstance(this).cancelAllTasks();
	}
}
