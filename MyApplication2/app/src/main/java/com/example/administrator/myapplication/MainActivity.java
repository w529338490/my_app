package com.example.administrator.myapplication;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;

import com.test_fragment.FondFragment;
import com.test_fragment.MeFragment;
import com.test_fragment.NewsFragment;
import com.test_fragment.News_CegerFrag;
import com.test_fragment.TweenFragment;

public class MainActivity extends FragmentActivity implements RadioGroup.OnCheckedChangeListener {
    private RadioGroup radioGroup;
    private RadioButton btn_new,btn_fond,btn_me,btn_tween;
    private FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fm=getSupportFragmentManager();
        initview();
        btn_new.setChecked(true);
        radioGroup.setOnCheckedChangeListener(this);
        changFragment(new NewsFragment(),false);

    }
    public void  initview(){
        radioGroup=(RadioGroup)findViewById(R.id.radio_main);
        btn_new= (RadioButton) findViewById(R.id.btn_news);
        btn_tween= (RadioButton) findViewById(R.id.btn_tween);
        btn_fond= (RadioButton) findViewById(R.id.btn_fond);
        btn_me= (RadioButton) findViewById(R.id.btn_me);

    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

         switch(checkedId){
             case R.id.btn_news:
                 btn_new.setTextColor(Color.parseColor("#96BF3B"));
                 btn_tween.setTextColor(Color.parseColor("#000000"));
                 btn_fond.setTextColor(Color.parseColor("#000000"));
                 btn_me.setTextColor(Color.parseColor("#000000"));

                 changFragment(new NewsFragment(),true);
                  break;
             case R.id.btn_tween:
                 btn_tween.setTextColor(Color.parseColor("#96BF3B"));
                 btn_new.setTextColor(Color.parseColor("#000000"));
                 btn_fond.setTextColor(Color.parseColor("#000000"));
                 btn_me.setTextColor(Color.parseColor("#000000"));
                 changFragment(new TweenFragment(),true);
                 break;
             case R.id.btn_fond:
                 btn_new.setTextColor(Color.parseColor("#000000"));
                 btn_tween.setTextColor(Color.parseColor("#000000"));
                 btn_fond.setTextColor(Color.parseColor("#96BF3B"));
                 btn_me.setTextColor(Color.parseColor("#000000"));
                 FondFragment fondFragment= new FondFragment();
              //   News_CegerFrag fondFragment=new News_CegerFrag();
                 fondFragment.setActivity(MainActivity.this);
                 changFragment(fondFragment,true);
                 break;
             case R.id.btn_me:

                 btn_new.setTextColor(Color.parseColor("#000000"));
                 btn_tween.setTextColor(Color.parseColor("#000000"));
                 btn_fond.setTextColor(Color.parseColor("#000000"));
                 btn_me.setTextColor(Color.parseColor("#96BF3B"));
                 changFragment(new MeFragment(),true);
                 break;


         }
    }
    public  void changFragment(Fragment f, boolean isfirst){
        FragmentTransaction transaction=fm.beginTransaction();
        transaction.replace(R.id.main_content,f);
        transaction.commit();
    }
}

