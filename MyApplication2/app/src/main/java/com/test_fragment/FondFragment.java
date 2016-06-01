package com.test_fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.administrator.myapplication.MainActivity;
import com.example.administrator.myapplication.R;
import com.viewpagerindicator.TabPageIndicator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/5/25.
 */
public class FondFragment extends Fragment {
    Context context;
    MainActivity activity;
    ViewPager pager;
    ListView list_iem;
    TabPageIndicator indicator;
    List<Fragment>list_fragments;
    FragmentManager fm;
    public String aaa;
    private static final String[] CONTENT = new String[] {"头条", "体育", "科技","军事","教育" };

    public void setActivity(MainActivity activity) {
        this.activity = activity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_fond, null);
        pager= (ViewPager) view.findViewById(R.id.pager);
        indicator = (TabPageIndicator)view.findViewById(R.id.indicator);
        list_fragments=new ArrayList<Fragment>();

        this.context=activity;

        lodingIamg();
        return view;
    }
    private void lodingIamg() {
        FragmentPagerAdapter adapter = new GoogleMusicAdapter(this.activity.getSupportFragmentManager());
        pager.setAdapter(adapter);
        indicator.setViewPager(pager);
    }



    class GoogleMusicAdapter extends FragmentPagerAdapter{
        public GoogleMusicAdapter(FragmentManager fm) {
            super(fm);
        }
        @Override
        public Fragment getItem(int position) {
            News_CegerFrag fragment = new News_CegerFrag();
            context=fragment.getContext();
            fragment.setTittle(CONTENT[position]);
            fragment.setContext(activity);
            return fragment;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return CONTENT[position % CONTENT.length].toUpperCase();
        }

        @Override
        public int getCount() {
            return CONTENT.length;
        }
    }


}
