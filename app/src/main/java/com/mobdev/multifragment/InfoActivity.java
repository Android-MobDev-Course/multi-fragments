package com.mobdev.multifragment;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Created by Marco Picone (picone.m@gmail.com) 12/03/2020
 */
public class InfoActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.single_fragment_activity);

		if (savedInstanceState == null) {

			InfoFragment infoFragemnt = null;
				
			Bundle bundle = this.getIntent().getExtras();

			if(bundle != null){
				infoFragemnt = new InfoFragment();
				infoFragemnt.setRandomNumber(bundle.getInt(RandomNumberFragment.INFO_NUMBER_EXTRA,-1));
			}
			else{
				infoFragemnt = new InfoFragment();
				infoFragemnt.setRandomNumber(-1);
			}

			getSupportFragmentManager().beginTransaction().add(R.id.container, infoFragemnt).commit();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
