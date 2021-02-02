package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "Vegetables")
public class Vegetables {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer VegetableId;
	@Column(length = 30)
	private String Title;
	@Column(length = 30)
	private String Description;
	@Column(length = 30)
	private String Category;
	private double UnitPrice;
	private double Quantity;

	@ManyToOne()// role 1-->vegetable*
	@JoinColumn(name = "RoleID",nullable = false)
	private Role RoleID;
	
	@Column(length = 300)
	private String ImageSrc;
	@OneToMany(mappedBy = "VegetableId",cascade = CascadeType.ALL) // vegetable1-->Orders*
	private List<Orders> Oid=new ArrayList<Orders>();
	
	public void addOrders(Orders o)
	{
		Oid.add(o);
		o.setVegetableId(this);
	}
	public void removeOrders(Orders o)
	{
		Oid.remove(o);
		o.setVegetableId(null);
	}
	
	public Vegetables() {
	
		System.out.println("in constr of " + getClass().getName());
	}
	public Vegetables(Integer vegetableId, String title, String description, String category, double unitPrice,
			double quantity) {
		
		VegetableId = vegetableId;
		Title = title;
		Description = description;
		Category = category;
		UnitPrice = unitPrice;
		Quantity = quantity;
	}
	
	public Vegetables(String title, String description, String category, double unitPrice, double quantity,
			Role roleID) {
		
		Title = title;
		Description = description;
		Category = category;
		UnitPrice = unitPrice;
		Quantity = quantity;
		RoleID = roleID;
	}
	public Vegetables(String title, String description, String category, double unitPrice, double quantity, Role roleID,
			String imageSrc) {
		
		Title = title;
		Description = description;
		Category = category;
		UnitPrice = unitPrice;
		Quantity = quantity;
		RoleID = roleID;
		ImageSrc = imageSrc;
	}
	public Integer getVegetableId() {
		return VegetableId;
	}

	public void setVegetableId(Integer vegetableId) {
		VegetableId = vegetableId;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getCategory() {
		return Category;
	}

	public void setCategory(String category) {
		Category = category;
	}

	public double getUnitPrice() {
		return UnitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		UnitPrice = unitPrice;
	}

	public double getQuantity() {
		return Quantity;
	}

	public void setQuantity(double quantity) {
		Quantity = quantity;
	}
	
	public String getImageSrc() {
		return ImageSrc;
	}
	public void setImageSrc(String imageSrc) {
		ImageSrc = imageSrc;
	}
	public Role getRoleID() {
		return RoleID;
	}
	public void setRoleID(Role roleID) {
		RoleID = roleID;
	}
	@Override
	public String toString() {
		return "Vegetables [VegetableId=" + VegetableId + ", Title=" + Title + ", Description=" + Description
				+ ", Category=" + Category + ", UnitPrice=" + UnitPrice + ", Quantity=" + Quantity + ", RoleID="
				+ RoleID + ", ImageSrc=" + ImageSrc + "]";
	}
	
}
