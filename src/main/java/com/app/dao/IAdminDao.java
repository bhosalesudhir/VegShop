package com.app.dao;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.app.pojos.Orders;
import com.app.pojos.Role;

public interface IAdminDao {
	
	List<Role> getAllUsersByRoleShopper(String accType);
	List<Role> getAllUsers(String accType);
	String removeUserByRole(int RoleID);
	Role getUsersByRoleId(int RoleID);
	Role updateUser(Role r);
	List<Orders> PendingOrders(Model map ,HttpSession  session);
	String ConfirmOrder(int OrderId);
}
