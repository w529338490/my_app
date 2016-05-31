package com.example.administrator.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;

public class Main2Activity extends AppCompatActivity {
    private ImageView star_img_bg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        star_img_bg= (ImageView) findViewById(R.id.star_img_bg);
        start();
    }

    private void start() {

        Observable.timer(2, TimeUnit.SECONDS, AndroidSchedulers.mainThread())
                .doOnNext(new Action1<Long>() {
                    @Override
                    public void call(Long aLong) {
                        startActivity(new Intent(Main2Activity.this, MainActivity.class));
                        finish();

                    }
                })
               .subscribe();
    }
}
