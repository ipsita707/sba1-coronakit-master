package com.eval.coronakit.service;

import java.util.List;

import com.eval.coronakit.entity.Item;
import com.eval.coronakit.entity.User;

public interface ItemService {

	Item validateAndAdd(Item item) throws Exception;

	Item validateAndSave(Item item) throws Exception;

	boolean deleteItem(int icode) throws Exception;

	Item getItemById(int icode) throws Exception;

	List<Item> getAllItems() throws Exception;
	
	User insertUserDetail(User user) throws Exception;
	
	//to show userkit details on showkit page
	User getUserDetails() throws  Exception;
	
	
	
}
