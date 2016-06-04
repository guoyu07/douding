package com.harry.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.harry.Detail_sms;
import com.harry.New_sms;
import com.harry.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Fragment_sms extends Fragment implements OnClickListener {
	private View smsView;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		smsView = inflater.inflate(R.layout.fragment_sms, null, false);
		return smsView;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		ListView lv_sms = (ListView) smsView.findViewById(R.id.lv);
		super.onActivityCreated(savedInstanceState);
		initView();

		final List<Map<String, String>> data = new ArrayList<Map<String, String>>();
		HashMap<String, String> line1 = new HashMap<String, String>();
		line1.put("name", "10010");
		line1.put("context", "温馨提示:截止11月21日9时,您当月流量已用280MB,剩余0.00MB,3G...");
		data.add(line1);
		
		HashMap<String, String> line2 = new HashMap<String, String>();
		line2.put("name", "18631819090");
		line2.put("context", "年长年长,开心就好;钱多钱少,够用就好;位高位低,健康就好;家贫家富,和气就好;有烦有恼，理解就好;在家在外,平安就好...");
		data.add(line2);
		
		HashMap<String, String> line3 = new HashMap<String, String>();
		line3.put("name", "106557950318");
		line3.put("context", "1G全国流量半年1元抢，下手越早价格越低。11月10日上午9点登录移动网上...");
		data.add(line3);
		
		HashMap<String, String> line4 = new HashMap<String, String>();
		line4.put("name", "106557950318");
		line4.put("context","温馨提示:截止11月21日9时,您当月流量已用280MB,剩余0.00MB,3G...");
		data.add(line4);
		
		HashMap<String, String> line5 = new HashMap<String, String>();
		line5.put("name", "106557950318");
		line5.put("context","1G全国流量半年1元抢，下手越早价格越低。11月10日上午9点登录移动网上..");
		data.add(line5);
				
		HashMap<String, String> line6 = new HashMap<String, String>();
		line6.put("name", "100867701102809");
		line6.put("context", "10分满意,源自百分努力,感谢您使用短信营业厅!请回复数字对我们的服务进行评价:10非常满意9很满意8满意7不满意...");
		data.add(line6);
		
		HashMap<String, String> line7 = new HashMap<String, String>();
		line7.put("name", "10657120794900");
		line7.put("context", "【三只松鼠】主人,昨晚强累了吧？要对自己好点呦，买点年前最底价的坚果常常吧!taobao://sanzhisongshu.tmall.com");
		data.add(line7);

		SimpleAdapter adapter = new SimpleAdapter(getActivity(), data,
				R.layout.item_sms, new String[] { "name", "context" },
				new int[] { R.id.tv_sms_name, R.id.tv_sms_content });

		ListView lv = (ListView) smsView.findViewById(R.id.lv_sms);
		lv.setAdapter(adapter);

		lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				Map<String, String> item = (Map<String, String>) arg0.getItemAtPosition(arg2);
				System.out.println(item.get("name"));
				Intent intent = new Intent();
				intent.setClass(getActivity(), Detail_sms.class);
//				传递参数
				intent.putExtra("name", item.get("name"));
				intent.putExtra("context", item.get("context"));
				
				startActivity(intent);
			}
		});

	}

	private void initView() {
		// TODO Auto-generated method stub
		TextView add = (TextView) smsView.findViewById(R.id.jiahao);
		add.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent intent = new Intent();
		intent.setClass(getActivity(), New_sms.class);
		startActivity(intent);
	}

}
