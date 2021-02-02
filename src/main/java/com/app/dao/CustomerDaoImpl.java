package com.app.dao;

import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import com.app.pojos.Orders;
import com.app.pojos.Shipment;
import com.app.pojos.Vegetables;

@Repository
public class CustomerDaoImpl implements ICustomerDao {

	public CustomerDaoImpl() {
		super();
		System.out.println("in cust defalt constr");
	}

	@Autowired
	private JavaMailSender sender;
	
	@PersistenceContext
	private EntityManager mgr;
	


	@Override
	public List<Vegetables> getAllProducts() {
		String jpql = "select v from Vegetables v";
		List<Vegetables> v = mgr.createQuery(jpql, Vegetables.class).getResultList();
		System.out.println(v);
		return v;
	}
	@Override
	public Vegetables getvegetable(int vid) {
		Vegetables v=mgr.find(Vegetables.class, vid);
		System.out.println(v);
		return v;
	}
	
	@Override
	public String placedOrder(HttpSession session, Model map) throws MessagingException {

		System.out.println("in placedOrder dao");
		// get min ordernum from Orders table
		//SELECT AVG(e.salary) FROM Professor e
		String jpql="Select MAX(o.orderNum) from Orders o";
		Integer OrderNumber=(int)mgr.createQuery(jpql).getSingleResult();
		if(OrderNumber==null)
		{
					OrderNumber=1;
		}
		OrderNumber+=1;
		// get Shipment id who deliverd TotalOrderDeliver orders 
		System.out.println("Ordernum="+OrderNumber);
		
		String jpql2="Select MIN(s.TotalOrderDeliver) from Shipment s";
		Integer minOrders=(Integer)mgr.createQuery(jpql2).getSingleResult();
		System.out.println("minOrderCount"+minOrders);
		System.out.println("minorders:"+minOrders);
		String jpql1="select s from Shipment s where s.TotalOrderDeliver=:m" ;
		System.out.println("jpql1="+jpql1);
		Shipment ShipId= mgr.createQuery(jpql1,Shipment.class).setParameter("m", minOrders).getSingleResult();
		System.out.println("Shipdetails="+ShipId);
		
		// mail

		MimeMessage message=sender.createMimeMessage();
		MimeMessageHelper helper=new MimeMessageHelper(message);
		
		
		String mailConStent="<table border= 2px><caption>Order details </caption>" + 
				"<tr align=center> <th>Vegetable</th><th>Quantity</th> <th>Unitprice</th>  <th>Amount</th></tr>";
		System.out.println("ShipeId:="+ShipId);
		// populate orders
		double totalBill=0;
		List<Orders> ordersList=(List<Orders>) session.getAttribute("OrderedCartList");
		
		for(Orders o:ordersList)
		{
			mailConStent+="<tr align=center>";
			mailConStent+="<td>"+o.getVegetableId().getTitle().toUpperCase()+"</td>";
			mailConStent+="<td>"+o.getQty()+"</td>";
			mailConStent+="<td>&#8377;"+ o.getUnitprice()+"</td>";
			mailConStent+="<td>&#8377;"+o.getTotalAmount()+"</td></tr>";
			o.setOrderNum(OrderNumber);
			o.setShipID(ShipId.getShipmentID());
			totalBill=totalBill+o.getTotalAmount();
			System.out.println("====================================");
			System.out.println("Current Order:-"+o);
			System.out.println("====================================");
			System.out.println("Orders:-"+mgr.merge(o));
			System.out.println("Orderplaced"+o);
			
			
		}
		mailConStent+="<tr>";
		mailConStent+="<td colspan=3 align=center><b>TotalBill</b></td><td colspan=3 align=left>&#8377;"+totalBill+"</td></tr></table>";
		
		helper.setTo("mdkadam96@gmail.com");
		helper.setSubject("Order details:-");
		helper.setText(mailConStent, true);
		sender.send(message);
		List<Orders> Olist=new ArrayList<Orders>();
		System.out.println("Order placed");
		session.setAttribute("OrderedCartList", Olist);
		map.addAttribute("OrderStatus", "your Order num"+OrderNumber+"SuccessFully placed");
		
		return "redirect:/customer/home";
	}
}
