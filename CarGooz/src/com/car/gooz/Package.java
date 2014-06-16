package com.car.gooz;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.GestureDetector;


public class Package {
	
	 public static float x; //cooirdinates
	 public static float y;
	 private Bitmap img; //bitmap
	 private static GestureDetector gestureDetector;
	 protected RectF Destination;
	 private Rect Frame;
	 private int Fw, Fh;
	 private float w,h;
	 
	 public Package(Bitmap img, float x, float y)
	 {
		    this.img=img;
			this.x = x;
	        this.y = y;
	        
	        Fw = img.getWidth();
	        Fh = img.getHeight();
	        w = 120.0f;
	        h = 135.0f;
	        SetDestination();
	 }


	 public void Update()
	 {
		 SetDestination();
	 }
	 
	 public void SetImg(Bitmap bitmap)
	 {
		 img = bitmap;
	 }
	 
	 protected void SetDestination()	// Sets the size of the destination rectangle.
	{
		Destination = new RectF  (	(x - w),		// Left.	Getting the coords for the rect like this allows 
									(y - h),		// Top.		for scaling from the center
									(x + w), 		// Right.
									(y + h));		// Bottom.
		
		
	}
				    
	    protected void SetFrame()	// Sets the size of the frame rectangle.
		{
			Frame = new Rect(0, 0, Fw, Fh);
		}
						
				 
	 /** @return the horizontal coordinate. */
	    public float getX() { return x; }

	    /** @return the vertical coordinate. */
	    public float getY() { return y; }
	    
	    public void setX(float newx) { x=newx; }
	    
	    public void setY(float newy) { y=newy; }
	    
	    public Bitmap GetBitmap() { return img; }
	    
	    public Rect GetFrame() { return Frame; }
	    
	    public RectF GetDestination() { return Destination; }

}
