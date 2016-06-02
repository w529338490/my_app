package com.coco.draggablegridviewpager.test;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class mAdapter  extends BaseAdapter{
	Context context;
	ArrayList<user> list;
	user u;

	public mAdapter(Context context) {
		super();
		list=new ArrayList<user>();
		this.context = context;
	
	}

	public mAdapter(Context context, ArrayList<user> list) {
		super();
		this.context = context;
		this.list = list;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return list.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		
		return arg0;
	}

	@Override
	public View getView(int position, View converview, ViewGroup arg2) {
		ViewHolder holder;
		    if(converview==null){
		    	   holder=new ViewHolder();
		    	   converview=LayoutInflater.from(context).inflate(R.layout.adapter_item, null);
		    	   holder.tv=(TextView) converview.findViewById(R.id.tv_adapter);
		                converview.setTag(holder);
		    }else{
		    	
		    	holder=(ViewHolder) converview.getTag();
		    }
	    int imgs[]={R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.e};	
	    holder.tv.setText(list.get(position).getName());
	    holder.tv.setTextSize(25);
	    if(position<4){
	    holder.tv.setBackgroundResource(imgs[position]);
	    }else{
	    	  holder.tv.setBackgroundResource(imgs[3]);
	    }    
		return converview;
	}
    class ViewHolder {
    	TextView tv;
    }
	public void add(user u){
		this.u=u;
		list.add(u);
	}

	public void setNotifyOnChange(boolean b) {
		if(b){
		   this.notifyDataSetChanged();
		}
		
	}

	public void remove(int item) {
		list.remove(item);
		
	}

	public void insert(int item, user user) {
		    list.add(user);
		
	}
}
