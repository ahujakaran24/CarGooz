package com.car.gooz;

import java.util.Iterator;
import java.util.Vector;





import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.view.Display;
import android.view.SurfaceHolder;
import android.view.WindowManager;

import com.car.gooz.Car;
import com.car.gooz.Goose;
import com.car.gooz.Package;

public class SurfaceThread extends Thread
{

	private boolean Running;
	private SurfaceHolder 	TheSurfaceHolder;
	private SurfacePanel		TheSurfacePanel;

	private Car TheCar;
	private Goose TheGoose;
	private Package Pack;
	
	
	
	
	private float a=500,b=600;
	

	public SurfaceThread(SurfaceHolder surfaceHolder, SurfacePanel SurfacePanel, Context context)
	{

		
		Bitmap CarBitmap = (BitmapFactory.decodeResource(context.getResources(), R.drawable.car));
		TheCar = new Car(CarBitmap,200,700);
		

		Bitmap GooseBitmap = (BitmapFactory.decodeResource(context.getResources(), R.drawable.goose));
		TheGoose = new Goose(GooseBitmap,100,100);
		
		
		Bitmap PackBitmap = (BitmapFactory.decodeResource(context.getResources(), R.drawable.pack));
		Pack = new Package(PackBitmap,800,750);
		
		

		
		TheSurfaceHolder = surfaceHolder;
		TheSurfacePanel = SurfacePanel;
		Running = false;
	}
	
	@SuppressLint("WrongCall") @Override
	public void run()
	{
		Canvas canvas;
		while (Running)
		{
			if(!TheSurfaceHolder.getSurface().isValid())
			{
				continue;
			}
			
			canvas = null;
			
			try
			{	
				canvas = TheSurfaceHolder.lockCanvas(null);
				synchronized(TheSurfaceHolder)
				{
				
				
					
					if(canvas!=null){
					TheSurfacePanel.onDraw(canvas);
					
					canvas.drawBitmap(TheCar.GetBitmap(), TheCar.GetFrame(), TheCar.GetDestination(), null);
					
					canvas.drawBitmap(TheGoose.GetBitmap(), TheGoose.GetFrame(), TheGoose.GetDestination(), null);
					

					
					for(int i=0; i<10; i++)
					{
						TheGoose.y+=0.3;
						TheGoose.x+=0.5;
						TheGoose.Update();
						if(TheGoose.x>=750)
						{
							canvas.drawBitmap(Pack.GetBitmap(), Pack.GetFrame(), Pack.GetDestination(), null);
							for(int j=0; j<5; j++)
							{
								Pack.x-=.25;
								Pack.Update();
								if(Pack.x<=600)
								{
									Pack.setX(600);
								}
							}

						}
					}
					}
				}
			
			}
			finally
			{
				if(canvas != null)
				{
					TheSurfaceHolder.unlockCanvasAndPost(canvas);
				}
			}
		}
	}
	
	public void SetRunning(boolean Run)
	{		
		Running = Run;
	}
}
