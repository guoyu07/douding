package com.harry;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Detail_sms extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);

		setContentView(R.layout.detail_sms);

	

		// 联系人接收
		TextView textView = (TextView) findViewById(R.id.tv_detail_sms_to);
		textView.setText(getIntent().getStringExtra("name"));

		// 建list接收短信内容数据
		List<Map<String, String>> data = new ArrayList<Map<String, String>>();
		HashMap<String, String> line1 = new HashMap<String, String>();
		line1.put("c", getIntent().getStringExtra("context"));
		line1.put("d", null);
		data.add(line1);
		// System.out.println("2");
		SimpleAdapter adapter = new SimpleAdapter(this, data,
				R.layout.item_sms_detail_dialog, new String[] { "d", "c" },
				new int[] { R.id.tv_detail_sms_dialog_to,
						R.id.tv_detail_sms_dialog_from });
		ListView lv = (ListView) findViewById(R.id.lv_detail_sms_dialog);
		lv.setAdapter(adapter);
	}

	// 实现发送功能

}
