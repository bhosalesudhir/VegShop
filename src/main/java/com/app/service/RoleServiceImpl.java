package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IRoleDao;
import com.app.pojos.Role;
import com.app.pojos.Users;

@Service
@Transactional
public class RoleServiceImpl implements IRoleService {
//dependnecy:dao i/f
	@Autowired
	private IRoleDao dao;
	
	@Override
	public Role addRole(Role transientRole)
	{
		System.out.println("in add role service");
		return dao.addRole(transientRole);
	}

	@Override
	public String addUser(Users transientUser) {
		System.out.println("in addd usee  service");
		return dao.addUser(transientUser);
	}

	@Override
	public Role validateRole(Role trasienrRole) {
		System.out.println("in validate role service");
		return dao.validateRole(trasienrRole);
	}

	@Override
	public Role frogetPassword(String emil, String pass) {
		System.out.println("in forgetpassword service method");
		return dao.frogetPassword(emil, pass);
	}

	
	
}
