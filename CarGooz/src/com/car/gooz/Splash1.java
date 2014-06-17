package com.car.gooz;

import java.util.Timer;
import java.util.TimerTask;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.GestureDetector;
import android.view.Menu;

import com.car.gooz.Car;
import com.car.gooz.Goose;
import com.car.gooz.SurfacePanel;



public class Splash1 extends Activity {
	
	private Goose g; 
	private Timer t;
	boolean check=true;
	
	Context context;
	Canvas canvas;
	
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        
        
       // setContentView(R.layout.splash1);
        setContentView(new SurfacePanel(this));
        
       
		
		
        
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
            	startActivity(new Intent(getApplicationContext(), Welcome.class));
            }
        }, 4000);
        
    }

	 
	
	
	    

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.welcome, menu);
        return true;
    }

}
