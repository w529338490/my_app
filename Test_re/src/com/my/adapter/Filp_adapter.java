package com.my.adapter;

import java.util.List;
import java.util.Map;

import com.example.test_re.MainActivity;
import com.example.test_re.R;
import com.example.test_re.WebViewsActivity;
import com.my.bean.ListBean;
import com.myiamgeloder.ImageLoaderPicture;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Filp_adapter  extends BaseAdapter {
	Context context;
	Activity ac;
	List<ListBean> listBeans;
	String url;
	
	 Map<String,View>map_view;
	public Filp_adapter(Context context, List<ListBean> listBean,Activity ac, Map<String,View>map_view) {
	     this.context=context;
	     this.listBeans=listBean;
	     this.ac=ac;
	     this.map_view=map_view;
	}

	@Override
	public int getCount() {
		
		return listBeans.size();
	}

	@Override
	public Object getItem(int arg0) {
		
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View converview, ViewGroup arg2) {
	             ViewHolder holder=null;
	             if(converview==null){
	            	 holder=new ViewHolder();
	            	 converview=LayoutInflater.from(context).inflate(R.layout.flip_item, null);
	            	 holder.img=(ImageView) converview.findViewById(R.id.flip_img);
	            	 holder.tv_content=(TextView) converview.findViewById(R.id.flip_tv);
	            	 holder.btn_back=(Button) converview.findViewById(R.id.btn_back);
	            	 holder.btn_back_web=(Button) converview.findViewById(R.id.btn_back_web);
	            	 converview.setTag(holder);
	            	 
	             }else{
	            	 holder=(ViewHolder) converview.getTag();
	            	 
	             }
	             
	              holder.tv_content.setText(listBeans.get(position).getTitle());
	              holder.tv_content.setTextSize(30);
	              holder.img.setImageResource(R.drawable.cao);
	              
	              url= listBeans.get(position).getUrl();
	              ImageLoader.getInstance()
	              
	              .displayImage(listBeans.get(position).getPic(), holder.img,new ImageLoaderPicture(context).getOptions(),new SimpleImageLoadingListener());
	              holder.btn_back.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View arg0) {		   
						Intent intent=new Intent(ac,WebViewsActivity.class);
						intent.putExtra("url", url);
						ac.startActivity(intent);		
					}
				});
		
	              holder.btn_back_web.setOnClickListener(new OnClickListener() {				
					@Override
					public void onClick(View arg0) {
						//(View)ac.getResources().getLayout(R.layout.activity_main)
							ac.setContentView(map_view.get("c_view"));
					}
				});
	              return converview;
	}
   public class ViewHolder{
	   
	   ImageView img;
	   TextView tv_content;
	   Button btn_back,btn_back_web;
   }
}
