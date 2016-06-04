package com.harry.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.harry.Detail_contact;
import com.harry.R;
import com.harry.bean.Contact;

import java.util.ArrayList;

public class Fragment_contacts extends Fragment {
    private View rootView;
    private ArrayList<Contact> contacts;
    PopupWindow pwindow;
    Handler handler = new Handler();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_1_3, null, false);
        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onActivityCreated(savedInstanceState);
        ListView lv_contacts = (ListView) rootView.findViewById(R.id.lv);

        MyAdapter adapter = new MyAdapter();
        lv_contacts.setAdapter(adapter);
        initView();

    }

    private void initView() {

    }


    class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            // TODO Auto-generated method stub
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
            // TODO Auto-generated method stub
            View view = View.inflate(getActivity(), R.layout.item_contacts,
                    null);

            TextView cname = (TextView) view.findViewById(R.id.tv_c_name);

            TextView cphonenumber = (TextView) view
                    .findViewById(R.id.tv_c_phonenumber);
            ImageButton cimage = (ImageButton) view
                    .findViewById(R.id.imb_c_image);

            final Contact contact = contacts.get(position);
            cimage.setImageResource(contact.getImage());
            cname.setText(contact.getName());
            cphonenumber.setText(contact.getPhonenumber());

            // 设置popwindow

            ImageButton imb_c_image = (ImageButton) view
                    .findViewById(R.id.imb_c_image);
            View view2 = View.inflate(getActivity(), R.layout.popwindow, null);
            view.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub
                    pwindow.dismiss();
                }
            });
            pwindow = new PopupWindow(view2);
            pwindow.setWindowLayoutMode(ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT);

            pwindow.getContentView().setOnTouchListener(new OnTouchListener() {

                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    pwindow.setFocusable(false);//失去焦点
                    pwindow.dismiss();//消除pw
                    return true;

                }
            });
            imb_c_image.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                    System.out.println("imb_c_image:click");
                    try {
                        if (pwindow.isShowing()) {
                            pwindow.dismiss();
                        }

                        pwindow.showAsDropDown(v);
                        pwindow.setFocusable(true);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
            });

            // 设置跳转详细联系人

            View view1 = view.findViewById(R.id.todetail);
            view1.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                    jump(contact);
                }
            });

            return view;
        }
    }

    public void setData(ArrayList<Contact> contacts) {
        // TODO Auto-generated method stub
        this.contacts = contacts;
    }

    private void jump(Contact contact) {

        Intent intent = new Intent();
        intent.setClass(getActivity(), Detail_contact.class);
        intent.putExtra("contact", contact);
        startActivity(intent);
    }

}
