package com.dsexample.viewscale;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View.MeasureSpec;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.TextView;

public class MyView extends TextView {

	boolean expanded = false;
	Context context;

	final String text = "dsafdsf  fdsafdsa  dsfdasf  sadfdsfasdf sdfasdfasdf dsfdsafdsa dsfdsafadadfda "
			+ "dsafdsf  fdsafdsa  dsfdasf  sadfdsfasdf sdfasdfasdf dsfdsafdsa dsfdsafadadfda "
			+ "dsafdsf  fdsafdsa  dsfdasf  sadfdsfasdf sdfasdfasdf dsfdsafdsa dsfdsafadadfda "
			+ "dsafdsf  fdsafdsa  dsfdasf  sadfdsfasdf sdfasdfasdf dsfdsafdsa dsfdsafadadfda "
			+ "dsafdsf  fdsafdsa  dsfdasf  sadfdsfasdf sdfasdfasdf dsfdsafdsa dsfdsafadadfda ";

	public MyView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		this.context = context;
	}

	public MyView(Context context) {
		// TODO Auto-generated constructor stub
		super(context);
		this.context = context;
	}

	public void toggle() {
		if (expanded) {
			expanded = false;
			final String stext = "dfasf";
			
			int newHight = getHeight(context, stext,
					getTextSize(), getMeasuredWidth());
			
			ResizeAnimation ra = new ResizeAnimation(this, getWidth(),
					getHeight(), getWidth(), newHight);
			ra.setAnimationListener(new AnimationListener() {

				@Override
				public void onAnimationStart(Animation animation) {
					// TODO Auto-generated method stub

				}

				@Override
				public void onAnimationRepeat(Animation animation) {
					// TODO Auto-generated method stub

				}

				@Override
				public void onAnimationEnd(Animation animation) {
					// TODO Auto-generated method stub
					setText(stext);
				}
			});
			startAnimation(ra);

		} else {
			expanded = true;
			
			int newHight = getHeight(context, text,
					getTextSize(), getMeasuredWidth());
			
			ResizeAnimation ra = new ResizeAnimation(this, getWidth(),
					getHeight(), getWidth(), newHight);
			ra.setAnimationListener(new AnimationListener() {

				@Override
				public void onAnimationStart(Animation animation) {
					// TODO Auto-generated method stub

				}

				@Override
				public void onAnimationRepeat(Animation animation) {
					// TODO Auto-generated method stub

				}

				@Override
				public void onAnimationEnd(Animation animation) {
					// TODO Auto-generated method stub
					setText(text);
				}
			});
			startAnimation(ra);
		}
	}
	
	public static int getHeight(Context context, String text, float textSize,
			int deviceWidth) {
		TextView textView = new TextView(context);
		textView.setTypeface(Typeface.MONOSPACE);
		textView.setText(text);
		textView.setTextSize(TypedValue.COMPLEX_UNIT_PX, textSize);
		int widthMeasureSpec = MeasureSpec.makeMeasureSpec(deviceWidth,
				MeasureSpec.AT_MOST);
		int heightMeasureSpec = MeasureSpec.makeMeasureSpec(0,
				MeasureSpec.UNSPECIFIED);
		textView.measure(widthMeasureSpec, heightMeasureSpec);

		return textView.getMeasuredHeight();
	}

}
