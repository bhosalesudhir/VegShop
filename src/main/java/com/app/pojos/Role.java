package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "Role")
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer RoleID;
	@Column(length = 30)
	private String email;
	@Column(length = 50)
	private String password;

	@OneToOne(mappedBy = "RoleID", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Users uid;
	@Column(length = 30)
	private String accType;
   
	//@Column(columnDefinition="tinyint(1) default 1")
	@Column
	private boolean Active=true;
	
	@OneToMany(mappedBy = "RoleID",cascade = CascadeType.ALL)
	private List<Vegetables> vlist=new ArrayList();
		public Role() {
		System.out.println("in default role constr");
	}
	@OneToMany(mappedBy = "oRoleId" ,cascade = CascadeType.ALL)
	private List<Orders> orderList=new ArrayList<Orders>();
	public Role(String email, String password, String accType) {

		this.email = email;
		this.password = password;
		this.accType = accType;
	}

	public Role(String email, String password, String accType, boolean active) {
		super();
		this.email = email;
		this.password = password;
		this.accType = accType;
		Active = active;
	}

	
	public Role(String email, String accType, boolean active) {
		super();
		this.email = email;
		this.accType = accType;
		Active = active;
	}

	public void addOrder(Orders o) {
		orderList.add(o);
		o.setoRoleId(this);
	}
	
	public void removeOrder(Orders o)
	{
		orderList.remove(o);
		o.setoRoleId(null);
	}
	public boolean isActive() {
		return Active;
	}

	public void setActive(boolean active) {
		Active = active;
	}

	public Integer getRoleID() {
		return RoleID;
	}

	public void setRoleID(Integer roleID) {
		RoleID = roleID;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAccType() {
		return accType;
	}

	public void setAccType(String accType) {
		this.accType = accType;
	}

	@Override
	public String toString() {
		return "Role [RoleID=" + RoleID + ", email=" + email + ", accType=" + accType + ", Active=" + Active + "]";
	}

	public void addvegetable(Vegetables v)
	{
		vlist.add(v);
		v.setRoleID(this);
	}
	public void removevegetable(Vegetables v)
	{
		vlist.remove(v);
		v.setRoleID(null);
		
	}

	public Users getUid() {
		return uid;
	}

	public List<Vegetables> getVlist() {
		return vlist;
	}
}
