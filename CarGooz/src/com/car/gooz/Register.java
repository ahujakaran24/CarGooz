package com.car.gooz;

import com.car.gooz.Welcome;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Register extends Activity {

	TextView l;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.register);
		
		
		l = (TextView)findViewById(R.id.register_btn);
		l.setOnClickListener(new OnClickListener() {
			
			public void onClick(View arg0) {
//				
//				
//				
				Intent i = new Intent(Register.this,Welcome.class);
				startActivity(i);
//				
			}
			
			
				
		
		
		});
		
		

	}
	
	 

}
