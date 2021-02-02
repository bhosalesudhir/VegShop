package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IShopperDao;
import com.app.pojos.Vegetables;

@Service
@Transactional
public class ShopperServiceImpl implements IShopperService {

	@Autowired
	private IShopperDao dao;

	public ShopperServiceImpl() {
		System.out.println("in Defal constr of shopper service");
	}

	@Override
	public String addProduct(Vegetables vegt) {
		System.out.println("in addproduct service");
		return dao.addProduct(vegt);
	}

	@Override
	public List<Vegetables> getVegetablesListByRoleId(int RoleID) {
		System.out.println("in getvegbyroleid service");
		return dao.getVegetablesListByRoleId(RoleID);
	}

	@Override
	public String removeProduct(int pid) {
		System.out.println("in "+getClass().getName()+" remove produt ");
		return dao.removeProduct(pid);
	}

	@Override
	public Vegetables getVegetablesById(int vid) {
		System.out.println("in"+getClass().getName()+"getVegetablesById");
		return dao.getVegetablesById(vid);
	}

	@Override
	public Vegetables updateProduct(Vegetables v) {
		
		return dao.updateProduct(v);
	}

}
