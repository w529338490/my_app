package com.my.adapter;

import java.util.List;

import com.example.test_re.R;
import com.my.bean.ListBean;
import com.myiamgeloder.ImageLoaderPicture;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;
import com.squareup.picasso.Picasso;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ListNews_adapter extends BaseAdapter {

	Context context;
	List<ListBean> listBeans;

	public ListNews_adapter(Context context, List<ListBean> listBean) {
		super();
		this.context = context;
		this.listBeans = listBean;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return listBeans.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return listBeans.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public View getView(final int position, View view, ViewGroup arg2) {
		ViewHodler holder = null;
		if (view == null) {
			holder = new ViewHodler();
			view = LayoutInflater.from(context).inflate(R.layout.listbean_item,
					null);
			holder.img = (ImageView) view.findViewById(R.id.news_img);
			holder.src = (TextView) view.findViewById(R.id.news_src);
			holder.tittle = (TextView) view.findViewById(R.id.news_tittle);
			holder.time = (TextView) view.findViewById(R.id.news_times);
			view.setTag(holder);

		} else {
			holder = (ViewHodler) view.getTag();
		}
		final ListBean b = listBeans.get(position);		
		//用ImageLoader加载图片
        ImageLoader.getInstance()
        .displayImage(b.getPic(), holder.img,new ImageLoaderPicture(context).getOptions(),new SimpleImageLoadingListener());
		holder.tittle.setText(b.getTitle());
		holder.time.setText(b.getTime());
		holder.src.setText(b.getSrc());

		// Picasso.with使用的是单例模式

		return view;
	}

	public class ViewHodler {
		ImageView img;
		TextView tittle;
		TextView time;
		TextView src;
	}
}
