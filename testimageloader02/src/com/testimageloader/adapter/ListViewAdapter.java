package com.testimageloader.adapter;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import com.testimageloader.activity.R;
import com.testimageloader.cache.AsyncImageLoader;
import com.testimageloader.util.DisplayUtil;

/**
 * listview适配器
 * 
 * @author blue
 * 
 */
public class ListViewAdapter extends SimpleBaseAdapter<String>
{
	private ListView listView;

	public ListViewAdapter(Context c, List<String> datas, ListView listView)
	{
		super(c, datas);
		this.listView = listView;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent)
	{
		EntityHolder entityHolder = null;

		if (convertView == null)
		{
			entityHolder = new EntityHolder();

			convertView = layoutInflater.inflate(R.layout.listview_item, null);
			entityHolder.imageView = (ImageView) convertView.findViewById(R.id.listView_iv_item);

			convertView.setTag(entityHolder);
		} else
		{
			entityHolder = (EntityHolder) convertView.getTag();
		}

		// 给imageview设置一个tag，保证异步加载图片时不会乱序h
		entityHolder.imageView.setTag(datas.get(position));
		// 开启异步加载图片,显示大小为100dp*100dp
		AsyncImageLoader.getInstance(c).loadBitmaps(listView, entityHolder.imageView, datas.get(position), DisplayUtil.dip2px(c, 100), DisplayUtil.dip2px(c, 100));

		return convertView;
	}

	private class EntityHolder
	{
		// 图片
		public ImageView imageView;
	}
}
