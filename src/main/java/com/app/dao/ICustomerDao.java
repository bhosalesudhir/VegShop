package com.app.dao;

import java.util.List;

import javax.mail.MessagingException;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.app.pojos.Vegetables;

public interface ICustomerDao {

	List<Vegetables> getAllProducts();
	Vegetables getvegetable(int vid);
	String placedOrder(HttpSession session,Model map) throws MessagingException;
}
