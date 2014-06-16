package com.car.gooz;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class SurfacePanel extends SurfaceView implements SurfaceHolder.Callback

{
	private SurfaceThread TheThread;
	
	public SurfacePanel(Context context) 
	{
		super(context);
		
		setFocusable(true);
		getHolder().addCallback(this);
		TheThread = new SurfaceThread(getHolder(), this, context);
	}
	
	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) 
	{
		TheThread.SetRunning(true);
		TheThread.start();
		
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		boolean Retry = true;
		TheThread.SetRunning(false);
		
		while(Retry)
		{
			try
			{
				Retry = false;
				TheThread.join();
			}
			catch(InterruptedException e)
			{
				
			}
		}
	}
	
	@Override
	protected void onDraw(Canvas canvas)
	{
		canvas.drawColor(Color.WHITE);
	}

}
