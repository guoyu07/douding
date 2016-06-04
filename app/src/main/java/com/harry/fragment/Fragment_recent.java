package com.harry.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.harry.R;
import com.harry.bean.Contact;

import java.util.ArrayList;

public class Fragment_recent extends Fragment{
	private ArrayList<Contact> contacts;
	private View recentView;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		recentView=inflater.inflate(R.layout.fragment_1_3, null, false);
	
		return recentView;
	}
@Override
public void onActivityCreated(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onActivityCreated(savedInstanceState);
	
	System.out.println("Fragment_recent");
	
	ListView lv_recent=(ListView) recentView.findViewById(R.id.lv);
	
	MyAdapter adapter=new MyAdapter();
	lv_recent.setAdapter(adapter);
	
	
	
}





class MyAdapter extends BaseAdapter
{

	@Override
	public int getCount() {
		return contacts.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View view=View.inflate(getActivity(), R.layout.item_recent , null);
		
		ImageView icon=(ImageView) view.findViewById(R.id.iv_icon);
		TextView rname=(TextView) view.findViewById(R.id.tv_rname);
		TextView rphonenumber=(TextView) view.findViewById(R.id.tv_rphonenumber);
		
		Contact contact=contacts.get(position);
		
		icon.setImageResource(contact.getImage());
		rname.setText(contact.getName());
		rphonenumber.setText(contact.getPhonenumber());
		
		return view;
	}
	}





public void setData(ArrayList<Contact> contacts2) {
	this.contacts=contacts2;
	
}


}
