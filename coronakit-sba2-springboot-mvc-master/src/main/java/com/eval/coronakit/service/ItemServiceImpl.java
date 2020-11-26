package com.eval.coronakit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eval.coronakit.dao.ItemDao;
import com.eval.coronakit.dao.ItemDaoJdbcImpl;
import com.eval.coronakit.entity.Item;
import com.eval.coronakit.entity.User;

@Service
public class ItemServiceImpl implements ItemService {
     
	@Autowired
	ItemDao itemDao;

	public ItemServiceImpl() {
		itemDao = new ItemDaoJdbcImpl();
	}

	@Override
	public Item validateAndAdd(Item item) throws Exception {
		if (item != null) {
			itemDao.add(item);
		}
		return item;
	}

	@Override
	public Item validateAndSave(Item item) throws Exception {
		if (item != null) {
			itemDao.save(item);
		}
		return item;
	}

	@Override
	public boolean deleteItem(int icode) throws Exception {
		return itemDao.deleteById(icode);
	}

	@Override
	public Item getItemById(int icode) throws Exception {
		return itemDao.getById(icode);
	}

	@Override
	public List<Item> getAllItems() throws Exception {
		return itemDao.getAll();
	}

	@Override
	public User insertUserDetail(User user) throws Exception {
		return itemDao.insertUserDetails(user);
	}

	
	
	@Override
	public User getUserDetails() throws Exception {
		return itemDao.getUserDetails();
	}

	
}
