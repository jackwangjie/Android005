package com.tcxy.service.Impl;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.tcxy.Dao.ContactService;
import com.tcxy.db.dbhelper.ContactDbHelper;
import com.tcxy.domain.Contact;

public class ContactServiceImpl implements ContactService{

	private ContactDbHelper contactDbHelper  =null;

	private SQLiteDatabase db = null;

	public ContactServiceImpl(Context context){

		contactDbHelper = new ContactDbHelper(context, "wj.db", null, 1);
	}


	@Override
	public boolean insert(Contact contact) {
		db = contactDbHelper.getWritableDatabase();
		ContentValues contentValues =new ContentValues();
		contentValues.put("name",contact.getName());
		contentValues.put("pwd", contact.getPwd());

		Long id = db.insert("wj",null, contentValues);
		if(id==-1){

			return false;
		}
		db.close();
		return true;
	}

	@Override
	public boolean delete(String name) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Contact> query() {
		
		db=contactDbHelper.getReadableDatabase();
		Cursor cursor=db.query("wj", null, null, null, null, null, null);
		
		List<Contact> contacts =new ArrayList<Contact>();
		while(cursor.moveToNext()){
			String name =cursor.getString(cursor.getColumnIndex("name"));
			String pwd =cursor.getString(cursor.getColumnIndex("pwd"));
			Contact contact =new Contact(name, pwd);
			contacts.add(contact);
		}
		cursor.close();
		db.close();
		return contacts;
	}

}
