package com.harry;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

public class Welcome extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.first);
		
		View view = findViewById(R.id.iv_welcome);
		
		AlphaAnimation animation=new AlphaAnimation(0.3f, 0.7f);
		animation.setDuration(3000);
		
		view.setAnimation(animation);
		
		animation.setAnimationListener(new AnimationListener() {
			
			@Override
			public void onAnimationStart(Animation animation) {
				
			}
			
			@Override
			public void onAnimationRepeat(Animation animation) {
				
			}
			
			@Override
			public void onAnimationEnd(Animation animation) {
				
				Intent intent=new Intent(Welcome.this,Login.class);
				startActivity(intent);
				finish();
			}
			
		});
	}
}
