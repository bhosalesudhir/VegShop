package com.app.service;

import java.util.List;

import javax.mail.MessagingException;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.app.dao.ICustomerDao;
import com.app.pojos.Vegetables;
@Service
@Transactional
public class CustomerServiceImpl implements ICustomerService {
	
	@Autowired
	private ICustomerDao dao;

	@Override
	public List<Vegetables> getAllProducts() {
	System.out.println("in cust getallproducts service");
		return dao.getAllProducts();
		
	}

	@Override
	public Vegetables getvegetable(int vid) {
		
		return dao.getvegetable(vid);
	}

	@Override
	public String placedOrder(HttpSession session, Model map) throws MessagingException {
		System.out.println("In "+getClass().getName());
		return dao.placedOrder(session, map);
	}

}
