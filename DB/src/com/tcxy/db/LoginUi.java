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
		Intent intent =getIntent();//���Intent
		String name=intent.getStringExtra("name");
		textView=(TextView) findViewById(R.id.tv_text);
		textView.setText("��ϲ"+name+"��¼�ɹ�");
		
	}
}
