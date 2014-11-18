package com.tcxy.db;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class LoginUi extends Activity {
	private TextView textView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sucess);
		Intent intent =getIntent();//获得Intent
		String name=intent.getStringExtra("name");
		textView=(TextView) findViewById(R.id.tv_text);
		textView.setText("恭喜"+name+"登录成功");
		
	}
}
