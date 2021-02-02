 package com.app.controller;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.app.pojos.Address;
import com.app.pojos.Orders;
import com.app.pojos.Role;
import com.app.pojos.Users;
import com.app.service.IRoleService;
import com.app.utils.AESAlgorithm;

@Controller
@RequestMapping("/role")
public class RoleController {
	// dependency:service i/f
	@Autowired
	private IRoleService service;

	@Autowired
	private JavaMailSender sender;
	
	public RoleController() {
		System.out.println("in conetr of " + getClass().getName());
	}

	@GetMapping("/login")
	public String showLoginForm(Role r) {
		System.out.println("in show Login form");
		return "/role/login";
	}
	
	// login form
	@PostMapping("/login")
	public String validateLogin(@RequestParam String email, @RequestParam String pass,
			@RequestParam String acctype, HttpSession hs, RedirectAttributes flash,Model map) {
		System.out.println("in role controller validateLogin");
		String loginmsg = "login filed";
		
		
		try {
			Role role = new Role(email, AESAlgorithm.en(pass), acctype);
			role = service.validateRole(role);
			if (role != null) {
				hs.setAttribute("logged_details", role);
				loginmsg = "loginsuccesfully";
				flash.addFlashAttribute("msg", loginmsg);
				if (role.getAccType().equals("Admin")) {
					return "redirect:/admin/home";
				} else if (role.getAccType().equals("Customer")) {
					List<Orders> ordersList = new ArrayList<Orders>();
					hs.setAttribute("OrderedCartList", ordersList);
					return "redirect:/customer/home";
				} else

					return "redirect:/shopper/home";
			}

		} catch (Exception e) {
			System.out.println("error in Role controller");
			//e.printStackTrace();
			
		}
		flash.addFlashAttribute("message", "Invalid Credentials");
		return "redirect:/role/login";

	}

	// req handiling method to show the form
	@GetMapping("/addrole")
	public String showAddRoleForm(Role r) {
		System.out.println("in show product form");
		return "/role/addrole";
	}

	@PostMapping("/addrole")
	public String processAddRoleForm(Role transientPopulatedRole, RedirectAttributes flashMap, HttpSession session) {
		System.out.println("in process form " + transientPopulatedRole);
		// invoke service dao--add--role to db
		//
		String enpass=null;
		 try {
			 enpass=AESAlgorithm.en(transientPopulatedRole.getPassword());
		} catch (GeneralSecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 System.out.println("Enpass:"+enpass);
		 transientPopulatedRole.setPassword(enpass);
		Role r = service.addRole(transientPopulatedRole);
		session.setAttribute("role_details", r);
		// System.out.println("role"+service.addRole(transientPopulatedRole));
		System.out.println("RoleID" + session.getAttribute("role_details"));
		// return "redirect:/role/addmoredetails";
		// //D.S:resp:sendRedirect(resp.encodeRedirectURL("/role/addrole")
		return "/role/addmoredetails";
	}

	@GetMapping("/addmoredetails")
	public String showaddmoredetails(Users u) {
		System.out.println("in showaddmoredetails");
		return "/role/addmoredetails";
	}

	@PostMapping("/addmoredetails")
	public String processaddmoredetails(@RequestParam String Fname, @RequestParam String Lname,
			@RequestParam String Gender, @RequestParam String ContactNo,@RequestParam(name = "DOR") 
			@DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate DOR,
			@RequestParam String City, @RequestParam String State, @RequestParam String PinCode,
			@Validated	Role RoleID,RedirectAttributes flash) {
		System.out.println("in post shoeew more detaisl");
		Address a = new Address(City, State, PinCode);
		Users u = new Users(Fname, Lname, Gender, ContactNo, DOR, a, RoleID);
		System.out.println(u);
				flash.addFlashAttribute("addusermsg", service.addUser(u));
		return "redirect:/";
	}
	@GetMapping("/forgetpass")
	public String forgetPassword() {
		System.out.println("in forgetPassword get method");
		return "/role/forgetpass";
	}
	@PostMapping("/forgetpass")
	public String forgetPassword(@RequestParam String email, @RequestParam String accType) {
		System.out.println("in forgetPassword post method ");
		Role r= service.frogetPassword(email, accType);
		
		MimeMessage message=sender.createMimeMessage();
		MimeMessageHelper helper=new MimeMessageHelper(message);
		
		
		try {
			String mailConStent="<h3>Your register passwoed Password:</h3>" + "<b>"+AESAlgorithm.dt(r.getPassword())+"</b>";
			helper.setTo("mdkadam96@gmail.com");
			helper.setSubject("Forget password is");
			helper.setText(mailConStent, true);
		} catch (MessagingException | GeneralSecurityException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sender.send(message);
		System.out.println("password send");
		/* map.addAttribute("msg", "password send to Register mail id "); */
		return "redirect:/";
	}
}
