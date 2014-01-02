package com.dsexample.viewscale;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.Menu;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.TextView;

public class MainActivity extends Activity {

	boolean t1exp = false;
	boolean t2exp = false;
	boolean t3exp = false;
	String TAG = "DSDS";

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

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		final TextView t1 = (TextView) findViewById(R.id.t1);
		t1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (!t1exp) {

					final String text = "dsafdsf  fdsafdsa  dsfdasf  sadfdsfasdf sdfasdfasdf dsfdsafdsa dsfdsafadadfda "
							+ "dsafdsf  fdsafdsa  dsfdasf  sadfdsfasdf sdfasdfasdf dsfdsafdsa dsfdsafadadfda "
							+ "dsafdsf  fdsafdsa  dsfdasf  sadfdsfasdf sdfasdfasdf dsfdsafdsa dsfdsafadadfda "
							+ "dsafdsf  fdsafdsa  dsfdasf  sadfdsfasdf sdfasdfasdf dsfdsafdsa dsfdsafadadfda "
							+ "dsafdsf  fdsafdsa  dsfdasf  sadfdsfasdf sdfasdfasdf dsfdsafdsa dsfdsafadadfda ";

					Log.e(TAG,
							"getHeight = "
									+ getHeight(MainActivity.this, text,
											t1.getTextSize(),
											t1.getMeasuredWidth()));
					//

					int newHight = getHeight(MainActivity.this, text,
							t1.getTextSize(), t1.getMeasuredWidth());

					ResizeAnimation ra = new ResizeAnimation(t1, t1.getWidth(),
							t1.getHeight(), t1.getWidth(), newHight);

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
							t1.setText(text);
						}
					});

					t1.startAnimation(ra);

					t1exp = true;
				} else {
					Log.e(TAG, "Height = " + t1.getMeasuredHeight());
					final String mystring = getResources().getString(
							R.string.hello_world2);
					// t1.setText(R.string.hello_world2);

					int newHight = getHeight(MainActivity.this, mystring,
							t1.getTextSize(), t1.getMeasuredWidth());

					ResizeAnimation ra = new ResizeAnimation(t1, t1.getWidth(),
							t1.getHeight(), t1.getWidth(), newHight);

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
							t1.setText(mystring);
						}
					});

					t1.startAnimation(ra);
					t1exp = false;
				}

			}
		});

		final MyView t2 = (MyView) findViewById(R.id.t2);
		t2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				t2.toggle();

			}
		});

		final TextView t3 = (TextView) findViewById(R.id.t3);
		t3.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (!t3exp) {

					ResizeAnimation ra = new ResizeAnimation(t3, t3.getWidth(),
							t3.getHeight(), t3.getWidth(), t3.getHeight() * 2);
					t3.startAnimation(ra);
					t3exp = true;
				} else {
					ResizeAnimation ra = new ResizeAnimation(t3, t3.getWidth(),
							t3.getHeight(), t3.getWidth(), t3.getHeight() / 2);
					t3.startAnimation(ra);
					t3exp = false;
				}

			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}


}
