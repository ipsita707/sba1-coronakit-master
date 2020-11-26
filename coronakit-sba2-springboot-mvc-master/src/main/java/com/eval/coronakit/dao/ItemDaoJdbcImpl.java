package com.eval.coronakit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.eval.coronakit.entity.Item;
import com.eval.coronakit.entity.User;
@Service
public class ItemDaoJdbcImpl implements ItemDao {

	public static final String INS_ITEM_QRY = "INSERT INTO item(title,unit,price) values(?,?,?)";
	public static final String UPD_ITEM_QRY = "UPDATE item SET title=?,unit=?,price=? WHERE icode=?";
	public static final String DEL_ITEM_QRY = "DELETE FROM item WHERE id=?";
	public static final String SEL_ITEM_QRY_BY_ID = "SELECT id,title,unit,price FROM item WHERE id=?";
	public static final String SEL_ALL_ITEMS_QRY = "SELECT id,title,unit,price FROM item";
	public static final String INS_USER_QRY="INSERT INTO user(name,email,address,phone) values(?,?,?,?)";
	public static final String GET_USER_DETAILS = "SELECT name,email,address,phone FROM user order by id desc limit  1 ";
			
	@Override
	public Item add(Item item) throws Exception {
		if (item != null) {
			try (Connection con = ProductMasterDao.getConnection();
					PreparedStatement pst = con.prepareStatement(INS_ITEM_QRY)) {

				pst.setString(1, item.getTitle());
				pst.setString(2, item.getUnit());
				pst.setInt(3, item.getPrice());

				pst.executeUpdate();

			} catch (SQLException exp) {
				exp.printStackTrace();
				throw new Exception("Saving the item failed!");
			}
		}
		return item;
	}

	@Override
	public Item save(Item item) throws Exception {
		if (item != null) {
			try (Connection con = ProductMasterDao.getConnection();
					PreparedStatement pst = con.prepareStatement(UPD_ITEM_QRY)) {

				/*
				 * pst.setString(1, item.getTitle()); pst.setDate(2,
				 * Date.valueOf(item.getPackageDate())); pst.setBoolean(3, item.getFragile());
				 * pst.setString(4, item.getUnit()); pst.setDouble(5, item.getCostPrice());
				 * pst.setDouble(6, item.getSellingPrice()); pst.setInt(7, item.getIcode());
				 */

				pst.executeUpdate();

			} catch (SQLException exp) {
				exp.printStackTrace();
				throw new Exception("Saving the item failed!");
			}
		}
		return item;
	}

	@Override
	public boolean deleteById(Integer icode) throws Exception {
		boolean isDeleted = false;
		try (Connection con = ProductMasterDao.getConnection();
				PreparedStatement pst = con.prepareStatement(DEL_ITEM_QRY)) {

			pst.setInt(1, icode);

			int rowsCount = pst.executeUpdate();

			isDeleted = rowsCount > 0;

		} catch (SQLException exp) {
			exp.printStackTrace();
			throw new Exception("Deleting the item failed!");
		}

		return isDeleted;
	}

	@Override
	public Item getById(Integer icode) throws Exception {
		Item item = null;

		try (Connection con = ProductMasterDao.getConnection();
				PreparedStatement pst = con.prepareStatement(SEL_ITEM_QRY_BY_ID)) {

			pst.setInt(1, icode);

			ResultSet rs = pst.executeQuery();


		} catch (SQLException exp) {
			exp.printStackTrace();
			throw new Exception("Retrival the item failed!");
		}

		return item;
	}

	@Override
	public List<Item> getAll() throws Exception {
		List<Item> items = new ArrayList<>();

		try (Connection con = ProductMasterDao.getConnection();
				PreparedStatement pst = con.prepareStatement(SEL_ALL_ITEMS_QRY)) {

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				Item item = new Item();
				item.setId(rs.getInt(1));
				item.setTitle(rs.getString(2));
				item.setUnit(rs.getString(3));
				item.setPrice(rs.getInt(4));
				items.add(item);
			}

			if (items.isEmpty()) {
				items = null;
			}
		} catch (SQLException exp) {
			exp.printStackTrace();
			throw new Exception("Retrival the item failed!");
		}
		return items;
	}
	
	
@Override
public User insertUserDetails(User user) throws Exception {
	if (user != null) {
		try (Connection con = ProductMasterDao.getConnection();
				PreparedStatement pst = con.prepareStatement(INS_USER_QRY)) {

			pst.setString(1, user.getName());
			pst.setString(2, user.getEmail());
			pst.setString(3, user.getAddress());
			pst.setInt(4, user.getPhone());

			pst.executeUpdate();

		} catch (SQLException exp) {
			exp.printStackTrace();
			throw new Exception("Saving the user failed!");
		}
	}
	return user;
}


@Override
public User getUserDetails() throws Exception {
	User user = null;

	try 
	{
		Connection con = ProductMasterDao.getConnection();
			PreparedStatement pst = con.prepareStatement(GET_USER_DETAILS);

		ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				user = new User();
			
				user.setName(rs.getNString(1));
				user.setEmail(rs.getString(2));
				user.setAddress(rs.getString(3));
				user.setPhone(rs.getInt(4));
			
			}


	} catch (SQLException exp) {
		exp.printStackTrace();
		throw new Exception("Retrival the item failed!");
	}

	return user;
}

}
