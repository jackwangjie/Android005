package com.tcxy.db;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.tcxy.Dao.ContactService;
import com.tcxy.domain.Contact;
import com.tcxy.service.Impl.ContactServiceImpl;

public class MainActivity extends Activity {

	private EditText et_name;
	private EditText et_pwd;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		et_name=(EditText) findViewById(R.id.et_name);
		et_pwd=(EditText) findViewById(R.id.et_pwd);

	}


	public void login(View view){

		Contact contact =new Contact(et_name.getText().toString().trim(), et_pwd.getText().toString().trim());
		ContactService c =new ContactServiceImpl(this);
		List<Contact> contacts=c.query();
		if(contacts.contains(contact))
		{
			Intent intent = new Intent();
			intent.putExtra("name", et_name.getText().toString().trim());
			intent.setClass(this, LoginUi.class);
			startActivity(intent);

		}else{
		Toast.makeText(this, "用户名或者密码错误", Toast.LENGTH_LONG).show();}

	}

	public void register(View view){

		Intent intent =new Intent(this, RegisterDb.class);
		startActivity(intent);


	}


}
