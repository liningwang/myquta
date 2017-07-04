package com.example.myquta;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class MyQuta extends View {

	int sumx = 0;
	public MyQuta(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}
	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		Paint paint = new Paint();
		paint.setAntiAlias(true);
//		paint.setStyle(Paint.Style.STROKE);
		paint.setColor(Color.RED);
		
		Path path = new Path();
		path.moveTo(20, 40);
		path.quadTo(30, 110, sumx, 40);
		path.lineTo(sumx, 50);
		path.quadTo(30, 110, 20, 50);
		path.close();
		canvas.drawPath(path, paint);
	}
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		switch (event.getAction()) {
		case MotionEvent.ACTION_MOVE:
//			sumx = (int) event.getRawX();//获得整个屏幕的x位置
			sumx = (int) event.getX(); //获得view中x的位置。
			if(sumx < 0) {
				sumx = (int) event.getRawX();
				setX(sumx);
			}
			Log.d("wang"," sum x is " + sumx);
			break;

		default:
			break;
		}
		invalidate();
		return true;
		
	}
	

}
