package com.com.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.com.utils.imageLoa;
import com.enity.beaninfo_a;
import com.example.administrator.myapplication.R;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;

import java.util.List;

/**
 * Created by Administrator on 2016/5/27.
 */
public class listviewadaper extends BaseAdapter {

    Context context;
    private List<beaninfo_a.ResultBean.ListBean> listdata;

    public listviewadaper(Context context,List listdata){
          this.context=context;
         this.listdata=listdata;
    }
    @Override
    public int getCount() {
        return listdata.size();
    }

    @Override
    public Object getItem(int position) {
        return listdata.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
             ViewHolder viewHolder = null;

            if(convertView==null){
                viewHolder = new ViewHolder();
                LayoutInflater mInflater = LayoutInflater.from(context);
                convertView=mInflater.inflate(R.layout.news_detail,null);
//listdata.get(position).getPic();
                viewHolder.newssrc= (TextView) convertView.findViewById(R.id.news_src);
                viewHolder.newsimg= (ImageView) convertView.findViewById(R.id.news_img);
                viewHolder.newstitlle= (TextView) convertView.findViewById(R.id.news_titlle);
                viewHolder.newstime= (TextView) convertView.findViewById(R.id.news_time);
                convertView.setTag(viewHolder);
            }else {
                viewHolder = (ViewHolder) convertView.getTag();
            }
        beaninfo_a.ResultBean.ListBean  ben = (beaninfo_a.ResultBean.ListBean)listdata.get(position);

        if (null != ben)
        {
            viewHolder.newstitlle.setText(ben.getTitle());
            viewHolder.newssrc.setText(ben.getSrc());
            viewHolder.newstime.setText(ben.getTime());
            ImageLoader.getInstance().displayImage
                    (ben.getPic(),viewHolder.newsimg,new imageLoa(context).getOptions(),
                            new SimpleImageLoadingListener());
        }

        return convertView;
    }
    private static class ViewHolder
    {
        ImageView newsimg;
        TextView newstitlle;
        TextView newssrc;
        TextView newstime;
    }
}
