package com.app.service;

import java.util.List;

import javax.mail.MessagingException;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.app.pojos.Vegetables;

public interface ICustomerService {
	List<Vegetables> getAllProducts();
	Vegetables getvegetable(int vid);
	String placedOrder(HttpSession session,Model map) throws MessagingException;

}
