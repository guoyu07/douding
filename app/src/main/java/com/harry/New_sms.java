package com.harry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class New_sms extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);

		setContentView(R.layout.new_sms);

	}
	public void send(View view){
		EditText et_nsms_to = (EditText) findViewById(R.id.et_nsms_to);
	    EditText et_nsms_content = (EditText) findViewById(R.id.et_nsms_content);
	    String mobile = et_nsms_to.getText().toString();
		String content = et_nsms_content.getText().toString();
		SmsManager smsManager = SmsManager.getDefault();
		ArrayList<String> texts = smsManager.divideMessage(content);
		for (String text : texts) {
			smsManager.sendTextMessage(mobile, null, text, null, null);
		}
		//TextView w=(TextView) findViewById(R.id.tv_sms_to);
		//String s=w.getText().toString();
		String m=  null;
		List<Map<String, String>> data = new ArrayList<Map<String,String>>();
		HashMap<String, String> line1 = new HashMap<String, String>();
		line1.put("a",content);
		line1.put("b",m );
		data.add(line1);
		SimpleAdapter adapter = new SimpleAdapter(this,data,R.layout.item_sms_dialog,
				new String[]{"a","b"},new int[]{R.id.tv_sms_to,R.id.tv_sms_from}); 
		ListView nsms_content = (ListView) findViewById(R.id.nsms_content);
		nsms_content.setAdapter(adapter);
	}
}
