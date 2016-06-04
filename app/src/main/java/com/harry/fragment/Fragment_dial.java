package com.harry.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;

import com.harry.R;

public class Fragment_dial extends Fragment {
	private View dialView;
	Button b1, b2, b3;
	Button b4, b5, b6, b7, b8, b9, b0, b14;
	static String forshow = "";
	private EditText et;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		dialView = inflater.inflate(R.layout.fragment_dial, null, false);
		return dialView;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {

		super.onActivityCreated(savedInstanceState);
		View view = View.inflate(getActivity(), R.layout.item_contacts, null);
		FrameLayout fg_dial = (FrameLayout) dialView.findViewById(R.id.fg_dial);
		// 实现功能
		b1 = (Button) dialView.findViewById(R.id.button1);
		b1.setOnClickListener(listener);
		b2 = (Button) dialView.findViewById(R.id.button2);
		b2.setOnClickListener(listener);
		b3 = (Button) dialView.findViewById(R.id.button3);
		b3.setOnClickListener(listener);
		b4 = (Button) dialView.findViewById(R.id.button4);
		b4.setOnClickListener(listener);

		b5 = (Button) dialView.findViewById(R.id.button5);
		b5.setOnClickListener(listener);
		b6 = (Button) dialView.findViewById(R.id.button6);
		b6.setOnClickListener(listener);
		b7 = (Button) dialView.findViewById(R.id.button7);
		b7.setOnClickListener(listener);
		b8 = (Button) dialView.findViewById(R.id.button8);
		b8.setOnClickListener(listener);
		b9 = (Button) dialView.findViewById(R.id.button9);
		b9.setOnClickListener(listener);
		Button b10 = (Button) dialView.findViewById(R.id.button10);
		b10.setOnClickListener(listener);

		Button b11 = (Button) dialView.findViewById(R.id.button11);
		b11.setOnClickListener(listener);
		Button b12 = (Button) dialView.findViewById(R.id.button12);
		b12.setOnClickListener(listener);
		et = (EditText) dialView.findViewById(com.harry.R.id.editText1);
		et.setOnClickListener(listener);
		b14 = (Button) dialView.findViewById(R.id.button14);
		b14.setOnClickListener(listener);

	}

	

	OnClickListener listener = new OnClickListener() {
		public void onClick(View v) {
			View view = v;
			if (view.getId() == com.harry.R.id.button1) {
				forshow = forshow + "1";
				et.setText(forshow);
			} else if (view.getId() == com.harry.R.id.button2) {
				forshow = forshow + "2";
				et.setText(forshow);
			} else if (view.getId() == com.harry.R.id.button3) {
				forshow = forshow + "3";
				et.setText(forshow);
			}

			else if (view.getId() == com.harry.R.id.button4) {
				forshow = forshow + "4";
				et.setText(forshow);
			} else if (view.getId() == com.harry.R.id.button5) {
				forshow = forshow + "5";
				et.setText(forshow);
			} else if (view.getId() == com.harry.R.id.button6) {
				forshow = forshow + "6";
				et.setText(forshow);
			} else if (view.getId() == com.harry.R.id.button7) {
				forshow = forshow + "7";
				et.setText(forshow);
			} else if (view.getId() == com.harry.R.id.button8) {
				forshow = forshow + "8";
				et.setText(forshow);
			} else if (view.getId() == com.harry.R.id.button9) {
				forshow = forshow + "9";
				et.setText(forshow);
			} else if (view.getId() == com.harry.R.id.button11) {
				forshow = forshow + "0";
				et.setText(forshow);
			} else if (view.getId() == com.harry.R.id.button12) {
				forshow = forshow + "#";
				et.setText(forshow);
			} else if (view.getId() == com.harry.R.id.button10) {
				forshow = forshow + "*";
				et.setText(forshow);
			} else if (view.getId() == com.harry.R.id.button14) {
				forshow = "";
				et.setText(forshow);
			}

		}
	};
}
