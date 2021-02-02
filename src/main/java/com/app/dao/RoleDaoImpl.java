package com.app.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.app.pojos.Role;
import com.app.pojos.Users;

@Repository //managed by SC:spring bean
public class RoleDaoImpl implements IRoleDao {
	
	@PersistenceContext
	private EntityManager mgr;
	
	@Override
	public Role addRole(Role transientRole)
	{
		String mesg="Role added successfully";
		Role r = mgr.merge(transientRole);
		System.out.println(r);
		return r;
	}

	@Override
	public String addUser(Users transientUser) {
		System.out.println("in add user dao");
		mgr.persist(transientUser);
		return "User added";
	}

	
	@Override
	public Role validateRole(Role trasienrRole) {
		String jpql="select r from Role r where r.email=:em and r.password=:ps and r.accType=:type";
		System.out.println("in validate role method of dao");
		Role r=mgr.createQuery(jpql, Role.class).setParameter("em", trasienrRole.getEmail()).
				setParameter("ps", trasienrRole.getPassword()).
				setParameter("type", trasienrRole.getAccType()).getSingleResult();
		System.out.println("Role from dao"+r);
		return r;
	}

	@Override
	public Role frogetPassword(String emil, String actype) {
		System.out.println("in frogetPassword dao layer");
		String jpql="select r from Role r where r.email=:em and  r.accType=:type";
		Role r=mgr.createQuery(jpql, Role.class).setParameter("em", emil).setParameter("type", actype).getSingleResult();
				System.out.println("Role from dao"+r);
		return r;
	}
	

}
