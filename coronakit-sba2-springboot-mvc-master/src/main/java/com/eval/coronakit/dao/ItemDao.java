package com.eval.coronakit.dao;


import java.util.List;

import com.eval.coronakit.entity.Item;
import com.eval.coronakit.entity.User;

public interface ItemDao {

	Item add(Item item) throws Exception;
	Item save(Item item) throws Exception;
	boolean deleteById(Integer icode) throws Exception;
	
	Item getById(Integer icode) throws Exception;
	List<Item> getAll() throws Exception;
	User insertUserDetails(User user) throws Exception;
	User getUserDetails() throws Exception;
	
	
}
