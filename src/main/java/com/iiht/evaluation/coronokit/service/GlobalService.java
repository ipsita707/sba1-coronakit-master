package com.iiht.evaluation.coronokit.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import com.iiht.evaluation.coronokit.model.*;

public class GlobalService {
	
	public static List<ProductMaster> allProducts = new ArrayList<>();
	public static List<CoronaKit> allUsers = new ArrayList<>();
	public static CopyOnWriteArrayList<KitDetail> kitDetails = new CopyOnWriteArrayList<KitDetail>();

	public void addProducts(String pname, String pcost, String pdesc) {
		ProductMaster productMaster = new ProductMaster();
		productMaster.setId(allProducts.size()+1);
		productMaster.setProductName(pname);
		productMaster.setCost(pcost);
		productMaster.setProductDescription(pdesc);
		
		allProducts.add(productMaster);
		
	}

	public Object getAllProducts() {
		return allProducts;
	}

	public void updateProduct(String pid, String pname, String pcost, String pdesc) {
		
		for(ProductMaster productMaster : allProducts) {
			if(productMaster.getId() == Integer.parseInt(pid)) {
				productMaster.setProductName(pname);
				productMaster.setCost(pcost);
				productMaster.setProductDescription(pdesc);
			}
		}
		
	}
	
	public void addUsers(String pname, String pemail, String pcontact) {
		CoronaKit coronaKit = new CoronaKit();
		coronaKit.setId(allProducts.size()+1);
		coronaKit.setPersonName(pname);
		coronaKit.setEmail(pemail);
		coronaKit.setContactNumber(pcontact);
		
		allUsers.add(coronaKit);
		
	}

	public void addProductToCart(String pid, String quantity) {
		
		KitDetail kitDetail = new KitDetail();
		kitDetail.setId(kitDetails.size()+1);
		kitDetail.setCoronaKitId(allUsers.size());
		kitDetail.setProductId(Integer.parseInt(pid));
		kitDetail.setQuantity(Integer.parseInt(quantity));
		kitDetail.setAmount(Integer.parseInt(getProductById(pid).getCost())*Integer.parseInt(quantity));
		kitDetails.add(kitDetail);
		
	}
	
	public ProductMaster getProductById(String pid) {
		for(ProductMaster productMaster : allProducts) {
			if(productMaster.getId() == Integer.parseInt(pid)) {
				return productMaster;
			}
		}
		return null;
	}

	public List<KitDetail> viewCart() {
		return kitDetails;
	}

	public void updateKart(String pid) {
		
		for(KitDetail kitDetail : kitDetails) {
			if(Integer.parseInt(pid) == kitDetail.getProductId()) {
				kitDetails.remove(kitDetail);
			}
		}
		
	}

}
