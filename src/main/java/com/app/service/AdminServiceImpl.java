package com.app.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.app.dao.IAdminDao;
import com.app.pojos.Orders;
import com.app.pojos.Role;

@Service
@Transactional
public class AdminServiceImpl implements IAdminService {
	@Autowired
	private IAdminDao dao;

	@Override
	public List<Role> getAllUsersByRoleShopper(String accType) {
	
		return dao.getAllUsersByRoleShopper(accType);
	}

	@Override
	public List<Role> getAllUsers(String accType) {
		// TODO Auto-generated method stub
		return dao.getAllUsers(accType);
	}

	@Override
	public String removeUserByRole(int RoleID) {
	
		return dao.removeUserByRole(RoleID);
	}

	@Override
	public Role getUsersByRoleId(int RoleID) {
		System.out.println("in"+getClass().getName()+"getUserByRoleId");
		return dao.getUsersByRoleId(RoleID);
	}

	@Override
	public Role updateUser(Role r) {
		// TODO Auto-generated method stub
		return dao.updateUser(r);
	}
	@Override
	public List<Orders> PendingOrders(Model map,HttpSession  session) {
		
		return dao.PendingOrders(map,session);
	}

	@Override
	public String ConfirmOrder(int OrderId) {
		// TODO Auto-generated method stub
		return dao.ConfirmOrder(OrderId);
	}
}
