package com.dutycalls.lite;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
//Shahiq
public class Login_activity extends Activity {

	Button btn_login;
	TextView txt_newUser;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		btn_login = (Button) findViewById(R.id.login_btn_login);
		txt_newUser = (TextView) findViewById(R.id.login_newuser);
		btn_login.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				startActivity(new Intent(Login_activity.this,Home_activity.class));
				
			}
		});
		txt_newUser.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				startActivity(new Intent(Login_activity.this,New_User_activity.class));
				
			}
		});
	}
}
