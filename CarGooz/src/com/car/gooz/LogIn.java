package com.car.gooz;

import com.car.gooz.Welcome;
import com.car.gooz.Register;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class LogIn extends Activity {

	TextView l;
	private static Button btn;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.login);
		
		
		l = (TextView)findViewById(R.id.login_btn);
		l.setOnClickListener(new OnClickListener() {
			
			public void onClick(View arg0) {
//				
//				
//				
				Intent i = new Intent(LogIn.this,Welcome.class);
				startActivity(i);
//				
			}
			
			
				
		
		
		});
		
		btn = (Button)findViewById(R.id.button1);
        btn.setOnClickListener(btnDoneOnClick);

	}
	
	  private final Button.OnClickListener btnDoneOnClick= new Button.OnClickListener()
      {
    	  public void onClick(View V)
    	  {
    		  Intent i = new Intent(LogIn.this,Register.class);
				startActivity(i);
    		//  finish();
    	  }
      };
}
