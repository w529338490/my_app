package com.my.fragment;

import com.example.test_re.R;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class fragment_keji extends Fragment {
	
	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		
		View view=inflater.inflate(R.layout.frag_toutiao, null);
		
		
		
		return view;
				}

}
