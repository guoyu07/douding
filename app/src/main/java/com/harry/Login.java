package com.harry;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;


	public class Login extends Activity {
		
		private String[][] data = new String[2][3];//每一行代表一个用户
		EditText user;
		EditText psw;


		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.login);
			data[0] = new String[3];
			data[0][0]="123";//第一列代表用户名
			data[0][1]="123";//第二列代表密码
			data[0][2]="0";//第三列代表是否记住密码（0记住/1不记住）
			data[1] = new String[3];
			data[1][0]="234";
			data[1][1]="234";
			data[1][2]="1";
			//获取EditText
			user=(EditText) findViewById(R.id.et_uers);
			psw=(EditText) findViewById(R.id.et_pwd);
			System.out.println("shuzu");
			//绑定控件
			user.setOnFocusChangeListener(linsterzh);
			System.out.println("jianting");
			//获取复选框
			CheckBox jz=(CheckBox) findViewById(R.id.cb_jizhu);
			CheckBox zd=(CheckBox) findViewById(R.id.cb_zidong);
			//绑定控件
			jz.setOnCheckedChangeListener(linsterjz);
			zd.setOnCheckedChangeListener(linsterzd);
			//获取按钮
			ImageView bt=(ImageView) findViewById(R.id.img_denglu);
			//绑定监听器
			bt.setOnClickListener(linsterbt);
		}
		
			OnFocusChangeListener linsterzh=new OnFocusChangeListener() {
				
				@Override
				public void onFocusChange(View v, boolean hasFocus) {
					//记住密码状态下，输入帐号，自动填充密码
					String use=user.getText().toString();
					for(int i=0;i<data.length;i++){
						if(data[i][0].equals(use)&&data[i][2].equals("0"))
							{psw.setText(data[i][1]);break;}
						else
							psw.setText("");
					}
					
				}
			};
			//登录按钮的监听器
			OnClickListener linsterbt = new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					String use=user.getText().toString();
					String passw=psw.getText().toString();
					int i;
					if(use.equals("")) Toast.makeText(getApplicationContext(),"用户名不能为空",Toast.LENGTH_LONG).show();
					else if(passw.equals("")) Toast.makeText(getApplicationContext(),"密码不能为空",Toast.LENGTH_LONG).show();
						else
							{for(i=0;i<data.length;i++)
								if(use.equals(data[i][0])&&passw.equals(data[i][1])){
									//1.新建Intent
									Intent intent = new Intent();
									//2.设置Intent参数
									intent.setClass(Login.this, MainActivity.class);
									//3.启动跳转(在跳转前一定要在AndroidManifest.xml中注册2个Activity)
									startActivity(intent);
									finish();
									break;
								}
							if(i==data.length)
								Toast.makeText(getApplicationContext(),"用户名或密码错误",Toast.LENGTH_LONG).show();	
							}
				}
			};
			
			//记住密码复选框的监听器
			OnCheckedChangeListener linsterjz=new OnCheckedChangeListener() {
				
				@Override
				public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
					String use=user.getText().toString();
					if(isChecked==true){	
						for(int i=0;i<data.length;i++)
							if(data[i][0].equals(use))
								data[i][2]="0";			
					else
						for(i=0;i<data.length;i++)
							if(data[i][0].equals(use))
								data[i][2]="1";
					}
				}
			};
			
			//自动登录复选框的监听器
			OnCheckedChangeListener linsterzd=new OnCheckedChangeListener() {
				
				@Override
				public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
					
					
				}
			};
			
			//注册功能
			public void zhuce(View view){
				
			}
			//忘记密码
			public void wangji(View view){
				
			}
			
			
			


		
	}


