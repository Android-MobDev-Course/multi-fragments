package com.mobdev.multifragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

/**
 * Created by Marco Picone (picone.m@gmail.com) 12/03/2020
 */
public  class CleanNumberFragment extends Fragment {

	private Button cleanButton = null;

	public CleanNumberFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.clean_number_fragment, container, false);

		cleanButton  = (Button)rootView.findViewById(R.id.cleanButton);
		cleanButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				((MainActivity)getActivity()).cleanNumberTextView();
			}
		});
		
		return rootView;
	}
	
}