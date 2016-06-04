package com.harry;



import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.harry.bean.Contact;

public class Detail_contact extends Activity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);

		setContentView(R.layout.detail_contact);
		Contact contact = (Contact) getIntent().getSerializableExtra("contact");
		
		TextView textView=(TextView) findViewById(R.id.tv_detail_name);
		textView.setText(contact.getName());
		TextView textView2=(TextView) findViewById(R.id.tv_detail_phonenumber);
		textView2.setText(contact.getPhonenumber());
		ImageView imageView=(ImageView) findViewById(R.id.iv_detail_conimg);
		imageView.setImageResource(contact.getImage());
	}

}
