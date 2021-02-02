package com.app.dao;

import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.management.Query;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import com.app.pojos.Orders;
import com.app.pojos.Role;
@Repository
public class AdminDaoImpl implements IAdminDao {
	
	@Autowired
	private EntityManager mgr;

	@Autowired
	private JavaMailSender sender;

	@Override
	public List<Role> getAllUsersByRoleShopper(String accType) {
		String jpql="select r from Role r where r.accType=:acc";
		System.out.println("in getAllUsersByRoleShopper dao");
		List<Role> r=mgr.createQuery(jpql, Role.class).setParameter("acc",accType).getResultList();
		System.out.println(r);
		return r;
	}

	/*
	 * @Override public List<Role> getAllUsers() { String
	 * jpql="select r from Role r"; return mgr.createQuery(jpql,
	 * Role.class).getResultList(); }
	 */
	

	@Override
	public List<Role> getAllUsers(String accType) {
		String jpql="select r from Role r where r.accType='Customer' or r.accType='Shopper' ";
		return mgr.createQuery(jpql, Role.class).setParameter("Customer",accType).setParameter("Shopper", accType).getResultList();
	}

	@Override
	public String removeUserByRole(int RoleID) {
	   Role r=mgr.find(Role.class, RoleID);
	   System.out.println("removing userByRole");
	   if(r!=null)
	   {
		   mgr.remove(r);
		   System.out.println("Successfully User removed");
		   return "Successfully User removed";
	   } 
		return "User Removing Failed";
	}

	@Override
	public Role getUsersByRoleId(int RoleID) {
	System.out.println("in "+getClass().getName()+"getUsersByRoleId");
		return mgr.find(Role.class, RoleID);
	}

	@Override
	public Role updateUser(Role r) {
		System.out.println("in "+getClass().getName());
		/*
		 * Role updateUser=mgr.find(Role.class,r.getRoleID());
		 * System.out.println("old user details"+updateUser);
		 * updateUser.setAccType(r.getAccType()); updateUser.setActive(r.isActive());
		 * updateUser.setEmail(r.getEmail()); Role r1=mgr.merge(updateUser);
		 * System.out.println("updated user"+r1);
		 */
		
		return mgr.merge(r);
	
	}
	@Override
	public List<Orders> PendingOrders(Model map,HttpSession  session) {
		String jpql="select o from Orders o where o.OStatus=:os";
		//select u from BankUser u left outer join fetch u.accts where u.userId=:id
		System.out.println("in getvegbyroleid dao");
		Role role=(Role) session.getAttribute("logged_details");
		System.out.println(role);
		List<Orders> r= mgr.createQuery(jpql,Orders.class).setParameter("os", 0).getResultList();
		
		return r;
	}

	@Override
	public String ConfirmOrder(int OrderId) {
		//UPDATE Student student SET student.level
		int id=1;
		String jpql="update Orders o set o.OStatus=:id where o.OrderId=:oid ";
		javax.persistence.Query query=mgr.createQuery(jpql);
		query.setParameter("id", id);
		query.setParameter("oid", OrderId);
		int j=query.executeUpdate();
		
		Orders o=mgr.find(Orders.class, OrderId);
		System.out.println("Custome mails od:-"+o.getoRoleId().getEmail());
		{
			MimeMessage message=sender.createMimeMessage();
			MimeMessageHelper helper=new MimeMessageHelper(message);
			
			String mailConStent="Order placed by Customer:-"+o.getoRoleId().getEmail()+" have Vegetable Id:-"+o.getVegetableId().getVegetableId();
			try {
				helper.setTo("mayurkadam458@gmail.com");
				helper.setFrom(o.getoRoleId().getEmail());
				helper.setSubject("Order placed by");
				helper.setText(mailConStent, true);
				sender.send(message);
				System.out.println("emial send to shopper");
			} catch (MessagingException e) {
				
				e.printStackTrace();
			}
			
			
		}
		if(j>=1)
		{
			return "Order Confirm";
			
		}
		return "Order cancle";
			
	
	}
}
