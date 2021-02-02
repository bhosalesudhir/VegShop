package com.app.dao;

import com.app.pojos.Role;
import com.app.pojos.Users;

public interface IRoleDao {
	Role addRole(Role transientRole);
	String addUser(Users transientUser);
	Role validateRole(Role trasienrRole);
	Role frogetPassword(String emil,String pass);
}
