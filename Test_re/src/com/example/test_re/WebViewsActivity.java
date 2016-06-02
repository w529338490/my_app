package com.example.test_re;

import java.util.ArrayList;
import java.util.List;

import com.my.bean.ListBean;

import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.onekeyshare.OnekeyShare;
import cn.sharesdk.onekeyshare.OnekeyShareTheme;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.Button;

public class WebViewsActivity extends Activity {
   private WebView my_wedview;
   private Button btn_share;
   ListBean item_beam;
   List<String> str=new ArrayList<String>();
	String url,pic,tittle;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_web_views);
		
		url=this.getIntent().getStringExtra("url");
		tittle=this.getIntent().getStringExtra("tittle");
		pic=this.getIntent().getStringExtra("pic");
			
		System.out.println("===================================="+str.size());
		btn_share=(Button) findViewById(R.id.btn_share);
		btn_share.setOnClickListener(new OnClickListener() {		
			@Override
			public void onClick(View arg0) {
				showShare();			
			}
		});
		my_wedview=(WebView) findViewById(R.id.my_wedview);
		my_wedview.getSettings().setJavaScriptEnabled(false);
		my_wedview.getSettings().setSupportZoom(false);
		my_wedview.getSettings().setDefaultFontSize(18);
		my_wedview.setScrollBarStyle(View.SCROLLBAR_POSITION_DEFAULT);
		
		my_wedview.loadUrl(url);
	}

	/**
	 * 分享, 注意在sdcard根目录放test.jpg
	 */
	private void showShare() {
		ShareSDK.initSDK(this);
		OnekeyShare oks = new OnekeyShare();	
		oks.setTheme(OnekeyShareTheme.SKYBLUE);//设置天蓝色的主题		
		// 关闭sso授权
		oks.disableSSOWhenAuthorize();

		// 分享时Notification的图标和文字
		oks.setNotification(R.drawable.ic_launcher,
				getString(R.string.app_name));
		// title标题，印象笔记、邮箱、信息、微信、人人网和QQ空间使用
	     //	getString(R.string.share)
		oks.setTitle(tittle);
		// titleUrl是标题的网络链接，仅在人人网和QQ空间使用
		oks.setTitleUrl(url);
		// text是分享文本，所有平台都需要这个字段
		oks.setText(tittle);
		// imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
		oks.setImagePath("/sdcard/test.jpg");// 确保SDcard下面存在此张图片
		// url仅在微信（包括好友和朋友圈）中使用
		oks.setUrl(url);
		// comment是我对这条分享的评论，仅在人人网和QQ空间使用
		oks.setComment("我是测试评论文本");
		// site是分享此内容的网站名称，仅在QQ空间使用
		oks.setSite(url);
		// siteUrl是分享此内容的网站地址，仅在QQ空间使用
		oks.setSiteUrl(url);
		// 启动分享GUI
		oks.show(this);
	}
}
