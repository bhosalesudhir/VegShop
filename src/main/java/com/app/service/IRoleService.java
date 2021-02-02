package com.app.service;

import com.app.pojos.Role;
import com.app.pojos.Users;

public interface IRoleService {
	
	Role addRole(Role transientRole);
	String addUser(Users transientUser);
	Role validateRole(Role trasienrRole);
	Role frogetPassword(String emil,String pass);
}
