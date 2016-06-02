package com.coco.draggablegridviewpager.test;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.coco.draggablegridviewpager.DraggableGridViewPager;
import com.coco.draggablegridviewpager.DraggableGridViewPager.OnPageChangeListener;
import com.coco.draggablegridviewpager.DraggableGridViewPager.OnRearrangeListener;

public class DraggableGridViewPagerTestActivity extends Activity {

	private static final String TAG = "DraggableGridViewPagerTestActivity";

	private DraggableGridViewPager mDraggableGridViewPager;
	private Button mAddButton;
	private Button mRemoveButton;

//	private ArrayAdapter<String> mAdapter;
	
	private mAdapter mAdapter;
	private int mGridCount;
	ArrayList<user> list=new ArrayList<user>();;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);

		setContentView(R.layout.draggable_grid_view_pager_test);
		mDraggableGridViewPager = (DraggableGridViewPager) findViewById(R.id.draggable_grid_view_pager);
		mAddButton = (Button) findViewById(R.id.add);
		mRemoveButton = (Button) findViewById(R.id.remove);
                  user u1=new user();
                  u1.name="zhangsan";
                  user u2=new user();
                  user u3=new user();
                  user u4=new user();
                 
                  u3.name="wangwu";
                  u4.name="zhaoliu";
                
                for(int i=1;i<40;i++){
                	user u=new user();
                	u.name=i+"q";
                list.add(u);
                }
                  list.add(u1);
                  list.add(u2);
                  list.add(u3);
                  list.add(u4);             
                  mAdapter=new mAdapter(getApplicationContext(),list); 
                  mAddButton.setText(mAdapter.getCount()+"'");
//		mAdapter = new ArrayAdapter<String>(this, 0) {
//			@Override
//			public View getView(int position, View convertView, ViewGroup parent) {
//				final String text = getItem(position);
//				if (convertView == null) {
//					convertView = (TextView) getLayoutInflater().inflate(R.layout.draggable_grid_item, null);
//				}
//				((TextView) convertView).setText(text);
//				return convertView;
//			}
//
//		};
                  
		mDraggableGridViewPager.setAdapter(mAdapter);
		
		mDraggableGridViewPager.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		//		showToast(((TextView) view).getText().toString());
			}
		});
		mDraggableGridViewPager.setOnItemLongClickListener(new OnItemLongClickListener() {
			@Override
			public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
			
				return true;
			}
		});
		mDraggableGridViewPager.setOnRearrangeListener(new OnRearrangeListener() {
			@Override
			public void onRearrange(int oldIndex, int newIndex) {
				Log.i(TAG, "OnRearrangeListener.onRearrange from=" + oldIndex + ", to=" + newIndex);
             System.out.println(oldIndex+"："+newIndex+"===========================");               
		    
//				  int item=oldIndex;
//				 mAdapter.setNotifyOnChange(false);
//			     mAdapter.remove(item);
//				 mAdapter.insert(item, list.get(newIndex));
//				 mAdapter.notifyDataSetChanged();
			}
		});

		mAddButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				mGridCount++;
			//	mAdapter.add(list.get(mGridCount));
				
			}
		});

		mRemoveButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (mAdapter.getCount() > 0) {
				//	mAdapter.remove(mAdapter.getItem(mAdapter.getCount() - 1));
					
				}
			}
		});
	}

	private void showToast(String msg) {
		Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
	}

}
