package com.test_fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.myapplication.R;

/**
 * Created by Administrator on 2016/5/25.
 */
public class MeFragment extends Fragment{
    Context context;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

              View view=inflater.inflate(R.layout.fragment_me,null);
                   return view;


    }
}
