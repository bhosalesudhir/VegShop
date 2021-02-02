package com.app.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.pojos.Orders;
import com.app.pojos.Role;
import com.app.service.IAdminService;

@Controller
@RequestMapping("/admin")
public class adminController {
	@Autowired
	private IAdminService service;

	@GetMapping("/home")
	public String AdminHomePage(HttpSession session,Model map)
	{
		System.out.println("in adminHomepage");
		Role role=(Role) session.getAttribute("logged_details");
	//	String acctype=role.getAccType();
		//System.out.println("accType ="+acctype);
	//	List<Role> r=service.getAllUsersByRoleShopper(acctype);
		
		//List<Role> r=service.getAllUsers(accType);
	//	System.out.println(r);
		
	//map.addAttribute("listByaccType",r);
		
		return "/admin/home";
	}
	
	@PostMapping("/home")
	public String processAdminHomePage(@RequestParam String acctype , HttpSession session,Model map)
	{
		System.out.println("in adminHomepage");
		Role role=(Role) session.getAttribute("logged_details");
		//String acctype=role.getAccType();
		System.out.println("accType ="+acctype);
		List<Role> r=service.getAllUsersByRoleShopper(acctype);
		System.out.println(r);
		map.addAttribute("listByaccType",r);
		return "/admin/home";
	}
	
	@GetMapping("/deleteuser/{RoleID}")
	public String deleteUser(@PathVariable int RoleID,RedirectAttributes flash)
	{
		System.out.println("in admin delete user");
		flash.addAttribute("deleteuserstatus",service.removeUserByRole(RoleID));
		
		return "redirect:/admin/home";
	}
	
	@GetMapping("/updateuser/{RoleID}")
	public String updateUserForm(@PathVariable int RoleID,Model map)
	{
		System.out.println("in "+getClass().getName()+"admin updateuser");
		Role r=service.getUsersByRoleId(RoleID);
		System.out.println("role "+r);
		map.addAttribute("updateuserdetails",r);
		return "/admin/updateuser";
	}
	
	@PostMapping("/updateuser/{RoleID}")
	public String updateUserForm(@PathVariable int RoleID,@RequestParam String accType,
			@RequestParam String email,
			@RequestParam boolean active,@Validated Role RiD,RedirectAttributes flashmap )
	{
		System.out.println("in"+getClass().getName());
		
		Role updateUser=service.getUsersByRoleId(RoleID);
		updateUser.setActive(active);
		System.out.println("updateUser"+updateUser);
		if(service.updateUser(updateUser)!=null)
		{
			flashmap.addFlashAttribute("updateuserstatus","successfully updated");
		}
		else
		{
			flashmap.addFlashAttribute("updateuserstatus", "user updation failed");
			return "redirect:/admin/home";
		}
		
		
		return "redirect:/admin/home";
	}
	
	@GetMapping("/PendingOrder")
	public String PendingOrder(Model map,HttpSession session)
	{
		System.out.println("in pending orders get method");
		java.util.List<Orders> pendingOrder=new ArrayList<Orders>();
		pendingOrder=service.PendingOrders(map, session);
		System.out.println(pendingOrder.toString());
		map.addAttribute("pendingOrder",pendingOrder);
		return "/admin/PendingOrder";
	}
	@GetMapping("/confirmOrder/{OrderId}")
	public String ConfirmOrder(@PathVariable int OrderId)
	{
		System.out.println("in admin Confirm Order");
		System.out.println(OrderId);
		String msg=service.ConfirmOrder(OrderId);
		
		System.out.println(msg);
		return "redirect:/admin/PendingOrder";
	}
	

	@GetMapping("/logout")
	public String logout(HttpSession session)
	{
		Role role=(Role) session.getAttribute("logged_details");
		session.invalidate();
		return "redirect:/";
	}
	
}
