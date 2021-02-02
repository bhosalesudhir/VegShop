package com.app.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.pojos.Role;
import com.app.pojos.Vegetables;
import com.app.service.IShopperService;

@Controller
@RequestMapping("/shopper")
public class ShopperController {

	@Autowired
	private IShopperService service;

	@GetMapping("/home")
	public String shopperHomePage(HttpSession session, Model map) {
		System.out.println("in shopperHomepage");
		Role role = (Role) session.getAttribute("logged_details");
		Integer roleid = role.getRoleID();
		System.out.println("Role id=" + roleid);
		List<Vegetables> v = service.getVegetablesListByRoleId(role.getRoleID());
		System.out.println(v);
		map.addAttribute("vegetables_list", v);
		return "/shopper/home";
	}

	@GetMapping("/addproduct")
	public String shopperAddProduct() {
		System.out.println("in shopperAddProduct");
		// populate all product of current shopper by rile id and add it to scope
		return "/shopper/addproduct";
	}

	@PostMapping("/addproduct")
	public String addProduct(@RequestParam String Title, @RequestParam String Description,
			@RequestParam String Category, @RequestParam double UnitPrice, @RequestParam double Quantity,
			@Validated Role RoleID, RedirectAttributes flashmap) {
		Vegetables newvegetable = new Vegetables(Title, Description, Category, UnitPrice, Quantity, RoleID);

		try {
			System.out.println("New Product:" + newvegetable);
			System.out.println("in post addproduct method");
			service.addProduct(newvegetable);
			flashmap.addFlashAttribute("productstatus", "product " + Title + " Added ");
			return "redirect:/shopper/home";
		} catch (RuntimeException e) {
			flashmap.addFlashAttribute("productstatus", "product " + Title + " failed ");
			return "redirect:/shopper/addproduct";
		}

	}

//	@GetMapping("/listproduct")
//	public String  getVegetablesListByRoleId(int RoleID,RedirectAttributes flash)
//	{
//		
//		List<Vegetables> v = service.getVegetablesListByRoleId(RoleID);
//		System.out.println(v);
//		flash.addAttribute("vegetable_list",v);
//		return "redirect:/shopper/listproduct";
//		
//	}
	@GetMapping("/deleteproduct/{pid}")
	public String deleteProductForm(@PathVariable int pid, RedirectAttributes flash) {
		System.out.println(" in shopper delete product ");

		flash.addAttribute("deleteproductstatus", service.removeProduct(pid));
		return "redirect:/shopper/home";
	}

	@GetMapping("/updateproduct/{pid}")
	public String updateProductForm(@PathVariable int pid, Model map) {
		System.out.println(" in" + getClass().getName() + " shopper updateproduct product ");
		Vegetables v = service.getVegetablesById(pid);
		System.out.println("Vegetable" + v);
		map.addAttribute("updateproductdetails", v);
		return "/shopper/updateproduct";
	}

	@PostMapping("/updateproduct/{vid}")
	public String updateProductFrom(@RequestParam int vid,@RequestParam String Title, @RequestParam String Description,
			@RequestParam String Category, @RequestParam double UnitPrice, @RequestParam double Quantity,
			@Validated Role RoleID, RedirectAttributes flashmap) {
		
		System.out.println("in "+getClass().getName());
		Vegetables updateVegetable =new Vegetables(vid, Title, Description, Category, UnitPrice, Quantity);
		if(service.updateProduct(updateVegetable)!=null)
		
		{
			flashmap.addFlashAttribute("updateproductstatus", "Successfully updated");
		}
		else 
		{
			flashmap.addFlashAttribute("updateproductstatus", "product updation failed");	}
		return "redirect:/shopper/home";

	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		Role role = (Role) session.getAttribute("logged_details");
		session.invalidate();
		return "redirect:/";
	}

}