package com.app.controller;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.pojos.Orders;
import com.app.pojos.Role;
import com.app.pojos.Vegetables;
import com.app.service.ICustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private ICustomerService service;

	@Autowired
	private JavaMailSender sender;

	private List<Vegetables> cart = new ArrayList<Vegetables>();


	@GetMapping("/home")
	public String customerHomePage(HttpSession session) {
		System.out.println("in customer Homepage");
		// Role role=(Role) session.getAttribute("logged_details");

		// get all Vegetable List from database
		List<Vegetables> v = service.getAllProducts();
		System.out.println(v);

		// create OrderCart for customer once he login
		/*
		 * List<Orders> ordersList = new ArrayList<Orders>();
		 * session.setAttribute("OrderedCartList", ordersList);
		 */
		// session.setAttribute("shoppingcart", this.cart);
		session.setAttribute("all_productlist", v);

		return "/customer/home";
	}

	@GetMapping("/bycategory")
	public String productByCategory() {
		return "/customer/bycategory";
	}

	@GetMapping("/addtocart/{pid}")
	public String addtoCart(@PathVariable int pid, Model map) {
		System.out.println("in addto cart ");
		Vegetables v = service.getvegetable(pid);
		cart.add(v);
		// System.out.println(v);
		map.addAttribute("pid", v);
		map.addAttribute("currentselectedVegetable", v);

		return "/customer/orderdetails";
	}

	@PostMapping("/addtocart/{pid}")
	public String addToCartOrdersDetails(@RequestParam String payment, @RequestParam String UPrice,
			@RequestParam String Quantity, @Validated Vegetables VegetableId, HttpSession hs) {

		Double OrdersQty = Double.parseDouble(Quantity);
		Double unitprice = Double.parseDouble(UPrice);
		// get OrderCart from session
		List<Orders> orderList = (List<Orders>) hs.getAttribute("OrderedCartList");
		System.out.println("addToCartOrdersDetails " + VegetableId + " payment=" + payment);
		Vegetables selectedvegetabledetails=service.getvegetable(VegetableId.getVegetableId());
		Role logRole = (Role) hs.getAttribute("logged_details");
		System.out.println("LogRole=" + logRole);
		Orders newOrder = new Orders();
		{
			newOrder.setVegetableId(selectedvegetabledetails);
			newOrder.setoRoleId(logRole);
			newOrder.setPaymentMode(payment);
			if (payment.equals("COD")) {
				newOrder.setOStatus(0);
				newOrder.setPaymentStatus("Unpaid");
			} else {
				newOrder.setOStatus(0);
				newOrder.setPaymentStatus("Paid");
			}
			
			Date date = new Date();
			LocalDate CurrentDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			System.out.println("localDate : " + CurrentDate);
			newOrder.setOrderDate(CurrentDate);
			newOrder.setUnitprice(unitprice);
			newOrder.setQty(OrdersQty);
			newOrder.setTotalAmount(OrdersQty * unitprice);

			orderList.add(newOrder);

		}

		System.out.println("Orders details:" + orderList);
		return "redirect:/customer/home";
	}

	@GetMapping("/shoppingcart")
	public String cart() {
		return "/customer/cart";
	}

	@GetMapping("/remove/{vid}")
	public String removeFromCart(@PathVariable	Integer vid, HttpSession hs) {

		System.out.println("in removeFromCart");
		System.out.println(vid);
		List<Orders> orderList = (List<Orders>) hs.getAttribute("OrderedCartList");
	
		System.out.println("orderList" + orderList);
		
		for(Orders o:orderList)
		{
			System.out.println("o.getVegetableId()="+o.getVegetableId());
			System.out.println("o.getVegetableId().getVegetableId()"+o.getVegetableId().getVegetableId());
			if(o.getVegetableId().getVegetableId().equals(vid))
			{
				orderList.remove(o);
				break;
			}
		}
		hs.setAttribute("OrderedCartList", orderList);
		return "redirect:/customer/shoppingcart";

	}

	@GetMapping("/checkout")
	public String checkOut(Model map ,HttpSession session) throws MessagingException {
		System.out.println("in check out");
		
		// get customer details from session
		Random r = new Random();
		String randomnumber = String.format("%04d", Integer.valueOf(r.nextInt(1001)));
		System.out.println("Otp=" + randomnumber);

		/*
		 * SimpleMailMessage m = new SimpleMailMessage();
		 * m.setTo("bhosalesudhir.info2@gmail.com"); m.setSubject("Otp");
		 * m.set("<html><h5>Your OneTimePasswoed:</h5>" + "<b>" + randomnumber +
		 * "</b></html>"); sender.send(m);
		 */

		MimeMessage message=sender.createMimeMessage();
		MimeMessageHelper helper=new MimeMessageHelper(message);
		
		String mailConStent="<h3>Your OneTime Password:</h3>" + "<b>" + randomnumber+"</b>";
		helper.setTo("mdkadam96@gmail.com");
		helper.setSubject("One Time Password");
		helper.setText(mailConStent, true);
		sender.send(message);
		
		map.addAttribute("otp", randomnumber);
		System.out.println("Email send ");
		 return "/customer/verifyotp"; 
	}

	@GetMapping("/placedorder")
	public String placedOrder(HttpSession session, Model map) {

		System.out.println("in palced order get mapping mehtod");

		try {
			return service.placedOrder(session, map);
		} catch (MessagingException e) {
			e.printStackTrace();
			return "/customer/error";
		}
	}

	@GetMapping("/logout")
	public String logout(HttpSession session)
	{
		System.out.println("in logout method");
		Role role=(Role) session.getAttribute("logged_details");
		session.invalidate();
		return "redirect:/";
	}
}
