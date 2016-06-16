package com.example.administrator.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class WebviewsActivity extends AppCompatActivity {

    WebView web_view;
   String url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webviews);
        web_view = (WebView) findViewById(R.id.web_view);
        url=this.getIntent().getStringExtra("url");

        web_view.getSettings().setJavaScriptEnabled(true);
        //加载需要显示的网页
        web_view.loadUrl(url);





    }
}
