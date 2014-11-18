package com.tcxy.Dao;

import java.util.List;

import com.tcxy.domain.Contact;


public interface ContactService {

	boolean insert(Contact contact);

	boolean delete(String name);

	List<Contact> query();

}
