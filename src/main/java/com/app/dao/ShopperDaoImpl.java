package com.app.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.pojos.Role;
import com.app.pojos.Vegetables;
@Repository
public class ShopperDaoImpl implements IShopperDao {

		public ShopperDaoImpl() {
			System.out.println("in shopper dao constructor");
		}
	@PersistenceContext
	private EntityManager mgr;
	
	@Override
	public String addProduct(Vegetables vegt) {
		System.out.println("in add product dao");
		mgr.persist(vegt);
		return "Product  Added";
	}

	@Override
	public List<Vegetables> getVegetablesListByRoleId(int RoleID) {
		String jpql="select r from Role r left outer join fetch r.vlist  where r.RoleID=:rid";
		//select u from BankUser u left outer join fetch u.accts where u.userId=:id
		System.out.println("in getvegbyroleid dao");
		Role r= mgr.createQuery(jpql,Role.class).setParameter("rid", RoleID).getSingleResult();
		System.out.println("List of vegetable"+r);
		return r.getVlist() ;
	}

	@Override
	public String removeProduct(int pid) {
		Vegetables v=mgr.find(Vegetables.class, pid);
		System.out.println("removing product "+v);
		if(v!=null)
		{
				mgr.remove(v);
				System.out.println("Successfully removed");
				return "Successfully removed";
		}
		return "Product deletion failed";
	}

	@Override
	public Vegetables getVegetablesById(int vid) {
		System.out.println(" in "+getClass().getName()+"getVegetablesById");
		return mgr.find(Vegetables.class, vid);
	}

	@Override
	public Vegetables updateProduct(Vegetables v ) {
		System.out.println("in "+getClass().getName());
		Vegetables updateVegtable=mgr.find(Vegetables.class, v.getVegetableId());
		System.out.println("old vegetavle "+updateVegtable);
		updateVegtable.setTitle(v.getTitle());
		updateVegtable.setDescription(v.getDescription());
		updateVegtable.setQuantity(v.getQuantity());
		updateVegtable.setUnitPrice(v.getUnitPrice());
		Vegetables v1=mgr.merge(updateVegtable);
		System.out.println("updated vegetable "+v1);
		return v1;
		
	}

	

}
