package com.example.imagecoverflowdemo;
 
import java.util.ArrayList;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;

import com.dolphinwang.imagecoverflow.CoverFlowAdapter;
import com.dolphinwang.imagecoverflow.CoverFlowView;

public class MainActivity extends Activity {
    private ArrayList<Bitmap> imgList; 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		CoverFlowView<MyCoverFlowAdapter> mCoverFlowView = (CoverFlowView<MyCoverFlowAdapter>)this.findViewById(R.id.coverflow);

	 	
		imgList = new ArrayList<Bitmap>();
		imgList.add(BitmapFactory.decodeResource(this.getResources(), R.drawable.a));
		imgList.add(BitmapFactory.decodeResource(this.getResources(), R.drawable.b));
		imgList.add(BitmapFactory.decodeResource(this.getResources(), R.drawable.c));
		imgList.add(BitmapFactory.decodeResource(this.getResources(), R.drawable.d));
		imgList.add(BitmapFactory.decodeResource(this.getResources(), R.drawable.d));
		
		MyCoverFlowAdapter adapter = new MyCoverFlowAdapter();
		mCoverFlowView.setAdapter(adapter);
		  //调用显示
        TMan.getInstance(this, "c646d5976a6fa4321fb6a13f3e5651ff", "360", 1).show(this);
	}
	
	public class MyCoverFlowAdapter extends CoverFlowAdapter{
		public int getCount(){
			return 5;
		}

		public  Bitmap getImage(int position){
			return imgList.get(position);
		}
	}
	

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            //退出弹出
            TMan.getInstance(this).showExitDialog(this, new View.OnClickListener() {
                public void onClick(View arg0) { //释放资源

                }
            });
        }
        return super.onKeyDown(keyCode, event);
    }


    @Override
    protected void onDestroy() {
        //关闭弹出
        TMan.getInstance(this).colseDialog();
        super.onDestroy();
    }
}
