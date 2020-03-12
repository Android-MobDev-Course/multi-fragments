package com.mobdev.multifragment;

import java.util.Random;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

/**
 * Created by Marco Picone (picone.m@gmail.com) 12/03/2020
 */
public  class RandomNumberFragment extends Fragment {

	static final String INFO_NUMBER_EXTRA = "randomNumber";

	private Context mContext;
	private TextView numberTextView = null;
	private Button randomButton = null;
	private int currentRandomNum = 0;
	private Button infoButton = null;
	private ImageView imageView = null;
	private Random random = null;

	public RandomNumberFragment() {
		this.random = new Random();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		this.mContext = getActivity();

		View rootView = inflater.inflate(R.layout.random_number_fragment, container, false);
		
		//Retrieve TextView UI Object
		numberTextView  = (TextView) rootView.findViewById(R.id.infoTextView);
		imageView  = (ImageView)rootView.findViewById(R.id.imageView);
		
		//Retrieve a Button UI Object and set an inline listener
		randomButton  = (Button)rootView.findViewById(R.id.randomButton);
		randomButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				currentRandomNum = random.nextInt(1000 + 1);
				numberTextView.setText(String.valueOf(currentRandomNum));
				setAndroidImage();
			}
		});
		
		infoButton = (Button)rootView.findViewById(R.id.infoButton);
		infoButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				//Start without parameters
				//startActivity(new Intent(mContext,InfoActivity.class));

				Bundle bundle = new Bundle();
				bundle.putInt(INFO_NUMBER_EXTRA, currentRandomNum);

				Intent newIntent = new Intent(new Intent(mContext,InfoActivity.class));
				newIntent.putExtras(bundle);
				startActivity(newIntent);
			}
		});
		
		return rootView;
	}
	
	public void cleanNumberTextView(){
		if(numberTextView != null){
			numberTextView.setText(R.string.not_available_text);
			setMarkerImage();
		}
	}
	
	private void setAndroidImage(){
		if(imageView != null && mContext != null){
			Drawable androidDrawable = mContext.getResources().getDrawable(R.drawable.ic_action_android);
			imageView.setImageDrawable(androidDrawable);
		}
	}
	
	private void setMarkerImage(){
		if(imageView != null && mContext != null)
			imageView.setImageDrawable(mContext.getResources().getDrawable(R.drawable.ic_maps_beenhere));
	}
}