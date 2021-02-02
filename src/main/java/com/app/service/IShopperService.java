package com.app.service;

import java.util.List;

import com.app.pojos.Vegetables;

public interface IShopperService {
	String addProduct(Vegetables vegt);
	List<Vegetables> getVegetablesListByRoleId(int RoleID);
	String removeProduct(int pid);
	Vegetables getVegetablesById(int vid);
	Vegetables updateProduct(Vegetables v);
}
