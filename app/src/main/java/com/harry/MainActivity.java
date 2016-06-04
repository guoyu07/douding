package com.harry;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;

import com.harry.bean.Contact;
import com.harry.fragment.Fragment_contacts;
import com.harry.fragment.Fragment_dial;
import com.harry.fragment.Fragment_recent;
import com.harry.fragment.Fragment_sms;

import java.util.ArrayList;

public class MainActivity extends Activity implements OnClickListener {
	
	private ArrayList<Contact> contacts;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.main);

		initView();

		loaddata();

		Fragment_contacts fragment_contacts = new Fragment_contacts();
		fragment_contacts.setData(contacts);
		getFragmentManager().beginTransaction()
				.replace(R.id.fl_content, fragment_contacts).commit();
	}
	//拨号功能
	public void call(View view) {
		// 获取输入的电话号码
		EditText et = (EditText) findViewById(R.id.editText1);
		String mobile = et.getText().toString();
		// 1.新建一个打电话的Intent
		Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:"
				+ mobile));
		System.out.println("123");
		// 2.开打（在AndroidManifest.xml中添加拨打电话的权限）
		startActivity(intent);
		System.out.println("456");
	}

	private void initView() {
		TextView recent = (TextView) findViewById(R.id.tv_recent);
		recent.setOnClickListener(this);
		TextView contacts = (TextView) findViewById(R.id.tv_contacts);
		contacts.setOnClickListener(this);
		TextView sms = (TextView) findViewById(R.id.tv_sms);
		sms.setOnClickListener(this);
		TextView dial = (TextView) findViewById(R.id.tv_dial);
		dial.setOnClickListener(this);
		
	}

	private void loaddata() {
		contacts = new ArrayList<Contact>();

		//for (int i = 0; i < 20; i++) {
			//Contact contact = new Contact();
			//contact.setName("name" + i);
			//contact.setPhonenumber("152031845" + i);
			//contact.setImage(R.drawable.ic_launcher);

			//contacts.add(contact);

		//}
		
		Contact jz=new Contact();
		jz.setName("靳卓");
		jz.setPhonenumber("18231851207");
		jz.setImage(R.drawable.jze);
		
		Contact zxs=new Contact();
		zxs.setName("张萧帅");
		zxs.setPhonenumber("18231852057");
		zxs.setImage(R.drawable.xjp);
		contacts.add(jz);
		contacts.add(zxs);
		
		Contact hl = new Contact();
		hl.setName("韩亮");
		hl.setPhonenumber("18231850970");
		hl.setImage(R.drawable.pj);
		contacts.add(hl);
		Contact dlk =new Contact();
		dlk.setName("董路宽");
		dlk.setPhonenumber("18231851798");
		dlk.setImage(R.drawable.abm);
		contacts.add(dlk);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.tv_recent:
			Fragment_recent fragment_recent = new Fragment_recent();

			fragment_recent.setData(contacts);
			getFragmentManager().beginTransaction()
					.replace(R.id.fl_content, fragment_recent).commit();

			break;
		case R.id.tv_contacts:
			Fragment_contacts fragment_contacts = new Fragment_contacts();
			
			fragment_contacts.setData(contacts);
			getFragmentManager().beginTransaction()
					.replace(R.id.fl_content, fragment_contacts).commit();
			break;
		case R.id.tv_sms:
			Fragment_sms fragment_sms = new Fragment_sms();
			getFragmentManager().beginTransaction()
					.replace(R.id.fl_content, fragment_sms).commit();
			break;
		case R.id.tv_dial:
			Fragment_dial fragment_dial = new Fragment_dial();
			getFragmentManager().beginTransaction()
					.replace(R.id.fl_content, fragment_dial).commit();
			break;
		
		default:
			break;
		}
	}

}
