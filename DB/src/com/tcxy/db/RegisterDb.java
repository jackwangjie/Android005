package com.tcxy.db;

import com.tcxy.Dao.ContactService;
import com.tcxy.domain.Contact;
import com.tcxy.service.Impl.ContactServiceImpl;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterDb extends Activity{
	
	private EditText et_name;
	private EditText et_pwd;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.register);
		et_name=(EditText) findViewById(R.id.et_name1);
		et_pwd=(EditText) findViewById(R.id.et_pwd1);
	}
	
	
	public void ok(View view) throws InterruptedException{
		
		ContactService a=new ContactServiceImpl(this);
		Contact contact =new Contact(et_name.getText().toString().trim(), et_pwd.getText().toString().trim());
		
		
		if(a.insert(contact))
		{
			Toast.makeText(this, "注册成功，回到登录界面", Toast.LENGTH_LONG).show();
			Intent intent =new Intent(this, MainActivity.class);
			startActivity(intent);
		}
		else
			Toast.makeText(this, "注册失败！", Toast.LENGTH_LONG).show();
		
	}
	public void no(View view){
		
		Intent intent2 =new Intent(this, MainActivity.class);
		startActivity(intent2);
	}

}
